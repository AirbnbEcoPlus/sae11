package fr.airbnbecoplus.utils;

import java.util.Scanner;

public final class saisieUtils {
    private static saisieUtils instance;
    Scanner sc; 
    public saisieUtils(){
        sc = new Scanner(System.in);
    }

    public static saisieUtils getInstance(){
        if(instance == null){
            instance = new saisieUtils();
        }
        return instance;
    }

    public int saisieIntWithMax(int min, int max, String msg){
        screenUtils.getInstance().afficher(msg);
        int rst = sc.nextInt();
        while(rst > min && rst < max){
            screenUtils.getInstance().afficher(msg);
            rst = sc.nextInt();
        }
        return rst;
    }

    public int saisieInt(int min, String msg){
        screenUtils.getInstance().afficher(msg);
        int rst = sc.nextInt();
        while(rst > min){
            screenUtils.getInstance().afficher(msg);
            rst = sc.nextInt();
        }
        return rst;
    }

    public double saisieDouble(double min, String msg){
        screenUtils.getInstance().afficher(msg);
        double rst = sc.nextDouble();
        while(rst > min){
            screenUtils.getInstance().afficher(msg);
            rst = sc.nextDouble();
        }
        return rst;
    }
    public String saisieString(String msg){
        screenUtils.getInstance().afficher(msg);
        return sc.nextLine(); 
    }
    public void saiseIntTab(String msg, int[] tab, int nbVal) {
        for (int i = 0; i < nbVal; i++) {
            System.out.print(msg + (i + 1) + " : ");
            int saisie = sc.nextInt();
            tab[i] = saisie;
        }
    }

}
