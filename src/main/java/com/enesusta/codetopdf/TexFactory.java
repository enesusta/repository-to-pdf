package com.enesusta.codetopdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;

public class TexFactory {

    private File file;
    private FileOutputStream fileOutputStream;
    private Factory factory;
    private DirectoryList directoryList;
    private List<String> codePath;

    public TexFactory(String fileName) throws FileNotFoundException {


        file = new File(SharedConstans.defaultPath + SharedConstans.sep + "codetopdf.tex");
        fileOutputStream = new FileOutputStream(file);

        directoryList = new DirectoryList(fileName);
        codePath = directoryList.getAbsolutePaths(fileName);

    }

    public void createPDF() {


        try (PrintStream printStream = new PrintStream(fileOutputStream)) {

            printStream.println(Base.text);

            for(String code : codePath) 
                if(!(code.contains("R.java")))
                    printStream.println("\\lstinputlisting{"+code+"}");
            

            printStream.println("\\end{document}");


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void show() {
        codePath.stream().forEach(System.out::println);
    }


}
