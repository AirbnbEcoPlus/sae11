

import java.util.Scanner;


class Main {




    /**
     * -------------------------
     *    PROGRAMME PRINCIPAL   
     * -------------------------
     * 
     * Point d'entrée du programme
     * 
     * @authors Adrien Faure / Zachary Ivars / Victor Jockin
     * 
     * @param args IN : arguments de la ligne de commande
     * 
     */
    public static void main(String[] args) {


        /*
         * ------------------------------------
         *    DÉCLARATIONS / INITIALISATIONS
         * ------------------------------------
         * 
         */

        // Déclaration des variables
        int tabTempsCompetiteurs[];     // Tableau contenant les temps de chaque compétiteur
        int nbCompetiteurs;             // Nombre de compétiteurs
        int longueurParcours;           // Longueur de la piste
        int nbObstacles;                // Nombre d'obstacles sur la piste
        int nbTotalBarres;              // Nombre total de barres (sur l'ensemble des obstacles)

        // Saisie des variables
        afficherTitre("INFORMATIONS SUR LE PARCOURS", 3) ;
        sautDeLignes(1) ;

        nbCompetiteurs = saisieIntBornes(1, 50, "[?] Saisir le nombre de competiteurs : ");
        longueurParcours = saisieIntBorneInf(0, "[?] Saisir la longueur de la piste : ");
        nbObstacles = saisieIntBorneInf(1, "[?] Saisir le nombe d'obstacles : ");
        nbTotalBarres = saisieNbTotalBarres(nbObstacles);
        // Saut de lignes afin d'améliorer la lisibilité
        sautDeLignes(2) ;

        // Tableau contenant les temps de chaque compétiteur
        tabTempsCompetiteurs = new int[nbCompetiteurs];


        /*
         * -----------------------------------
         *    DÉROULEMENT DE LA COMPÉTITION
         * -----------------------------------
         * 
         * Nombre de manches : 2
         * 
         */
        for (int manche = 1 ; manche<=2 ; manche++) {
            afficherTitre("MANCHE " + manche, 3) ;
            sautDeLignes(1) ;
            for (int competiteur = 1 ; competiteur<=nbCompetiteurs ; competiteur++) {
                // Si la case d'indice i du tableau a pour valeur -1,
                // cela signifie que le competiteur i+1 est éliminé.
                if (tabTempsCompetiteurs[competiteur-1] != -1) {
                    afficherSousTitre("Compétiteur n°" + competiteur) ;
                    saisieEtTraitementResultatsManche(tabTempsCompetiteurs, competiteur, longueurParcours, nbTotalBarres) ;
                    sautDeLignes(1) ;
                }
            }
        }
        // Saut de lignes afin d'améliorer la lisibilité
        sautDeLignes(2) ;

        // Affichage du podium
        afficherTitre("PODIUM", 3) ;
        sautDeLignes(1) ;
        emplacementPodium(tabTempsCompetiteurs, nbCompetiteurs) ;
        sautDeLignes(2) ;


    }




    /*
     * -------------
     *    SAISIES
     * -------------
     * 
     */

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
        return saisieIntBornes(min, max, "[?] Saisir le nombre total de barres : ");
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
        System.out.print(pfMsg + " (Valeur minimale : " + pfMin + ")");
        Scanner clavier = new Scanner(System.in);
        int entier = clavier.nextInt();
        while (entier < pfMin) {
            System.out.println("[!] Valeur minimale : " + pfMin);
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
        System.out.print(pfMsg + " (Valeur maximale" + pfMax + ")");
        Scanner clavier = new Scanner(System.in);
        int entier = clavier.nextInt();
        while (entier > pfMax) {
            System.out.println("[!] Valeur maximale " + pfMax);
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
        System.out.print(pfMsg + " (Valeur comprise entre " + pfMin + " et " + pfMax + ")"));
        Scanner clavier = new Scanner(System.in);
        int entier = clavier.nextInt();
        while (entier < pfMin || entier > pfMax) {
            System.out.println("[!] Valeur comprise entre " + pfMin + " et " + pfMax);
            System.out.print(pfMsg);
            entier = clavier.nextInt();
        }
        return entier;
    }




    /*
     * -----------------------------------------------
     *    CALCUL ET MISE EN FORME DU TEMPS COMPENSÉ
     * -----------------------------------------------
     * 
     */

    /** 
     * Calcule et retourne le temps compensé en millisecondes
     *
     * @author Adrien Faure
     * @param temps IN : Temps d'un competiteur
     * @param nbBarresTombees IN : nombre de barres tombé par le compétiteur
     * @return temps composé
     */
    public static int calculTempsAvecPenalites(int temps, int nbBarresTombees){
        int tempsCompense = temps + (8000 * nbBarresTombees);
        return tempsCompense; 
    }
    
    /** 
     * Retourne le temps compensé en minutes, secondes et millisecondes
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




    /*
     * -----------------------------------------
     *    SAISIE ET TRAITEMENT DES RÉSULTATS
     * -----------------------------------------
     * 
     * -- (1) --
     * Saisie des résultats d'un compétiteur pour une manche
     * 
     * -- (2) --
     * Elimination ou non des compétiteurs
     * 
     * -- (3) --
     * Qualification ou non des participants
     * pour la manche suivante
     * 
     */

    /**
     * ---------------------------------------------------
     *    Procédure : saisieEtTraitementResultatsManche
     * ---------------------------------------------------
     * 
     * @author Victor Jockin
     * 
     * Procède à la saisie des résultats pour un compétiteur
     * d'une manche
     * 
     * @param pfTabTempsCompetiteurs    IN/OUT  :   tableau des temps de chaque compétiteurs
     * @param pfBrassardCompetiteur     IN      :   numéro de brassard du compétiteur
     * @param pfLongueurParcours        IN      :   longueur du parcours (utilisée dans la fonction estElimine)
     * @param pfNbTotalBarres           IN      :   nombre total de barres du parcours
     * 
    **/
    public static void saisieEtTraitementResultatsManche(int[] pfTabTempsCompetiteurs, int pfBrassardCompetiteur, int pfLongueurParcours, int pfNbTotalBarres) {
        
        // Saisie des résultats du compétiteur
        int nbBarresTombees = saisieIntBornes(0, pfNbTotalBarres, "[?] Saisir le nombre de barres tombées : ") ;
        int nbRefus = saisieIntBorneInf(0, "[?] Saisir le nombre de refus : ") ;
        int testChute = saisieIntBornes(0, 1, "[?] Y a-t-il eu chute ?\n    [0] Oui\n    [1] Non\n-----------------------") ;
        int temps = saisieIntBorneInf(0, "[?] Saisir le temps réalisé en millisecondes : ") ;
        pfTabTempsCompetiteurs[pfBrassardCompetiteur-1] = temps ;

        // Elimination ou non du compétiteur
        // Qualification du compétiteur s'il n'est pas éliminé
        if (estElimine(nbRefus, testChute, temps, pfLongueurParcours) == true) {
            // Remarque : Lorsque qu'un compétiteur est éliminé,
            // son temps dans le tableau vaut -1
            pfTabTempsCompetiteurs[pfBrassardCompetiteur-1] = -1 ;
        } else {
            int tempsCompense = calculTempsAvecPenalites(temps, nbBarresTombees) ;
            pfTabTempsCompetiteurs[pfBrassardCompetiteur-1] = tempsCompense ;
            // Affichage du temps compensé
            System.out.println(convertMillisecondeToTime(tempsCompense)) ;
        }

    }

    /**
     * ---------------------------
     *    Fonction : estElimine
     * ---------------------------
     * 
     * @author Victor Jockin
     * 
     * Détermine si un compétiteur est éliminé ou non
     * en applicant le barème C
     * 
     * @param pfNbRefus             IN  :   nombre de refus du cheval du compétiteur
     * @param pfTestChute           IN  :   s'il y a eu chute (booléen)
     * @param pfTemps               IN  :   temps réalisé par le compétiteur
     * @param pfLongueurParcours    IN  :   longueur du parcours
     * 
     * @return Si le compétiteur est éliminé ou non (booléen)
     * 
    **/
    public static boolean estElimine(int pfNbRefus, int pfTestChute, int pfTemps, int pfLongueurParcours) {
        if (pfNbRefus<3) {
            if (pfTestChute == 1) {
                if (pfLongueurParcours<600 && pfTemps<=120000 || pfLongueurParcours>=600 && pfTemps<=180000) {
                    return false ;
                }
            }
        }
        return true ;
    }




    /*
     * ------------
     *    PODIUM
     * ------------
     * 
     */

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
        int tempTab[];

        // traitement des données
        /* temp signifiant temporary permet de garder le meilleur temps fait par les compétiteurs */
        temp = meilleurTemps(pfTableau, pfNbVal);
        tempTab = tempsPostModif(pfTableau, pfNbVal, temp);
        /* Tant que le nombre de places occupées est inférieur ou égale à 3 on éxecute le code*/
        if (pfNbVal == 1){
            if (pfTableau[0] == -1) System.out.println ("Le seul compétiteur est perdant");
            else System.out.println("Le seul compétiteur a gagne avec un temps de : " + convertMillisecondeToTime(pfTableau[0]));
        } else {
        while (placesPodium <= 3) {
            /* On dis à chaque place le numéro de place */
            System.out.println("\n" + placesPodium + "° : ");
            /* si c'est la place occupée est 1 alors on regarde combien de fois temp apparaît puis on rajoute le numéro du brassard correspondant à la chaîne de caractère */
            if (placesPodium == 1) {
                for (int i = 0; i < pfNbVal; i++) 
                    if (temp == pfTableau[i]) {
                        System.out.print("" + (i + 1) + "\n" + "avec un temps de : " + convertMillisecondeToTime(pfTableau[i]));
                        /* À chaque fois que le temps est trouvé alors on rajoute 1 au nombre de places occupées */
                        placesPodium += 1;
                    }
                
            /* Si la place occupé n'est pas la première place alors on exécute le code */
            } else {
                /* On redefinit temp qui est deuxième meilleur temps */
                temp = meilleurTemps(tempTab, tempTab.length);
                tempTab = tempsPostModif(tempTab, tempTab.length, temp);
                /* on regarde combien de fois temp_bis apparaît puis on rajoute le numéro du brassard correspondant à la chaîne de caractère */
                for (int i = 0; i < pfNbVal; i++) 
                    if (temp == pfTableau[i]) {
                        System.out.print("" + (i + 1) + "\n" + "avec un temps de : " + convertMillisecondeToTime(pfTableau[i]));
                        placesPodium += 1;
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
        if (pfTableau[0] != 0) int bestTime = pfTableau[0];

        // traitement des données
        /* On parcours le tableau et à chaque fois que bestTime est supérieur à l'élément dans le tableau alors on affecte à bestTime le temps le plus bas */
        for (int i = 0; i < pfNbVal; i++)
            if (bestTime >= pfTableau[i] && pfTableau[i] >= 0)
                bestTime = pfTableau[i];
        

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

        //traitement des données
        /* On parcours le tableau original, et on affecte tous les éléments différents du meilleur temps à un nouveau tableau */
        for (int i = 0; i < pfNbVal; i++)
            if (pfTableau[i] != pfVal) {
                tab[nbElt] = pfTableau[i];
                nbElt++;
            }
        
        /* On réaffecte tous les éléments du nouveau tableau dans le tableau renvoyée */
        int tabPostModif[] = new int[nbElt];
        for (int k = 0; k < nbElt; k++)
            tabPostModif[k] = tab[k];
        

        /* Retour du tableau */
        return tabPostModif;
    }




    /* 
     * --------------------------------
     *    AFFICHAGE ET MISE EN FORME
     * --------------------------------
     * 
     */

    /**
     * -------------------------------
     *    Procédure : afficherTitre
     * -------------------------------
     * 
     * @author Victor Jockin
     *
     * Affiche la mise en forme du titre donné en paramètre
     * 
     * @param pfTitre       IN  :   titre à mettre en forme et à afficher
     * @param pfTabulation  IN  :   tabulation (nombre d'espaces) avant le titre
     * 
    **/
    public static void afficherTitre(String pfTitre, int pfTabulation) {
        String ligneH = ligneHorizontale(pfTitre.length() + 2 * pfTabulation, "-") ;
        String tabulation = ligneHorizontale(pfTabulation, " ") ;
        System.out.println("\n" + ligneH + "\n" + tabulation + pfTitre + "\n" + ligneH + "\n") ;
    }

    /**
     * -----------------------------------
     *    Procédure : afficherSousTitre
     * -----------------------------------
     * 
     * @author Victor Jockin
     *
     * Affiche la mise en forme du sous-titre donné en paramètre
     * 
     * @param pfSousTitre   IN  :   sous-titre à mettre en forme et à afficher
     * 
    **/
    public static void afficherSousTitre(String pfSousTitre) {
        System.out.println(pfSousTitre + "\n" + ligneHorizontale(pfSousTitre.length(), "-")) ;
    }

    /**
     * ------------------------------
     *    Procédure : sautDeLignes
     * ------------------------------
     * 
     * @author Victor Jockin
     *
     * Affiche un nombre donné de sauts de lignes
     * 
     * @param pfNbSautsDeLignes IN  :   nombre de sauts de lignes à afficher
     * 
    **/
    public static void sautDeLignes(int pfNbSautsDeLignes) {
        for (int i = 0 ; i<pfNbSautsDeLignes ; i++) {
                System.out.println("") ;
        }
    }

    /**
     * ---------------------------------
     *    Fonction : ligneHorizontale
     * ---------------------------------
     * 
     * @author Victor Jockin
     *
     * Retourne une ligne horizontale :
     * - Avec une longueur donnée
     * - Construite à partir d'un caractère donné
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
