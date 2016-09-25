//Players take turns to play the game and make their moves.
//Hence we have a Game class to play the Game.
public class Game{
	
	private Board board;
	private Player currentPlayer,player1,player2;
	
	public Game(){
		board=new Board();
		initialisePlayers();
	}
	
	//Assign appropriate player signs to the two players.
	public void initialisePlayers(){
		player1=new Player(board, Marker.CROSS);
		player2=new Player(board, Marker.CIRCLE);
		currentPlayer=player1;
	}
	
	//Toggle between players after every valid move.
	public void changePlayer(){
		if(currentPlayer.equals(player1))
			currentPlayer=player2;
		else
			currentPlayer=player1;
	}
	
	//Make a move in the game.
	//Replace the spot chosen for the move by appropriate player sign.
	//The player sign is 'X' if the currentPlayer=player1.
	//The player sign is 'O' if the currentPlayer=player2.
	public int makeMove(int digit){
		int row=digit/3;
		int col=digit%3;
		int winStatus=0;
		currentPlayer.makeMove(row,col);
		changePlayer();
		display();
		if(checkWin()!=Marker.NONE){
			winStatus=1;
			return winStatus;
		}
		return winStatus;
	}
	
	//Determine if there is a winner at any point in the game.
	public Marker checkWin(){
		Marker winner;
		int i;
		for(i=0; i<3; i++){
            winner = checkRow(i);
            if (winner != Marker.NONE) {
                return winner;
            }

            winner = checkColumn(i);
            if (winner != Marker.NONE) {
                return winner;
            }
        }
		return checkDiagonal();
    }
	
	//Determine if there is a winning condition in any of the two diagonals.
	public Marker checkDiagonal(){
		if (board.getSpot(0, 0).getMarker() == board.getSpot(1, 1).getMarker() &&
                board.getSpot(0, 0).getMarker() == board.getSpot(2, 2).getMarker()) {
            return board.getSpot(0, 0).getMarker();
        }
        if (board.getSpot(0, 2).getMarker() == board.getSpot(1, 1).getMarker() &&
                board.getSpot(0, 2).getMarker() == board.getSpot(2, 0).getMarker()) {
            return board.getSpot(0, 2).getMarker();
        }
        return Marker.NONE;
    }
	
	//Determine if there is a winning condition in any of the three rows.
	public Marker checkRow(int row){
		if (board.getSpot(row, 0).getMarker() == board.getSpot(row, 1).getMarker() &&
                board.getSpot(row, 0).getMarker() == board.getSpot(row, 2).getMarker()) { //row full
            return board.getSpot(row, 0).getMarker();
        }
        return Marker.NONE;
    }
	
	//Determine if there is a winning condition in any of the three columns.
	public Marker checkColumn(int col){
        if (board.getSpot(0, col).getMarker() == board.getSpot(1, col).getMarker() &&
                board.getSpot(0, col).getMarker() == board.getSpot(2, col).getMarker()){
            return board.getSpot(0, col).getMarker();
        }
        return Marker.NONE;
    }
	
	//Display the game board at any point in the game.
	public void display(){
        Marker marker;
        int i,j;
        for(i=0; i<3; i++){
        	for(j=0; j<3; j++){
        		marker=board.getSpot(i, j).getMarker();
        		System.out.print(marker+"\t");
            }
            System.out.print("\n");
        }
    }
	
}