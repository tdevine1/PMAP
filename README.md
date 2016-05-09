# PMAP

I am now the readme, fear me.

The PMAP project is a proof of concept to show that it is feasible and possible to port 
all end of year assessments to a digtial format for ease of taking and for instructors to 
easily see various datapoints shown by the assessments. 

Project Devs: Samuel Blankenship, Christopher Browning
Project Managers: 

Design: 
The project is a database backed, web application designed primarily in HTML, CSS, Javascript
and driven by a Java Spring Framework. The project contains many features that could be implemented
to make it a fully functional for the school if server space is allocated. 

Running:
In order to run this project you must have at least JDK 1.7+, Maven 3.3.9 +, and MySQL Workbench 6.0+.
To set up Maven if not already setup on your machine, the following link give a simple yet
detailed guide on setting up Maven on Windows.  (http://www.mkyong.com/maven/how-to-install-maven-in-windows/)
To start:

1. Start MySQL server and build the database on it using the latest create schema.
2. Change the database login information in the login page to point to your local database.
3. Open Command prompt and change the directory to the PMAP/Project_Managment_Assessment folder.
4. Use the command: MVN Jetty:Run.
5. Once Maven has compiled, using your browser open the following address: localhost:8080/PMA/login
