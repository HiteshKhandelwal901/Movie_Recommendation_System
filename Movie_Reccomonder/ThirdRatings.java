
/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class ThirdRatings {
   
    private ArrayList<Rater> myRaters;
    
    public ThirdRatings() {
        // default constructor
        this("ratings_short.csv");
    }
    
    public  ThirdRatings(String Ratingsfile)
    {
         FirstRatings fir = new  FirstRatings();
         myRaters = fir.LoadRaters(Ratingsfile);
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
        ArrayList<String> myMovies = MovieDatabase.filterBy(new TrueFilter());
        //System.out.println("myMovies size = " + myMovies.size());
        for(int i=0;i<myMovies.size();i++)
        {
           // System.out.println("Mymovies.get(i) = " + myMovies.get(i));
            if(Contains(myMovies.get(i),RatingsList)==false)
            
            {
                NumOfRaters = getNumOfRaters(myMovies.get(i));
                //System.out.println("NumOfRaters = " + NumOfRaters);
                if(NumOfRaters >= MinRaters)
                {
                  AvgRating = getAverageByID(myMovies.get(i),MinRaters);
                  Rating rt = new Rating(myMovies.get(i),AvgRating);
                  RatingsList.add(rt);
                  //title.add(getTitle(rt.getItem()));
                }
        } 
    }
    Collections.sort(RatingsList);
    
    
     for(int i=0;i<RatingsList.size();i++)
    {
         title.add(getTitle(RatingsList.get(i).getItem()));
        
    }
    
        print(RatingsList,title);
       // print(RatingsList,title);
        return RatingsList;
 }
 
    
 public boolean Contains(String ID, ArrayList<Rating> RatingsList)
 {
     for(int i=0;i<RatingsList.size();i++)
     {
       if(RatingsList.get(i).getItem().equals(ID))
       {
           return true;
       }
     }
     return false;
 }
 
 public String getTitle(String ID)
 {
     int id = Integer.parseInt(ID);
     String Cid = Integer.toString(id) ;
    String Title = MovieDatabase.getTitle(Cid);
 return Title;
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
    
    return "NOT FOUND";
 }
 
 
 public ArrayList<Rating> getAverageRatingsByFilter(int MinRaters, Filter filterCriteria)
 {
      
      ArrayList<Rating> RatingsList = new ArrayList<Rating>();
         ArrayList<String> title = new ArrayList<String>();
        double AvgRating = 0,NumOfRaters=0;
        ArrayList<String> myMovies = MovieDatabase.filterBy(filterCriteria);
        System.out.println("myMovies size = " + myMovies.size());
        System.out.println(myMovies);
       // for(int i=0;i<myMovies.size();i++)
       for(String ID : myMovies)
       
        {
           // System.out.println("Mymovies.get(i) = " + myMovies.get(i));
            if(Contains(ID,RatingsList)==false)
            
            {
                NumOfRaters = getNumOfRaters(ID);
                //System.out.println("NumOfRaters = " + NumOfRaters);
                if(NumOfRaters >= MinRaters)
                {
                  AvgRating = getAverageByID(ID,MinRaters);
                  Rating rt = new Rating(ID,AvgRating);
                  RatingsList.add(rt);
                  //title.add(getTitle(rt.getItem()));
                }
        } 
    }
    Collections.sort(RatingsList);
    
    
   
    
        
        return RatingsList;
 }
 
 
 public ArrayList<Rating> getAverageRatingsByFilterDirector(int MinRaters, Filter filterCriteria)
 {
      
      ArrayList<Rating> RatingsList = new ArrayList<Rating>();
         ArrayList<String> title = new ArrayList<String>();
        double AvgRating = 0,NumOfRaters=0;
        ArrayList<String> myMovies = MovieDatabase.filterBy(filterCriteria);
        System.out.println("myMovies size = " + myMovies.size());
        System.out.println(myMovies);
       // for(int i=0;i<myMovies.size();i++)
       for(String ID : myMovies)
       
        {
           // System.out.println("Mymovies.get(i) = " + myMovies.get(i));
           
            
            
                NumOfRaters = getNumOfRaters(ID);
                //System.out.println("NumOfRaters = " + NumOfRaters);
                if(NumOfRaters >= MinRaters)
                {
                  AvgRating = getAverageByID(ID,MinRaters);
                  Rating rt = new Rating(ID,AvgRating);
                  RatingsList.add(rt);
                  //title.add(getTitle(rt.getItem()));
                }
         
    }
    Collections.sort(RatingsList);
    
    
   
    
        
        return RatingsList;
 }
}
            
        
    

  
   
