package codeanalyzer;

public class MetricsWriterFactory {
	
	public static MetricsWriter createMetricsWriter(String outputFileType) {
		MetricsWriter metricsWriter = null;
		if (outputFileType.contentEquals("csv")) {
			metricsWriter = new CsvWriter();
		}
		return metricsWriter;
	}
}
