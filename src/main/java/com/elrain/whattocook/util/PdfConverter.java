package com.elrain.whattocook.util;

import com.elrain.whattocook.dao.entity.AmountEntity;
import com.elrain.whattocook.dao.entity.RecipeEntity;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

/**
 * Created by elrain on 19.08.15.
 */
public class PdfConverter {

    public static final String FONT = "times.ttf";
    public static final String ENCODING = "cp1251";
    public static final String PDFS_PATH = "/home/elrain/projects/mysql/whattocook/pdfs/rec";
    public static final int NAME_SIZE = 16;
    public static final int NORMAL_SIZE = 14;
    public static final String PATH_DIVIDER = "/";
    public static final String PDF = ".pdf";
    public static final String ROW_NAME_INGRIDIENTSS = "Ингредиенты";
    public static final String ROW_NAME_COUNT = "Кол-во";

    public static void savePdf(RecipeEntity re) throws IOException, DocumentException {
        Document d = new Document();
        PdfWriter.getInstance(d, new FileOutputStream(PDFS_PATH + re.getIdRecipe() + PATH_DIVIDER + re.getName() + PDF));

        BaseFont bf = BaseFont.createFont(FONT, ENCODING, BaseFont.EMBEDDED);

        Font nameFont = new Font(bf, NAME_SIZE);
        Font normalFont = new Font(bf, NORMAL_SIZE);

        d.open();

        Paragraph nameParagraph = new Paragraph(re.getName(), nameFont);
        nameParagraph.setAlignment(Element.ALIGN_CENTER);

        d.add(nameParagraph);

        d.add(getImage(re.getImage(), d.getPageSize().getWidth(), d.leftMargin(), d.rightMargin()));
        d.add(Chunk.NEWLINE);

        d.add(getTable(re.getAmounts(), normalFont));

        d.add(new Paragraph(re.getDescription(), normalFont));

        d.close();
    }

    private static PdfPTable getTable(Set<AmountEntity> amountEntities, Font normalFont) throws DocumentException {
        PdfPTable table = new PdfPTable(2);
        table.setWidths(new int[]{3, 1});

        table.addCell(new Phrase(ROW_NAME_INGRIDIENTSS, normalFont));
        table.addCell(new Phrase(ROW_NAME_COUNT, normalFont));
        for (AmountEntity ae : amountEntities) {
            table.addCell(new Phrase(ae.getIngridient().getName(), normalFont));
            String amount = ae.getCount() == 0 ? ae.getAmountType().getName() : ae.getCount() + " " + ae.getAmountType().getName();
            table.addCell(new Phrase(amount, normalFont));
        }
        return table;
    }

    private static Image getImage(String imagePath, float width, float leftMargin, float rightMargin) throws BadElementException, IOException {
        Image image = Image.getInstance(imagePath);
        float scaler = ((width - leftMargin - rightMargin) / image.getWidth()) * 50;
        image.scalePercent(scaler);
        image.setAlignment(Element.ALIGN_CENTER);
        return image;
    }
}
