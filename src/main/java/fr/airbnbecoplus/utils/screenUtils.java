package fr.airbnbecoplus.utils;

public final class screenUtils {
    private static screenUtils instance;

    public static screenUtils getInstance() {
        if (instance == null) {
            instance = new screenUtils();
        }
        return instance;
    }

    public void afficher(String msg) {
        System.out.println(msg);
    }

    public void afficherSeparator(int size, char c) {
        for (int i = 0; i < size; i++) {
            System.out.print(c);
        }
        System.out.println("\n");
    }
}
