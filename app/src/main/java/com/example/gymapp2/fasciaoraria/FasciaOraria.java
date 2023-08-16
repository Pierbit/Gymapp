package com.example.gymapp2.fasciaoraria;

public class FasciaOraria {

    public FasciaOraria(Integer id_fascia, String fascia_oraria, Integer posti){

        this.fascia_oraria = fascia_oraria;
        this.id_fascia = id_fascia;
        this.posti = posti;

    }

    public Integer getId_fascia() {
        return id_fascia;
    }

    public String getFascia_oraria() {
        return fascia_oraria;
    }

    public Integer getPosti(){
        return this.posti;
    }

    public void setPosti(Integer posti){
        this.posti = posti;
    }

    private Integer id_fascia;
    private String fascia_oraria;
    private Integer posti;
}
