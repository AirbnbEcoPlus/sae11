package fr.airbnbecoplus.entity;

public class competiteur {
    int nombreRefus;
    int nombreBorneTombe;
    int nombreChute;
    double temps;
    public competiteur(int nombreRefus, int nombreBorneTombe, int nombreChute, double temps){
        this.nombreRefus = nombreRefus;
        this.nombreBorneTombe = nombreBorneTombe;
        this.nombreChute = nombreChute;
        this.temps = temps;
    }

    public void setNombreRefus(int nombreRefus){
        this.nombreRefus = nombreRefus;
    }
    public int getNombreRefus(){
        return nombreRefus;
    }
    public void setNombreBorneTombe(int nombreBorneTombe){
        this.nombreBorneTombe = nombreBorneTombe;
    }
    public int getNombreBorneTombe(){
        return nombreBorneTombe;
    }
    public void setNombreChute(int nombreChute){
        this.nombreChute = nombreChute;
    } 
    public int getNombreChute(){
        return nombreChute;
    }
    public void setTemps(double temps){
        this.temps = temps;
    }
    public double getTemps(){
        return temps;
    }
}
