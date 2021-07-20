package notePad;

import java.awt.Font;

public class Function_Format {
	
	GUI gui;
	Font arial, comicSansMS, timesNewRoman;
	String selectedFont;
	
	public Function_Format(GUI gui) {
		
		this.gui = gui;
	}
	
	//creating word wrap method
	
	public void wordWrap() {
		
		if(gui.wordWrapOn == false) {
			gui.wordWrapOn = true;
			gui.textArea.setLineWrap(true);
			gui.textArea.setWrapStyleWord(true);
			gui.iWrap.setText("Word Wrap: On");
			
		}
		else if(gui.wordWrapOn == true) {
			gui.wordWrapOn = false;
			gui.textArea.setLineWrap(false);
			gui.textArea.setWrapStyleWord(false);
			gui.iWrap.setText("Word Wrap: Off");
			
			
		}
		
		
	}
	
	//Creating font method
	
	//Using INT fontSize to get font size based on what size was clicked 
	//and calling it on the switch case statement
	
	public void createFont(int fontSize) {
		
		arial = new Font("Arial", Font.PLAIN,fontSize);
		comicSansMS = new Font("Comic Sans MS", Font.PLAIN,fontSize);
		timesNewRoman = new Font("Times New Roman", Font.PLAIN,fontSize);
		
		setFont(selectedFont);
		
		
		
		
	}
	
	//setting font sizes and which font was selected
	
	public void setFont(String font) {
		
		selectedFont = font;
		
		switch(selectedFont) {
		case "Arial":
			gui.textArea.setFont(arial);
			break;
		case "Comic Sans MS":
			gui.textArea.setFont(comicSansMS);
			break;
		case "Times New Roman":
			gui.textArea.setFont(timesNewRoman);
			break;
		}
	}

}
