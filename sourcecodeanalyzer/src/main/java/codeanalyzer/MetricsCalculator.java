package codeanalyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
* Represents a class which gathers the metrics that have to be calculated, calculates 
* them end exports them
* @author Maria Gkoulta
* @author marygkoulta@gmail.com
*/
public class MetricsCalculator {
	
	private AnalyzerType analyzerType;
	private List<Metric> metrics = new ArrayList<>();
	
	public AnalyzerType getAnalyzerType() {
		return this.analyzerType;
	}
	
	public void setAnalyzerType(AnalyzerType analyzerType) {
		this.analyzerType = analyzerType;
	}
	
	public MetricsCalculator(String sourceFileLocation, String filepath, String sourceCodeAnalyzerType) throws IOException {
		AnalyzerTypeFactory analyzerTypeFactory = new AnalyzerTypeFactory(sourceFileLocation, filepath);
		this.analyzerType = analyzerTypeFactory.createAnalyzerType(sourceCodeAnalyzerType);
	}	
	
	public List<Metric> getMetrics() {
		metrics.add(new LocMetric());
		metrics.add(new NomMetric());
		metrics.add(new NocMetric());
		return metrics;
	}
	
	/***
	 * Receives a list with the various metrics that have to be calculated and 
	 * according to the analyzer type, calculates them and puts them in a map
	 * with their respective name.
	 *
	 * @param metrics a list of the metrics that have to be calculated
	 * @return a map with the name of the metric and its value
	 */
	public Map<String, Integer> calculateMetrics(List<Metric> metrics) {
		Map<String, Integer> calculatedMetrics = new HashMap<>();
		for (Metric metric: metrics) {
			calculatedMetrics.put(metric.getName(), analyzerType.calculate(metric));
			}
		return calculatedMetrics;
		}
	
	/***
	 * Receives the type of the output file and the filepath where the metrics are exported and 
	 * calls the appropriate MetricsWriter in order to export the metrics.
	 * 
	 * @param outputFileType the type of the output file, i.e csv, json
	 * @param outputFilePath the path of the output file of the metrics calculated
	 */
	public void exportMetrics(String outputFileType, String outputFilePath) {
		MetricsWriter metricsWriter = MetricsWriterFactory.createMetricsWriter(outputFileType);
		metricsWriter.writeFile(calculateMetrics(getMetrics()), outputFilePath);
	}
}
