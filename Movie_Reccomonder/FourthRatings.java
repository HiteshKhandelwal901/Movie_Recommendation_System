
/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class FourthRatings {
   
    
 
  public double dotProduct(Rater me, Rater r)
  {
        double DotProduct = 0,Product=0;
        double meRatings =0,rRatings=0;
        ArrayList<String> myMovies = MovieDatabase.filterBy(new TrueFilter());
      
        //System.out.println("Movies read = " + myMovies.size());
        
        
     for(String ID : myMovies)
     {
         //System.out.println("CHCECKING FOR MOVIE ID = "+ ID);
       if(me.hasRating(ID) == true && r.hasRating(ID) == true)
       {
         meRatings = me.getRating(ID);
         //System.out.println("meRatings for " + ID + " = " + meRatings);
        rRatings = r.getRating(ID);
        //System.out.println("rRatings for " + ID + " = " + rRatings);
        if(meRatings !=-1 && rRatings!=-1)
        {
          Product = (meRatings-5) * (rRatings-5);
         // System.out.println("product  = " + Product);
          DotProduct = DotProduct + Product;
          //System.out.println("Dotproduct  = " + DotProduct);
        }
       }
    }
     return DotProduct;
  }
  
  public ArrayList<Rating> getSimilarities(String ID)
  {
      ArrayList<Rating> list = new ArrayList<Rating>();
      for(Rater r : RaterDatabase.getRaters())
      {
          
         // System.out.println("Checking for rater = " + r.getID());
         // System.out.println("Checking if rater " + ID  + " == " + r.getID());
          if(!(r.getID().equals(ID)))
          
          {
             Rater me =  RaterDatabase.getRater(ID);
            //System.out.println("me rater = " +me.getID());
             
             Double dotProduct = dotProduct(me,r);
            // System.out.println("dot product = " + dotProduct);
             if(dotProduct>=0)
             {
                 list.add(new Rating(r.getID(),dotProduct));
             }
          }
          
      }
      Collections.sort(list,Collections.reverseOrder());
      
      return list;
  }
  
  
   
    
    public ArrayList<Rating> getSimilarRatingsbyFilter(String id, int MinRaters ,int numOfSimilarRaters,Filter filterCriteria )
   {
       ArrayList<Rating> list = getSimilarities(id);
      // System.out.println("RatingList = " + list);
       ArrayList<Rating>MoviesList = new ArrayList<Rating>();
       ArrayList<String> myMovies = MovieDatabase.filterBy(filterCriteria);
      // System.out.println("myMovies.size() = " + myMovies.size());
       
       for(int i=0;i<myMovies.size();i++)
       {
          // System.out.println("=====================================");
          //System.out.println("CurrMOVIE = " +  myMovies.get(i));
           double TotalRaters = 0;
           double WeightedTotal = 0;
           double AVG = 0;
         for(int k=0;k<numOfSimilarRaters;k++)
         {
             String CurrRaterID = list.get(k).getItem(); 
             //System.out.println("CurrRaterID from list = " + CurrRaterID);
              Rater CurrRater = RaterDatabase.getRater(CurrRaterID);
             // System.out.println("CurrRater from database = " + RaterDatabase.getRater(CurrRaterID));
             // System.out.println("Checking if movie  " +myMovies.get(i) + "is present in" + RaterDatabase.getRater(CurrRaterID));
              
              if(CurrRater.hasRating(myMovies.get(i))==true)
              {
                // System.out.println("Movie PRESENT");
                 TotalRaters++;
                // System.out.println("TotalRaters = " + TotalRaters);
                //System.out.println("list.get(k).getValue = " + list.get(k).getValue() + "CurrRater.getRating(myMovies.get(i)) = " + CurrRater.getRating(myMovies.get(i)));
                 WeightedTotal = WeightedTotal + (list.get(k).getValue() )* (CurrRater.getRating(myMovies.get(i)));
               // System.out.println("Weighted Total = " + WeightedTotal);
              }
         }
         if(TotalRaters >= MinRaters)
         {
              AVG = WeightedTotal / TotalRaters;
          //  System.out.println("Average wieghtedtoal for movie " + myMovies.get(i) + " =  " + AVG);
             MoviesList.add(new Rating(myMovies.get(i),AVG));
             
         }
       }
       Collections.sort(MoviesList,Collections.reverseOrder());
      // System.out.println("MovieList = " + MoviesList);
       return MoviesList;
       
    }
    
    


}
            
        
    

  
   
