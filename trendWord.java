
public class trendWord {

	private int ticker;
	private String phrase;
	
		//TrendWord constructor
		public trendWord(int ticker, String phrase) {
			this.ticker = ticker;
			this.phrase = phrase;
		}
		
	// setter methods
		public void setTicker(int t) {
			this.ticker = t;
		}
		
		public void setPhrase(String str) {
			this.phrase = str;
		}
		
	// getter methods
		public int getTicker() {
			return ticker;
		}
		
		public String getPhrase() {
			return phrase;
		}
		
	// toString method for printing object
		
		public String toString() {
			
			return ticker + " " + phrase;
		}
		
		
		
		
		
}
