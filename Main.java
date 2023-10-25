import java.util.Scanner;

class Main {


    /**
     * Point d'entrée du programme
     * @authors Victor Jockin / Adrien Faure / Zachary Ivars 
     * @param args IN : arguments de la ligne de commande
     */
    public static void main(String[] args) {
        // Déclaration des variables
        int competiteurs[];     // Tableau contenant les temps de chaque compétiteur
        int nbCompetiteurs;     // Nombre de compétiteurs
        int longueurParcours;       // Longueur de la piste
        int nbObstacles;        // Nombre d'obstacles sur la piste
        int nbTotalBarres;      // Nombre total de barres (sur l'ensemble des obstacles)

        // Mettre un petit affichage pour le bohneur des yeux
        nbCompetiteurs = saisieIntBornes(1, 50, "Saisir le nombre de competiteurs : ");
        longueurParcours = saisieIntBorneInf(0, "Saisir la longueur de la piste : ");
        nbObstacles = saisieIntBorneInf(1, "Saisir le nombe d'obstacles : ");
        nbTotalBarres = saisieNbTotalBarres(nbObstacles);

        competiteurs = new int[nbCompetiteurs];

    }


    /** 
     * Calcule et retourne le temps compensé en millisecondes
     *
     * @author Adrien Faure
     * @param temps IN : Temps d'un competiteur
     * @param nombreBarresTombe IN : nombre de barres tombé par le compétiteur
     * @return temps composé
     */
    public static int calcTemps(int temps, int nombreBarresTombe){
        int tempsCompense = temps + (8000 * nombreBarresTombe);
        return tempsCompense; 
    }
    
    /** 
     * Retourne le temps compensé en minutes et secondes et millisecondes
     *
     * @author Adrien Faure
     * @param tempsCompense IN : Temps d'un competiteur
     * @return temps composé en minute, secondes et millisecondes
     */
    public static String convertMillisecondeToTime(int tempsCompense){
        int secondes = (int) (tempsCompense/1000) % 60;
        tempsCompense -= 1000 * secondes;
        int minutes = (int) tempsCompense /(1000*60);
        tempsCompense -= 60000 * minutes;
        return minutes + " minutes et " + secondes + " secondes " + tempsCompense; 
    }


    /**
     * Permet la saisie a l'utilisateur du nombre Total de barres en vérifiant la
     * coherence avec le nombre d'obstacle
     * 
     * @author Adrien Faure
     * @param tab   OUT tableau de valeurs
     * @param nbVal IN nombre de valeurs a saisir
     */
    public static int saisieNbTotalBarres(int pfNbObstacles) {
        int min = pfNbObstacles * 2;
        int max = pfNbObstacles * 4;
        return saisieIntBornes(min, max, "Saisir le nombre total de barres : ");
    }


    /**
     * Permet la saisie a l'utilisateur d'un tableau
     * 
     * @author Adrien Faure
     * @param pfMsg   IN message visible a l'utilisateur
     * @param pfTab   OUT tableau de valeurs
     * @param pfNbVal IN nombre de valeurs a saisir
     */
    public static void saisieTabInt(String pfMsg, int[] pfTab, int pfNbVal) {
        Scanner clavier = new Scanner(System.in);
        for (int i = 0; i < pfNbVal; i++) {
            System.out.print(pfMsg + (i + 1) + " : ");
            int saisie = clavier.nextInt();
            pfTab[i] = saisie;
        }
    }

    /**
     * Permet la saisie de l'utilisateur a partir d'un minimum
     * 
     * @author Adrien Faure
     * @param pfMin IN borne minimum de la valeur saisie
     * @param pfMsg IN message visible a l'utilisateur
     * @return valeur saisie par l'utilisateur
     */
    public static int saisieIntBorneInf(int pfMin, String pfMsg) {
        System.out.print(pfMsg);
        Scanner clavier = new Scanner(System.in);
        int entier = clavier.nextInt();
        while (entier < pfMin) {
            System.out.println("(Valeur minimale " + pfMin + ")");
            System.out.print(pfMsg);
            entier = clavier.nextInt();
        }
        return entier;
    }

    /**
     * Permet la saisie de l'utilisateur a partir d'un maximum
     * 
     * @author Adrien Faure
     * @param pfMax IN borne maximum de la valeur saisie
     * @param pfMsg IN message visible a l'utilisateur
     * @return valeur saisie par l'utilisateur
     */
    public static int saisieIntBorneSup(int pfMax, String pfMsg) {
        System.out.print(pfMsg);
        Scanner clavier = new Scanner(System.in);
        int entier = clavier.nextInt();
        while (entier > pfMax) {
            System.out.println("(Valeur maximale " + pfMax + ")");
            System.out.print(pfMsg);
            entier = clavier.nextInt();
        }
        return entier;
    }

    /**
     * Permet la saisie de l'utilisateur a partir d'un minimum et maximum
     * 
     * @author Adrien Faure
     * @param pfMin IN borne minimum de la valeur saisie
     * @param pfMax IN borne maximum de la valeur saisie
     * @param pfMsg IN message visible a l'utilisateur
     * @return valeur saisie par l'utilisateur
     */
    public static int saisieIntBornes(int pfMin, int pfMax, String pfMsg) {
        System.out.print(pfMsg);
        Scanner clavier = new Scanner(System.in);
        int entier = clavier.nextInt();
        while (entier < pfMin || entier > pfMax) {
            System.out.println("(Valeur comprise entre " + pfMin + " et " + pfMax + ")");
            System.out.print(pfMsg);
            entier = clavier.nextInt();
        }
        return entier;
    }


    /* 
     * ------------------------------------------
     *    FONCTIONS DE SAISIE ET DE TRAITEMENT
     * ------------------------------------------
     *    - Par manche
     *    - Pour chaque compétiteur
     * 
     */

    /**
     * --------------------------------------
     *    Fonction : saisieResultatsManche
     * --------------------------------------
     * 
     * @author Victor Jockin
     * 
     * Procède à la saisie des résultats pour un compétiteur
     * d'une manche
     * 
     * @param pfTabTempsCompetiteurs    IN/OUT  :   tableau des temps de chaque compétiteurs
     * @param pfBrassardCompetiteur     IN      :   numéro de brassard du compétiteur
     * 
    **/
    public static void saisieResultatsManche(int[] pfTabTempsCompetiteurs, int pfBrassardCompetiteur) {
        int nbBarresTombees = saisieIntBornes(0, nbTotalBarres, "Saisir le nombre de barres tombées : ") ;
        int nbRefus = saisieIntBorneInf(0, "Saisir le nombre de refus : ") ;
        int testChute = saisieIntBorne(0, 1, "Y a-t-il eu chute ?\n[0] Oui\n[1] Non\n[2] Si quand même\n---") ;
        int temps = saisieIntBorneInf(0, "Saisir le temps réalisé en millisecondes : ") ;
        pfTabTempsCompetiteurs[pfBrassardCompetiteur-1] = temps ;
    }



    /**
     * 
     * 
     * 
     * @author Zachary Ivars
     * 
     * Programme permettant de trouver les participants allant sur le podium
     * 
     * @param pfTableau IN Tableau contenant les temps de chaque participant à la
     *                  fin des deux manches
     * @param pfNbVal   IN Le nombre de valeurs à être traité dans pfTableau
     * @return Une phrase indiquant les numéros des dossard pour chaque participant
     *         sur le podium avec leur temps.
     */
    public static void emplacementPodium(int[] pfTableau, int pfNbVal) {
        // initialisation des variables
        int temp;
        int placesPodium = 1;

        // traitement des données
        while (placesPodium <= 3) {
            temp = meilleurTemps(pfTableau, pfNbVal);
            System.out.println("" + placesPodium + "° : ");
            if (placesPodium == 1) {
                for (int i = 0; i < pfNbVal; i++) {
                    if (temp == pfTableau[i]) {
                        System.out.print("" + (i + 1));
                        placesPodium -= 1;
                    }
                }
            } else {
                temp = meilleurTemps(tempsPostModif(pfTableau, pfNbVal, temp),
                        tempsPostModif(pfTableau, pfNbVal, temp).length);
                System.out.println("" + placesPodium + "° : ");
                for (int i = 0; i < pfNbVal; i++) {
                    if (temp == pfTableau[i]) {
                        System.out.print("" + (i + 1));
                        placesPodium -= 1;
                    }
                }
            }
        }
    }

    /**
     * 
     * 
     * 
     * @author Zachary Ivars
     * 
     * Programme permettant de trouver les meilleurs temps
     * 
     * @param pfTableau IN Tableau contenant les temps de chaque participant à la
     *                  fin des deux manches
     * @param pfNbVal   IN Le nombre de valeurs à être traité dans pfTableau
     * @return un tableau contenant le mielleur temps, et le nombre d'occurrences du
     *         meilleur temps
     */
    public static int meilleurTemps(int[] pfTableau, int pfNbVal) {
        // initialisation des variables
        int bestTime = pfTableau[0];

        for (int i = 1; i < pfNbVal; i++) {
            if (bestTime >= pfTableau[i])
                bestTime = pfTableau[i];
        }

        return bestTime;
    }

    /**
     * 
     * 
     * 
     * @author Zachary Ivars
     * 
     * Programme permettant d'éliminer les meilleurs temps
     * 
     * @param pfTableau IN Tableau contenant les temps de chaque participant à la
     *                  fin des deux manches
     * @param pfNbVal   IN Le nombre de valeurs à être traité dans pfTableau
     * @return un tableau contenant les tous les temps en excluant le mielleur temps
     */
    public static int[] tempsPostModif(int[] pfTableau, int pfNbVal, int pfVal) {
        // initialisation des variables
        int tab[] = new int[pfNbVal];
        int nbElt = 0;

        for (int i = 0; i < pfNbVal; i++) {
            if (pfTableau[i] != pfVal) {
                tab[i] = pfTableau[i];
                nbElt++;
            }
        }
        int tabPostModif[] = new int[nbElt];
        for (int k = 0; k < nbElt; k++) {
            tabPostModif[k] = tab[k];
        }

        return tabPostModif;
    }



    /* 
     * ---------------------------
     *    FONCTIONS D'AFFICHAGE 
     * ---------------------------
     */

    /**
     * ---------------------------------
     *    Fonction : miseEnFormeTitre
     * ---------------------------------
     * 
     * @author Victor Jockin
     *
     * Retourne la mise en forme d'un titre
     * 
     * @param pfTitre   IN  :   titre à mettre en forme
     * 
     * @return le titre mis en forme
     * 
    **/
    public static String miseEnFormeTitre(String pfTitre) {
        return pfTitre + "\n" + ligneHorizontale(pfTitre.length(), "-") ;
    }

    /**
     * ---------------------------------
     *    Fonction : ligneHorizontale
     * ---------------------------------
     * 
     * @author Victor Jockin
     *
     * Retourne une ligne horizontale construite à partir
     * d'un caractère donné en paramètre
     * 
     * @param pfLongueurLigne   IN  :   longueur de la ligne à construire
     * @param pfCaractere       IN  :   caractère utilisé pour construire la ligne
     * 
     * @return la ligne horizontale
     * 
    **/
    public static String ligneHorizontale(int pfLongueurLigne, String pfCaractere) {
        String ligneHorizontale = "" ;
        for (int i = 0 ; i<pfLongueurLigne ; i++) {
            ligneHorizontale = ligneHorizontale + pfCaractere ;
        }
        return ligneHorizontale ;
    }
}
