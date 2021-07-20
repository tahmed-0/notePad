package notePad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;


public class GUI implements ActionListener {
	
	//In here I am creating my attributes
	
	JFrame window;
	
	//Text Area component
	JTextArea textArea;
	JScrollPane scrollPane;
	boolean wordWrapOn = false;
	//Top menu bar
	JMenuBar menuBar;
	JMenu menuFile, menuEdit, menuFormat, menuColor;
	//File menu
	JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
	
	//Edit Menu
	
	JMenuItem iUndo, iRedo;
	
	//Format menu
	JMenuItem iWrap, iFontArial, iFontCSMS, iFontTNR, iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28;
	JMenu menuFont, menuFontSize;
	
	//COLOR MENU
	
	JMenuItem iColor1, iColor2, iColor3;
	
	
	
	
	//initializing the class
	
	Function_File file = new Function_File(this);
	Function_Format format = new Function_Format(this);
	Function_Color color = new Function_Color(this);
	Function_Edit edit = new Function_Edit(this);
	KeyHandler kHandler = new KeyHandler(this);
	
	
	UndoManager um = new UndoManager();
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new GUI();
		

	}
	
	//In here I am calling my methods to get displayed on the screen
	
	
	public GUI() {
		
		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		createEditMenu();
		createFormatMenu();
		createColorMenu();
		
		
		//default font
		format.selectedFont = "Arial";
		format.createFont(16);
		format.wordWrap();
		color.changeColor("White");
		window.setVisible(true);
		
	}
	
	//In here I am creating the window frame with its title, size and exit to close.
	
	public void createWindow() {
		window = new JFrame("Notepad");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	//In here I am creating text area where you can type anything 
	
	public void createTextArea() {
		
		textArea = new JTextArea();
		textArea.setFont(format.arial);
		
		//key listener
		
		textArea.addKeyListener(kHandler);
		
		//Undo
	
		
		textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
			
			public void undoableEditHappened(UndoableEditEvent e) {
				
				um.addEdit(e.getEdit());
				
			}
		});
		
		//In here I am creating a scroll bar
		
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		//Takes out the border
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		
		window.add(scrollPane);
		
	
		
	}
	
	//In here I am creating the menu bar
	
	public void createMenuBar() {
		
		menuBar = new JMenuBar();
		window.setJMenuBar(menuBar);
		
		//In here I am adding different features my notePad going to have
		
		menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);
		
		menuFormat = new JMenu("Format");
		menuBar.add(menuFormat);
		
		menuColor = new JMenu("Color");
		menuBar.add(menuColor);
	}
	
	//Here I am adding Menus under the File
	//SetAction command for switch case
	
	public void createFileMenu() {
		
		iNew = new  JMenuItem("New");
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		menuFile.add(iNew);
		
		iOpen = new JMenuItem("Open");
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		menuFile.add(iOpen);
		
		iSave = new JMenuItem("Save");
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		menuFile.add(iSave);
		
		iSaveAs = new JMenuItem("Save as");
		iSaveAs.addActionListener(this);
		iSaveAs.setActionCommand("SaveAs");
		menuFile.add(iSaveAs);
		
		iExit = new JMenuItem("Exit");
		iExit.addActionListener(this);
		iExit.setActionCommand("Exit");
		menuFile.add(iExit);
	}
	
	//Format Menu
	
	public void createFormatMenu() {
		
		iWrap = new JMenuItem("Word Wrap: Off");
		iWrap.addActionListener(this);
		iWrap.setActionCommand("Word Wrap");
		menuFormat.add(iWrap);
		
		//initializing 
		//Menu font
		
		menuFont = new JMenu("Font");
		menuFormat.add(menuFont);
		
		//font names
		//Arial font
		
		iFontArial = new JMenuItem("Arial");
		iFontArial.addActionListener(this);
		iFontArial.setActionCommand("Arial");
		menuFont.add(iFontArial);
		
		// iFontCSMS
		
		iFontCSMS = new JMenuItem("Comic Sans MS");
		iFontCSMS.addActionListener(this);
		iFontCSMS.setActionCommand("Comic Sans MS");
		menuFont.add(iFontCSMS);
		
		//iFontTNR
		
		iFontTNR = new JMenuItem("Times New Roman");
		iFontTNR.addActionListener(this);
		iFontTNR.setActionCommand("Times New Roman");
		menuFont.add(iFontTNR);
		
		//Menu font size
		
		menuFontSize = new JMenu("Font Size");
		menuFormat.add(menuFontSize);
		
		//Font size 
		//Size 8
		
		iFontSize8 = new JMenuItem("8");
		iFontSize8.addActionListener(this);
		iFontSize8.setActionCommand("size8");
		menuFontSize.add(iFontSize8);
		
		//Size 12
		
		iFontSize12 = new JMenuItem("12");
		iFontSize12.addActionListener(this);
		iFontSize12.setActionCommand("size12");
		menuFontSize.add(iFontSize12);
		
		//Size 16
		
		iFontSize16 = new JMenuItem("16");
		iFontSize16.addActionListener(this);
		iFontSize16.setActionCommand("size16");
		menuFontSize.add(iFontSize16);
		
		//Size 20
		
		iFontSize20 = new JMenuItem("20");
		iFontSize20.addActionListener(this);
		iFontSize20.setActionCommand("size20");
		menuFontSize.add(iFontSize20);
		
		//Size 24
		
		iFontSize24 = new JMenuItem("24");
		iFontSize24.addActionListener(this);
		iFontSize24.setActionCommand("size24");
		menuFontSize.add(iFontSize20);
		
		//Size 28
		
		iFontSize28 = new JMenuItem("28");
		iFontSize28.addActionListener(this);
		iFontSize28.setActionCommand("size28");
		menuFontSize.add(iFontSize28);
		
		
		
		
	}
	
	//COLOR MENU METHOD
	
	public void createColorMenu() {
		
		iColor1 = new JMenuItem("White");
		iColor1.addActionListener(this);
		iColor1.setActionCommand("White");
		menuColor.add(iColor1);
		
		iColor2 = new JMenuItem("Black");
		iColor2.addActionListener(this);
		iColor2.setActionCommand("Black");
		menuColor.add(iColor2);
		
		iColor3 = new JMenuItem("Blue");
		iColor3.addActionListener(this);
		iColor3.setActionCommand("Blue");
		menuColor.add(iColor3);
		
		
	}
	
	//Edit Menu Method
	
	public void createEditMenu() {
		
		iUndo = new JMenuItem("Undo");
		iUndo.addActionListener(this);
		iUndo.setActionCommand("Undo");
		menuEdit.add(iUndo);
		
		
		iRedo = new JMenuItem("Redo");
		iRedo.addActionListener(this);
		iRedo.setActionCommand("Redo");
		menuEdit.add(iRedo);
		
		
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//Makes new file or does something whenever user clicks the menu
		
		String command = e.getActionCommand();
		
		switch(command) {
		case "New": 
			file.newFile(); 
		break;
		
		case "Open":
			file.open();
			break;
			
		case "Save":
			file.save();
			break;
			
		case "SaveAs":
			file.saveAs();
			break;
			
		case "Exit":
			file.exit();
			break;
			
		case "Word Wrap":
			format.wordWrap();
			break;
		case "Arial":
			format.setFont(command);
			break;
		case "Comic Sans MS":
			format.setFont(command);
			break;
		case "Times New Roman":
			format.setFont(command);
			break;
			
		case "size8":
			format.createFont(8);
			break;
		case "size12":
			format.createFont(12);
			break;
		case "size16":
			format.createFont(16);
			break;
		case "size20":
			format.createFont(20);
			break;
		case "size24":
			format.createFont(24);
			break;
		case "size28":
			format.createFont(28);
			break;
			
		case "White":
			color.changeColor(command);
			break;
		case "Black":
			color.changeColor(command);
			break;
		case "Blue":
			color.changeColor(command);
			break;
			
		case "Undo":
			edit.undo();
			break;
			
		case "Redo":
			edit.redo();
			break;
			
			
			
		}
		
		
	}

}
