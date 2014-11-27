package com.example.ehamelo.smartimmobilier.entite;

import java.util.ArrayList;

/**
 * Created by ehamelo on 24/11/2014.
 */
public class Fiche {
    String nom;
    ArrayList<Images> ressource;
    Son descAudio;
    int coordX;
    int coordY;

    public Fiche(String nom,Son audio,int x, int y){
        this.nom=nom;
        descAudio=audio;
        coordX=x;
        coordY=y;
    }

    /*getters setters*/
    public Son getDescAudio() {
        return descAudio;
    }

    public void setDescAudio(Son descAudio) {
        this.descAudio = descAudio;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }
}
