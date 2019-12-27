import java.util.ArrayList;
/**
 * Write a description of MovieRunnerSimilarRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovieRunnerSimilarRatings {
    
     public void printAvgRtaingByFillter()
    {
        FourthRatings fr = new FourthRatings();
        RaterDatabase rd = new RaterDatabase();
        rd.initialize("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
      
     
     ArrayList<Rating> ratings =  fr.getSimilarRatings("71",5,20);
     System.out.println(ratings);
       
     System.out.println("Number of movies in database = " + ratings.size());
     System.out.println("Number of raters = " + RaterDatabase.size());
      
        for(int i=0;i<ratings.size();i++)
        {
        
        System.out.println(ratings.get(i).getValue() + " " + " " +  " " +  MovieDatabase.getTitle(ratings.get(i).getItem()) );
     }
       
    }
    
    
     public void printSimilarRatingsByAVG()
    {
        RaterDatabase rd = new RaterDatabase();
        rd.initialize("ratings_short.csv");
        MovieDatabase.initialize("ratedmovies_short.csv");
        //System.out.println("Ratings = " + rd.getRaters());
     FourthRatings fr = new FourthRatings();
     fr.TestSimilarities();
    }
   
    public void printAvgRtaingBaesOnYearAfterAndGenre()
    {
         ThirdRatings sr = new  ThirdRatings("ratings.csv" );
         MovieDatabase.initialize("ratedmoviesfull.csv");
         AllFilters AF = new AllFilters();
         AF.addFilter( new GenreFilter("Drama"));
         AF.addFilter( new YearAfterFilter(1975));
        
         
       
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
    
    public void printAvgRtaingBaesOnGenre()
    {
         FourthRatings sr = new  FourthRatings();
         MovieDatabase.initialize("ratedmoviesfull.csv");
         RaterDatabase rd = new RaterDatabase();
         rd.initialize("ratings.csv");
       
       ArrayList<Rating> ratings =  sr.getSimilarRatingsbyFilter("964",5,20,new GenreFilter("Mystery"));
       
        System.out.println("Number of movies in database = " + ratings.size());
        System.out.println("Number of raters = " + RaterDatabase.size());
      
        for(int i=0;i<ratings.size();i++)
        {
          
        //int id =  Integer.parseInt(ratings.get(i).getItem());
        //String  ID = Integer.toString(id);
        System.out.println(ratings.get(i).getValue() + " "  + MovieDatabase.getGenres(ratings.get(i).getItem()) + " " +  MovieDatabase.getTitle(ratings.get(i).getItem()) );
       }
       
    }
     public void printAvgRtaingBaesOnDirectors()
    {
         FourthRatings sr = new  FourthRatings();
         MovieDatabase.initialize("ratedmoviesfull.csv");
         RaterDatabase rd = new RaterDatabase();
         rd.initialize("ratings.csv");
       
       ArrayList<Rating> ratings =  sr.getSimilarRatingsbyFilter("65",3,10,new DirectorsFilter("Clint Eastwood,Sydney Pollack,David Cronenberg,Oliver Stone"));
       
        System.out.println("Number of movies in database = " + ratings.size());
        System.out.println("Number of raters = " + RaterDatabase.size());
      
        for(int i=0;i<ratings.size();i++)
        {
          
        //int id =  Integer.parseInt(ratings.get(i).getItem());
        //String  ID = Integer.toString(id);
        System.out.println(ratings.get(i).getValue() + " "  + MovieDatabase.getGenres(ratings.get(i).getItem()) + " " +  MovieDatabase.getTitle(ratings.get(i).getItem()) );
       }
       
    }

    
    public void printAvgRtaingBaesOnMinutesAndGenre()
    {
         FourthRatings fr = new  FourthRatings( );
         MovieDatabase.initialize("ratedmoviesfull.csv");
         RaterDatabase rd = new RaterDatabase();
         rd.initialize("ratings.csv");
         AllFilters AF = new AllFilters();
         AF.addFilter( new GenreFilter("Drama"));
         AF.addFilter(new GenreFilter("Comedy"));
         AF.addFilter( new MinutesFilter(80,160));
        
         
       
       ArrayList<Rating> ratings =  fr.getSimilarRatingsbyFilter("168",3,10,AF);
       
       
        System.out.println("Number of movies in database = " + ratings.size());
        System.out.println("Number of raters = " + RaterDatabase.size());
      
        for(int i=0;i<ratings.size();i++)
        {
          
        int id =  Integer.parseInt(ratings.get(i).getItem());
        String  ID = Integer.toString(id);
        System.out.println(ratings.get(i).getValue() + " "  + " " +MovieDatabase.getMinutes(ratings.get(i).getItem()) + " " + MovieDatabase.getGenres(ratings.get(i).getItem()) + " " +  MovieDatabase.getTitle(ratings.get(i).getItem()) );
       }
       
    }
    
    public void printAvgRtaingsBasedOnYearAfterMinutes()
    {
         FourthRatings fr = new  FourthRatings( );
         MovieDatabase.initialize("ratedmoviesfull.csv");
         RaterDatabase rd = new RaterDatabase();
         rd.initialize("ratings.csv");
         AllFilters AF = new AllFilters();
         AF.addFilter( new YearAfterFilter(1975));
         AF.addFilter( new MinutesFilter(70,200));
        
         
       
        ArrayList<Rating> ratings =  fr.getSimilarRatingsbyFilter("314",5,10,AF);
       
       
        System.out.println("Number of movies in database = " + ratings.size());
        System.out.println("Number of raters = " + RaterDatabase.size());
      
        for(int i=0;i<ratings.size();i++)
        {
          
        int id =  Integer.parseInt(ratings.get(i).getItem());
        String  ID = Integer.toString(id);
        System.out.println(ratings.get(i).getValue() + " "  + " " +MovieDatabase.getMinutes(ratings.get(i).getItem()) + " " + MovieDatabase.getYear(ratings.get(i).getItem()) + " " +  MovieDatabase.getTitle(ratings.get(i).getItem()) );
       }
       
    }
    
    
}
