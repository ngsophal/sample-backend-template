sample-backend-template
=======================

rest-api backend none-gae : tomcat | jetty


- To run this backend project : git clone from git hub

-1 : install maven 2 or 3  
-2 : install mariaDb database
-3 : import sql file in mysql console : sample-install.sql 
-4 : go to this project location by console
-5 : create class-path for eclipse :mvn eclipse:eclipse
-6 : run command mvn clean jetty:run  or mvn clean tomcat:run
-7 : sample APIs :
a) monitor api : http://localhost:8080/sample/api/monitor/v10
b) category api: http://localhost:8080/sample/api/category/v1/all
