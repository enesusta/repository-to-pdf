package com.enesusta.codetopdf.itext;

import com.itextpdf.layout.element.Text;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.ColumnText;

import java.io.IOException;

public class Colorized {

    private KeywordManager keywordManager;

    public Colorized() {
        keywordManager = new KeywordManager();
    }


    public void addHighlightedDocumentToDocument(Document document, String bigString)
        throws IOException, DocumentException {

        for (Chunk chunk : keywordManager.isCoupling(bigString))
            document.add(new Paragraph(chunk));

    }

    public void addHighlightedColumnTextToDocument(ColumnText columnText, String bigString) throws IOException, DocumentException {

        columnText.setSimpleColumn(new Rectangle(36,600,144,769));

        for(Chunk chunk : keywordManager.isCoupling(bigString))
            columnText.addElement(new Paragraph(chunk));

        columnText.go();

    }

}
