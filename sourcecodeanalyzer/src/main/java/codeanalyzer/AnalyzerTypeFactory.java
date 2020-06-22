package codeanalyzer;

import java.io.IOException;

/***
* Represents an analyzer type factory, which produces analyzer types
* @author Maria Gkoulta
* @author marygkoulta@gmail.com
*/
public class AnalyzerTypeFactory {
	
	private LocationReader locationReader;
	
	public AnalyzerTypeFactory(String sourceFileLocation, String filepath) throws IOException{
		this.locationReader = LocationReaderFactory.createLocationReader(sourceFileLocation, filepath); 
	}
	
	/***
	* Receives the source code analyzer type and creates the respective object
	* @param sourceCodeAnalyzerType the type of the analyzer of the source code
	* @return the analyzer type
	*/
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
