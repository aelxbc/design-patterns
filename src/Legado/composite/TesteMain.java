package Legado.composite;

import Facade.PrintFacade;

public class TesteMain {
    public static void main(String[] args) {
        TrechoSimples ts1 = new TrechoSimples("São Paulo", "Brasília", 500);
        TrechoSimples ts2 = new TrechoSimples("Brasília", "Recife", 300);
        TrechoSimples ts3 = new TrechoSimples("Recife","Natal", 350);
        TrechoComposto tc1 = new TrechoComposto(ts2, ts3, 30);
        TrechoComposto tc2 = new TrechoComposto(ts1, tc1, 50);

//        System.out.println(tc2.toString());

        PrintFacade printer = new PrintFacade();

        printer.savePdf("Joseph Roberto De Jesus", "10-11-2021",tc2,"teste" +
                ".pdf");

        printer.saveJSON("Joseph Roberto De Jesus", "10-11-2021",tc2,"teste" +
                ".json");
    }
}
