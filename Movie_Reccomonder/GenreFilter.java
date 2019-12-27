
public class GenreFilter implements Filter {
	private String myGenre;
	
	public GenreFilter(String Genre) {
		myGenre = Genre;
	}
	
	@Override
	public boolean satisfies(String id) {
	    if(MovieDatabase.getGenres(id).contains(myGenre))
	    {
	        return true;
	    }
		return false;
	}

}

