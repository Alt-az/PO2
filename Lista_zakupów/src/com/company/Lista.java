package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lista {
    private final List<Kategoria> ListaZakupow;
    private final List<Kategoria> ListaProduktow;
    public Lista() throws IOException {
        ListaZakupow=odczytaj(ostatniplik());
        ListaProduktow=odczytaj("Produkty.txt");
    }

    String ostatniplik() throws IOException {
        System.out.println("[1]skorzystac z poprzedniej listy\n[2]stworzyc nowa?");
        Scanner zmienna= new Scanner(System.in);
        String z=zmienna.nextLine();
        Scanner sciezka;
        String filesciezka= "";
        switch (z){
            case "1" -> {
                sciezka = new Scanner(new File("Sciezka.txt"));
                filesciezka=sciezka.nextLine();
            }
            case "2" ->{
                System.out.println("Podaj nazwe sciezki");
                filesciezka=zmienna.nextLine();
            }
            default -> System.out.println("Zle dana");
        }
        FileWriter b=new FileWriter("Sciezka.txt");
        b.flush();
        b.write(filesciezka);
        b.close();
        return filesciezka;
    }
    List<Kategoria> odczytaj(String filesciezka) throws IOException {
        File sfilename=new File(filesciezka);
        sfilename.createNewFile();
        Scanner odczyt = new Scanner(sfilename);
        List<Kategoria> J = new ArrayList<>();
        while (odczyt.hasNextLine()) {
            String zczyt = odczyt.nextLine();
            String[] podzial = zczyt.split(";");
            Kategoria Kat = new Kategoria();
            Kat.giveKategoriaName(podzial[0]);
            String[] zczytProdukty = podzial[1].split(",");
            for (String P : zczytProdukty) {
                Produkt a = new Produkt();
                a.giveNazwa(P);
                Kat.dodajProdukt(a);
            }
            J.add(Kat);
        }
        odczyt.close();
        return J;
    }
    void dodajProdukt(String Kategoria,Produkt a) throws IOException {
        int g=0;
        for(Kategoria K : ListaZakupow){
            if(K.getKategoriaName().equals(Kategoria)){
                K.dodajProdukt(a);
                g=1;
            }
        }
        if(g==0){
            Kategoria nowa=new Kategoria();
            nowa.giveKategoriaName(Kategoria);
            nowa.dodajProdukt(a);
            ListaZakupow.add(nowa);
        }
        Scanner b=new Scanner(new File("Sciezka.txt"));
        String Name=b.nextLine();
        b.close();
        wczytaj(new FileWriter(Name));
    }
    void usunProdukt(String Kategoria,Produkt a) throws IOException {
        for(Kategoria K : ListaZakupow){
            if(K.getKategoriaName().equals(Kategoria)){
                K.usunProdukt(a);
            }
        }
        Scanner b=new Scanner(new File("Sciezka.txt"));
        String Name=b.nextLine();
        b.close();
        wczytaj(new FileWriter(Name));
    }
    void wyczysc() throws IOException {
        Scanner b=new Scanner(new File("Sciezka.txt"));
        String Name=b.nextLine();
        FileWriter moje= new FileWriter(Name);
        b.close();
        moje.flush();
        moje.close();
        ListaZakupow.clear();
    }
    void zapisnadysku() throws IOException {
        Scanner myScan=new Scanner(System.in);
        System.out.println("Gdzie chcesz zapisac?:");
        String s=myScan.nextLine();
        File myFile=new File(s);
        if(myFile.createNewFile()){
            System.out.println("Sukcess!!");
        }
        else System.out.println("Juz taki plik istnieje");
        wczytaj(new FileWriter(myFile));
    }
    void wczytaj(FileWriter mojWriter) throws IOException {
        mojWriter.flush();
        for(Kategoria K:ListaZakupow){
            if(K.produktyZKatSize()!=0) {
                mojWriter.write(K.getKategoriaName() + ";");
                K.wczytaj(mojWriter);
                mojWriter.write("\n");
            }
        }
        mojWriter.close();
    }
    String znajdz(String Produkt){
        for(Kategoria K : ListaProduktow){
            if(K.znajdzProdukt(Produkt)){
                return K.getKategoriaName();
            }
        }
        return "";
    }
}
