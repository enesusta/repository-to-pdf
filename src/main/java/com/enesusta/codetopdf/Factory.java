package com.enesusta.codetopdf;


import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Factory {

    private String pdfName;
    private String pdfLocation;


    public void setPdfName(String pdfName) {
        this.pdfName = pdfName;
    }

    public void setPdfLocation(String pdfLocation) {
        this.pdfLocation = pdfLocation;
    }

    public String getPdfName() {
        return pdfName;
    }

    public String getPdfLocation() {
        return pdfLocation;
    }

    public class PdfFactory extends PrintStream {

        public PdfFactory(String fileName) throws FileNotFoundException {
            super(fileName);
        }
    }



}


