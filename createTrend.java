import java.util.ArrayList;

public class createTrend {
	
public static ArrayList<String> strArr = new ArrayList<>();
public static ArrayList<trendWord> arr = new ArrayList<trendWord>();
public static ArrayList<trendWord> shopItemArr = new ArrayList<trendWord>();
public static ArrayList<String> shopItems = new ArrayList<String>();
public static trendWord[] finalTrends = new trendWord[10];
public static trendWord[] finalTrendsInInventory = new trendWord[10];
public static int count = 1;
public static String word = "";
public static boolean copy = true;
public static ArrayList<String> processedWords = new ArrayList<>();




//Ties all of the methods together to make the final string going to the GUI. 
public static void makeTrendArray(ArrayList<String> procWords) {
	for(int i = 0; i < strArr.size(); i++) {
		processedWords.add(StopWords.processString(procWords.get(i)));
		//System.out.println(processedWords.toString()); // for debugging
		parseArray(processedWords, arr);
		sort(arr);
		seperateTrend(arr, shopItems);
		cleanArray(arr);
		trimArray(arr);
	}
}


//counts the number of itterations a string appears. 
public static void parseArray(ArrayList<String> strArr, ArrayList<trendWord> arr) {
	for (int i = 0; i < strArr.size(); i++) {
		word = strArr.get(i);
		if (word.equalsIgnoreCase(word))
		for (int j = i+1; j < strArr.size(); j++) {
			if (word.equalsIgnoreCase(strArr.get(j))){
				count = count + 1;
			}
		}
		trendWord obj = new trendWord(count, word);
		arr.add(obj);
		count = 1;
		
		
		}
	
}

//Removes redundancy in words (deletes copies)
public static void cleanArray(ArrayList<trendWord> arr){
	for(int i = 0; i < arr.size(); i++) {
		word = arr.get(i).getPhrase();
		word.trim();
		
		for(int j = arr.size()-1; j > i; j--) {
			if (word.isBlank() || word.equalsIgnoreCase(arr.get(j).getPhrase())) {
				arr.remove(j);
			}
		}
	}
	
}

//Sorts the Array in order of ticker value.
public static void sort(ArrayList<trendWord> arr) {
	
	for (int i = 0; i < arr.size()-1; i++) {
		for (int j = 0; j < arr.size()-1; j++) {
			if (arr.get(j+1).getTicker() > arr.get(j).getTicker()) {
				trendWord temp = arr.get(j);
				arr.set(j,  arr.get(j+1));
				arr.set(j+1,  temp);
			
			}
		}
	}
}

public static void seperateTrend(ArrayList<trendWord> arr, ArrayList<String> shopArr){
	String word = "";
	String word2 = "";
	for(int i = 0; i < arr.size(); i++){
		word = arr.get(i).getPhrase();
		
		for (int k = 0; k < arr.size()-1; k++){
			word2 = shopArr.get(k);
			if(word.equalsIgnoreCase(word2){
				shopItemArr.add(arr.get(i));
			}
			}
		}
	}


public static void trimArray(ArrayList<trendWord> arr) {
	if (arr.size() >= 10) {

		for (int i = arr.size()-1;i > 9; i--) {
			arr.remove(i);
		}

   }
   if (shopItemArr.size() >= 10){
		for(int i = shopItemArr.size()-1; i > 9){
			arr.remove(i);
		}
   }
   for (int i = 0; i < 9; i++){
	finalTrends[i] = arr.get(i);
	finalTrendsInInventory[i] = shopItemArr.get(i);
   }

}
//A wait method for debugging.
	public static void wait(int i) {
		i = i*1000;
		try        
		{
		    Thread.sleep(i);
		} 
		catch(InterruptedException ex) 
		{
		    Thread.currentThread().interrupt();
		}
	}
}




