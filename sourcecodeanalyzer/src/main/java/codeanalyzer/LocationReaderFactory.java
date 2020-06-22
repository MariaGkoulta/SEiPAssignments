package codeanalyzer;

import java.io.IOException;

public class LocationReaderFactory {
	
	/***
	* Receives the location of a file as well as the respective
	* filepath and creates the right location reader
	* @param location of the file, for example local or web
	* @param filepath of the file that contains the code 
	* @return the right location reader according to the location given 
	*/
	public static LocationReader createLocationReader(String location, String filepath) throws IOException {
		LocationReader locationReader = null;
		if (location.equals("local")) {
			locationReader = new LocalFileReader(filepath);
		} else if (location.equals("web")) {
			locationReader = new WebFileReader(filepath);
		} else {
			locationReader = null;
		}
		return locationReader;
		}
	}