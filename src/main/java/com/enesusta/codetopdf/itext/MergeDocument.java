package com.enesusta.codetopdf.itext;

import com.enesusta.codetopdf.Filter;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MergeDocument {

    public List<String> getPdfFilesFromCurrentDirectory() {

        String pathBase = "/home/phield/Music";
        List<String> tmp = new ArrayList<>();

        Filter filter = new Filter("pdf");
        File dir = new File(pathBase);

        File[] fList = dir.listFiles(filter);

        for (File file : fList)
            tmp.add(file.getAbsolutePath());


        return tmp;
    }


    public void doMerge()
        throws DocumentException, IOException {

        OutputStream outputStream = new FileOutputStream("/home/phield/Music/result.pdf");
        List<InputStream> list = new ArrayList<>();

        for (String code : getPdfFilesFromCurrentDirectory())
            list.add(new FileInputStream(new File(code)));


        com.lowagie.text.Document document = new com.lowagie.text.Document();
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
        document.open();
        PdfContentByte cb = writer.getDirectContent();

        for (InputStream in : list) {

            com.lowagie.text.pdf.PdfReader reader = new com.lowagie.text.pdf.PdfReader(in);

            for (int i = 1; i <= reader.getNumberOfPages(); i++) {

                document.newPage();
                //import the page from source pdf
                PdfImportedPage page = writer.getImportedPage(reader, i);
                //add the page to the destination pdf
                cb.addTemplate(page, 0, 0);
            }
        }

        outputStream.flush();
        document.close();
        outputStream.close();
    }


}
