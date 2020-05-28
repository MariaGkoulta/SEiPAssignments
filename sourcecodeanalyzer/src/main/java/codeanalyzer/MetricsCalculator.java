package codeanalyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetricsCalculator {
	
	public AnalyzerType analyzerType;
	public List<Metric> metrics = new ArrayList<>();
	
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
	
	public Map<String, Integer> calculateMetrics(List<Metric> metrics) {
		Map<String, Integer> calculatedMetrics = new HashMap<>();
		for (Metric metric: metrics) {
			calculatedMetrics.put(metric.getName(), analyzerType.calculate(metric));
			}
		return calculatedMetrics;
		}

	public void exportMetrics(String outputFileType, String outputFilePath) {
		MetricsWriter metricsWriter = MetricsWriterFactory.createMetricsWriter(outputFileType);
		metricsWriter.writeFile(calculateMetrics(getMetrics()), outputFilePath);
	}
}
