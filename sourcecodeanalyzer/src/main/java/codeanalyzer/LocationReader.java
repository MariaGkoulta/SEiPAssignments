package codeanalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public abstract class LocationReader {

	public abstract BufferedReader getBufferedReader();
}

class LocalFileReader extends LocationReader {
	private BufferedReader bufferedReader;
	
	public BufferedReader getBufferedReader() {
		return this.bufferedReader;
	}
	
	public LocalFileReader(String filepath) throws IOException {
		File file = new File(filepath);
		this.bufferedReader = new BufferedReader(new FileReader(file));
	}	
}

class WebFileReader extends LocationReader {
	private BufferedReader bufferedReader;
	
	public BufferedReader getBufferedReader() {
		return this.bufferedReader;
	}
	
	public WebFileReader(String filepath) throws IOException {
        URL url = new URL(filepath);
        this.bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
	}
}
