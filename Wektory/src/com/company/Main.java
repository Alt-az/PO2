package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        int g = 1;
        while (g == 1) {
                g = 0;
                System.out.println("Podaj pierwszy wektor:");
                Scanner scanner = new Scanner(System.in);
                Wektor Wektor1 = new Wektor();
                Wektor Wektor2 = new Wektor();
                try {
                    Wektor1.setLiczby(scanner.nextLine());
                    System.out.println("Podaj drugi wektor:");
                    Wektor2.setLiczby(scanner.nextLine());
                }catch (Exception e) {
                    System.out.println("Zle dane");
                    g=1;
                    continue;
                }
                if (Wektor1.getSize() != Wektor2.getSize()) try {
                    g = 1;
                    throw new WektoryRoznejDlugosciException("Długość pierwszego wektora to " + Wektor1.getSize() + " a drugiego to " + Wektor2.getSize() + " \n");
                } catch (WektoryRoznejDlugosciException e) {
                    e.printStackTrace();
                    continue;
                }
                Wektor suma = new Wektor();
                suma.addVectors(Wektor1.getLiczby(), Wektor2.getLiczby());
            try {
                suma.wpiszDoPliku();
            } catch (IOException e) {
                System.out.println("Problem z dostaniem sie do pliku lub z jego stworzeniem");
            }
        }
    }
}
