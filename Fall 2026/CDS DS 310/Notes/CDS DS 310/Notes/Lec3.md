# Recall
## Cartesian Product
![[Pasted image 20260910110913.png]]
![[Pasted image 20260910110920.png]]

## Performing a Natural Join
1. Take the full Cartesian product.
![[Pasted image 20260910111121.png]]
2. Perform a selection in which we filter out tuples in which attributes with the same name have different values.
    - if there are no attributes with the same name, skip this step
![[Pasted image 20260910111133.png]]
3. Perform a projection that keeps only one copy of each duplicated column.
![[Pasted image 20260910111145.png]]
4. Final result: A table with all combinations of “matching” rows from the original tables.
![[Pasted image 20260910111157.png]]
## Condition Joins (Theta Joins)
Performs a “filtered” Cartesian product according to a specified predicate
Syntax: $R1\bowtie _\theta R2$ , where θ is a predicate
Fundamental-operation equivalent: cross, select using θ

# Joins and Unmatched Tuples
Let’s say we want to know the majors of all enrolled students – including those with no major

![[Pasted image 20260910112222.png]]
# Outer Joins
Outer joins allow us to include unmatched tuples in the result.

Left outer join (R1 ⟕ R2): in addition to the natural-join tuples, include an extra tuple for each tuple from R1 with no match in R2
![[Pasted image 20260910112501.png]]

in the extra tuples, give the R2 attributes values of _null_

Right outer join (R1 ⟖ R2): include an extra tuple for each tuple from R2 with no match in R1
![[Pasted image 20260910112552.png]]

Full outer join (R1 ⟗ R2): include an extra tuple for each tuple from _either_ relation with no match in the other relation
![[Pasted image 20260910112556.png]]

# Set Difference

What it does: selects tuples that are in one relation but not in another.
Syntax: `R1 - R2`
Rules:
- The relations must have the same number of attributes, and corresponding attributes must have the same domain
The resulting relation inherits its attribute names from the first relation
Duplicates are eliminated, since relational algebra treats relations as sets

Example:
![[Pasted image 20260910112918.png]]
Example of where it's required:
	Of the students enrolled in courses, which ones are _not_ enrolled in any courses for graduate credit
Why does this not work:
- π$_{student\_id}($σ$_{credit\_status != ‘graduate’}$(Enrolled))
This query does work:
- π$_{student\_id}$(Enrolled) − π$_{student\_id}$(σ$_{credit\_status = ‘graduate’}$(Enrolled))
# Assignment
What it does: assigns the result of an operation to a temporary variable, or to an existing relation.
Syntax: `relation` ← rel. alg. expression
Uses:
- simplifying complex expressions
- example: recall this expression
result = σ$_{room}$ = $_{BigRoom.name}$(Course × ρ$_{BigRoom}$(σ$_{capacity > 200}$(Room)))
- simpler version using assignment:
BigRoom ← σ$_{capacity > 200}$(Room)  
result ← σ$_{room}$ = $_{BigRoom.name}$(Course × BigRoom)

# SQL 
**S**tructured **Q**uery **L**anguage
The query language used by most RDBMSs.
Originally developed at IBM as part of System R – one of the first RDBMSs.

## Syntax
The **FROM** clause specifies which **table** you are using.
The **WHERE** clause specifies which **rows** should be included in the result.
The **SELECT** clause specifies which **columns** should be included.

## SQL and Relational Algebra
![[Pasted image 20260910114657.png]]
### Example Query
Given these relations:
- _Student(id, name)_
- _Enrolled(student_id, course_name, credit_status)_
- _MajorsIn(student_id, dept_name)_
We want to find the major of the student John Tukey*.

Here’s a query that will give us the answer:

```SQL
SELECT dept_name 
FROM Student, MajorsIn 
WHERE name = 'John Tukey' 
AND id = student_id;
```

![[Pasted image 20260910115033.png]]
```SQL
SELECT dept_name FROM Student, MajorsIn
WHERE name = 'John Tukey' AND id = student_id;
```
![[Pasted image 20260910115102.png]]![[Pasted image 20260910115109.png]]
![[Pasted image 20260910115132.png]]Join happens at `id = student_id;`


## Join Conditions

Query from last problem:
```SQL
SELECT dept_name
FROM Student, MajorsIn
WHERE name = 'John Tukey'
AND id = student_id;
```

`id = student_id` is a _join condition_ – a condition that is used to match up “related” tuples from the two tables.
it selects the tuples in the Cartesian product that “make sense”
for N tables, you typically need N – 1 join conditions
![[Pasted image 20260910115654.png]]

## The LIKE Operator and Wildcards
Use LIKE whenever we need to match a pattern.
Form the pattern using one or more _wildcard characters_:
- % stands for 0 or more arbitrary characters
- _ stands for a single arbitrary character

```SQL
SELECT * FROM Movie WHERE rating LIKE 'PG%'
```

## Comparisons with NULL 
Because NULL is a special value, any comparison involving NULL that uses the standard operators is _always_ false.
For example, all of the following will always be false:

```SQL
`room = NULL` `NULL != 10`
`room != NULL` `NULL = NULL`
```

This is useful for cases like the following:
    - assume that we add a country column to Student
    - use NULL for students whose country is unknown
![[Pasted image 20260910120154.png]]
```SQL
SELECT name FROM Student
WHERE country != 'USA';   -- won't include NULLs
```

To test for the presence or absence of a NULL value, use special operators: `IS NULL` `IS NOT NULL`

Example: find students whose country is
```SQL
SELECT name FROM Student WHERE country IS NULL;
```

## Removing Duplicates
By default, a SELECT command _may_ produce duplicates
To eliminate them, add `DISTINCT`

```SQL
SELECT DISTINCT column1, column2, …
```

## COUNT Function
In what follows, we’ll use the COUNT function.

COUNT is an _aggregate_ function. It counts the number of values of an attribute or the number of tuples in a relation.

### COUNT( \* ) vs COUNT(attribute)

SELECT COUNT(\*\) counts the number of tuples in a result.
Example: find the total number of courses
```SQL
SELECT COUNT(*)
FROM Course;
```
Result: 6
![[Pasted image 20260910120749.png]]
SELECT COUNT(attribute) counts the number of _non-NULL_ values of that attribute in a result.
example: find the number of courses that meet in a room

```SQL
SELECT COUNT(room_id)
FROM Course;
```
result: `COUNT(room_id) = 5`

## Applying an Aggregate Function to Subgroups
A GROUP BY clause allows us to:
- group together tuples that have a common value
- apply an aggregate function to the tuples in each subgroup
Example: find the enrollment of each course:
```SQL
SELECT course_name, COUNT(*)
FROM Enrolled
GROUP BY course_name;
```
When you group by an attribute, you can include it in the SELECT clause alongside an aggregate function

## Question:
![[Pasted image 20260910121257.png]]
![[Pasted image 20260910121309.png]]
## GROUP BY + WHERE
```SQL
SELECT course_name, COUNT(*)
FROM Enrolled
WHERE credit_status = 'ugrad'
GROUP BY course_name;
```
![[Pasted image 20260910121416.png]]
## Sorting the Results
An ORDER BY clause sorts the tuples in the result of the query by one or more attributes.
example:
```SQL
SELECT name, capacity
FROM Room
WHERE capacity >= 500
ORDER BY capacity;
```
![[Pasted image 20260910121513.png]]
- ascending order by default, use DESC to get descending
![[Pasted image 20260910121533.png]]