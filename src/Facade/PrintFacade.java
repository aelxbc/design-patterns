package Facade;

import Legado.composite.TrechoAereo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;

public class PrintFacade {
    public void savePdf(String nome, String data, TrechoAereo passagem,
                        String file) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER_BOLD, 18,
                BaseColor.BLACK);
        Font font2 = FontFactory.getFont(FontFactory.TIMES, 16,
                BaseColor.BLACK);

        try {
            document.add(new Paragraph("Passagem: \n", font));
            document.add(new Paragraph(String.format("Passageiro: %s\n", nome),
                    font));
            document.add(new Paragraph(String.format("Data da Viagem: %s\n",
                    data),
                    font));
            document.add(new Paragraph(passagem.toString(), font2));

            document.add(new Paragraph(String.format("Valor total: : %.2f\n",
                    passagem.getPreco()),
                    font));
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        document.close();
    }

    public void saveJSON(String nome, String data, TrechoAereo passagem,
                         String file) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File(file), passagem);

            JsonNode json = mapper.valueToTree(passagem);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
