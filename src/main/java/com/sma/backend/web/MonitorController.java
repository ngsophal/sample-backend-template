package com.sma.backend.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sma.backend.json.JMonitor;
import com.sma.backend.service.PdfFileCreator;
import com.sma.backend.service.PdfFileRequest;
import com.sma.backend.service.Version;

/**
 * Display application status such as the version number of the application.
 * 
 * @author sm
 */
@Controller
@RequestMapping("monitor")
public class MonitorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MonitorController.class);

    @RequestMapping(value = "v10", method = RequestMethod.GET)
    public ResponseEntity<JMonitor> monitor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.info("/monitor/v10");

        final JMonitor monitor = new JMonitor();
        final String version = Version.getVersion(request.getSession().getServletContext());
        monitor.setVersion(version);
        monitor.setMillis(System.currentTimeMillis());
        monitor.setIp(request.getRemoteAddr());
        
        String url= request.getParameter("url");
        if (url != null) {
            //write to response
            PdfFileRequest pdfFile = new PdfFileRequest();
            //
           // File temp = File.createTempFile("System", RandomStringUtils.random(10, true, true) + ".pdf");
            
            String tempName = String.format("SYS-%s.pdf", RandomStringUtils.random(10, true, true));
            pdfFile.setFileName(tempName);
            LOGGER.info(tempName);
            pdfFile.setSourceHtmlUrl(url);
            PdfFileCreator.writePdfToResponse(pdfFile, response);
        }
        return new ResponseEntity<JMonitor>(monitor, HttpStatus.OK);
    }
  
}
