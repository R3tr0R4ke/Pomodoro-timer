import java.util.Scanner;

public class Inserimenti {
    private int durataBloccoStudio;
    private int ripetizioneBlocchi;
    private int durataPausa;
    private int durataMiniBreak;

    // Variabili che permettono di aggiungere colore alle stringhe visualizzate in output (su Windows potrebberò non essere visualizzati)
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    private static Scanner myInt = new Scanner(System.in);

    public Inserimenti(int durataBloccoStudio, int ripetizioneBlocchi, int durataPausa, int durataMiniBreak) {
        this.durataBloccoStudio = durataBloccoStudio;
        this.ripetizioneBlocchi = ripetizioneBlocchi;
        this.durataPausa = durataPausa;
        this.durataMiniBreak = durataMiniBreak;
    }

    public void setDurataBloccoStudio(int durata) {
        this.durataBloccoStudio = durata;
    }

    public int getDurataBloccoStudio() {
        return durataBloccoStudio;
    }

    public void setRipetizioneBlocchi(int ripetizione) {
        this.ripetizioneBlocchi = ripetizione;
    }

    public int getRipetizioneBlocchi() {
        return ripetizioneBlocchi;
    }

    public void setDurataPausa(int durata) {
        this.durataPausa = durata;
    }

    public int getDurataPausa() {
        return durataPausa;
    }

    public void setDurataMiniBreak(int durata) {
        this.durataMiniBreak = durata;
    }

    public int getDurataMiniBreak() {
        return durataMiniBreak;
    }

    public void chiediBloccoStudio() {
        try {
            System.out.print(ANSI_YELLOW + "\nPer quanto tempo vuoi studiare a blocco?\nInserisci tempo in minuti: " + ANSI_RESET);
            int studioBlocco = myInt.nextInt();

            if (studioBlocco > 0) {
                System.out.println(ANSI_GREEN + "\nInserimento avvenuto con successo!!!" + ANSI_RESET);
                setDurataBloccoStudio(studioBlocco);
                chiediRipetizioni();
            } else {
                System.out.println(ANSI_RED + "\nInserimento errato, non può esistere un blocco di tempo uguale a 0... \nPrego reinserire scelta..." + ANSI_RESET);
                chiediBloccoStudio();
            }
        } catch (Exception e) {
            System.out.println(ANSI_RED + "\nInserisci un valore numerico intero..." + ANSI_RESET);
            chiediBloccoStudio();
            myInt.nextLine(); // consuma il carattere di fine linea lasciato dal metodo nextInt()
        }
    }

    public void chiediRipetizioni() {
        try {
            System.out.print(ANSI_YELLOW + "\nPer quante volte vuoi ripetere i blocchi di studio?\nInserire un numero intero (tra 1 e 12): " + ANSI_RESET);
            int ripetiBlocchi = myInt.nextInt();
            if (ripetiBlocchi > 0 || ripetiBlocchi > 12) {
                System.out.println(ANSI_GREEN + "\nInserimento avvenuto con successo!!!" + ANSI_RESET);
                setRipetizioneBlocchi(ripetiBlocchi);
                chiediPausa();
            } else {
                System.out.print(ANSI_RED + "\nInserimento errato, hai inserito un numero minore o uguale a 0 o maggiore di 12...\nPrego reinserire il numero" + ANSI_RESET);
                chiediRipetizioni();
            }
        } catch (Exception e) {
            System.out.println(ANSI_RESET + "\nInserisci un valore numerico intero..." + ANSI_RESET);
            chiediRipetizioni();
            myInt.nextLine(); // consuma il carattere di fine linea lasciato dal metodo nextInt()
        }
    }

    public void chiediPausa() {
        try {
            System.out.print(ANSI_YELLOW + "\nQuanto deve durare la pausa dopo il blocco di studio?\nInserire numero in minuti: " + ANSI_RESET);
            int pausa = myInt.nextInt();

            if (pausa >= getDurataBloccoStudio() || pausa > 30) {
                System.out.println(ANSI_RED + "\nUna pausa non può essere più lunga di quanto tempo vuoi studiare!!!\nReinserisci un valore numerico intero non ambiguo..." + ANSI_RESET);
                chiediPausa();
            } else if (pausa < 20) {
                System.out.println(ANSI_PURPLE + "Vuoi veramente studiare o fare finta?..." + ANSI_RESET);
                chiediPausa();
            } else if (pausa < 5) {
                System.out.println(ANSI_PURPLE + "\nAffinchè tu riesca a studiare meglio nei prossimi blocchi, conviene mettere una pausa di almeno o più di 5 minuti..." + ANSI_RESET);
                chiediPausa();
            } else {
                System.out.println(ANSI_GREEN + "\nInserimento avvenuto con successo!!!" + ANSI_RESET);
                setDurataPausa(pausa);
                chiediMiniPausa();
            }
        } catch (Exception e) {
            System.out.println(ANSI_RED + "\nInserisci un valore numerico intero..." + ANSI_RESET);
            chiediPausa();
            myInt.nextLine(); // consuma il carattere di fine linea lasciato dal metodo nextInt()
        }
    }

    public void chiediMiniPausa() {
        try {
            System.out.print(ANSI_YELLOW + "\nQuanto vuoi far durare le mini pause prima di riprendere?\nInserire numero intero che indica i secondi (tra 15 e 60) di mini pausa: " + ANSI_RESET);
            int miniPausa = myInt.nextInt();

            if (miniPausa < 15) {
                System.out.println(ANSI_PURPLE + "\nPrenditi almeno 15 secondi per ricordarti che non sei un robot!!!" + ANSI_RESET);
                chiediMiniPausa();
            } else if (miniPausa > 60) {
                System.out.println(ANSI_PURPLE + "\nNon esagerare con il tempo... Potresti distarti troppo..." + ANSI_RESET);
                chiediMiniPausa();
            } else {
                System.out.println(ANSI_GREEN + "\nInserimento avvenuto con successo!!!" + ANSI_RESET);
                setDurataMiniBreak(miniPausa);
                // Esco dai metodi creati e passo a prossimo blocco di codice nel main
            }
        } catch (Exception e) {
            System.out.println(ANSI_RED + "\nInserisci un valore numerico intero..." + ANSI_RESET);
            chiediMiniPausa();
            myInt.nextLine(); // consuma il carattere di fine linea lasciato dal metodo nextInt()
        }
    }

    public void visualizzaPiano() {
        System.out.println(ANSI_YELLOW + "\nStudio blocco: " + getDurataBloccoStudio() + " minuti" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "Ripetizioni blocco studio: " + getRipetizioneBlocchi() + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "Durata pausa: " + getDurataPausa() + " minuti" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "Durata mini pause: " + getDurataMiniBreak() + " secondi" + ANSI_RESET);
    }
}