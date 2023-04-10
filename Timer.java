//import java.awt.Toolkit;

public class Timer
{
    public void reminderDopoBlocco (int tempo)
    {
        try
        {
            long tempoInMs = tempo * 60 * 1000;  //Converto i minuti in millisecondi, per convertire in secondi invece faccio solo * 1000
            Thread.sleep(tempoInMs); //Questo metodo "ferma" il programma per attendere tot millisecondi"
            //TODO: INTRODUZIONE SUONI ACUSTICI, QUESTO METODO NON FUNGE
            //Toolkit.getDefaultToolkit().beep(); //RIPRODUCO SUONO ACUSTICO
            System.out.println("\nPROVA");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
