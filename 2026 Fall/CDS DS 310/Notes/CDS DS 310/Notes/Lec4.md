# Aggregate Functions

SELECT clause can include an _aggregate function_, which performs a computation on a collection of values of an attribute
Example: find the average capacity of rooms in the Sci Ctr

```SQL
SELECT AVG(capacity)
FROM Room
WHERE name LIKE 'Sci Ctr%';
```
![[Pasted image 20260915110746.png]]
Possible functions include:
- MIN, MAX: find the minimum/maximum of a value
- AVG, SUM: compute the average/sum of numeric values
- COUNT: count the number of values
For AVG, SUM, and COUNT, we can add the keyword DISTINCT to perform the computation on all distinct values.
- example: find the number of students enrolled for courses
```SQL
SELECT COUNT(DISTINCT student)
FROM Enrolled;
```
SELECT COUNT(*) will count the number of tuples in the result of the select command.
- example: find the number of DS courses
```SQL
SELECT COUNT(*)
FROM Course
WHERE name LIKE 'ds%';
```
- COUNT(attribute) counts the number of non-NULL values of attribute, so it won’t always be equivalent to COUNT(*)

Aggregate functions cannot be used in the WHERE clause.
Practice with aggregate functions: write a query to find the largest capacity of any room in the Science Center
```SQL
SELECT MAX(capacity)
FROM Room
WHERE name LIKE 'Sci Ctr%';
```

The following will _not_ work if we wanted the name of the room with the max. capacity
```SQL
SELECT name, MAX(capacity)
FROM Room
WHERE name LIKE 'Sci Ctr%';
```

![[Pasted image 20260915111423.png]]
In general, you can’t mix aggregate functions with column names in the SELECT clause

# Subqueries
A subquery allows us to use the result of one query in the evaluation of another query.
- the queries can involve the same table or different tables
We can use a subquery to solve the previous problem

```SQL
SELECT name, capacity
FROM Room
WHERE name LIKE 'Sci Ctr%'
  AND capacity = (SELECT MAX(capacity)      -- the subquery
                  FROM Room
                  WHERE name LIKE 'Sci Ctr%');
```
Since the subquery evaluates to 500, this is equivalent to
```SQL
SELECT name, capacity
FROM Room
WHERE name LIKE 'Sci Ctr%'
  AND capacity = 500;
```
# A Restriction on Aggregate Functions
```SQL
SELECT name, MIN(runtime)
FROM Movie
WHERE rating = 'PG-13';
```

This does not work in standard SQL!
![[Pasted image 20260915112719.png]]

-------
```SQL
SELECT name, MIN(runtime)
FROM Movie
WHERE rating = 'PG-13';    -- does not work in standard SQL!
```

In general, a SELECT clause cannot combine:
- an aggregate function
- a column name that is on its own (and is not being operated on by an aggregate function)

We’ll see an important exception to this soon.
Warning: SQLite lets you violate this rule, but…
- doing so is not standard SQL
- you should not do this in your work for this class!

# Subqueries and Set Membership
Subqueries can be used to test for set membership in conjunction with the IN and NOT IN operators
- example: find all students who are not enrolled in CSCI E-268
```SQL
SELECT name
FROM Student
WHERE id NOT IN (SELECT student
                 FROM Enrolled
                 WHERE course = 'cscie268');
```

![[Pasted image 20260915113518.png]]

# Subqueries and Set Comparisons
Subqueries also enable comparisons with elements of a set using the ALL and SOME operators
- example: find rooms larger than all rooms in Sever Hall
```SQL
SELECT name, capacity
FROM Room
WHERE capacity > ALL (SELECT capacity
                      FROM Room
                      WHERE name LIKE 'Sever%');
```
- example: find rooms larger than at least one room in Sever
```SQL
SELECT name, capacity
FROM Room
WHERE capacity > SOME (SELECT capacity
                       FROM Room
                       WHERE name LIKE 'Sever%');
```

# Applying an Aggregate Function to Subgroups
A GROUP BY clause allows us to:
- group together tuples that have a common value
- apply an aggregate function to the tuples in each subgroup
Example: find the enrollment of each course

```SQL
SELECT course, COUNT(*)
FROM Enrolled
GROUP BY course;
```

When you group by an attribute, you can include it in the SELECT clause with an aggregate function
- because we’re grouping by that attribute, every tuple in a given group will have the same value for it
# Evaluating a query with GROUP BY
```SQL
SELECT course, COUNT(*)
FROM Enrolled
GROUP BY course;
```
![[Pasted image 20260915113749.png]]
# Applying a Condition to Subgroups
A HAVING clause allows us to apply a selection condition to the subgroups produced by a GROUP BY clause.
- example: find enrollments of courses with at least 2 students
```SQL
SELECT course, COUNT(*)
FROM Enrolled
GROUP BY course
HAVING COUNT(*) > 1;
```

![[Pasted image 20260915113901.png]]
Result: 
![[Pasted image 20260915113913.png]]
Important difference:
- a WHERE clause is applied _before_ grouping
- a HAVING clause is applied _after_ grouping

# Subqueries in FROM clauses

A subquery can also appear in a FROM clause.
Useful when you need to perform a computation on values obtained by applying an aggregate.
- example: find the average enrollment in a DS course
```SQL
SELECT AVG(count)
FROM (SELECT course, COUNT(*) as count
      FROM Enrolled
      GROUP BY course) AS enrollCounts
WHERE course LIKE 'ds%';
```
Some systems require that you assign a FROM-clause subquery a name (e.g., `enrollCounts` above).

# Sorting the Results
An ORDER BY clause sorts the tuples in the result of the query by one or more attributes.
- ascending order by default, use DESC to get descending
- example:
```SQL
SELECT name, capacity
FROM Room
WHERE capacity > 100
ORDER BY capacity DESC, name;
```
![[Pasted image 20260915114442.png]]
# Set Operations
UNION, INTERSECTION, EXCEPT (set difference)
Example: find the IDs of students and advisors
```SQL
SELECT student
FROM Enrolled
UNION
SELECT advisor
FROM Advises;
```
## Outer Join 
Syntax for left outer join
``` SQL
SELECT …
FROM T1 LEFT OUTER JOIN T2 ON join condition
WHERE …
```

The result is equivalent to:
 - forming the Cartesian product `T1 x T2`

selecting the tuples in the Cartesian product that satisfy the join condition in the ON clause

including an extra tuple for each row from T1 that does not have a match with a row from T2 based on the ON clause
- the T2 attributes in the extra tuples are given null values
 applying the remaining clauses as before

Also available: RIGHT OUTER JOIN, FULL OUTER JOIN


Example: get the IDs and majors of all enrolled students
![[Pasted image 20260915114855.png]]
```SQL
SELECT DISTINCT Enrolled.student, dept
FROM Enrolled LEFT OUTER JOIN MajorsIn
ON Enrolled.student = MajorsIn.student;
```
![[Pasted image 20260915114910.png]]

Another example: find the IDs and majors of all students enrolled in cscie268 (including those with no major)

```SQL
SELECT Enrolled.student, dept
FROM Enrolled LEFT OUTER JOIN MajorsIn
     ON Enrolled.student = MajorsIn.student
WHERE course = 'cscie268';
```
in this case, there is a WHERE clause with an additional selection condition

the additional condition belongs in the WHERE clause because it’s not a join condition 
- i.e., it isn’t used to match up tuples from the two tables
Note: when there is no additional condition, we don’t need a WHERE clause – the join condition is in the ON clause

# Evaluating a SELECT command

```SQL
SELECT column1, column2, …
FROM table1, table2, ...
...
```
The result is equivalent to:
- evaluating any subqueries in the FROM clause
- forming the Cartesian product of the tables in the FROM clause: `table1 x table2 x …`
- if there is an OUTER JOIN, applying its join condition and adding extra tuples as needed
- applying the remaining clauses in the following order:
``` SQL
WHERE (including any subqueries)   GROUP BY   HAVING   SELECT   ORDER BY
```
# CREATE TABLE
What it does: creates a relation with the specified schema
Basic syntax
```SQL
CREATE TABLE relation_name(
    attribute1_name attribute1_type,
    attribute2_name attribute2_type,
    …
    attributeN_name attributeN_type );
```

Examples: 
```SQL
CREATE TABLE Student(id CHAR(8), name VARCHAR(30));

CREATE TABLE Room(id CHAR(4), name VARCHAR(30),
                  capacity INTEGER);
```

# Data Types
An attribute’s type specifies the domain of the attribute.
The set of possible types depends on the DBMS.
Standard SQL types include:
- INTEGER: a four-byte integer (-2147483648 to +2147483647)
- CHAR(n): a fixed-length string of n characters
- VARCHAR(n): a variable-length string of up to n characters
- REAL: a real number (i.e., one that may have a fractional part)
- NUMERIC(n, d): a numeric value with at most n digits, exactly d of which are after the decimal point
- DATE: a date of the form yyyy-mm-dd
- TIME: a time of the form hh:mm:ss
When specifying a non-numeric value, you should surround it with single quotes (e.g., ‘Jill Jones’ or ‘2007-01-26’).

# CHAR v VARCHAR
CHAR(n): a fixed-length string of _exactly_ n characters
- the DBMS will pad with spaces as needed
- example: with `id CHAR(6)`, ‘12345’ will be stored as ‘12345 ’

VARCHAR(n): a variable-length string of _up to_ n characters
- the DBMS does not pad the value

In both cases, values will be truncated if they’re too long.
If a string attribute can have a wide range of possible lengths, it’s usually better to use VARCHAR.

# Types in SQLite
SQLite has its own types, including:
- INTEGER
- REAL
- TEXT
It also allows you to use the typical SQL types, but it converts them to one of its own types.
As a result, the length restrictions indicated for CHAR and VARCHAR are not observed.
It is also more lax in type checking than typical DBMSs.