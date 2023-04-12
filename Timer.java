public class Timer {
    // Variabili che permettono di aggiungere colore alle stringhe visualizzate in output (su Windows potrebberò non essere visualizzati)
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public void reminderDopoBlocco(int tempo) {
        try {
            long tempoInMs = tempo * 60 * 1000; // Converto i minuti in millisecondi, per convertire in secondi invece
                                                // faccio solo * 1000
            Thread.sleep(tempoInMs);            // Questo metodo "ferma" il programma per attendere tot millisecondi"
            SimpleAudioPlayer.avviaSuono();     // Avvio il suono acustico richiamando il metodo avviaSuono() dalla classe SimpleAudioPlayer
            // Avviso di inizio pausa
            System.out.println(ANSI_GREEN + "\nLa pausa è iniziata... Prendi un pò d'aria" + ANSI_RESET);
            // Nel main c'è il richiamo del metodo reminderDopoPausa()
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reminderDopoPausa(int tempo) {
        try {
            long tempoMs = tempo * 60 * 1000;   // Converto i minuti in millisecondi
            Thread.sleep(tempoMs);              // "Fermo" il programma
            SimpleAudioPlayer.avviaSuono();     // Avvio il suono acustico richiamando il metodo avviaSuono() dalla classe SimpleAudioPlayer
            System.out.println(ANSI_GREEN + "\nPausa finita!!! Riprendi a studiare" + ANSI_RESET);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
