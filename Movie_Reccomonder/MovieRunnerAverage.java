import java.util.*;
/**
 * Write a description of MovieRunnerAverage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovieRunnerAverage {
    
    
    public void printAvgRtaingByFillter()
    {
     ThirdRatings fr = new ThirdRatings("ratings_short.csv");
      MovieDatabase.initialize("ratedmovies_short.csv");
      ArrayList<Rating> ratings =  fr.getAverageRatings(1);
       
     System.out.println("Number of movies in database = " + ratings.size());
     System.out.println("Number of raters = " + ratings.size());
      
        for(int i=0;i<ratings.size();i++)
        {
          
        //int id =  Integer.parseInt(ratings.get(i).getItem());
        //System.out.println("ID = " + ratings.get(i).getItem());
        //String  ID = Integer.toString(id);
        
       // System.out.println("id = " + id + " " + "ID = " + ID);
       
        //System.out.println(ratings.get(i).getValue() + " " + " " + MovieDatabase.getMinutes(ratings.get(i).getItem()) + " " +  MovieDatabase.getTitle(ratings.get(i).getItem()) );
     }
       
    }
   
    public void printAvgRtaingBaesOnYearAfterAndGenre()
    {
         ThirdRatings sr = new  ThirdRatings("ratings.csv" );
         MovieDatabase.initialize("ratedmoviesfull.csv");
         AllFilters AF = new AllFilters();
         AF.addFilter( new GenreFilter("Drama"));
         AF.addFilter( new YearAfterFilter(1990));
        
         
       
       ArrayList<Rating> ratings =  sr.getAverageRatingsByFilter(8,AF);
       
       
        System.out.println("Number of movies in database = " + ratings.size());
        System.out.println("Number of raters = " + sr.getRatersSize());
      
        for(int i=0;i<ratings.size();i++)
        {
          
        int id =  Integer.parseInt(ratings.get(i).getItem());
        String  ID = Integer.toString(id);
        System.out.println(ratings.get(i).getValue() + " "  + " " +MovieDatabase.getYear(ratings.get(i).getItem()) + " " + MovieDatabase.getGenres(ratings.get(i).getItem()) + " " +  MovieDatabase.getTitle(ratings.get(i).getItem()) );
       }
       
    }
   
    public void getAverageRatingsOneMovie()
    {
        FourthRatings sr = new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");
        
        //System.out.println("NUMBER OF RATERS = " +sr.getRatersSize() + " Number of Movie =  "+ sr.getMovieSize());
        String MovieID = sr.getID("");
        //System.out.println("MovieID = " + MovieID);
        System.out.println("Average Ratings = "  + sr.getAverageByID("1798709",5));
    }
    
    public void printAvgRtaingBaesOnGenre()
    {
         ThirdRatings sr = new  ThirdRatings("ratings.csv" );
         MovieDatabase.initialize("ratedmoviesfull.csv");
       
       ArrayList<Rating> ratings =  sr.sr.getAverageRatingsByFilter(20,new GenreFilter("Comedy");
       
        System.out.println("Number of movies in database = " + ratings.size());
        System.out.println("Number of raters = " + sr.getRatersSize());
      
        for(int i=0;i<ratings.size();i++)
        {
          
        //int id =  Integer.parseInt(ratings.get(i).getItem());
        //String  ID = Integer.toString(id);
        System.out.println(ratings.get(i).getValue() + " "  + MovieDatabase.getGenres(ratings.get(i).getItem()) + " " +  MovieDatabase.getTitle(ratings.get(i).getItem()) );
       }
       
    }

}
