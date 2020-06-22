package codeanalyzer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/***
* Represents a metrics writer
* Currently only csv writers are supported
* @author Maria Gkoulta
* @author marygkoulta@gmail.com
*/
public interface MetricsWriter {
	
	/***
	 * Receives a map with the metric name and its value as well as the 
	 * path where this file is located and writes the metrics in the correct 
	 * form 
	 *
	 * @param metrics a list of the metrics that have to be written to the file
	 * @param the path of the file where the metrics have to be written
	 */
	public void writeFile(Map<String, Integer> metrics, String filepath);
}

class CsvWriter implements MetricsWriter {
	
	@Override
	public void writeFile(Map<String, Integer> metrics, String filepath) {
		File outputFile = new File(filepath + ".csv");
		StringBuilder metricsNames = new StringBuilder();
		StringBuilder metricsValues = new StringBuilder();
		
		for (Map.Entry<String, Integer> entry : metrics.entrySet()) {
			metricsNames.append(entry.getKey() + ",");
			metricsValues.append(entry.getValue()+",");
		}
		
		try {
			FileWriter writer = new FileWriter(outputFile);
			writer.append(metricsNames + "\n");
			writer.append(metricsValues + "\n");
			writer.close();
			System.out.println("Metrics saved in " + outputFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
			}		
		}
	}