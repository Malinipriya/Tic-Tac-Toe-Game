//There are different symbols(markers) used by players to play the game.
//Hence we have an enumerator to take care of symbol functionality.
public enum Marker{
	
	NONE("*"),
	CIRCLE("O"),
	CROSS("X");
	
	private String sign;
	private Marker(String sign){
		this.sign=sign;
	}
	
	@Override
    public String toString() {
        return sign;
    }
}