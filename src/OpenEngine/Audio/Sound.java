package OpenEngine.Audio;

import java.io.File; 

import java.io.IOException; 
  
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 

public class Sound{
	String path;
	Clip clip;
	Long currentFrame;
    AudioInputStream audioStream;
	
	public Sound(String path) throws IOException, LineUnavailableException,UnsupportedAudioFileException{
		this.audioStream = AudioSystem.getAudioInputStream(new File("res/audio/"+path).getAbsoluteFile());
		this.clip = AudioSystem.getClip();
		
        this.clip.open(audioStream); 
        
        this.clip.loop(Clip.LOOP_CONTINUOUSLY); 
	}
	public void Play() throws IOException {
		clip.start();
		audioStream.reset();
		this.clip.setMicrosecondPosition(this.currentFrame);
	}
	public void Pause() throws IOException {
		clip.stop(); 
		audioStream.reset();
		this.currentFrame = this.clip.getMicrosecondPosition();
		
	}
}
