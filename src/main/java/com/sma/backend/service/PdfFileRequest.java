package com.sma.backend.service;

public class PdfFileRequest {
    private String fileName;
    private String sourceHtmlUrl;
 
    public String getFileName() {
        return fileName;
    }
 
    public String getSourceHtmlUrl() {
        return sourceHtmlUrl;
    }
 
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
 
    public void setSourceHtmlUrl(String sourceHtmlUrl) {
        this.sourceHtmlUrl = sourceHtmlUrl;
    }
}
