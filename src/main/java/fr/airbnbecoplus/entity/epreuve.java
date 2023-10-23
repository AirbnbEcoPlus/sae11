package fr.airbnbecoplus.entity;

import java.util.ArrayList;
import java.util.List;

public class epreuve {
    List<competiteur> competiteurs = new ArrayList<>();
    List<obstacle> obstacles = new ArrayList<>();
    double longeurPiste;
    

    public epreuve(List<competiteur> competiteurs, List<obstacle> obstacles, double longeurPiste){
        this.competiteurs = competiteurs;
        this.obstacles = obstacles;
        this.longeurPiste = longeurPiste;
    }


    public List<competiteur> getCompetiteurs(){
        return competiteurs;
    }
    public List<obstacle> getObstacles(){
        return obstacles;
    }
    public double getLongeurPiste(){
        return longeurPiste;
    }
   
    public void setCompetiteurs(List<competiteur> competiteurs){
        this.competiteurs = competiteurs;
    }
    public void setObstacles(List<obstacle> obstacles){
        this.obstacles = obstacles;
    } 
    public void setLongeurPiste(double longeurPiste){
        this.longeurPiste = longeurPiste;
    }
  
}
