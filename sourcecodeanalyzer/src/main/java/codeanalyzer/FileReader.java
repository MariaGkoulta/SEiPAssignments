package codeanalyzer;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
	private BufferedReader bufferedReader;

	public FileReader(String location, String filepath) throws IOException {
		LocationReader locationReader = LocationReaderFactory.createLocationReader(location, filepath);
		this.bufferedReader = locationReader.getBufferedReader();
	}
	
	public List<String> readFileIntoList() throws IOException {
		List<String> lines = new ArrayList<>();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			lines.add(line);
			}
		bufferedReader.close();
		return lines;	
	}
	
	public String readFileIntoString() throws IOException {
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			sb.append(line + "\n");	
		}
		bufferedReader.close();
		return sb.toString();	
	}
}