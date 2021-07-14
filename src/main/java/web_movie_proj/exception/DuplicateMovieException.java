package web_movie_proj.exception;

@SuppressWarnings("serial")
public class DuplicateMovieException extends RuntimeException {

	public DuplicateMovieException(String message) {
		super(message);
	}

}
