//Every box in the board is a separate spot to which a move will be made.
//Hence we have a Spot class.
public class Spot{
	
	public Marker marker=Marker.NONE;
	
	//Return the marker('X' OR 'O') at a particular spot during the game.
	public Marker getMarker(){
		return marker;
	}
	
	//Set the marker('X' OR 'O') at a particular spot during the game.
	public void setMarker(Marker marker){
		this.marker=marker;
	}
}
