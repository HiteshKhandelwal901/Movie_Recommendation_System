import java.util.*;
import java.io.*;
/**
 * Write a description of sc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RecommendationRunner implements Recommender {
    
    public ArrayList<String> getItemsToRate()
    {
        ArrayList<String> MovieList = new ArrayList<String>();
        ArrayList<String> List = new ArrayList<String>();
        FourthRatings fr = new  FourthRatings( );
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase rd = new RaterDatabase();
        rd.initialize("ratings.csv");
        AllFilters AF = new AllFilters();
        
        AF.addFilter(new YearAfterFilter(2005));
        AF.addFilter( new MinutesFilter(90,180));
        List = MovieDatabase.filterBy(AF);
        
        for(int i=0;i<15;i++)
        {
            MovieList.add(List.get(i));
        }
       // System.out.println(MovieList);
        return MovieList;
    }
    
    public void printRecommendationsFor(String webRaterID)
    {
        MovieDatabase.initialize("ratedmoviesfull.csv");
       RaterDatabase rd = new RaterDatabase();
        rd.initialize("ratings.csv");
        ArrayList<String> MovieList = new ArrayList<String>();
        ArrayList<Rating> List = new ArrayList<Rating>();
        FourthRatings fr = new  FourthRatings( );
        AllFilters AF = new AllFilters();
        AF.addFilter(new YearAfterFilter(1980));
        AF.addFilter( new MinutesFilter(70,180));
        
       
         List = fr.getSimilarRatingsbyFilter(webRaterID,3,10,AF);
         System.out.println("RECOMMENDED MOVIES");
         System.out.println("<table border =\"2\">");
        
         System.out.println("<tr> <th>  "  + "SL NO" + "</th>"+ "<th>" +"YEAR" + "</th>" + "<th>" +"MOVIE TITLE" + "</th>" + "<th>"+ "DIRECTORS" + "</th>" + "</tr>");
         for(int i=0;i<List.size();i++)
         {
             System.out.println("<tr><td>" + i +"</td>" + "<td>"   + MovieDatabase.getYear(List.get(i).getItem()) +
             " </td>" + "<td>" + MovieDatabase.getTitle(List.get(i).getItem()) + "</td>" +  "<td>" + MovieDatabase.getGenres(List.get(i).getItem())+ "</td>" + "</tr>");
             System.out.println("");
         }
        System.out.println("</table>");
                
               
                
    
    }

}
