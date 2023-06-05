package sounds;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class Beep {
	
	public Clip clip;
	private File file;
	private static Beep instance;
	
	 private Beep() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		 	file = new File("Beep Short .wav");
	        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
	        clip = AudioSystem.getClip();
	        clip.open(audioStream);
	    }
	 
	 public static Beep getInstance() {		 
				 if(instance == null){
					 try {
						instance = new Beep();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
						e.printStackTrace();
					}
				 }
			 
		 
		 return instance;
	 }
	    
	 public void play() {
		    if (clip != null) {
		        if (!clip.isRunning()) {
		            clip.setFramePosition(0);
		            clip.start();
		        } else {
		            clip.stop();
		            clip.setFramePosition(0);
		            clip.start();
		        }
		    } else {
		        System.err.println("Error: Clip is null. Unable to play the sound.");
		    }
		}
	    
	 public void stop() {
		    if (clip != null && clip.isRunning()) {
		        clip.stop();
		        clip.setFramePosition(0);
		    }
	 }
	 
	
}

	

