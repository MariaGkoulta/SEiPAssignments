package codeanalyzer;

import java.io.IOException;

public class AnalyzerTypeFactory {
	
	private LocationReader locationReader;
	
	public AnalyzerTypeFactory(String sourceFileLocation, String filepath) throws IOException{
		this.locationReader = LocationReaderFactory.createLocationReader(sourceFileLocation, filepath); 
	}
	
	public AnalyzerType createAnalyzerType(String sourceCodeAnalyzerType) throws IOException {
		
		AnalyzerType analyzerType = null;
		if (sourceCodeAnalyzerType.contentEquals("regex")) {
			analyzerType = new RegexAnalyzer(locationReader);
		} else if (sourceCodeAnalyzerType.contentEquals("strcomp")) {
			analyzerType = new StrcompAnalyzer(locationReader);
		} else {
			return null;
		}
		return analyzerType;		
		}
	}
