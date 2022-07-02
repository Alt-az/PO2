package com.company;

public class Produkt {
    private String Nazwa;
    public Produkt() {
        Nazwa = "";
    }
    void giveNazwa(String Nazwa){
        this.Nazwa= Nazwa;
    }
    String getNazwa(){
        return Nazwa;
    }
}
