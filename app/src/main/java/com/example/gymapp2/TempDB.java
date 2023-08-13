package com.example.gymapp2;

import com.example.gymapp2.esercizio.Esercizio;
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

    private ArrayList<Scheda> schede;
    private ArrayList<Esercizio> esercizios;
}
