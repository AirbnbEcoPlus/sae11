import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // Déclaration des variables
        int competiteurs[];     // Tableau contenant les temps de chaque compétiteur
        int nbCompetiteurs;     // Nombre de compétiteurs
        int longeurPiste;       // Longueur de la piste
        int nbObstacles;        // Nombre d'obstacles sur la piste
        int nbTotalBarres;      // Nombre total de barres (sur l'ensemble des obstacles)

        // Mettre un petit affichage pour le bohneur des yeux
        nbCompetiteurs = saisieIntBornes(1, 50, "Saisir le nombre de competiteurs : ");
        longeurPiste = saisieIntBorneInf(0, "Saisir la longueur de la piste : ");
        nbObstacles = saisieIntBorneInf(1, "Saisir le nombe d'obstacles : ");
        nbTotalBarres = saisieNbTotalBarres(nbObstacles);

        competiteurs = new int[nbCompetiteurs];

    }
    /** 
     * Calcule et retourne le temps compensé en minutes et secondes et millisecondes
     *
     * @author Adrien Faure
     * @param temps IN : Temps d'un competiteur
     * @param nombreBarresTombe IN : nombre de barres tombé par le compétiteur
     * @return temps composé
     */
    public static String calcTemps(int temps, int nombreBarresTombe){
        int tempsCompense = temps + (8000 * nombreBarresTombe);
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
    
    /**
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
        int tab_1[] = meilleurTemps(pfTableau, pfNbVal);
        int tab_2[] = meilleurTemps(tab_1, tab_1.length);
        int tab_3[] = meilleurTemps(tab_2, tab_2.length);
        int placesPodium = 3;

        // traitement des données
        placePodiumPremier(tab_1[1], pfTableau, pfNbVal, tab_1);
        placesPodium -= tab_1[1];
        placePodiumSecond(tab_2[1], pfTableau, pfNbVal, tab_2, placesPodium);
        placesPodium -= tab_2[1];
        placePodiumTroisieme(tab_3[1], pfTableau, pfNbVal, tab_3, placesPodium);
    }

    /**
     * Programme permettant de trouver les meilleurs temps
     * 
     * @param pfTableau IN Tableau contenant les temps de chaque participant à la
     *                  fin des deux manches
     * @param pfNbVal   IN Le nombre de valeurs à être traité dans pfTableau
     * @return un tableau contenant le mielleur temps, et le nombre d'occurrences du
     *         meilleur temps
     */
    public static int[] meilleurTemps(int[] pfTableau, int pfNbVal) {
        // initialisation des variables
        int bestTime = pfTableau[0];
        int tabRes[] = new int[2];
        int nbOccurrences = 1;

        for (int i = 1; i < pfNbVal; i++) {
            if (bestTime < pfTableau[i]) {
                bestTime = pfTableau[i];
                nbOccurrences = 1;
            } else if (bestTime == pfTableau[i]) {
                nbOccurrences += 1;
            }
        }
        tabRes[0] = bestTime;
        tabRes[1] = nbOccurrences;

        return tabRes;
    }

    /**
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

    /**
     * Programme permettant de trouver l'indice du temps voulu dans le tableau
     * donnée
     * 
     * @param pfTableau IN Tableau contenant les temps de chaque participant à la
     *                  fin des deux manches
     * @param pfNbVal   IN Le nombre de valeurs à être traité dans pfTableau
     * @return l'indice du temps cherché dans le tableau
     */
    public static int rechercheIndice(int[] pfTableau, int pfNbVal, int pfVal) {
        int indice = 0;
        boolean trouvee = false;
        int i = 0;

        while (trouvee = false || i < pfNbVal) {
            if (pfTableau[i] == pfVal) {
                indice = i;
                trouvee = true;
            }
            i++;
        }

        return indice;
    }

    /**
     * Programme permettant d'en déduire le cas trouvé selon les données du meilleur
     * temps
     * 
     * @param choix IN le cas trouvé
     * 
     */
    public static void placePodiumPremier(int cas, int[] pfTableauResultat, int pfNbVal, int[] pfTableau) {
        int indice;
        if (cas == 1) {
            indice = rechercheIndice(pfTableauResultat, pfNbVal, cas);
            System.out.println("Le premier est le numéro : " + (indice + 1) + "avec un temps de: " + pfTableau[0]);
        } else if (cas == 2) {
            int compteur = 0;
            System.out.println("Les premiers sont les numéros : ");
            while (compteur < cas) {
                for (int i = 0; i < pfNbVal; i++) {
                    if (pfTableau[i] == pfTableau[0]) {
                        System.out.print("" + i + " ");
                        compteur++;
                        System.out.print("" + rechercheIndice(pfTableauResultat, pfNbVal, cas) + " ");
                    }
                }
            }
            System.out.print("avec un temps de: " + pfTableau[1]);
        } else if (cas >= 3) {
            int compteur = 0;
            System.out.println("Les premiers sont les numéros : ");
            while (compteur < cas) {
                for (int i = 0; i < pfNbVal; i++) {
                    if (pfTableau[i] == pfTableau[0]) {
                        System.out.print("" + i + " ");
                        compteur++;
                        System.out.print("" + rechercheIndice(pfTableauResultat, pfNbVal, cas) + " ");
                    }
                }
            }
        }
    }

    public static void placePodiumSecond(int cas, int[] pfTableauResultat, int pfNbVal, int[] pfTableau,
            int placesDisponible) {
        int indice;
        if (placesDisponible > 0) {
            if (cas == 1) {
                indice = rechercheIndice(pfTableauResultat, pfNbVal, cas);
                System.out.println("Le seconde est le numéro : " + (indice + 1) + "avec un temps de: " + pfTableau[0]);
            } else if (cas == 2) {
                int compteur = 0;
                System.out.println("Les secondes sont les numéros : ");
                while (compteur < cas) {
                    for (int i = 0; i < pfNbVal; i++) {
                        if (pfTableau[i] == pfTableau[0]) {
                            System.out.print("" + i + " ");
                            compteur++;
                            System.out.print("" + rechercheIndice(pfTableauResultat, pfNbVal, cas) + " ");
                        }
                    }
                }
                System.out.print("avec un temps de: " + pfTableau[1]);
            } else if (cas >= 3) {
                int compteur = 0;
                System.out.println("Les secondes sont les numéros : ");
                while (compteur < cas) {
                    for (int i = 0; i < pfNbVal; i++) {
                        if (pfTableau[i] == pfTableau[0]) {
                            System.out.print("" + i + " ");
                            compteur++;
                            System.out.print("" + rechercheIndice(pfTableauResultat, pfNbVal, cas) + " ");
                        }
                    }
                }
                System.out.print("avec un temps de: " + pfTableau[1]);
            }
        } else {
            System.out.println("Il y a plus de places de disponible");
        }
    }

    public static void placePodiumTroisieme(int cas, int[] pfTableauResultat, int pfNbVal, int[] pfTableau,
            int placesDisponible) {
        int indice;
        if (placesDisponible > 0) {
            if (cas == 1) {
                indice = rechercheIndice(pfTableauResultat, pfNbVal, cas);
                System.out.println("Le troisème est le numéro : " + (indice + 1) + "avec un temps de: " + pfTableau[0]);
            } else if (cas == 2) {
                int compteur = 0;
                System.out.println("Les troisième sont les numéros : ");
                while (compteur < cas) {
                    for (int i = 0; i < pfNbVal; i++) {
                        if (pfTableau[i] == pfTableau[0]) {
                            System.out.print("" + i + " ");
                            compteur++;
                            System.out.print("" + rechercheIndice(pfTableauResultat, pfNbVal, cas) + " ");
                        }
                    }
                }
                System.out.print("avec un temps de: " + pfTableau[1]);
            } else if (cas >= 3) {
                int compteur = 0;
                System.out.println("Les troisième sont les numéros : ");
                while (compteur < cas) {
                    for (int i = 0; i < pfNbVal; i++) {
                        if (pfTableau[i] == pfTableau[0]) {
                            System.out.print("" + i + " ");
                            compteur++;
                            System.out.print("" + rechercheIndice(pfTableauResultat, pfNbVal, cas) + " ");
                        }
                    }
                }
                System.out.print("avec un temps de: " + pfTableau[1]);
            }
        } else {
            System.out.println("Il y a plus de places de disponible");
        }
    }
}
