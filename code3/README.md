# Readme file

This README file explains how the attached code snippet can be executed by a user to attain the required output. 

- Pre-requisites:  
  JDK and Java Runtime Environment Packages(7)

- In order to achieve the results, execute the following steps:
1. Install a Mysql server on your machine using the following commands(for Linux):
  - sudo apt-get install mysql-server
  - Load your previous data into the server using: mysqldump --all-databases --all-routines -u root -p > ~/fulldump.sql
  - you can also enter the data indivisually by creating a database yourself : 
    $ mysql -uroot -p
     create database demo character set latin1;
     grant all privileges on demo.* to 'demo'@'localhost'
     identified by 'demo' with grant option;
     flush privileges;
     exit;
    $ mysql -udemo -pdemo -Ddemo
      (Now enter data using normal SQL commands)
2. Place the Java file at a known location(folder) in the system.
3. Compile/execute the aforementioned java file with the following commands:
  - javac code3.java
  - java code3


