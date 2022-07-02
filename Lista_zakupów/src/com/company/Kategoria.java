package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Kategoria {
    private final List <Produkt> ProduktyzKategorii;
    private String KategoriaName;
    Kategoria() {
        ProduktyzKategorii = new ArrayList<>();
    }
    void giveKategoriaName(String KategoriaName){
        this.KategoriaName= KategoriaName;
    }
    String getKategoriaName(){
        return KategoriaName;
    }
    void dodajProdukt(Produkt a){
        ProduktyzKategorii.add(a);
    }
    void usunProdukt(Produkt a){
        ProduktyzKategorii.removeIf(P -> P.getNazwa().equals(a.getNazwa()));
    }
    void wczytaj(FileWriter mojWriter) throws IOException {
        for(Produkt P:ProduktyzKategorii){
            mojWriter.write(P.getNazwa()+",");
        }
    }
    boolean znajdzProdukt(String Produkt){
        for(Produkt P : ProduktyzKategorii){
            if(P.getNazwa().equals(Produkt))return true;
        }
        return false;
    }
    int produktyZKatSize(){
        return ProduktyzKategorii.size();
    }
}
