/*Script preso da https://www.geeksforgeeks.org/play-audio-file-using-java/ e modificato in base alle esigenze di questo programma */
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import java.util.Scanner;

public class SimpleAudioPlayer {
  // Variabili che permettono di aggiungere colore alle stringhe visualizzate in output (su Windows potrebberò non essere visualizzati)
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_BLUE = "\u001B[34m";

  private static Scanner sc = new Scanner(System.in);

  // To store current position
  Long currentFrame;
  Clip clip;

  // Current status of clip
  String status;

  AudioInputStream audioInputStream;
  static String filePath;

  // constructor to initialize streams and clip
  public SimpleAudioPlayer() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    // create AudioInputStream object
    audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

    // create clip reference
    clip = AudioSystem.getClip();

    // open audioInputStream to the clip
    clip.open(audioInputStream);

    clip.loop(Clip.LOOP_CONTINUOUSLY);
  }

  public static void avviaSuono() {
    try {
      filePath = "FX2.wav";
      SimpleAudioPlayer audioPlayer = new SimpleAudioPlayer();

      audioPlayer.play();

      while (true) {
        System.out.print(ANSI_BLUE + "\nInserisci 1 per stoppare il suono e iniziare la pausa/blocco studio: " + ANSI_RESET);
        int c = sc.nextInt();

        audioPlayer.gotoChoice(c);
        if (c == 1) {
          break;
        }
      }
    } catch (Exception ex) {
      System.out.println(ANSI_RED + "Error with playing sound." + ANSI_RESET);
      ex.printStackTrace();
    }
  }

  private void gotoChoice(int c) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
    switch (c) {
      case 1:
        stop();
        break;
    }
  }

  // Method to play the audio
  public void play() {
    // start the clip
    clip.start();

    status = "play";
  }

  // Method to stop the audio
  public void stop() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    currentFrame = 0L;
    clip.stop();
    clip.close();
  }
}