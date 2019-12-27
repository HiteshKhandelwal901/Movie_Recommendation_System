import java.util.*;
public class DirectorsFilter implements Filter {
	private String myDirectors;
	
	public DirectorsFilter(String Directors) {
		myDirectors = Directors;
	}
	
	@Override
	public boolean satisfies(String id) {
	    String Directors[] = myDirectors.split(",");
	    //System.out.println("size = " + Directors.length);
	    for(int i=0;i<Directors.length;i++)
	    {
	    //System.out.println("DirectorsList at " + i  + " = " + Directors[i]);
	   }
	    if(contains(MovieDatabase.getDirector(id),Directors)==true)
	    {
	        return true;
	    }
		return false;
	}
	
	
	public boolean contains(String director, String[]DirectorsList)
	{
	    String CDirectors[] = director.split(",");
	    for(int i=0;i<CDirectors.length;i++)
	    {
	    //System.out.println("CDirctorss at " + i  + " = " + CDirectors[i]);
	   }
	    for(int i=0;i<DirectorsList.length;i++)
	    {
	        //System.out.println("Checking if  " + DirectorsList[i] + " == " + director);
	        for(int k=0;k<CDirectors.length;k++)
	        {
	           //System.out.println("DCirectors[i] = " + CDirectors[k]);
	        if(DirectorsList[i].equals(CDirectors[k]))
	        {
	            //System.out.println(" true invoked");
	            //System.out.println("===============================================");
	            return true;
	        }
	        
	       }
	    }
	    //System.out.println("false invoked");
	    //System.out.println("===============================================");
	    return false;
	}

}
