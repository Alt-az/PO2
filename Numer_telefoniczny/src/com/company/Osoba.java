package com.company;

public class Osoba extends Wpis {
    private final String imie;
    private final String nazwisko;
    private final String adres;
    private final NrTelefoniczny numer;

    public Osoba(String imie, String nazwisko, String adres, NrTelefoniczny numer) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.numer = numer;
    }
    @Override
    public String getName() {
        return imie;
    }
    @Override
    public String getNazwisko() {
        return nazwisko;
    }
    @Override
    public String getAdres() {
        return adres;
    }
    @Override
    public NrTelefoniczny getNumer() {
        return numer;
    }

    @Override
    String opis() {
        return this.getName()+" "+this.getNazwisko()+" "+this.getAdres()+" "+ this.getNumer().getNrTelefonu();
    }
}
