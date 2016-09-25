//We have different players.So we have a Player class.
public class Player{
	
	private Marker marker;
	private Board board;
	
	public Player(Board board,Marker marker){
		this.board=board;
		this.marker=marker;
	}
	
	//Replace the spot chosen for the move by appropriate player sign(marker).
	public void makeMove(int row,int col){
		board.setSpot(row, col, marker);
	}
	
	//Return the marker of a player during the game.
	public Marker getMarker(){
		return marker;
	}
}