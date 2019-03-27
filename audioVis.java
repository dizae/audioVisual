/*
*Audio Visualizer, a bar that dances and changes to music!
*
*/

import ddf.minim.analysis.*;
import ddf.minim.*;
 
Minim minim;
AudioPlayer jingle;
AudioInput input;
FFT fft;
int[][] colo=new int[300][3];
//AudioIn in;
 
void setup()
{
  size(480, 320);
   //fullScreen();
  noCursor();
 
 
  minim = new Minim(this);
 
 
  input = minim.getLineIn();
 
  fft = new FFT(input.bufferSize(), input.sampleRate());
 
 
 // textFont(createFont("Arial", 16));
 
 // windowName = "None";
}
 
void draw()
{
  background(0);
  stroke(255);
  
 
  fft.forward(input.mix);
//512 values below --> this loop is called 25 times per second
//try getting the highest value and making a shape based on that value
//maybe change color based on the size of the value?
  for(int i = 0; i < fft.specSize(); i++)
  {
 
 
 
    fft.getBand(i); //this is float which is very much like a double
   float audioLevel = 0;
    if(i%50 == 0){ //takes only the values for every 50 and sets audioLevel to those
      audioLevel = fft.getBand(i); 
    }
    
    System.out.println(audioLevel); //prints to console for troubleshooting
    fill(50 * audioLevel, 0, 0); //traditional bar equalizer, fill changes shade of red with volume
    rect(225, 250, 40, -(50 * audioLevel)); //height changes with respect to volume 
  
 
}
 
  // keep us informed about the window being used
 // text("The window being used is: " + windowName, 5, 20);
}