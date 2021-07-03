## Catalog Application

#### Description
Developer is expected to build/create below mentioned APIS for the catalog
application, below mentioned are the descriptions of what a catalog application is and what
are the apis that need to be built.

#### Technologies

    - Spring Boot - Server side framework
    - Lombok - Provides automated getter/setters
    - Swagger - In-built swagger documentation support
    - MySql DB  - Database
#### Prerequisite
  * Set the following environment variables:

       **DB_URL**  :  It should contain the database URL. 
        Example: jdbc:mysql://localhost:3306/**<DB_NAME>**
       
       **DB_USERNAME** : It should contain username.
       
       **DB_PASSWORD** : It should contain password.


  * Please create a database[if it doesn't exist] with the same name [DB_NAME] that you kept in **DB_URL**
       
      

#### Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `src/main/java/com/omnirio/assignment/AssignmentApplication.java` class from your IDE.

- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one)
- Open Command Prompt and Change directory (cd) to folder containing pom.xml
- Open Eclipse 
   - File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
   - Select the project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and Run as Java Application

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
#### Note
If you get any permission related issue for port.Please change the port in application.yml file. Default port is 9090 for this APP.

### APis: Please refer swagger for following APIs.
1) To create a category.

2)  To create category attributes.

3)  To create a product by linking it to category and its attributes.

4)  Get product by id.

5)  get category attributes by category id.

#### Swagger Documentation

> Swagger documentation is in-built in this app and can be accessed at the following URL:
> 
>   http://<host>:<port-number>>/swagger-ui.html#/catalog-controller  
> example: http://localhost:9090/swagger-ui.html#/catalog-controller 