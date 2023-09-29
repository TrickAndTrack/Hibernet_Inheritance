# Hibernet_Inheritance
In this we create the curd operation of one-to-one, one-to-many, many-to-many. 
# Agenda
* Hibernate Basic
  * why Hibernate
  * what is Hibernate
* Hibernate ORM features
  * Hibernate Configuration Files
  * Features of Hibernate ORM
  * JPA(Java Persistence Application Programming Interface)
  * Hibernate programming Model
  * Hibernate architecture
  * persistent Object
  * Hibernate Core APIs
  * Hibernate Interface
* Hibernate Project
* Hibernate Annotations
* Hibernate CURD Operations
* HQL
* Native SQL Query and Criteria Query
* Caching in Hibernate
* Transaction Management

# Introduction
* Hibernate is a framwework that simplifies the developemnt of java application to interact with the database.
* HIBERNATE Converts database - specific query automtically, base on dialect provided, it uses (HQL hibernate Query Language), which is independent of database.


  ## Advantages of using ORM
* it can significntly reduced the developemnt time
* it involves writing less code
* it increases system performace
* you can support different database managment systems by adopting ORM. it provides portability

# Hibernate ORM features
As an object rellational mapping ORM framework, hibernate is connected with data persistence as it applies to realtional database (via JDBC).
 ## Hibernate Configuration Files
 * DBMS-specific details and mappiong file deatils are specified in hibernate.cfg.xml and mappingfile.xml.
 * Hibernate engine uses these files to generate DBMS-specific SQL syntax.
 ## Features of Hibernate ORM
 * hibernate ORM provides its own native API, in addition to full JPA(Java persistance API) supports.
   * Hibernate model implements Java Persistence object relational API.
   * hibernate persistance provider can be used in any environment of Java SE or Java EE
 * it maps Java POJO's(Plain Old Java Object) to releational database.
 * it provides rich tool set.
 * performance: Fetch strategies, caching, byte code enhancement
 * It is part of JBoss community.
 ## Hibernate programming Model
 ![image](https://github.com/TrickAndTrack/Hibernet_Inheritance/assets/73180409/cd8239f7-1c3c-44cf-afd9-414acbdca650)
 ## Hibernate architecture
 ![image](https://github.com/TrickAndTrack/Hibernet_Inheritance/assets/73180409/af5a3d48-01a8-412f-a69b-4542ec854c95)
 ## persistent Object
 * Session object is created within the Database Layer in every DAO method. it is known as p[ersistence Object.
 It has three lifecycle states:
 * Transient:
 * persistent:
 * Detached:
 ## Hibernate Core APIs
 * Configuration (org.hibernate.cfg): it gives two services in hibernate application.
   * Loads mapping file and configuration file into memory and makes them available to hibernate engine.
   * Acts as factory to create the session factory
 * SessionFactory(org.hibernate.SessionFactory)
   * SessionFactory is one per DBMS (mostly one per application)
   * SessionFactory is thread safe
   * SessionFactory is not a singleton
   * It creates Session object, SessionFactory encapsulates, second level cache, connection pool, meta informtion cache and pool of session.
 ## Hibernate Interface
 * Session(org.hibernate.Session)
   * Hibenrate engine implements Session interface.
   * Session object acts as persistent manager
   * Session object is a light weight objet
   * It encapsulates connection and first level cache
   * Session object is not thread-safe
   * In every dao method, Session object is created
   * It is used for CURD operation.
 * Transaction(org.hibernate.Transaction)
   * Hibernate engine implements this interface
   * When database connection is created by hibernate, connection associated with session is in autocommit disable mode.
   * whenever any CRUD operation is performed, the changes will not be reflected in the database unless connection is maintained in auto-commit enabled enabled mode.
# Hibernate Project
* setting up project with Hibernate
![S1](https://github.com/TrickAndTrack/Hibernet_Inheritance/assets/73180409/da959fb9-4346-4b24-a944-6b3466293b0d)
* Download the latest version of hibernate
* Right click on project
* Click on build path
* Click on add External JARs
* Add all requred Hibernate JARs
* Download mysqlconnector.jar from:
* Downlaod link for ojdbc14.jar for oracle 11g:
  
|1st step | 2nd step    ↩|
|-------------|-------------|
|![image](https://github.com/TrickAndTrack/Hibernet_Inheritance/assets/73180409/d51aae87-192a-4e15-9921-cbb10d5fdd39)|![image](https://github.com/TrickAndTrack/Hibernet_Inheritance/assets/73180409/1b7c921c-05ca-4224-bcb9-9968338a0293)|
|![image](https://github.com/TrickAndTrack/Hibernet_Inheritance/assets/73180409/67c6e73d-c0f5-43ba-88e5-1107482c5137)|![image](https://github.com/TrickAndTrack/Hibernet_Inheritance/assets/73180409/5d96a04f-441e-4cdd-904d-e1bca9ff01ba)|
|![image](https://github.com/TrickAndTrack/Hibernet_Inheritance/assets/73180409/3500c6cf-91f6-46f5-b099-58291ebd23d5)|![image](https://github.com/TrickAndTrack/Hibernet_Inheritance/assets/73180409/9212efae-b19b-4a14-a9e1-671eacf2e5ad)|

# Hibernate Annotations
Hibernate annotation is the newest way to define mappings wihtout the use of XML file. you can use annotation in addition to or as a replacment of XML mapping metadata.
* `@Entity`: Specifies that the class is an entity. This annotation is placed on the class name.
* `@Id`: Specifies the primary key of the entity. In this case, id is the primary key.
* `@GeneratedValue`: Indicates that the primary key should be automatically generated. Here, it's set to GenerationType.IDENTITY, which means an auto-incremented column in the database.
* `@Table(name = "student")`: Specifies the name of the database table to which the entity will be mapped.

 ```
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    // Constructors, getters, and setters

    // Getters and setters
    // Generated getters and setters for id, username, and email
}
```
>  Use POJO class Student, hibernate.cfg.xml and annontaions instead of hibernate mapping file.
* Configuration.config
  ![image](https://github.com/TrickAndTrack/Hibernet_Inheritance/assets/73180409/713ab9ee-d929-4f52-8e9a-a795e6be81d2)
# CURD Operation
* The acronym CRUD stands Create, Read, Update and Delete
* They are four basic operations that any data-driven application perfroms often
* Hibernate also supports CURD operation by means of Session interface.
 ## Limitation of using session method
 * Multiple persistent objects can't be expressed to perform some complex CRUD operation.
 * Multiple delet and update operations are not possible
 * Required criteria can't be expressed to perform some complex CRUD operation.
   ## To overcome the above limitaions the following are used:
   * HQL
     * it gives query language provide by hibernate,
     * it is same as SQL but it doesnt depend on the table of the database, it uses classes.
   * Criteria API
     * It is one way of querying the DB in the hibernate application
     * It can be used for DML (Database Manipulation Language) operations
     * Criteria API is an object oriented after native for HQL to read data from database
     * Criteria API supports compile time checking for the query that we build, unlike HQL
   * Native SQL
     


 

