/**
Song class describes a song object.
@author Bidlake
*/


public class Song implements Comparable<Song>{

	/**
    The frequency the song has been played.
    */
	private int freq;
	
	/**
    The name of the band or artist.
    */
	private String band;
	
	/**
    The song title.
    */
	private String title;
	
	/**
    Creates a song with the specified frequency, band name and song title.
	@param freq Frequency the song has been played.
	@param band The name of the band or artist.
	@param title The song title.
    */	
	public Song(int freq, String band, String title){
		this.freq = freq;
		this.band = band;
		this.title = title;
	}
	
	public String getBand(){
		return band;
	}
	
	public String getTitle(){
		return title;
	}
	
	public int getFreq(){
		return freq;
	}
	
	public int compareTo(Song other){
		int compareFreq = this.freq - ((Song)other).getFreq();
		//change to all lower case;
		int compareBand = 0;
		int compareTitle = 0;
		
		if(compareFreq == 0) {
			compareBand = this.band.toLowerCase().compareTo(other.getBand().toLowerCase());
			if(compareBand == 0){
				compareTitle = this.title.toLowerCase().compareTo(other.getTitle().toLowerCase());
				return compareTitle;
			}
			else {
				return compareBand;
			}
		}
		else{
			return compareFreq;
		}
	}
	

	
	/**
    Prints the information about the song.
	@return The formatted information about the song.
    */	
	public String toString(){
		String result = freq + ", " + band + ", " + title;
		return result;
	}
	
}

