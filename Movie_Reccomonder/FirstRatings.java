import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;
/**
 * Write a description of FirstRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FirstRatings {
       public ArrayList<Movie> loadMovies(String fileName)
    {
        ArrayList<Movie> Movielist = new ArrayList<Movie>();
        FileResource fr = new FileResource(fileName);
        for(CSVRecord rec : fr.getCSVParser())
        {
            Movie mv = new Movie(rec.get(0),rec.get(1),rec.get(2),rec.get(3),rec.get(4),rec.get(5),Integer.parseInt(rec.get(6)),rec.get(7));
            Movielist.add(mv);
        }
        
        //loadMoviesInGenre(fileName);
        //loadMoviesBasedOnMin(fileName);
        //MaxMovByDir(fileName);
        
       
        //System.out.println("Total Number Of Movies = " + Movielist.size());
        return Movielist;
    }
    
    
     public ArrayList<Rater>  LoadRaters(String filename)
     {
         FileResource fr = new FileResource(filename);
       
        ArrayList<Rater> RaterList = new ArrayList<Rater>();
        HashMap<Integer,Integer> Map = new HashMap<Integer,Integer>();
        
        
         for(CSVRecord rec : fr.getCSVParser())
        {
            
            Rater rt = new Rater(rec.get(0));
            rt.addRating(rec.get(1),Double.parseDouble(rec.get(2)));
           
           
           
              // System.out.println(rt.getID());
              RaterList.add(rt);
            
            
            
            
            
            //System.out.println("movie = " + rt.getItem() + " "+ rt.getRating(rt.getItem()));
        }
        
        return RaterList;
    }
    
    public void test()
    {
        LoadRaters("ratings_short.csv");
    }
}
    
        
    
    
    
   
   


