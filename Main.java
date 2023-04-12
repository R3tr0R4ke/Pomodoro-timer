
/*Program developed by R3tr0R4k3
 * Feel free to report bug or some advice for this program
 */
import java.util.Scanner;

public class Main {
    // Dichiarazione oggetto myInsert
    private static Inserimenti myInsert = new Inserimenti(0, 0, 0, 0);
    private static Scanner myScelta = new Scanner(System.in);

    // Variabili che permettono di aggiungere colore alle stringhe visualizzate in output (su Windows potrebberò non essere visualizzati)
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args) {
        menuPrincipale();
    }

    public static void menuPrincipale() {
        try {
            System.out.print(ANSI_BLUE
                    + "\nCosa vuoi fare?\n1: Termina programma\n2: Imposta piano studio\n3: Visualizza piano studio\n4: Avvia timer\nInserisci scelta con il corrispondente numero: "
                    + ANSI_RESET);
            int scelta = myScelta.nextInt();

            switch (scelta) {
                // Termina programma
                case 1:
                    System.out.println(ANSI_RED + "\nTERMINO IL PROGRAMMA!!! ARRIVEDERCI" + ANSI_RESET);
                    break;

                // Imposta piano
                case 2:
                    // Funzione ricursiva, termina alla richiesta delle mini pause
                    myInsert.chiediBloccoStudio();
                    // Torno al menu principale dopo aver impostato il piano studio
                    menuPrincipale();
                    break;

                // Visualizza piano studio
                case 3:
                    // Richiamo del metodo visualizzaPiano() della classe inserimenti, permette di vedere l'attuale piano studio
                    myInsert.visualizzaPiano();
                    // Torno al menu principale dopo aver impostato il piano studio
                    menuPrincipale();
                    break;

                // Avvia pomodoro timer
                case 4:
                    // Implemento l'iterazione in base a quante volte l'utente vuole ripetere i blocchi studio
                    for (int i = 0; i < myInsert.getRipetizioneBlocchi(); i++) {
                        // Creo un oggetto Timer in modo da poter chiamare il metodo dalla classe Timer
                        Timer myTimes = new Timer();
                        // Chiamo il metodo reminderDopoBlocco() dalla classe Timer e prende come parametro il valore di durataBloccoStudio dall'oggetto myInsert
                        myTimes.reminderDopoBlocco(myInsert.getDurataBloccoStudio());
                        // Chiamo il metodo reminderDopoPausa() dalla classe Timer e prende come parametro il valore di durataPausa dall'oggetto myInsert
                        myTimes.reminderDopoPausa(myInsert.getDurataPausa());
                    }
                    // Torno al menù principale
                    menuPrincipale();
                    break;

                // Inserimenti errati
                default:
                    System.out.println(ANSI_RED + "\nInserimento errato...\nPrego reinserire scelta" + ANSI_RESET);
                    // Torno al menu principale in modo da reinserire la scelta
                    menuPrincipale();
                    break;
            }
        }
        // Eccezioni nel caso l'utente inserisca un simbolo o carattere alfabetico anzichè un'intero
        catch (Exception e) {
            System.out.println(ANSI_RED + "\nInserisci un valore numerico intero..." + ANSI_RESET);
            myScelta.nextLine();    // consuma il carattere di fine linea lasciato dal metodo nextInt()
            menuPrincipale();
        }
        myScelta.close();
    }
}