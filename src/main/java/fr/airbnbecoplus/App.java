package fr.airbnbecoplus;

import java.util.ArrayList;
import java.util.List;

import fr.airbnbecoplus.entity.competiteur;
import fr.airbnbecoplus.entity.epreuve;
import fr.airbnbecoplus.entity.obstacle;
import fr.airbnbecoplus.utils.saisieUtils;
import fr.airbnbecoplus.utils.screenUtils;

public class App {

    public static epreuve epreuve;

    public static void main(String[] args) {
        saisieEpreuve();
        saisieManche();
        traitement();
        affichagePodium();
        affichageResultat();
    }

    public static void saisieEpreuve() {
        int participants = saisieUtils.getInstance().saisieIntWithMax(0, 51, "Nombre de participant");
        double longueur = saisieUtils.getInstance().saisieDouble(0, "Longueur de la piste");
        double nombreObstacle = saisieUtils.getInstance().saisieInt(0, "Nombre d'obstacles");
        List<competiteur> competiteurs = new ArrayList<>();
        for(int i = 0 ; i < participants ; i++){
            competiteurs.add(new competiteur(0, 0, 0, 0));
        }
        List<obstacle> obstacles = new ArrayList<>();
        for(int i = 0 ; i < nombreObstacle ; i++){
            int numberBarres = saisieUtils.getInstance().saisieIntWithMax(1, 5, "Combient de barres pour l'obstacle n°" + i);
            obstacles.add(new obstacle(numberBarres));
        }
        epreuve = new epreuve(competiteurs, obstacles, longueur);
    }

    public static void saisieManche() {
        
    }

    public static void traitement() {

    }

    public static void affichagePodium() {

    }

    public static void affichageResultat() {

    }
}
