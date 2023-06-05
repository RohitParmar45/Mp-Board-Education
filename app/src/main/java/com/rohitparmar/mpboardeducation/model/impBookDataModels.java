package com.rohitparmar.mpboardeducation.model;

public class impBookDataModels {
    private String pdfTitle, pdfUrl, chapName;

    public impBookDataModels() {
    }

    public impBookDataModels(String pdfTitle, String pdfUrl, String chapName) {
        this.pdfTitle = pdfTitle;
        this.pdfUrl = pdfUrl;
        this.chapName = chapName;
    }

    public String getChapName() {
        return chapName;
    }

    public void setChapName(String chapName) {
        this.chapName = chapName;
    }

    public String getPdfTitle() {
        return pdfTitle;
    }

    public void setPdfTitle(String pdfTitle) {
        this.pdfTitle = pdfTitle;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}
