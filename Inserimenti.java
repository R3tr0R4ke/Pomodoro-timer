import java.util.Scanner;

public class Inserimenti 
{
    private int durataBloccoStudio;
    private int ripetizioneBlocchi;
    private int durataPausa;
    private int durataMiniBreak;

    private static Scanner myInt = new Scanner(System.in);

    public Inserimenti (int durataBloccoStudio, int ripetizioneBlocchi, int durataPausa, int durataMiniBreak)
    {
        this.durataBloccoStudio = durataBloccoStudio;
        this.ripetizioneBlocchi = ripetizioneBlocchi;
        this.durataPausa = durataPausa;
        this.durataMiniBreak = durataMiniBreak;
    }

    public void setDurataBloccoStudio (int durata)
    {
        this.durataBloccoStudio = durata;
    }

    public int getDurataBloccoStudio ()
    {
        return durataBloccoStudio;
    }

    public void setRipetizioneBlocchi(int ripetizione) 
    {
        this.ripetizioneBlocchi = ripetizione;
    }

    public int getRipetizioneBlocchi() 
    {
        return ripetizioneBlocchi;
    }

    public void setDurataPausa(int durata) 
    {
        this.durataPausa = durata;
    }

    public int getDurataPausa() 
    {
        return durataPausa;
    }

    public void setDurataMiniBreak(int durata) 
    {
        this.durataMiniBreak = durata;
    }

    public int getDurataMiniBreak() 
    {
        return durataMiniBreak;
    }

    public void chiediBloccoStudio ()
    {  
        try
        {
            System.out.print("\nPer quanto tempo vuoi studiare a blocco?\nInserisci tempo in minuti: ");
            int studioBlocco = myInt.nextInt();

            if (studioBlocco > 0)
            {
                System.out.println("\nInserimento avvenuto con successo!!!");
                setDurataBloccoStudio(studioBlocco);
                chiediRipetizioni();
            }
            else
            {
                System.out.println("\nInserimento errato, non può esistere un blocco di tempo uguale a 0... \nPrego reinserire scelta...");
                chiediBloccoStudio();
            }
        }
        catch(Exception e)
        {
            System.out.println("\nInserisci un valore numerico intero...");
            chiediBloccoStudio();
            myInt.nextLine(); // consuma il carattere di fine linea lasciato dal metodo nextInt()
        }
    }

    public void chiediRipetizioni ()
    {
        try
        {
            System.out.print("\nPer quante volte vuoi ripetere i blocchi di studio?\nInserire un numero intero (tra 1 e 12): ");
            int ripetiBlocchi = myInt.nextInt();
            if (ripetiBlocchi > 0 || ripetiBlocchi > 12)
            {
                System.out.println("\nInserimento avvenuto con successo!!!");
                setRipetizioneBlocchi(ripetiBlocchi);
                chiediPausa();            
            }
            else
            {
                System.out.print("\nInserimento errato, hai inserito un numero minore o uguale a 0 o maggiore di 12...\nPrego reinserire il numero");
                chiediRipetizioni();
            }
        }
        catch (Exception e)
        {
            System.out.println("\nInserisci un valore numerico intero...");
            chiediRipetizioni();
            myInt.nextLine(); // consuma il carattere di fine linea lasciato dal metodo nextInt()
        }
    }

    public void chiediPausa ()
    {
        try
        {
            System.out.print("\nQuanto deve durare la pausa dopo il blocco di studio?\nInserire numero in minuti: ");
            int pausa = myInt.nextInt();
            //TODO: RIMUOVI I COMMENTI QUANDO HAI FINITO DI FARE LE PROVE DI 1 MINUTO
            /*if (pausa >= getDurataBloccoStudio() || pausa > 30)
            {
                System.out.println("\nUna pausa non può essere più lunga di quanto tempo vuoi studiare!!!\nReinserisci un valore numerico intero non ambiguo...");
                chiediPausa();
            }
            else if (pausa < 20)
            {
                System.out.println("Vuoi veramente studiare o fare finta?...");
                chiediPausa();
            }
            else*/ if (pausa < 5)
            {
                System.out.println("\nAffinchè tu riesca a studiare meglio nei prossimi blocchi, conviene mettere una pausa di almeno o più di 5 minuti...");
                chiediPausa();
            }
            else 
            {
                System.out.println("\nInserimento avvenuto con successo!!!");
                setDurataPausa(pausa);
                chiediMiniPausa();            
            }
        }
        catch (Exception e)
        {
            System.out.println("\nInserisci un valore numerico intero...");
            chiediPausa();
            myInt.nextLine(); // consuma il carattere di fine linea lasciato dal metodo nextInt()
        }
    }

    public void chiediMiniPausa ()
    {
        try 
        {
            System.out.print("\nQuanto vuoi far durare le mini pause prima di riprendere?\nInserire numero intero che indica i secondi (tra 15 e 60) di mini pausa: ");
            int miniPausa = myInt.nextInt();

            if (miniPausa < 15)
            {
                System.out.println("\nPrenditi almeno 15 secondi per ricordarti che non sei un robot!!!");
                chiediMiniPausa();
            }
            else if (miniPausa > 60)
            {
                System.out.println("\nNon esagerare con il tempo... Potresti distarti troppo...");
                chiediMiniPausa();
            }
            else
            {
                System.out.println("\nInserimento avvenuto con successo!!!");
                setDurataMiniBreak(miniPausa);
                //Esco dai metodi creati e passo a prossimo blocco di codice nel main
            }
        }
        catch (Exception e)
        {
            System.out.println("\nInserisci un valore numerico intero...");
            chiediMiniPausa(); 
            myInt.nextLine(); // consuma il carattere di fine linea lasciato dal metodo nextInt()
        }
    }

    public void visualizzaPiano ()
    {
        System.out.println("\nStudio blocco: " + getDurataBloccoStudio() + " minuti");
        System.out.println("Ripetizioni blocco studio: " + getRipetizioneBlocchi());
        System.out.println("Durata pausa: " + getDurataPausa() + " minuti");
        System.out.println("Durata mini pause: " + getDurataMiniBreak() + " secondi");
    }
}