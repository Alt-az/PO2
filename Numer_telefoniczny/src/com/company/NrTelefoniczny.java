package com.company;

public class NrTelefoniczny implements Comparable<NrTelefoniczny>{
    private int nrkierunkowy;
    private int nrTelefonu;

    public NrTelefoniczny() {}

    public int getNrkierunkowy() {
        return nrkierunkowy;
    }

    public int getNrTelefonu() {
        return nrTelefonu;
    }

    public boolean setNrkierunkowy(int nrkierunkowy) {
        if(nrkierunkowy>0){
            this.nrkierunkowy = nrkierunkowy;
            return true;
        }
        else return false;
    }

    public boolean setNrTelefonu(int nrTelefonu) {
        if(nrTelefonu>0){
            this.nrTelefonu = nrTelefonu;
            return true;
        }
        else return false;
    }

    @Override
    public int compareTo(NrTelefoniczny o) {
        return Integer.compare(this.getNrTelefonu(), o.getNrTelefonu());
    }

}
