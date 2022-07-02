package com.company;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Osoba osobnik_1 = new Osoba("Piotr","S","Kaszynskiego",new NrTelefoniczny());
        osobnik_1.getNumer().setNrkierunkowy(48);
        osobnik_1.getNumer().setNrTelefonu(533513968);
        Osoba osobnik_3 = new Osoba("Piotr","M","Kaszynskiego",new NrTelefoniczny());
        osobnik_3.getNumer().setNrkierunkowy(48);
        osobnik_3.getNumer().setNrTelefonu(933513968);
        Osoba osobnik_2 = new Osoba("Mariusz","J","Politechniki",new NrTelefoniczny());
        osobnik_2.getNumer().setNrkierunkowy(48);
        osobnik_2.getNumer().setNrTelefonu(663241342);
        Firma firma_1 = new Firma("Wart-gaz","Maja",new NrTelefoniczny());
        firma_1.getNumer().setNrkierunkowy(48);
        firma_1.getNumer().setNrTelefonu(332332567);
        Firma firma_2 = new Firma("Roza","Cielecka",new NrTelefoniczny());
        firma_2.getNumer().setNrkierunkowy(48);
        firma_2.getNumer().setNrTelefonu(847675235);
        Firma firma_3 = new Firma("Balar","Kaszynskiego",new NrTelefoniczny());
        firma_3.getNumer().setNrkierunkowy(48);
        firma_3.getNumer().setNrTelefonu(976675235);
        TreeMap<NrTelefoniczny,Wpis> oryginalny = new TreeMap<>();
        oryginalny.put(osobnik_1.getNumer(),osobnik_1);
        oryginalny.put(osobnik_2.getNumer(),osobnik_2);
        oryginalny.put(osobnik_3.getNumer(),osobnik_3);
        oryginalny.put(firma_1.getNumer(),firma_1);
        oryginalny.put(firma_2.getNumer(),firma_2);
        oryginalny.put(firma_3.getNumer(),firma_3);
        for (Map.Entry<NrTelefoniczny, Wpis> e : oryginalny.entrySet()) {
            System.out.println(e.getValue().opis());
        }
        TreeMap<NrTelefoniczny,Wpis> withoutDuplicates=new TreeMap<>();
        withoutDuplicates.putAll(oryginalny);
        int j=0;
        for (Map.Entry<NrTelefoniczny, Wpis> e : oryginalny.entrySet()) {
            for (Map.Entry<NrTelefoniczny, Wpis> u : withoutDuplicates.entrySet()){
                if(Objects.equals(u.getValue().getAdres(), e.getValue().getAdres()))j++;
            }
            if(j>=2)withoutDuplicates.remove(e.getKey());
            j=0;
        }
        System.out.println("\n\n");
        for (Map.Entry<NrTelefoniczny, Wpis> e : withoutDuplicates.entrySet()) {
            System.out.println(e.getValue().opis());
        }
    }
}
