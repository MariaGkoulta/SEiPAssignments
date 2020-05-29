package codeanalyzer;

/***
* Represents a factory that produces metrics writers
* @author Maria Gkoulta
* @author marygkoulta@gmail.com
*/
public class MetricsWriterFactory {
	
	/***
	* Receives the type of the output file and produces 
	* a metrics writer accordingly
	* @param ouputFilePath which is the type output file, for 
	* example csv, json 
	* where the metrics are written 
	* @return the metrics writer according to the type of the file
	*/
	public static MetricsWriter createMetricsWriter(String outputFileType) {
		MetricsWriter metricsWriter = null;
		if (outputFileType.contentEquals("csv")) {
			metricsWriter = new CsvWriter();
		}
		return metricsWriter;
	}
}
