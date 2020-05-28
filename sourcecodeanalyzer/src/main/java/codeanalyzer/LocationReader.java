package codeanalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public abstract class LocationReader {
	
	public abstract List<String> readIntoList() throws IOException;
	public abstract String readIntoString() throws IOException;
	
	public List<String> readBufferIntoList(BufferedReader bufferedReader) throws IOException {
		List<String> lines = new ArrayList<>();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			lines.add(line);
			}
		bufferedReader.close();
		return lines;	
	}
	
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
