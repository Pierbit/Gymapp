package com.example.gymapp2.scheda;

import com.example.gymapp2.esercizio.Esercizio;

import java.util.ArrayList;

public class Scheda {

    public Scheda(String nome, ArrayList<Esercizio> esercizi){

        this.nome = nome;
        this.esercizi = esercizi;

    }

    public String getNome(){
        return this.nome;
    }

    public int getNum_esercizi(){
        return esercizi.size();
    }

    public ArrayList<Esercizio> getEsercizi(){
        return this.esercizi;
    }

    private String nome;
    private int num_esercizi;
    private ArrayList<Esercizio> esercizi;
}
