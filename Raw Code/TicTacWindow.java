/**
 * Name: Quy Do
 * Date: 14/12/2017
 * 
 * Purpose: Java program will initiate and run the game Tic Tac Toe.
 * The program has JFrame, JLabel and Font to support and help run 
 * the graphic of the game. The game will let the users play and 
 * determine whether there is a winner or the game is a tie.
 * 
 * 
 * Constructors(in class TicTacWindow:
 * TicTacToeWindow()
 * 
 * Functions(in class TicTacWindow):
 * actionPerformed - void
 * mousePressed - void
 * mouseReleased - void
 * mouseEntered - void
 * mouseExited - void
 * mouseClicked - void
 * main - void
 * 
 * Constructors(in class TicTacRules):
 * TicTacRules()
 * 
 * Functions(in class TicTacRules):
 * win - void
 * gameOver - void
 */

package tictactoe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;  //needed to use swing components e.g. JFrame 
import javax.swing.JLabel; 

public class TicTacWindow extends JFrame implements ActionListener,MouseListener{
	// Set up constants for width and height of frame
		static final int WIDTH = 400; 
		static final int HEIGHT = 400;
		
		// Set up constants for the interval between the position of the JBuottons of the board
		private static int bWidth = 100;
		private static int bHeight = 50;
		
		//all the necessary JButtons, JLabel and Font
		protected static  JButton[][] button;
		protected static JButton	  exitButton, resetButton;
		protected static JLabel    statusLabel;
		protected static Font      fancyFont;
		
		//click counter and the game over check
		protected static int click=0;
		protected static boolean gameOver = false;
		
		// default constructor
	    public TicTacWindow(String title) { 
	    	// Set the title of the frame, must be before variable declarations 
	    	super(title); 
	    	
	    	//set up the general frame
	    	getContentPane().setLayout(null); 
	    	getContentPane().setBackground(Color.getHSBColor(120, 200, 150));
	    	
	    	//create buttons for the board of the game
	    	button = new JButton[3][3];
	    	for (int column=0; column<3; column++){
	    		for (int row=0; row<3; row++){
	    			button[column][row] = new JButton(""); 
	    			button[column][row].setBackground(SystemColor.control); 
	    			button[column][row].setLocation((50+(column*bWidth)), (100+(row*bHeight))); 
	    			button[column][row].setSize(bWidth,bHeight); 
	    			getContentPane().add(button[column][row]);
			     
			        //Set all buttons to work with the event handlers
	    			button[column][row].addActionListener(this);
	    			button[column][row].addMouseListener(this);
	    		}
	    	}	
			        	  
	     // Create and add a status label JLabel 
			statusLabel = new JLabel("Start Playing!"); 
			fancyFont = new Font("Times New Roman", Font.BOLD, 28);
			statusLabel.setFont(fancyFont);
			statusLabel.setBounds(110,30,250, 45);
			getContentPane().add(statusLabel);
			
			//create and add an exit button JButton
			exitButton = new JButton("Exit"); 
			exitButton.setBackground(SystemColor.control); 
			exitButton.setLocation(250, 300); 
		    exitButton.setSize(100,40); 
		    getContentPane().add(exitButton);
		        
		    //create and add a restart button JButton
		    resetButton = new JButton("New Game"); 
			resetButton.setBackground(SystemColor.control); 
			resetButton.setLocation(50, 300); 
		    resetButton.setSize(100,40); 
		    getContentPane().add(resetButton);
		    
		    //Set the exit and restart buttons to work with the event handlers
		    resetButton.addMouseListener(this); 
		    exitButton.addMouseListener(this);
		    resetButton.addActionListener(this);
	        exitButton.addActionListener(this);
	    	    	
	    } 
	    
	    //This is the event handler for the button 
	    public void actionPerformed(ActionEvent e) { 
	        //Ask the event which button it represents 
	    	//exit the game if the user chooses the exit button
	    	if (e.getActionCommand().equals("Exit")){
	            System.exit(0); 
	        }
	    	
	    	//restart the game if the user chooses the exit button
	    	if (e.getActionCommand().equals("New Game")){
	        	for (int column=0; column<3; column++){
		    		for (int row=0; row<3; row++){
		    			button[column][row].setEnabled(true);
		    			button[column][row].setText("");
		    		}
		    	}
	        	statusLabel.setText("Start Playing!");
	        	gameOver=false;
	        	click=0;
	        }
	        
	    	//change the text of the buttons in the board if the user chooses them
	        if (e.getActionCommand().equals("")){
	        	click++;
	        	if((click%2)==1){
	        		((AbstractButton) e.getSource()).setText("X");
	        		statusLabel.setText("Player 2's Turn!");
	        	}else if(click==0){
	        		statusLabel.setText("Start Playing!");
	        	}else{
	        		((AbstractButton) e.getSource()).setText("O");
	        		statusLabel.setText("Player 1's Turn!");
	        	}
	        }
	        //run the methods to check the winner and to check if the game is over
	        TicTacRules.win();
	        TicTacRules.gameOver();
	    }
	    
	    //method which initiates when the mouse is pressed
	    public void mousePressed(MouseEvent event) { 
	        System.out.println("MousePressed"); 
	    }
	    
	    //method which initiates when the mouse is released
	    public void mouseReleased(MouseEvent event) { 
	    	System.out.println("MouseReleased"); 
	    }
	    
	    //method which initiates when the mouse enters a button
	    public void mouseEntered(MouseEvent event) { 
	    	System.out.println("MouseEntered"); 
	    }

	    //method which initiates when the mouse exits a button
	    public void mouseExited(MouseEvent event) { 
	    	System.out.println("MouseExited"); 
	    }
	    
	    //method which initiates when the mouse clicks on a button
	    public void mouseClicked(MouseEvent event) { 
	        String s; 
	        if (event.getButton() == 1) 
	            s = "Right"; 
	        else s = "Left"; // Ignores the middle button case 
	        System.out.printf("Mouse" + s + "-Clicked " + event.getClickCount() + 
	                          " times successively ", event); 
	    }
	    
	    public static JButton getButton(int columnNum,int rowNum){
	    	return(button[columnNum][rowNum]);
	    }
	    
	    //the main method of the class which will initiate the game
	    public static void main(String args[]) { 
	         // Instantiate a FirstApplication object so you can display it 
	         TicTacWindow frame =  new TicTacWindow("TicTacToe Game"); 
	         frame.setDefaultCloseOperation(EXIT_ON_CLOSE); 
	         
	         // Set the size of the application window (frame) 
	         frame.setSize(WIDTH, HEIGHT); 
	         frame.setVisible(true); // Show the application (frame) 
	         frame.setResizable(false); // Make the size of the window fixed
	    } 
}



