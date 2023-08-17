package com.example.gymapp2;

import com.example.gymapp2.esercizio.Esercizio;
import com.example.gymapp2.fasciaoraria.FasciaOraria;
import com.example.gymapp2.scheda.Scheda;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class TempDB {

    public TempDB(){

        this.esercizios = new ArrayList<>();

        Esercizio es1 = new Esercizio("Panca piana",3,10,3.0);
        esercizios.add(es1);
        Esercizio es2 = new Esercizio("Squat",4,8,3.5);
        esercizios.add(es2);
        Esercizio es3 = new Esercizio("Leg curl",3,12,2.0);
        esercizios.add(es3);
        Esercizio es4 = new Esercizio("Stacchi",5,6,4.0);
        esercizios.add(es4);
        Esercizio es5 = new Esercizio("Trazioni",3,10,3.5);
        esercizios.add(es5);
        Esercizio es6 = new Esercizio("Rematore",3,10, 1.5);
        esercizios.add(es6);
        Esercizio es7 = new Esercizio("Plank",5,15,3.0);
        esercizios.add(es7);
        Esercizio es8 = new Esercizio("Curl bicipiti", 3,10,1.0);
        esercizios.add(es8);
        Esercizio es9 = new Esercizio("Dip",4,8,2.5);
        esercizios.add(es9);
        Esercizio es10 = new Esercizio("Croci",3,10,2.0);
        esercizios.add(es10);

        this.schede = new ArrayList<>();

        for(int i = 1; i < 6; i++){

            ArrayList<Esercizio> temp = new ArrayList<>();

            Random rand = new Random();
            int x = rand.nextInt(9) + 1;
            for(int j = 0; j < x; j++){
                temp.add(this.esercizios.get(j));
            }

            Scheda scheda = new Scheda("Scheda "+i, temp);
            this.schede.add(scheda);
        }


        FasciaOraria fascia1 = new FasciaOraria(1, "8:30-9:30",30);
        this.fasceorarie.add(fascia1);
        FasciaOraria fascia2 = new FasciaOraria(2, "9:30-10:30",30);
        this.fasceorarie.add(fascia2);
        FasciaOraria fascia3 = new FasciaOraria(3, "10:30-11:30",30);
        this.fasceorarie.add(fascia3);
        FasciaOraria fascia4 = new FasciaOraria(4, "11:30-12:30",10);
        this.fasceorarie.add(fascia4);
        FasciaOraria fascia5 = new FasciaOraria(5, "14:30-15:30",30);
        this.fasceorarie.add(fascia5);
        FasciaOraria fascia6 = new FasciaOraria(6, "15:30-16:30",30);
        this.fasceorarie.add(fascia6);
        FasciaOraria fascia7 = new FasciaOraria(7, "16:30-17:30",15);
        this.fasceorarie.add(fascia7);
        FasciaOraria fascia8 = new FasciaOraria(8, "17:30-18:30",5);
        this.fasceorarie.add(fascia8);
        FasciaOraria fascia9 = new FasciaOraria(9,"18:30-19:30",2);
        this.fasceorarie.add(fascia9);
        FasciaOraria fascia10 = new FasciaOraria(10,"19:30-20:30",0);
        this.fasceorarie.add(fascia10);

    }

    public ArrayList<Scheda> getSchede(){
        return this.schede;
    }

    public ArrayList<Esercizio> getEsercizi(){
        return this.esercizios;
    }

    public void addScheda(Scheda scheda){
        this.schede.add(scheda);
    }

    public String getScheda_selezionata(){
        return this.scheda_selezionata;
    }

    public void setScheda_selezionata(String string){
        this.scheda_selezionata = string;
    }

    public Esercizio getEsercizio_selezionato(){
        return this.esercizio_selezionato;
    }

    public void setEsercizio_selezionato(Esercizio esercizio_selezionato) {
        this.esercizio_selezionato = esercizio_selezionato;
    }

    public ArrayList<FasciaOraria> getFasceorarie() {
        return this.fasceorarie;
    }

    public Integer getGeneratedCounter(){
        this.generatedCounter = this.generatedCounter + 1;
        return this.generatedCounter;
    }

    private ArrayList<Scheda> schede;
    private ArrayList<Esercizio> esercizios;
    private String scheda_selezionata;
    private Esercizio esercizio_selezionato;
    private ArrayList<FasciaOraria> fasceorarie = new ArrayList<>();
    private Integer generatedCounter = 0;
}
