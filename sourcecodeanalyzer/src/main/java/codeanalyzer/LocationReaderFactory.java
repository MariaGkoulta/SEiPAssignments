package codeanalyzer;

import java.io.IOException;

public class LocationReaderFactory {
	
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