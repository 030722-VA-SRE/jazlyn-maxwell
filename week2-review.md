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

    - **Data Definition Language (DDL)** is used to create, edit, and delete
    data entities, such as databases, schemas, uasers, tables, and properties.
    CREATE, ALTER, DROP, and TRUNCATE are all DDL commands.
    - **Data Control Language (DCL)** is used to manage user permissions
    within a database. GRANT and REVOKE are DCL commands.
    - **Data Manipulation Language (DML)** is used to interact with records
    within tables. INSERT, UPDATE, and DELETE are DML commands.
    - **Data Query Language (DQL)** is used to retrieve information from tables.
    SELECT is the main operation used to query data. WHERE, GROUP BY, HAVING, 
    ORDER BY, and LIMIT are all DQL commands used to filter data.
    - **Transaction Control Language (TCL)** is used to create and manage 
    transactions. Transactions combine multiple operations into a unit of work.
    BEGIN, SAVEPOINT, ROLLBACK, and COMMIT are TCL commands.
    
* What is the difference between DELETE, DROP, and TRUNCATE commands?
    
    - DELETE removes records from a TABLE, can use a WHERE clause to select
    which records to remove.
    - DROP deletes an entire table and all of its records.
    - TRUNCATE removes all the records from a table (but not the table 
    itself).

* What are some SQL clauses you can use with SELECT statements?
   
   - WHERE, GROUP BY, HAVING, ORDER BY, and LIMIT are all DQL commands that 
   can be used with SELECT statements.

* What is the difference between joins and set operators?

    - JOINS combine rows from different tables based on a logical relationship,
    typically a foreign key relationship.
    - Set operators combine queries together. Set operations are used on 
    queries on the same table. UNION, UNION ALL, INTERSECT, and EXCEPT are
    all set operations.

* What are the types of joins? Explain the differences.
 
    - (INNER) JOIN returns all records that have *matching* values in both 
    tables.
    - LEFT (OUTER) JOIN returns all records in the *left* table and matching 
    records in the right table.
    - RIGHT (OUTER) JOIN returns all records in the *right* table and mathcing
    records in the left table.
    - FULL (OUTER) JOIN returns all records in *both* tables
    - SELF JOIN joins a table to itself to combine related data on the same table.

* Explain the difference between UNION, UNION ALL, and INTERSECT

    - UNION combines the query sets and removes duplicate records
    - UNION ALL combines the query sets, but does not remove duplicate records
    - INTERSECT returns the common records from both data sets
    - EXCEPT returns a dataset where the results from the second query are
    removed from the first.

### Transactions

* What are the properties a transaction must follow?
 
    - **Atomicity:** a transaction should either occur in its entirety or not at all.
    - **Consistency:** a database should be in a valid (according to database constraints and 
    business logic) state before and after every transaction.
    - **Isolation:** a transaction should not interfere with another transaction. Concurrent
    transactions should behave the same as sequential transactions.
    - **Durability:** changes made during a transaction should be persisted to the database.

* Explain the different isolation levels. What read phenomena do each prevent?

    - Read uncommited allows data to be read from an uncommitted transaction. This allows all 
    read phenomena to be possible.
    - Read committed  only allows data to be read from committed transactions. This isolation 
    level prevents the dirty read phenomena.
    - Repeatable read only allows data to be seen that was committed before the transaction 
    began. This isolation level prevents the nonrepeatable read phenomena from occuring.
    - Serializable is the strictest level of isolation and forces transactions to occur 
    sequentially. This prevents the phantom read phenomena from occuring.

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

    ```select * from employees;```

* Write a query to find employees with a salary over 75

    ```
    select * from employees 
    where salary > 75;
    ```

* Write a query to find employees whose first name contains an 'e' or whose last name begins with 'S'\

    ```
    select * from employees 
    where firstName like '%e%' OR lastName like 'S%';
    ```

* Write a query to find the first name of all employees who do not work in accounting

    ```
    select firstName from employees 
    where dept != 'Accounting';
    ```

* Write a query to find the average salary of all employees whose last names begin with 'M'

    ```
    select AVG(salary) from employees 
    where lastName like 'M%';
    ```

* Write a query to find the highest paid salesperson

    ```
    select * from employees 
    where dept = 'Sales' 
    order by salary 
    limit 1;
    ```

* Write a query to combine the resultsets of any two previous queries

    ```
    (select * from employees where salary > 75) 
    union 
    (select * from employees where firstName like '%e%' OR lastName like 'S%');
    ```

* Remove all members of accounting from the database

    ```delete from employees where dept = 'Accounting';```

* Given removing the dept column from the employees table and creating a table 'department' and linking the two via a foreign key relationship

| dept_id | name |
| ------- | ---  |
| 1       | Sales |
| 2       | HR   |
| 3       | Accounting |
| 4       | Customer Service |

* Write a query to find the salary of the lowest paid salesperson (HINT: use a join)

    ```
    select salary from employees
    join department on employees.dept_id = department.dept_id
    where name = 'Sales'
    order by salary asc
    limit 1;
    ```

* Write a query to find the average salary of each department

    ```
    select name, AVG(salary) from employees
    join department on employees.dept_id = department.dept_id
    group by dept_id;
    ```

* Write a query to find all possible combinations of employees and departments. How many records do you expect?

    ```
    select * from employees
    cross join department;
    ```
    - I expect to see 36 records

* Change the name of department 4 to 'Quality Assurance'

    ```
    update department 
    set name = 'Quality Assurance' 
    where dept_id = 4;
    ```

* Remove both tables

    ```
    drop table employees;
    drop table department;
    ```

# JDBC
1.	What is JDBC?

    - Stands for the *Java Database Connectivity*. Establishes a conection between
    a java application and a statbase. 

2.	What are the core interfaces / classes in JDBC?

    - The DriverManager class manages the JDBC driver and provides the get connection method.
    - The Connection interface represents the connection to your database.
    - The Statement and PreparedStatement interfaces represent a SQL statement.
    - The ResultSet interface represents the result of a query.

3.	What is a stored procedure and how would you call it in Java?

    - A stored procedure is a set of database operations stored for reusability.
    - A stored procedure can be prepared in Java by using the Connection.prepareCall() method 
    to create a CallableStatement and executing it with the executeQuery() method.

4.	What is the difference between Statement and PreparedStatement?

    - A PreparedStatement has been preprocessed to prevent SQL injection. Methods can be used 
    to set the fields of a PreparedStatement. A Statement is executed as-is and is vulnerable 
    to SQL injection.

5.	Steps to executing an SQL query using JDBC?

    - First, establish a connection. Then, create a statement using a SQL query represented 
    as a String. Then, execute the query using the execute(), executeQuery() or executeUpdate() methods. If required, process the ResultSet object. Finally, close the connection.

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


