- To run this backend project :

-1 : install maven 3  / JDK 1.8
-2 : install mariaDb database
-3 : import sql file in mysql console : sample-install.sql 
-4 : go to this project location by console
-5 : create class-path for eclipse :mvn eclipse:eclipse
-6 : run command mvn clean jetty:run  or mvn clean tomcat7:run
-7 : sample APIs :
a) monitor api : http://localhost:8080/api/monitor/v10
b) category api: http://localhost:8080/api/category/v1/all

8 - tool creating PDF Documents With Wkhtmltopdf (converting from html to pdf)
http://localhost:8080/api/htmltopdf/v1?url=http://www.google.com
