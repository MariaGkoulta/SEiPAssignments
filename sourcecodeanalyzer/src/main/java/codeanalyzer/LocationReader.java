package codeanalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/***
* Represents a reader for a specific location of a file
* Currently, the types supported are a local file and a 
* file in the web
* @author Maria Gkoulta
* @author marygkoulta@gmail.com
*/
public abstract class LocationReader {
	
	/***
	* Converts a file with source code into a list of the 
	* strings of each line of code
	* @return the list of the strings
	*/
	public abstract List<String> readIntoList() throws IOException;
	
	/***
	* Converts a file with source code into a string 
	* @return the string with the source code
	*/
	public abstract String readIntoString() throws IOException;
	
	/***
	* Receives a bufferedReader, iterates through its lines
	* and returns a list with strings which represent each line
	* @param the bufferedReader according to which the list is created 
	* @return the list of strings of the source code
	*/
	public List<String> readBufferIntoList(BufferedReader bufferedReader) throws IOException {
		List<String> lines = new ArrayList<>();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			lines.add(line);
			}
		bufferedReader.close();
		return lines;	
	}

	/***
	* Receives a bufferedReader, iterates through its lines
	* and returns a string with each line being seperated with \n
	* @param the bufferedReader according to which the string is created 
	* @return the string of the source code
	*/
	public String readBufferIntoString(BufferedReader bufferedReader) throws IOException {
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			sb.append(line + "\n");	
		}
		bufferedReader.close();
		return sb.toString();	
	}
}

class LocalFileReader extends LocationReader {
	private BufferedReader bufferedReader;
	
	public LocalFileReader(String filepath) throws IOException {
		File file = new File(filepath);
		this.bufferedReader = new BufferedReader(new FileReader(file));
	}
	
	public String readIntoString() throws IOException {
		return readBufferIntoString(this.bufferedReader);
	}
	
	public List<String> readIntoList() throws IOException {
		return readBufferIntoList(this.bufferedReader);
	}
}

class WebFileReader extends LocationReader {
	private BufferedReader bufferedReader;
	
	public WebFileReader(String filepath) throws IOException {
        URL url = new URL(filepath);
        this.bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
	}
	
	public String readIntoString() throws IOException {
		return readBufferIntoString(this.bufferedReader);
	}
	
	public List<String> readIntoList() throws IOException {
		return readBufferIntoList(this.bufferedReader);
	}
}
