
/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    public SecondRatings() {
        // default constructor
        this("ratedmoviesfull.csv", "ratings.csv");
    }
    
    public  SecondRatings(String moviefile,String Ratingsfile)
    {
         FirstRatings fir = new  FirstRatings();
         myMovies = fir.loadMovies(moviefile);
         myRaters = fir.LoadRaters(Ratingsfile);
         //System.out.println(myMovies);
         //System.out.println("===================");
         //System.out.println(myRaters);
         
         
    }
    
   
    
    public int getMovieSize()
    {
        //System.out.println("movie size = " + myMovies.size());
        return myMovies.size();
        
    }
    
    public int getRatersSize()
    {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0;i<myRaters.size();i++)
        {
            String Key = myRaters.get(i).getID();
            if(!map.containsKey(Key))
            {
                map.put(Key,1);
            }
            
        }
        //System.out.println("raters = " + map.size());
        return map.size();
    }
    
    public double getAverageByID(String movieID,int minRaters)
    {
        double NumOfRaters = getNumOfRaters(movieID);
        double AvgRatings=0,totalRatings=0,Ratings=0;
        if(NumOfRaters >= minRaters)
        {
            for(int i=0;i<myRaters.size();i++)
            {
                if(Integer.parseInt(myRaters.get(i).getItem())==Integer.parseInt(movieID))
                {
                    
                    Ratings = myRaters.get(i).getRating(movieID);
                    //System.out.println("Ratings = " + Ratings);
                    totalRatings = totalRatings +  Ratings;
                }
            }
            AvgRatings = totalRatings/NumOfRaters;
            return AvgRatings;
      }
        return 0.0;
        
    }
    
 public ArrayList<Rating> getAverageRatings(int MinRaters)
 {
        ArrayList<Rating> RatingsList = new ArrayList<Rating>();
         ArrayList<String> title = new ArrayList<String>();
        double AvgRating = 0,NumOfRaters=0;
        for(int i=0;i<myRaters.size();i++)
        {
            if(Contains(myRaters.get(i),RatingsList)==false)
            {
                NumOfRaters = getNumOfRaters(myRaters.get(i).getItem());
                if(NumOfRaters >= MinRaters)
                {
                  AvgRating = getAverageByID(myRaters.get(i).getItem(),MinRaters);
                  Rating rt = new Rating(myRaters.get(i).getItem(),AvgRating);
                  RatingsList.add(rt);
                 // title.add(getTitle(rt.getItem()));
                }
        } 
    }
    Collections.sort(RatingsList);
    
    for(int i=0;i<RatingsList.size();i++)
    {
         title.add(getTitle(RatingsList.get(i).getItem()));
        
    }
    
        print(RatingsList,title);
        return RatingsList;
 }
 
    
 public boolean Contains(Rater rt, ArrayList<Rating> RatingsList)
 {
     for(int i=0;i<RatingsList.size();i++)
     {
       if(Integer.parseInt(RatingsList.get(i).getItem())==Integer.parseInt(rt.getItem()))
       {
           //System.out.println("" + Integer.parseInt(myRaters.get(i).getItem()) + "== " + Integer.parseInt(rt.getItem()));
           //System.out.println("Returned True");
           return true;
        }
     }
     return false;
 }
 
 public String getTitle(String ID)
 {
     String Title;
     for(int i=0;i<myMovies.size();i++)
     {
       if(Integer.parseInt(myMovies.get(i).getID())==Integer.parseInt(ID))
       {
          Title = myMovies.get(i).getTitle(); 
          return Title;
       }
 }
 return "Not Found";
}

public void print(ArrayList<Rating> RatingsList, ArrayList<String> title)
{
    for(int i=0;i<RatingsList.size();i++)
    {
        
        System.out.println(RatingsList.get(i).getValue() + " " + title.get(i));
    }
}
 /*
 @Override
 public boolean equals(Object obj)
 {
   Rater rt = (Rater) obj;
   if(Integer.parseInt(rt.getItem())== Integer.parseInt(rt.getItem()))
   {
       return true;
    }
    return false;
 }
 */
 public int getNumOfRaters(String movieID)
 {
        int Count=0;
     for(int i=0;i<myRaters.size();i++)
      {
         if(Integer.parseInt(myRaters.get(i).getItem())==Integer.parseInt(movieID))
         {
                  Count++;
                  
         }
          
      }
     return Count;
 }
 
 public String getID(String Title)
 {
    for(int i=0;i<myMovies.size();i++)
    {
        if(myMovies.get(i).getTitle().equals(Title))
        {
            return myMovies.get(i).getID();
        }
    }
    return "NOT FOUND";
 }
}
            
        
    

  
   
