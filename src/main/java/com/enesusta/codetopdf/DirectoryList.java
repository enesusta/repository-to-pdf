package com.enesusta.codetopdf;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirectoryList extends File {

    private String sep = File.separator;
    private String defaultPath;


    public DirectoryList(String path) {

        super(path);

    }

    public List<String> getAbsolutePaths(String directoryName) {

        DirectoryList directoryList = new DirectoryList(directoryName);
        List<File> list = directoryList.listf(directoryName);

        Filter filter = new Filter("java");
        List<String> stringList = new ArrayList<>();

        for (File i : list) {

            if (i.isDirectory()) {
                File[] paths = i.listFiles(filter);

                for (File x : paths)
                    stringList.add(x.getAbsolutePath());

            }
        }

        return stringList;

    }


    public List<File> listf(String directoryName) {

        File directory = new File(directoryName);

        List<File> resultList = new ArrayList<File>();

        File[] fList = directory.listFiles();
        resultList.addAll(Arrays.asList(fList));

        for (File file : fList) {

            if (file.isDirectory())
                resultList.addAll(listf(file.getAbsolutePath()));


        }
        return resultList;

    }


}
