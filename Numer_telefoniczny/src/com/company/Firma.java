package com.company;

public class Firma extends Wpis {
    private final String name;
    private final String adres;
    private final NrTelefoniczny telefon;

    public Firma(String name, String adres, NrTelefoniczny telefon) {
        this.name = name;
        this.adres = adres;
        this.telefon = telefon;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getAdres() {
        return adres;
    }
    @Override
    public NrTelefoniczny getNumer() {
        return telefon;
    }

    @Override
    String opis() {
        return this.getName()+" "+this.getAdres()+" "+this.getNumer().getNrTelefonu();
    }
}
