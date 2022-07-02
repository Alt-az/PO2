package com.company;
import java.util.*;

public class Main {
    public static void main(String[] args){
        try {
        Lista aktualna = new Lista();
        boolean g=true;
        while(g) {
                System.out.println("Co chesz zrobic?: \n[1]Dodac nowy produkt\n[2]Usunac produkt\n[3]Usunac wszystkie produkty\n[4]Zapisac liste produktow na dysku\n[5]Wyjsc z programu");
                Scanner mojscan = new Scanner(System.in);
                String n = mojscan.nextLine();
                switch (n) {
                    case "1" -> {
                        System.out.println("Podaj Produkt:");
                        String caly = mojscan.nextLine();
                        Produkt wpisProd = new Produkt();
                        wpisProd.giveNazwa(caly);
                        String kategoria = aktualna.znajdz(wpisProd.getNazwa());
                        if(kategoria.equals("")){
                            System.out.println("Nie ma takiego produktu w sklepie");
                            break;
                        }
                        aktualna.dodajProdukt(kategoria, wpisProd);
                    }
                    case "2" -> {
                        System.out.println("Podaj Produkt:");
                        String caly = mojscan.nextLine();
                        Produkt wpisProd = new Produkt();
                        wpisProd.giveNazwa(caly);
                        String kategoria = aktualna.znajdz(wpisProd.getNazwa());
                        if(kategoria.equals("")){
                            System.out.println("Nie ma takiego produktu w sklepie ani na liscie");
                            break;
                        }
                        aktualna.usunProdukt(kategoria, wpisProd);
                    }
                    case "3" -> aktualna.wyczysc();
                    case "4" -> aktualna.zapisnadysku();
                    case "5" -> g = false;
                    default -> System.out.println("Zla dana");
                }
        }
        }catch(Exception e){
            System.out.println("Blad dostepu do pliku");
    }
}
}

