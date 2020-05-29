package codeanalyzer;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
* Represents an analyzer type, and currently there are
* implementations for regular expressions, string comparison
* @author Maria Gkoulta
* @author marygkoulta@gmail.com
*/
public interface AnalyzerType {
	
	/***
	* Receives a metric type and calculates it
	* @param metric that has to be calculated
	* @return the number of the specific metric 
	*/
	public int calculate(Metric metric);
}

class RegexAnalyzer implements AnalyzerType {
	
	private String sourceCode;
	
	public RegexAnalyzer(LocationReader locationReader) throws IOException {
		this.sourceCode = locationReader.readIntoString();
	}
	
	public int calculate(Metric metric) {
		Pattern pattern = Pattern.compile(metric.getPattern());
		Matcher matcher = pattern.matcher(sourceCode);
		int counter = 0;
		while (matcher.find()) {
			counter++;
		}
		if (metric.substractFromTotal()) {
			counter = sourceCode.split("\n").length - counter;
		}
		return counter;
	}
}

class StrcompAnalyzer implements AnalyzerType {
	
	private List<String> sourceCodeList;
	
	public StrcompAnalyzer(LocationReader locationReader) throws IOException {
		this.sourceCodeList = locationReader.readIntoList();
	}
	
	public int calculate(Metric metric) {
		int counter = 0;
		for (String line : sourceCodeList) {
			line = line.strip(); //remove leading and trailing white spaces
			if (metric.evaluateLine(line)) {
				counter++;		
				}
			}
		if (metric.substractFromTotal()) {
			counter = sourceCodeList.size() - counter;
		}
		return counter;
		}
	}