package tictactoe;

public class TicTacRules extends TicTacWindow{
	//default constructor
	public TicTacRules(String title) {
		super(title);
	}
	
	//method to check if a player wins the game
    //f a player wins, the label will change to congratulate the winner
    public static void win(){
    	for(int column=0; column<3; column++){
        	if((button[column][0].getText().equals("X"))&&(button[column][1].getText().equals("X"))&&(button[column][2].getText().equals("X"))){
        		statusLabel.setText("Player 1 Won!");
        		gameOver=true;
        	}else if((button[column][0].getText().equals("O"))&&(button[column][1].getText().equals("O"))&&(button[column][2].getText().equals("O"))){
        		statusLabel.setText("Player 2 Won!");
        		gameOver=true;
        	}
        }
        
        for(int row=0; row<3; row++){
        	if((button[0][row].getText().equals("X"))&&(button[1][row].getText().equals("X"))&&(button[2][row].getText().equals("X"))){
        		statusLabel.setText("Player 1 Won!");
        		gameOver=true;
        	}else if((button[0][row].getText().equals("O"))&&(button[1][row].getText().equals("O"))&&(button[2][row].getText().equals("O"))){
        		statusLabel.setText("Player 2 Won!");
        		gameOver=true;
        	} 
        }

        if((button[0][0].getText().equals("X"))&&(button[1][1].getText().equals("X"))&&(button[2][2].getText().equals("X"))){
        	statusLabel.setText("Player 1 Won!");
    		gameOver=true;
        }else if((button[0][0].getText().equals("O"))&&(button[1][1].getText().equals("O"))&&(button[2][2].getText().equals("O"))){
        	statusLabel.setText("Player 2 Won!");
    		gameOver=true;
        }
        
        if((button[0][2].getText().equals("X"))&&(button[1][1].getText().equals("X"))&&(button[2][0].getText().equals("X"))){
        	statusLabel.setText("Player 1 Won!");
    		gameOver=true;
        }else if((button[0][2].getText().equals("O"))&&(button[1][1].getText().equals("O"))&&(button[2][0].getText().equals("O"))){
        	statusLabel.setText("Player 2 Won!");
    		gameOver=true;
        }
    }
    
    //the method which restarts the whole board and changes the label
    public static void gameOver(){
    	if((click==9)&&(gameOver==false)){
    		gameOver=true;
    		statusLabel.setText("Tie!!!!!!!!!!!!");
    	}
    	
    	if(gameOver==true){
        	for (int a=0; a<3; a++){
	    		for (int b=0; b<3; b++){
	    			button[a][b].setEnabled(false);
	    		}
    		}
        }
    }
}
