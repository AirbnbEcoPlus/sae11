import java.util.Scanner;

class Main {
    public static void main(String[] args) {

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
            System.out.print(msg);
            rst = clavier.nextInt();
        }
        return rst;
    }
}
