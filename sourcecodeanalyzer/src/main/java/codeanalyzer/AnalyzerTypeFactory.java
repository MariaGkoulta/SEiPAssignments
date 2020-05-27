package codeanalyzer;

import java.io.IOException;
import java.util.List;

public class AnalyzerTypeFactory {
	private FileReader fileReader;
	
	public AnalyzerTypeFactory(String sourceFileLocation, String filepath) throws IOException{
		this.fileReader = new FileReader(sourceFileLocation, filepath);
	}
	
	public AnalyzerType createAnalyzerType(String sourceCodeAnalyzerType) throws IOException {
		
		AnalyzerType analyzerType = null;
		if (sourceCodeAnalyzerType.contentEquals("regex")) {
			String sourceCode = fileReader.readFileIntoString();
			analyzerType = new RegexAnalyzer(sourceCode);
		} else if (sourceCodeAnalyzerType.contentEquals("strcomp")) {
			List<String> sourceCodeList = fileReader.readFileIntoList();
			analyzerType = new StrcompAnalyzer(sourceCodeList);
		} else {
			return null;
		}
		return analyzerType;		
		}
	}
