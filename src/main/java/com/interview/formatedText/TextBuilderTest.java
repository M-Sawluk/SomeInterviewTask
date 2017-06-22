package com.interview.formatedText;

import com.interview.formatedText.builders.TextBuilder;
import com.interview.formatedText.builders.TextBuilderFactory;
import com.interview.formatedText.builders.types.WordSplitType;
import com.interview.formatedText.organizers.SplitOn2Cols;
import com.interview.formatedText.organizers.types.VerticalTextOrganizer;
import com.interview.formatedText.sources.types.RestTextSource;
import com.interview.formatedText.sources.types.restTools.MyGistWithText;


public class TextBuilderTest {

    public static void main(String[] args) {

        TextBuilder textBuilder = TextBuilderFactory.getTextBuilder(45,
                new SplitOn2Cols(new VerticalTextOrganizer()), WordSplitType.PolishSyllable);

        textBuilder.setPadding(10);

//        textBuilder = new ConsoleTextSource(textBuilder);

       textBuilder.setText(getText());

//        textBuilder = new FileTextSource(textBuilder,"someText.txt");

//        textBuilder = new RestTextSource(textBuilder,new MyGistWithText(),"https://gist.githubu" +
//                "sercontent.com/M-Sawluk/eb9cf670d957b2f97f214cf05072f1a1/raw/2c8a22" +
//                "cad3ce5ed6e45f1949d0182a2d9bc54d5e/someText.json");

        System.out.println(textBuilder.getFormattedText());



//        List<String> list = WordSplitter.splitSentenceWithTabs("    Ala ma kota");
//
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//
//        list = WordSplitter.splitSentenceWithTabs(" Ala    ma kota");
//
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//
//        int end = "Ala ma kota ".indexOf(" ",8);
//        list=WordSplitter.splitSentenceOnSyllablesToOffset("Ala ma kota ".substring(0,end),8);
//
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//
//        end = "Ala ma kota ".indexOf(" ",3);
//        list=WordSplitter.splitSentenceOnSyllablesToOffset("Ala ma kota ".substring(0,end),3);
//
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));

    }

    static String getText(){
        return
                "    Wartość rynku TCF szacuje się na 5 mld dol." +
                "    Rocznie wzrasta on o kilkanaście procent i " +
                "już w 2022 roku rynek powinien przekroczyć wartość 7,5 mld." +
                "    Jak wskazuje przedstawiciel XTPL, firma nie tylko wchodzi na " +
                "perspektywiczny rynek, lecz także opracowana przez nią innowacyjna technologia " +
                "pozwala na uniezależnienie od indu, który dotychczas dominował na rynku TFC." +
                "    Tlenek indu pozwala na tworzenie warstw przewodzących, które są relatywnie " +
                "drogie, nie są elastyczne ani optymalne, jeżeli chodzi o parametry związane z " +
                "ppprzewodzeniem prądu.    Nam udało się to wszystko połączyć w jedno." +
                "    Rozwijamy technologię, " +
                "która jest tania, która świetnie przewodzi prąd i do tego jest elastyczna, co ma niebagatelne " +
                "znaczenie z punktu widzenia rozwijającej się na świecie branży elektroniki elastycznej –" +
                " przekonuje ekspert.";
    }

}
