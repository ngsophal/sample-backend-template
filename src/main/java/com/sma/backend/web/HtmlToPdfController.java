package com.sma.backend.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sma.backend.service.PdfFileCreator;
import com.sma.backend.service.PdfFileRequest;

/**
 * Display application status such as the version number of the application.
 * 
 * @author sm
 */
@Controller
@RequestMapping("htmltopdf")
public class HtmlToPdfController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HtmlToPdfController.class);

    @RequestMapping(value = "v1", method = RequestMethod.GET)
    public void converthtmlToPdf(HttpServletRequest request, HttpServletResponse response, @RequestParam String url) {
        LOGGER.info("/htmltopdf/v1 - {}", url);
        
            //write to response
            final PdfFileRequest pdfFile = new PdfFileRequest();
            final String tempName = String.format("SYS-%s.pdf", RandomStringUtils.random(10, true, true));
            pdfFile.setFileName(tempName);
            pdfFile.setSourceHtmlUrl(url);
            PdfFileCreator.writePdfToResponse(pdfFile, response);
    }
}
