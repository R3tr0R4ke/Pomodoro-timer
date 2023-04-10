import java.applet.Applet;
import java.applet.AudioClip;

public class PlaySound
{
    public void PlayBeep() {        
        AudioClip clip = Applet.newAudioClip(getClass().getResource("/sounds/beep3.wav"));
        clip.play();
    }
}