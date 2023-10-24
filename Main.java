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

}


