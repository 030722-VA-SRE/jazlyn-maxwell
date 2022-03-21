# SQL

### Relations

* Explain what SQL is. What are some SQL databases?

    - SQL stands for Structured Query Language. It is used to create, manage, 
    and access relational databases.
    - SQL implementations include PostgreSQL, MS SQL Server, MySQL, and OracleSQL.

* How is data structured in a SQL database?

    - Data is placed into tables. Every column in the table represents an attribute 
    or field. Each row, called a record, represents an individual item of data.
    
* What is an ERD? How is it useful?

    - ERD stands for Entity Relationship Diagram. An ERD is a visual representation
    of the different tables in a database and models the relationships between 
    different tables.
    - ERD can be a useful tool when designing a database, and can be used as 
    helpful documentation when accessing a database.

* What are the different multiplicity relationships? How would you create these relations?

    - Relationships in a RDBMS can be one-to-one, one-to-many/many-to-one, or many-to-many.
    - A one-to-one relationship is implemented by refencing a primary key in another 
    table. To ensure that the relationship remains one-to-one and one row references
    exactly one other row, the foreign key should also be either a primary key or
    have a unique constraint.
    - A many-to-one relationship is a relationship in which many rows may reference
    one row. A table must simply reference another table in order to implement this
    type of relation. Note that the table with the foreign key represents the 'many'
    side of this relation.
    - A many-to-many relationship occurs when many rows may reference many other rows
    in another table. In SQL, this is done by creating a separate junction table
    which references both tables in the many-to-many relation.

* What kind of relationship would exist between Students and Classes? Students and Textbooks?

    - Students and Classes have a many-to-many relation. A Student may take many
    Classes and a Class may have many Students.
    - Students and Textbooks have a one-to-many relation. A Student may have many
    Textbooks, but a Textbook only belongs to one Student.

* Explain the concept of referential integrity

    - Referential integrity means that every entry in a foreign key column has a matchning 
    record in the associated table.
    - We don't want orphaned records, or foreign keys that don't have a matching
    primary key, in our database.

* What is a cascade delete?
    
    - With a cascade delete, if a record referenced by records in other tables 
    is deleted, then all records referencing it will also be deleted.

* List the integrity constraints

    - Domain constraints define the valid set of values for an attribute. You
    can also specify that a value should be unique or not null.
    - The entity integrity constraint prevents the primary key of a table
    from being null. We cannot use the primary key to identify a record if
    the priomary key is null.
    - Referential integrity constraints require foreign keys to be null or
    match existing records in the referenced table.
    - Key constraints identify the attribute(s) that will be used to uniquely
    identify all records in the table.
    
* Define the word "schema"

    - A database schema is a collection of tables, views, triggers, and functions.
    
* What is a candidate key? What about a surrogate key?

    - A candiadate key is any attribute or set of attributes that are unique 
    for all records in a table, qualifying them to be used as a primary key.
    - Surrogate keys are primary keys used in a database to uniquely identify
    a record, but is not related or derived from the data itself. A surrogate
    key is artificially generated.

### Sublanguages & Queries
    
* What are the 5 sublanguages of SQL? List some commands for each
    
* What is the difference between DELETE, DROP, and TRUNCATE commands?
    
* What are some SQL clauses you can use with SELECT statements?
   

* What is the difference between joins and set operators?

* What are the types of joins? Explain the differences.
 

* Explain the difference between UNION, UNION ALL, and INTERSECT

### Transactions

* What are the properties a transaction must follow?
 

* Explain the different isolation levels. What read phenomena do each prevent?

### Practicals

Given the following table 'employees'...

| id | firstName | lastName | salary | dept |
| --- | -------- | -------- | ------ | ---- |
| 1  | Michael   | Scott    | 65     | Sales|
| 2  | Dwight    | Schrute  | 75     | Sales|
| 3  | Toby      | Flenderson| 80    | HR  |
| 4  | Jim       | Halpert  | 90     | Sales|
| 5  | Oscar     | Martinez | 90     | Accounting |
| 6  | Angela    | Martin   | 75     | Accounting |
| 7  | Kevin     | Malone   | 70     | Accounting |
| 8  | Holly     | Flax     | 60     | HR |
| 9  | Creed     | Branton  | 70     | Quality Assurance |

* Write a query to find all data in the table

* Write a query to find employees with a salary over 75

* Write a query to find employees whose first name contains an 'e' or whose last name begins with 'S'\

* Write a query to find the first name of all employees who do not work in accounting

* Write a query to find the average salary of all employees whose last names begin with 'M'

* Write a query to find the highest paid salesperson

* Write a query to combine the resultsets of any two previous queries

* Remove all members of accounting from the database


* Given removing the dept column from the employees table and creating a table 'department' and linking the two via a foreign key relationship

| dept_id | name |
| ------- | ---  |
| 1       | Sales |
| 2       | HR   |
| 3       | Accounting |
| 4       | Customer Service |

* Write a query to find the salary of the lowest paid salesperson (HINT: use a join)

* Write a query to find the average salary of each department

* Write a query to find all possible combinations of employees and departments. How many records do you expect?

* Change the name of department 4 to 'Quality Assurance'

* Remove both tables

# JDBC
1.	What is JDBC?
2.	What are the core interfaces / classes in JDBC?
3.	What is a stored procedure and how would you call it in Java?
4.	What is the difference between Statement and PreparedStatement?
5.	Steps to executing an SQL query using JDBC?

# AWS

### Cloud / AWS Overview
* How would you describe AWS? What is "the cloud" or "cloud computing" and why is it so popular now?

* Define Infrastructure, Platform, and Software as a Service
 
* What's the difference between a Region and an Availability Zone (AZ)?
 
* How are you charged for using AWS services? Does it vary by service?
 
* Different ways to interact with AWS services?


### EC2

* What are the configuration options for EC2?
 
* What are the different EC2 instance sizes/types?
 
* Once you create an EC2, how to connect to it?
 
* What are Security Groups? When defining a rule for a security group, what 3 things do you need to specify?
  
* What's the difference between scalability, elasticity, and resiliency?
 
* Ways of paying for EC2?


### RDS

* What's an RDS?

* Which vendors are supported?


# UNIX/LINUX

* What are the differences between a Thread and Process and a Service?

* Write a basic bash script 
    * ie: installing java/maven/git to an ec2
    * if you're feeling ambitious, a script that would delete a file if it exists


