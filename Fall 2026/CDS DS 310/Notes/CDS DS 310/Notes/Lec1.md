# Database Design
we determine what to include, how they are related, how they should be grouped/decomposed
	end result: logical schema for database
## ER Models
`Entity-Relationship Model`
a tool for db design
	graphical
	implementation-neutral
	![](https://ds310.cds.bu.edu/images/L01-Intro-ER/slide002.png)
	They specify relevent things and their relationships
## Sample Domain: University
Data: Employees, students courses, departments
How many tables we need can't be determined at first
	hard to determine which tables are needed to encode *relationships between* data items
## Entries, AKA the "things"
represented using rectangles
each rectangle represents an _entity set_, which is a collection of individual entities 
## Attributes
Associated with entities are _attributes_ that describe them
represented as ovals connected to entities
double oval = multiple values

## Keys 
_key_ is an attribute or collection of attributes that can be used to uniquely identify each entity in an entity set
Observe that an entity set may have more than one possible key
![](https://ds310.cds.bu.edu/images/L01-Intro-ER/slide006.png)
Possible keys include:
    - _id_
    - _email_
    - _(id, email)_
    - _(id, name)_

### Candidate Key
_candidate key_ is a _minimal_ collection of attributes that is a key. Note that minimal = no unnecessary attributes are included
	Not same as minimum
### Primary Key 
We typically choose one of the candidate keys as the _primary key_.
In an ER diagram, the primary key attribute(s) are underlined

## Relationships Between Entities
Relationships between entities are represented using diamonds that are connected to the relevant entity sets
![[Pasted image 20260903115739.png]]
Strictly speaking, each diamond represents a _relationship set_, which is a collection of relationships between individual entities

### Attributes of Relationships
A relationship set can also have attributes.These attributes specify information associated with the relationships in the set
![[Pasted image 20260903115933.png]]
### Key of a Relationship Set
A key of a relationship set can be formed by taking the union of the primary keys of its participating entities.
![](https://ds310.cds.bu.edu/images/L01-Intro-ER/slide013.png)
The resulting key may or may not be a primary key as it may not be minimal

### Degree of a Relationship Set
_Enrolled_ is a _binary_ relationship set: it connects two entity sets. It has a degree = 2
![[Pasted image 20260903120351.png]]
also possible to have higher-degree relationship sets
![[Pasted image 20260903120402.png]]
### Relationships with Role Indicators
It’s possible for a relationship set to involve more than one entity from the same entity set
In such cases, we use _role indicators_ (labels on the lines) to distinguish the roles of the entities in the relationship
![[Pasted image 20260903120510.png]]
## Cardinality (or Key) Constraints
_cardinality constraint_ (or _key constraint_) limits the number of times that a given entity can appear in a relationship set
A key constraint specifies a functional mapping from one entity set to another
As a result, each course appears in at most one relationship in the _meets in_ relationship set.
The arrow in the ER diagram has same direction as the mapping
![](https://ds310.cds.bu.edu/images/L01-Intro-ER/slide018.png)
The presence or absence of cardinality constraints divides relationships into three types:
- many-to-one
- one-to-one
- many-to-many
### Many-to-One Relationships
_Meets In_ is an example of a _many-to-one_ relationship.
We need to specify a _direction_ for this type of relationship.
![[Pasted image 20260903120803.png]]
In general, in a many-to-one relationship from A to B:

![](https://ds310.cds.bu.edu/images/L01-Intro-ER/slide019.png)

an entity in A can be related to _at most one_ entity in B
an entity in B can be related to an arbitrary number of entities in A (0 or more)

### One-to-One
In a _one-to-one relationship_ involving A ***and*** B (not A to B)
- an entity in A can be related to _at most one_ entity in B
- an entity in B can be related to _at most one_ entity in A
We indicate a one-to-one relationship by putting an arrow on both sides of the relationship
![](https://ds310.cds.bu.edu/images/L01-Intro-ER/slide021.png)
### Many-to-Many
In a _many-to-many relationship_ involving A and B:
- an entity in A can be related to an arbitrary number of entities in B (0 or more)
- an entity in B can be related to an arbitrary number of entities in A (0 or more)

If a relationship has no cardinality constraints specified (i.e., if there are no arrows on the connecting lines), it is assumed to be many-to-many.
![[Pasted image 20260903121120.png]]
## Participation Constraints
Cardinality constraints allow us to specify that each entity will appear _at most_ once in a given relationship set.
Participation constraints allow us to specify that each entity will appear _at least_ once (i.e., 1 or more time).
- indicate using a thick line (or double line)
Example: each department must have at least one chairperson.
![[Pasted image 20260903121243.png]]
We say Department has _total participation_ in Chairs

We can combine cardinality and participation constraints
![](https://ds310.cds.bu.edu/images/L01-Intro-ER/slide029.png)
a person chairs at most one department

