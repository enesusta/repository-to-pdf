package com.enesusta.codetopdf;

import com.enesusta.codetopdf.itext.Colorized;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TexFactory {

    private File file;
    private FileOutputStream fileOutputStream;
    private Factory factory;
    private DirectoryList directoryList;
    private List<String> codePath;
    private Document document;
    private Colorized colorizedSource;
    private StringBuilder bigString;

    public TexFactory(String fileName) throws FileNotFoundException {


        //file = new File(SharedConstans.defaultPath + SharedConstans.sep + "codetopdf.tex");
        fileOutputStream = new FileOutputStream(new File(System.getProperty("user.home")+"/a.tex"));

        directoryList = new DirectoryList(fileName);
        codePath = directoryList.getAbsolutePaths(fileName);
        document = new Document();
        colorizedSource = new Colorized();
        bigString = new StringBuilder();

    }

    public void createPDF() {


        try (PrintStream printStream = new PrintStream(fileOutputStream)) {


            printStream.println(Base.text);

            for (String code : codePath)
                if (!(code.contains("R.java")))
                    printStream.println("\\lstinputlisting{" + code + "}");


            printStream.println("\\end{document}");


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void show() {
        codePath.stream().forEach(System.out::println);
    }


    public void isDone() {

        String pathBase = "/home/phield/Music/";
        bigString = new StringBuilder();
        Document temp = new Document();
        ColumnText columnText;

/*
            PdfWriter writer = PdfWriter.getInstance(temp, fileOutputStream);
            temp.open();
            columnText = new ColumnText(writer.getDirectContent());
*/
            for (String code : codePath) {

                JavaSourceReader sourceReader = new JavaSourceReader(new File(code));
                bigString.append(sourceReader.getSource());
            }

/*
            temp.add(new Chunk(""));
            colorizedSource.addHighlightedDocumentToDocument(temp,bigString.toString());
            colorizedSource.addHighlightedColumnTextToDocument(columnText,bigString.toString());


            temp.close();
*/
    }

    public String getBigString() {
        return bigString.toString();
    }


}
