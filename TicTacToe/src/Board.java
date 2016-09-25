//We need a board(UI) of size 3x3 to play the game.
//Therefore, we have a Board class.
public class Board{
	
	private Spot[][] board=new Spot[3][3];
	
    //Initialize the 3x3 board with marker '*'.
	public Board() {
    	int i,j;
        for (i=0; i<3; i++){
            for (j=0;j<3;j++){
                board[i][j]=new Spot();
            }
        }
    }
    
    //Fill a spot in the board game with the appropriate marker.
	public void setSpot (int row, int col, Marker type){
        board[row][col].setMarker(type);
    }
	
	//Return a spot in the board game.
    public Spot getSpot(int row, int col){
        return board[row][col];
    }
}