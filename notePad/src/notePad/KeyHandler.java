package notePad;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
	GUI gui;
	
	

	public KeyHandler(GUI gui) {
		
		this.gui = gui;
		
	}
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// If key pressed and the save method is being called
		//If control key is pressed and s pressed 
		
		if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
			
			gui.file.save();	
		}
		
		//If shift down and S is pressed 
		
		if(e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_S) {
			gui.file.saveAs();
		}
		
		//If ALT/option is pressed and F the file menu is clicked
		
		if(e.isAltDown() && e.getKeyCode() == KeyEvent.VK_F) {
			gui.menuFile.doClick();
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
