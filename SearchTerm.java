public class SearchTerm {
    public String searchTerm;
    public String timestamp;
    public SearchTerm(String searchTerm, String timestamp) {
        this.searchTerm = searchTerm;
        this.timestamp = timestamp;
        //System.out.println("Search Term: " + this.searchTerm + ":: Timestamp: " + this.timestamp);
    }
    public String getTerm(){
        return searchTerm;
    }
}
