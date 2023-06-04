package sounds;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class Beep {
	
	public Clip clip;
	File file;
	private static Beep instance;
	
	 private Beep() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		 	file = new File("Beep Short .wav");
	        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
	        clip = AudioSystem.getClip();
	        clip.open(audioStream);
	    }
	 
	 public static Beep getInstance() {
		 
		 if(instance == null) {
			 synchronized (Beep.class) {
				 
				 if(instance == null) {
					 try {
						instance = new Beep();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
						e.printStackTrace();
					}
				 }
			 }
		 }
		 return instance;
	 }
	    
	    public void play() {
	        clip.setFramePosition(0);
	        clip.start();
	    }
	    
	    public void close() {
	    	clip.close();
	    }

	}

