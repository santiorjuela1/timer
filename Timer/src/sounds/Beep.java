package sounds;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class Beep{
	
	public Clip clip;
	
	 public Beep() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
	        File file = new File("Beep Short .wav");
	        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
	        clip = AudioSystem.getClip();
	        clip.open(audioStream);
	    }
	    
	    public void play() {
	        if (this.clip.isRunning()) {
	            clip.stop();
	        }
	        clip.setFramePosition(0);
	        clip.start();
	    }

	}

