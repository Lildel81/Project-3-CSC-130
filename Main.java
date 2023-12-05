import java.util.ArrayList;

public class Main{
    public static void main(String args[]){
        ArrayList<SearchTerm> searchTerms = new ArrayList<SearchTerm>();
        GetWebsiteData getReq = new GetWebsiteData();

        try{
          getReq.getSearchHistory(searchTerms);  
          getReq.getShopItems(createTrend.shopItems);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
         System.out.println("Search Terms:");
        for(SearchTerm term: searchTerms){
            System.out.printf("Search Term: %-20s - Timestamp: %-20s%n", term.searchTerm, term.timestamp);

        }
        System.out.println("Shop Items:");
        for(String item: createTrend.shopItems){
            System.out.println("Shop Item: " + item);

        }


        createTrend.strArr.add(searchTerms.get(0).getTerm());
         for (int i = 1; i < searchTerms.size(); i++){
            createTrend.strArr.add(searchTerms.get(i).getTerm());

       }
       
        createTrend.makeTrendArray(createTrend.strArr);
        
        
        System.out.println("Top Ten Items Searched");
        for (int i = 0; i < createTrend.arr.size(); i++){
            System.out.println(createTrend.arr.get(i).getTicker() + " " + createTrend.arr.get(i).getPhrase());
            //System.out.println(createTrend.shopItemArr.get(i).toString());

        }
       
        }
        
    }
    
