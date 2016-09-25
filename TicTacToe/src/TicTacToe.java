import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

//This is the main class which coordinates the functionalities of the board,players and moves by using other classes.
public class TicTacToe{
	
	//The object used to make moves on the board during the game.
	private Game newGame;
	
	public TicTacToe(){
		newGame=new Game();
	}
	
	public void playGame(String playerType1, String playerType2){
		int i,input=0,validInputFlag=0,moveNumber=0,playerNumber=1,winFlag=0;;
		String playerType=playerType1;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Random random = new Random();
		//This array list makes sure that the players don't reuse already chosen numbers(spots).
		ArrayList<Integer> inputCheck=new ArrayList<Integer>();
		
		newGame.display();
		System.out.println("Game Begins.");
		
		//The game requires at most 9 valid moves to decide win or draw.
		while(moveNumber<9)
		{
			
			validInputFlag=0;
			try{
				//Act according to player type:human or computer
				switch(playerType){
					case "human":	System.out.println("Player "+playerNumber+"'s move:Enter an unused number from 1-9");
									input=Integer.parseInt(br.readLine());
								 	for(i=0;i<9;i++) {
								 		if(i==input-1 && !inputCheck.contains(input)){
											winFlag=newGame.makeMove(input-1);
											validInputFlag=1;
											break;
										}
									}
									break;
					case "computer":	System.out.println("Player "+playerNumber+"'s move:");
										int min=1,max=9;
										input=random.nextInt(max - min + 1) + min;
										if(!inputCheck.contains(input)){
											System.out.println("Computer generated number:"+input);
											winFlag=newGame.makeMove(input-1);
											validInputFlag=1;
										}
										break;
				}
				//If the win flag is set, it means a player has won across a row, column or diagonal.
				if(winFlag==1){
					System.out.println("Player "+playerNumber+" wins!!");
					break;
				}
				//If the number chosen is not in the range 1-9 or if the number is already taken, then prompt the user to get another valid input.
				if(validInputFlag==0)
					System.out.println("Invalid input!!");
				else{
					inputCheck.add(input);
					moveNumber++;
					if(playerNumber==1)
						playerNumber=2;
					else
						playerNumber=1;
					if(playerType==playerType1)
						playerType=playerType2;
					else
						playerType=playerType1;
				}
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		if(winFlag==0)
			System.out.println("It's a draw!!");
		System.out.println("Game over.");
		inputCheck.clear();
	}
	
	public static void numpadDisplay()
	{
		int i,j,count=0;
        for(i=0; i<3; i++){
        	for(j=0; j<3; j++){
        		count++;
        		System.out.print(count+"\t");
            }
            System.out.print("\n");
        }
	}
	
	public static void main(String[] args){
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome to Tic Tac Toe!! ");
		System.out.println("To choose your spot, use a standard numpad as an entry grid, as such:\n ");
		numpadDisplay();
		
		System.out.print("Start?(y/n):");
		char choice='y';
		String playerType1="",playerType2="";
		try{
			choice=br.readLine().charAt(0);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		if(choice=='n'||choice=='N'){
			return;
		}
		do{
			TicTacToe game=new TicTacToe();
			
			//Choose the player type: human or computer
			System.out.print("Player1?(human/computer):");
			try{
				playerType1=br.readLine();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			System.out.println("Player 1's symbol to play the game will be 'X'");
			System.out.print("Player2?(human/computer):");
			try{
				playerType2=br.readLine();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			System.out.println("Player 2's symbol to play the game will be 'O'");
			
			//Start playing the game if players are valid
			if((playerType1.equals("human") || playerType1.equals("computer")) && (playerType2.equals("human") || playerType2.equals("computer")))
				game.playGame(playerType1,playerType2);
			else
				System.out.println("Invalid players!! Please use the words 'human' or 'computer' to choose your players");
			
			//Prompt the user to play another game
			System.out.print("Another game?(y/n):");
			try{
				choice=br.readLine().charAt(0);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}while(choice!='n'||choice=='N');
		System.out.println("\nQuitting game.Bye!");
	}
}