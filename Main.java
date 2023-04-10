import java.util.Scanner;

public class Main 
{
    //Dichiarazione oggetto myInsert
    private static Inserimenti myInsert = new Inserimenti(0, 0, 0, 0);
    
    
    public static void main(String[] args) 
    {
        menuPrincipale();
    }

    public static void menuPrincipale() 
    {
        Scanner myScelta = new Scanner(System.in);

        try 
        {
            System.out.print("\nCosa vuoi fare?\n1: Termina programma\n2: Imposta piano studio\n3: Visualizza piano studio\n4: Avvia timer\nInserisci scelta con il corrispondente numero: ");
            int scelta = myScelta.nextInt();

            switch (scelta) 
            {
                // Termina programma
                case 1:
                    System.out.println("\nTERMINO IL PROGRAMMA!!! ARRIVEDERCI");
                break;

                // Imposta piano
                case 2:
                    // Funzione ricursiva, termina alla richiesta delle mini pause
                    myInsert.chiediBloccoStudio();
                    menuPrincipale();
                break;

                // Visualizza piano studio
                case 3:
                    myInsert.visualizzaPiano();
                    menuPrincipale();
                break;

                // Avvia pomodoro timer //TODO: FINIRE QUESTA SEZIONE METTENDO CON L'IMPLEMENTO DEI SUONI E I REMINDER AD OGNI PAUSA 
                case 4:
                    Timer myTimes = new Timer();    //Creo un oggetto Timer in modo da poter chiamare il metodo dalla classe Timer
                    myTimes.reminderDopoBlocco(myInsert.getDurataBloccoStudio());   //Chiamo il metodo dalla classe Timer
                    
                break;

                // Inserimenti errati
                default:
                    System.out.println("\nInserimento errato...\nPrego reinserire scelta");
                    menuPrincipale();
                break;
            }

        }
        catch (Exception e) 
        {
            System.out.println("\nInserisci un valore numerico intero...");
            myScelta.nextLine();
            menuPrincipale();
        }
        myScelta.close();
    }
}