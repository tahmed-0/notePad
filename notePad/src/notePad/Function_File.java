//In this file I am going to add functions to the menu

package notePad;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function_File {
	
	GUI gui;
	String fileName;
	String fileAddress;
	

	public Function_File(GUI gui) {
		
		this.gui = gui;
		
	}
	
	//This method going to start a new text file
	
	public void newFile() {
		
		//gets a blank text 
		
		gui.textArea.setText("");
		gui.window.setTitle("New");
		fileName = null;
		fileAddress = null;
		
	}
	
	//This method will access/ open the file 
	
	public void open() {
		
		FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
		fd.setVisible(true);
		
		//gets the file to open
		
		if(fd.getFile() != null) {
			
			fileName = fd.getFile();
			fileAddress = fd.getDirectory();
			gui.window.setTitle(fileName);
			
		}
		//load content of the file
		//Accessing fileAddress and fileName in order to access the file
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName)); //you need the file address to read the file 
			
			gui.textArea.setText("");
			
			String line = null;
			
			while((line = br.readLine()) != null) {
				
				gui.textArea.append(line + "\n");
				
			}
			br.close();
		} catch(Exception e) {
			System.out.println("File not opened");
			
		}
		
		
	}
	
	//in here I am going to save the file
	//Save your file you already have saved
	//Overrides existing file
	
	public void save() {
		
		//if file is a new and don't have name
		
		if(fileName == null) {
			saveAs();
			
		}
	//working on existing file
		
		else {
			try {
				FileWriter fw = new FileWriter(fileAddress + fileName);
				fw.write(gui.textArea.getText());
				gui.window.setTitle(fileName);
				fw.close();
				
			} catch(Exception e) {
				System.out.println("Something went wrong");
				
				
			}
			
		}
		
	}
	
	//In here I am going to save the file 
	//save the text data
	//Saving in a file you want
	
	public void saveAs() {
		FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE);
		fd.setVisible(true);
		
		if(fd.getFile() != null) {
			fileName = fd.getFile();
			fileAddress = fd.getDirectory();
			gui.window.setTitle(fileName);
			
		}
		try {
			FileWriter fw = new FileWriter(fileAddress + fileName);
			fw.write(gui.textArea.getText());
			fw.close();
		
		}
			catch(Exception e) {
				System.out.println("Something went wrong");
				
			}
		}
//Exit 
	
	public void exit() {
		System.exit(0);
	}
		
	}


