package codeanalyzer;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class MetricsWriterFactoryTest {
	
	MetricsWriterFactory mwf = new MetricsWriterFactory();
	
	@Test
	public void testCreateCsvSucceed() {
        final String type = "csv";
        MetricsWriter metricsWriter = MetricsWriterFactory.createMetricsWriter(type);
        assertThat(metricsWriter, instanceOf(CsvWriter.class));       
	}
	
	@Test
	public void testCreateCsvFail() {
        final String type = "abc";
        MetricsWriter metricsWriter = MetricsWriterFactory.createMetricsWriter(type);
        assertFalse(metricsWriter instanceof CsvWriter);      
	}
}
