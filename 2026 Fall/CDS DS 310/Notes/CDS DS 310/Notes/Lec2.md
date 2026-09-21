# Relationship Model
## History
Created by Edgar Ted Codd
Earlier data models were related to physical representation of data
New model was revolutionary because it provided data independence
Allows users to access the data without understanding how it is stored on disk

## Basic Concepts
A basic database consists of tables
Each row contains data that either describes
- an entity
- a relationship between 2 or more entities
Each column in a table represents one attribute of an entity
- each column has a domain of possible values
## Terminology
There are two sets of terminology
- table = relation
- row = tuple
- column = attribute
Both terms are used
## Requirements of a Relation
Each column must have a unique name
values must be of the same types
each cell must contain one single value
- it cant contain a list of something
no two rows can be identical
- aka no duplicates
## Null Values 
By default, the domains of most columns include a special value called *null*
Null values can be used to indicate that:
- the value of an attribute is unknown for a particular tuple
- the attribute doesn’t apply to a particular tuple
![[Pasted image 20260908112030.png]]
# Relational Schema
Schema contains of
- the name of the relation
- the name of its attributes
- the attributes' domains
	- ignore for now
eg
	Student(id, name, address, email, phone)
	
The schema of a relational database consists of the schema of all of the relations in the database.
## ER Diagram to Relational Database Schema
Process
-  entity set → relation with the same attributes
- relationship set → relation whose attributes are:
	- primary keys of the connected entity sets
	- the attributes of the relationship set
- Example:
![[Pasted image 20260908112550.png]]
## Renaming Attributes
When converting a relationship set to a relation, there may be multiple attributes with the same name. In which case, we need to rename them.
![[Pasted image 20260908112637.png]]
# Special Cases
## Many-to-One Relationship Sets
Ordinarily, a binary relationship set will produce three relations:
- one for the relationship set
- one for each of the connected entity sets
![[Pasted image 20260908112803.png]]Advantages of this approach:
- makes some types of queries more efficient to execute
- uses less space
![[Pasted image 20260908113128.png]]
Some reasons why you might not do this:
- If one or more entities don’t participate in the relationship, there will be null attributes for the fields that capture the relationship.
- If a large number of entities don’t participate in the relationship, it may be better to use a separate relation.
Eg. some courses dont have rooms
Simply using NULL's will solve your problems, however it might cause storage problems
- Data driven solution
## One-to-One Relationship Sets
Here again, we’re able to have only two relations – one for each of the entity sets.
In this case, we can capture the relationship set in the relation used for _either of the entity sets._
![](https://ds310.cds.bu.edu/images/L02-Relational/slide012.png)
In this case, the second one makes more sense since almost every Department has a chair
## Many-to-Many Relationship Sets

For many-to-many relationship sets, we need to use a _separate relation_ for the relationship set
![](https://ds310.cds.bu.edu/images/L02-Relational/slide005.png)
Can’t capture the relationships in the _Student_ table
- a given student can be enrolled in multiple courses
Can’t capture the relationships in the _Course_ table
- a given course can have multiple students enrolled in it
Need to use a separate table:
- _Enrolled(student_id, course_name, credit_status)_

# Recall
## Keys and Candidate Keys
A key is an attribute or collection of attributes that can be used to uniquely identify each entity in an entity set
![](https://ds310.cds.bu.edu/images/L02-Relational/slide013.png)Possible keys include:
- id
- email
- (id, name)
A candidate key is a minimal collection of attributes that is a key.
- minimal = no unnecessary attributes are included
Note that (id, name) is not minimal, because we can remove name and still have a key

## Primary Key
We typically choose one of the candidate keys as the primary key. In an ER diagram, we underline the primary key attribute(s).
![](https://ds310.cds.bu.edu/images/L02-Relational/slide013.png)In the relational model, we also designate a primary key by underlying it.
					Person(**id**, name, address, …)
A relational DBMS (Data Base Management System) will ensure that no two rows have the same value / combination of values for the primary key.
- known as a **uniqueness constraint**

# Primary Keys of Relations for Entity Sets
When translating an _entity set_ to a relation, the relation gets the same primary key as the entity set.
![[Pasted image 20260908114252.png]]
# Primary Keys of Relations for Relationship Sets
When translating a _relationship set_ to a relation, the primary key depends on the cardinality constraints.
For a _many-to-many_ relationship set, we take the union of the primary keys of the connected entity sets.
![](https://ds310.cds.bu.edu/images/L02-Relational/slide016.png)
Doing so prevents a given _combination_ of entities from appearing more than once in the relation
It still allows a single entity to appear multiple times, as part of different combinations

For a many-to-one relationship set, if we decide to use a separate relation for it, what should that relation’s primary key include?
![[Pasted image 20260908114516.png]]
**Only the primary key of the entity set at the many end**

Limiting the primary key enforces the cardinality constraint
- in this example, the DBMS will ensure that a given book is borrowed by at most once person

We could also have eliminated the relation for Borrows; put the borrower’s id in the Book relation
	- could be bad because there might be alot of null values due to unborrowed books


For a _one-to-one_ relationship set, what should the primary key of the resulting relation be?
![[Pasted image 20260908114810.png]]**Either Key is OK**

# Foreign Keys
A _foreign key_ is attribute(s) in one relation that take on values from the primary-key attribute(s) of another relation
EG:
![](https://ds310.cds.bu.edu/images/L02-Relational/slide021.png)
Foreign keys are used to capture relationships between entities
All values of a foreign key must match the referenced attribute(s) of some tuple in the other relation
- AKA a **referential integrity** constraint

# Enforcing Constraints
EG. assume all tables below show all their tuples

Which additions wiuld the DBMS allow?

![](https://ds310.cds.bu.edu/images/L02-Relational/slide021.png)
A. adding (12345678, ‘John Smith’, …) to _Student_ → **no**, uniqueness constraint
B. adding (33333333, ‘Howdy Doody’, …) to _Student_ → **yes** 
C. adding (12345678, ‘physics’) to _MajorsIn_ → **no**, referential integrity constraint
D. adding (25252525, ‘english’) to _MajorsIn_ → **yes**

# Design Issue: Attribute or Entity Set
It can sometimes be hard to decide if something should be treated as an attribute or an entity set

![](https://ds310.cds.bu.edu/images/L02-Relational/slide022.png)
Indications that you should use an entity set:

- if it has attributes of its own that you wish to capture
- if, as an attribute, it could have multiple values
    - multi-valued attributes are problematic in some data models

---
# Relational Algebra

The query language proposed by Codd.
- a collection of operations on relations
Each operation:
- takes one or more relations
- produces a relation
![](https://ds310.cds.bu.edu/images/L02-Relational/slide025.png)
Relations are treated as sets.
- all duplicate tuples are removed from an operation’s result

## Selection
- What it does: selects tuples from a relation that match a predicate
    - predicate = condition
- Syntax: $\sigma_{predicate}(relation)$ 
![](https://ds310.cds.bu.edu/images/L02-Relational/slide026.png)
- Predicates may include: >, <, =, ≠, etc., as well as _and_, _or_, _not_



$$\pi_{title}(\sigma_{study\_uid=\pi_{study\_uid}(\sigma _{\text{status = 'completed'}}\text{(Application))}}(Study))$$


## Projection
- What it does: extracts attributes from a relation
- Syntax: $\pi _{attribute}(relation)$ 
![[Pasted image 20260908120658.png]]

## Combining Operations
Since each operation produces a relation, we can combine them
![[Pasted image 20260908120725.png]]



## Example
How many rows are in the result of this query?
![](https://ds310.cds.bu.edu/images/L02-Relational/slide029.png)
Answer: 2

![[Pasted image 20260908121032.png]]
# Mathematical Foundations: Cartesian Product
- Let 𝐴 be the set of values $\{a_1,a_2,…\}$, 𝐵 be the set of values $\{b1,b2,…\}$
- The _Cartesian product_ of two sets 𝐴 and 𝐵 (written 𝐴 × 𝐵) is the set of all possible ordered pairs $(𝑎_𝑖, 𝑏_𝑗)$, where 𝑎𝑖∈𝐴 and 𝑏𝑗∈𝐵.

- Example:
    - 𝐴 = {apple,pear,orange}
    - 𝐵 = {cat,dog}
    - 𝐴 × 𝐵 = { (apple, cat), (apple, dog), (pear, cat), (pear, dog), (orange, cat), (orange, dog) }

- 𝐶 = {5,10}
- 𝐷 = {2,4}

$$𝐶 × 𝐷 = \{ (5, 2), (5, 4), (10, 2), (10, 4) \}$$
- We can also take the Cartesian product of three or more sets.
- 𝐴 × 𝐵 × 𝐶 is the set of all possible ordered triples $(𝑎_𝑖, 𝑏_𝑗, 𝑐_𝑘)$, where $𝑎_i \in 𝐴$, $b_j \in B$, and $c_k \in C$.
    - example:
    - 𝐶 = {5,10}
    - 𝐷 = {2,4}
    - 𝐸 = {hi,there}
    - 𝐶 × **D** × 𝐸 = { (5, 2, hi), (5, 2, there), (5, 4, hi), (5, 4, there), (10, 2, hi), (10, 2, there), (10, 4, hi), (10, 4, there) }