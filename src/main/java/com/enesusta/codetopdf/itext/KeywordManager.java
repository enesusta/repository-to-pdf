package com.enesusta.codetopdf.itext;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.element.Text;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class KeywordManager {


    public List<String> readKeywords() {

        List<String> keywords = new ArrayList<>();

        ClassLoader classLoader = getClass().getClassLoader();
        File keyFile = new File(classLoader.getResource("keywords.txt").getFile());


        try (InputStream inputStream = new FileInputStream(keyFile)) {

            Scanner scanner = new Scanner(inputStream);
            scanner.useDelimiter(System.lineSeparator());

            while (scanner.hasNext())
                keywords.add(scanner.next());


        } catch (IOException e) {
            e.printStackTrace();
        }

        return keywords;
    }


    public List<Chunk> isCoupling(String source) throws IOException {

        List<Chunk> chunkList = new ArrayList<>();
        List<String> words = new ArrayList<>();
        List<String> splitWords = new ArrayList<>();

        Font red = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.RED);
        Font white = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK);


        String split[] = source.split(System.lineSeparator());

        for (String splitWordsTemp : split)
            words.add(splitWordsTemp);


        for (String iter : words) {

            String splitTmp[] = iter.split(" ");

            for (String splitT : splitTmp) {

                System.out.println("okunan string : " + splitT);

                if (containsString(splitT, readKeywords())) {

                    if (!splitT.trim().isEmpty()) {
                        Chunk redKeyword = new Chunk(splitT, red);
                        chunkList.add(redKeyword);
                    }

                } else {

                    if (!splitT.trim().isEmpty()) {
                        Chunk whiteKeyword = new Chunk(splitT, white);
                        chunkList.add(whiteKeyword);
                    }
                }
            }
        }

        return chunkList;

    }


    private boolean containsString(String testString, List<String> list) {
        return list.contains(testString);
    }

    public static void main(String[] args) {


    }

}
