package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class Wektor {
    Vector<Integer> liczby;

    public Wektor() {
        liczby = new Vector<>();
    }

    public void setLiczby(String surowyWekor) throws NumberFormatException {
        String[] podzielonyWektor = surowyWekor.split(",");
        int przetlumaczonaLiczba;
        for (String pojedynczaliczba : podzielonyWektor) {
            przetlumaczonaLiczba = Integer.parseInt(pojedynczaliczba);
            this.liczby.add(przetlumaczonaLiczba);
        }
    }

    public Vector<Integer> getLiczby() {
        return liczby;
    }

    public int getSize() {
        return liczby.size();
    }

    public void addVectors(Vector<Integer> a, Vector<Integer> b) {
        int suma;
        for (int i = 0; i < a.size(); i++) {
            suma = a.get(i) + b.get(i);
            this.liczby.add(i, suma);
        }
    }

    void wpiszDoPliku() throws IOException {
        File myObj = new File("wynikdodawania.txt");
        myObj.createNewFile();
        FileWriter myWriter = new FileWriter("wynikdodawania.txt");
        if (this.liczby.size() > 1) {
            for (int i = 0; i < getSize() - 1; i++) {
                myWriter.write(this.liczby.get(i) + ",");
            }
            myWriter.write(this.liczby.get(getSize() - 1)+" ");
        } else if (getSize() == 1) myWriter.write(this.liczby.get(this.liczby.size() - 1));
        myWriter.close();
    }
}
