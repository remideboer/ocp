package generics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LowerboundsRunner {
	public static void main(String[] args) {
		List<? super IOException> exceptions = new ArrayList<Exception>();
		
		exceptions.add(new Exception()); // DOES NOT COMPILE without cast, list is of type IOException even though it is declared super
		exceptions.add(new IOException());
		exceptions.add(new FileNotFoundException()); // oddly enough the compiler considers FileNotFoundException an IOException even though its declared with super...
	}
}
