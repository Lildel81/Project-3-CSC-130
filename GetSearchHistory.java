import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class GetSearchHistory {
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String GET_URL = "https://csc130.crowleybrynn.com/getSearchTerms.php";
    
    public String getData(ArrayList<SearchTerm> searchTerms) throws IOException{
        URL url = new URL(GET_URL);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = connection.getResponseCode();
        System.out.println("GET Response Code: " + responseCode);
        if(responseCode == HttpsURLConnection.HTTP_OK){
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                // Parse the JSON response
                JSONArray jsonArray = new JSONArray(reader.readLine());
                
                // Iterate through the JSON array and create SearchTerm objects
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String searchTerm = jsonObject.getString("Search");
                    String timestamp = jsonObject.getString("Timestamp");
                    SearchTerm searchTermObject = new SearchTerm(searchTerm, timestamp);
                    searchTerms.add(searchTermObject);
                }
            }catch(Exception e){
                System.out.println("Exception " + e + ". Reading HTTP response.");
            }
        }else{
            System.out.println("GET Request Error!");
        }
        return "Yay!";
    }
}
