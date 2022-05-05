package Facade;

import com.fasterxml.jackson.databind.node.ObjectNode;
import composite.TrechoAereo;
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
            ObjectNode info = mapper.createObjectNode();
            info.put("Passageiro",nome);
            info.put("Data da Viagem",data);

            ObjectNode viagem = mapper.createObjectNode();
            viagem.put("Partida",passagem.getOrigem());
            viagem.put("Destino Final",passagem.getDestino());

            info.put("Valor total",passagem.getPreco());
            info.set("Viagem", viagem);

            mapper.writeValue(new File(file), info);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
