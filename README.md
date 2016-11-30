![Travis Build](https://travis-ci.org/sophea/sample-backend-template.svg?branch=master)
[![Codecov](https://codecov.io/github/sophea/sample-backend-template/coverage.svg?branch=master)](https://codecov.io/github/sophea/sample-backend-template?branch=master)
![Java 8 required](https://img.shields.io/badge/java-8-brightgreen.svg)
[![Sputnik](https://sputnik.ci/conf/badge)](https://sputnik.ci/app#/builds/sophea/sample-backend-template)

sample-backend-template
=======================

rest-api backend none-gae : tomcat | jetty + database mybatis frameworks


To run this backend project : git clone from git hub : https://github.com/sophea/sample-backend-template

1 : install Java JDK 1.8 or later version , maven 2 or 3 

2 : install mariaDb database (https://downloads.mariadb.org/)

3 : import sql file in mysql console : sample-install.sql 

4 : go to this project location by console

5 : create class-path for eclipse :mvn eclipse:eclipse

6 : run command mvn clean jetty:run  or mvn clean tomcat7:run

7 : sample APIs :

 a) monitor api : http://localhost:8080/api/monitor/v10
 
 b) category api: http://localhost:8080/api/category/v1/all
 b) category api: http://localhost:8080/api/category/v1/2


If you want to change database type :  have a look on file persistence-db.xml


8 : Tool creating PDF Documents With Wkhtmltopdf (converting from html to pdf)

To use this, Your server must install wkhtmltopdf : http://wkhtmltopdf.org/downloads.html

It support all platforms window / linux / MacOS

ex : http://localhost:8080/api/htmltopdf/v1?url=http://www.google.com

```sh
public void converthtmlToPdf(HttpServletRequest request, HttpServletResponse response, @RequestParam String url) {
        LOGGER.info("/htmltopdf/v1 - {}", url);
        
            //write to response
            final PdfFileRequest pdfFile = new PdfFileRequest();
            final String tempName = String.format("SYS-%s.pdf", RandomStringUtils.random(10, true, true));
            pdfFile.setFileName(tempName);
            pdfFile.setSourceHtmlUrl(url);
            PdfFileCreator.writePdfToResponse(pdfFile, response);
    }
    
 Class PdfFileCreator.java
 ==========================
 public static void writePdfToResponse(PdfFileRequest fileRequest, HttpServletResponse response) {
        final String pdfFileName = fileRequest.getFileName();
        requireNotEmpty(pdfFileName, "File name of the created PDF cannot be empty");
 
        String sourceHtmlUrl = fileRequest.getSourceHtmlUrl();
        requireNotEmpty(sourceHtmlUrl, "Source HTML url cannot be empty");
 
        final List<String> pdfCommand = Arrays.asList(
                "wkhtmltopdf",
                sourceHtmlUrl,
                "-"
        );
 
        ProcessBuilder pb = new ProcessBuilder(pdfCommand);
        Process pdfProcess;
 
        try {
            pdfProcess = pb.start();
 
            try(InputStream in = pdfProcess.getInputStream()) {
                writeCreatedPdfFileToResponse(in, response);
                waitForProcessBeforeContinueCurrentThread(pdfProcess);
                requireSuccessfulExitStatus(pdfProcess);
                setResponseHeaders(response, fileRequest);
            }
            catch (Exception ex) {
                writeErrorMessageToLog(ex, pdfProcess);
                throw new RuntimeException("PDF generation failed");
            }
            finally {
                pdfProcess.destroy();
            }
        }
        catch (IOException ex) {
            throw new RuntimeException("PDF generation failed");
        }
    }
```
