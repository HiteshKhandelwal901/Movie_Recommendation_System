
public class MinutesFilter implements Filter {
	private int Min;
	private int Max;
	
	public MinutesFilter(int min,int max) {
		Min = min;
		Max = max;
	}
	
	@Override
	public boolean satisfies(String id) {
		if(MovieDatabase.getMinutes(id) >= Min && MovieDatabase.getMinutes(id)<=Max )
		{
		    return true;
		    
		}
		else{
		    return false;
		  }
	}

}
