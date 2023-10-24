import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // Déclaration des variables
        int competiteurs[];
        int nombreCompetiteurs;
        int longeurPiste;
        int nombreObstacles;
        int nombreTotalBarres;
        
        System.out.println(calcTemps(124338472, 0));

        // Mettre un petite affichage pour le bohneur des yeux
        nombreCompetiteurs = saisieIntBornes(1, 50, "Saisir le nombre de competiteurs : ");
        longeurPiste = saisieIntBorneMin(0, "Saisir la longueur de la piste : ");
        nombreObstacles = saisieIntBorneMin(1, "Saisir le nombe d'obstacles : ");
        nombreTotalBarres = saisieTotalBarres(nombreObstacles);

        competiteurs = new int[nombreCompetiteurs];

    }
    
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
    public static int saisieTotalBarres(int nombreObstacle) {
        int max = nombreObstacle * 2;
        int min = nombreObstacle * 4;
        return saisieIntBornes(min, max, "Saisir le nombre total de barres");
    }


    /**
     * Permet la saisie a l'utilisateur d'un tableau
     * 
     * @author Adrien Faure
     * @param msg   IN message visible a l'utilisateur
     * @param tab   OUT tableau de valeurs
     * @param nbVal IN nombre de valeurs a saisir
     */
    public static void saisieIntTab(String msg, int[] tab, int nbVal) {
        Scanner clavier = new Scanner(System.in);
        for (int i = 0; i < nbVal; i++) {
            System.out.print(msg + (i + 1) + " : ");
            int saisie = clavier.nextInt();
            tab[i] = saisie;
        }
    }

    /**
     * Permet la saisie de l'utilisateur a partir d'un minimum
     * 
     * @author Adrien Faure
     * @param min IN borne minimum de la valeur saisie
     * @param msg IN message visible a l'utilisateur
     * @return valeur saisie par l'utilisateur
     */
    public static int saisieIntBorneMin(int min, String msg) {
        System.out.print(msg);
        Scanner clavier = new Scanner(System.in);
        int rst = clavier.nextInt();
        while (rst < min) {
            System.out.println("(Valeur minimale " + min + ")");
            System.out.print(msg);
            rst = clavier.nextInt();
        }
        return rst;
    }

    /**
     * Permet la saisie de l'utilisateur a partir d'un maximum
     * 
     * @author Adrien Faure
     * @param max IN borne maximum de la valeur saisie
     * @param msg IN message visible a l'utilisateur
     * @return valeur saisie par l'utilisateur
     */
    public static int saisieIntBorneMax(int max, String msg) {
        System.out.print(msg);
        Scanner clavier = new Scanner(System.in);
        int rst = clavier.nextInt();
        while (rst > max) {
            System.out.println("(Valeur maximale " + max + ")");
            System.out.print(msg);
            rst = clavier.nextInt();
        }
        return rst;
    }

    /**
     * Permet la saisie de l'utilisateur a partir d'un minimum et maximum
     * 
     * @author Adrien Faure
     * @param min IN borne minimum de la valeur saisie
     * @param max IN borne maximum de la valeur saisie
     * @param msg IN message visible a l'utilisateur
     * @return valeur saisie par l'utilisateur
     */
    public static int saisieIntBornes(int min, int max, String msg) {
        System.out.print(msg);
        Scanner clavier = new Scanner(System.in);
        int rst = clavier.nextInt();
        while (rst < min || rst > max) {
            System.out.println("(Valeur comprise entre " + min + " et " + max + ")");
            System.out.print(msg);
            rst = clavier.nextInt();
        }
        return rst;
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


