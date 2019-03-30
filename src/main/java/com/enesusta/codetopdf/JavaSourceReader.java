package com.enesusta.codetopdf;

import java.io.*;

public class JavaSourceReader {

    private File file;
    private File keyFile;

    public JavaSourceReader(File file) {

        ClassLoader classLoader = getClass().getClassLoader();
        keyFile = new File(classLoader.getResource("try.txt").getFile());
        this.file = file;

    }

    public String getSource() {

        String tmp = "A";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
                stringBuilder.append(System.lineSeparator());
            }

            tmp = stringBuilder.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tmp;
    }

    public static void main(String[] args) {

        System.out.println(new JavaSourceReader(new File("/home/phield")).getSource());


    }


}
