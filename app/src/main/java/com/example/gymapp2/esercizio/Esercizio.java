package com.example.gymapp2.esercizio;

public class Esercizio {

    public Esercizio(String nome,int set,int ripetizioni,Double recupero){

        this.nome = nome;
        this.set = set;
        this.ripetizioni = ripetizioni;
        this.recupero = recupero;
    }

    public String getNome(){
        return this.nome;
    }

    public int getSet(){
        return this.set;
    }

    public int getRipetizioni(){
        return this.ripetizioni;
    }

    public Double getRecupero(){
        return this.recupero;
    }

    private String nome;
    private int set;
    private int ripetizioni;
    private Double recupero;

}
