package codeanalyzer;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class MetricsCalculatorTest {

	private static String TYPE_LOCAL = "local";
	private final static String TYPE_REGEX = "regex";
	private final static String TYPE_STRCOMP = "strcomp";
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	private final static String TYPE_WEB = "web";
	private final static String TEST_CLASS_WEB ="https://drive.google.com/uc?export=download&id=1z51FZXqPyun4oeB7ERFlOgfcoDfLLLhg";
	
	@Test
	public void testGetMetrics() throws IOException {
		MetricsCalculator metricsCalculator = new MetricsCalculator(TYPE_LOCAL, TEST_CLASS, TYPE_REGEX);
		List<Metric> returnedMetrics = metricsCalculator.getMetrics(); 
		assertThat(returnedMetrics.get(0), instanceOf(LocMetric.class)); 
		assertThat(returnedMetrics.get(1), instanceOf(NomMetric.class));
		assertThat(returnedMetrics.get(2), instanceOf(NocMetric.class));
	}
	
	@Test
	public void testCalculateMetricsLocalRegex() throws IOException {
		List<Metric> metrics =new ArrayList<>();
		MetricsCalculator mc = new MetricsCalculator(TYPE_LOCAL, TEST_CLASS, TYPE_REGEX);
		LocMetric locMetric = new LocMetric();
		NocMetric nocMetric = new NocMetric();
		NomMetric nomMetric = new NomMetric();
		metrics.add(locMetric);
		metrics.add(nocMetric);
		metrics.add(nomMetric);
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("loc", 21);
		hmap.put("noc", 3);
		hmap.put("nom", 3);
		assertEquals(mc.calculateMetrics(metrics), hmap);
	}
	
	@Test
	public void testCalculateMetricsLocalStrcomp() throws IOException {
		List<Metric> metrics =new ArrayList<>();
		MetricsCalculator mc = new MetricsCalculator(TYPE_LOCAL, TEST_CLASS, TYPE_STRCOMP);
		LocMetric locMetric = new LocMetric();
		NocMetric nocMetric = new NocMetric();
		NomMetric nomMetric = new NomMetric();
		metrics.add(locMetric);
		metrics.add(nocMetric);
		metrics.add(nomMetric);
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("loc", 7);
		hmap.put("noc", 3);
		hmap.put("nom", 3);
		assertEquals(mc.calculateMetrics(metrics), hmap);
	}
	
	@Test
	public void testCalculateMetricsWebRegex() throws IOException {
		List<Metric> metrics =new ArrayList<>();
		MetricsCalculator mc = new MetricsCalculator(TYPE_WEB, TEST_CLASS_WEB, TYPE_REGEX);
		LocMetric locMetric = new LocMetric();
		NocMetric nocMetric = new NocMetric();
		NomMetric nomMetric = new NomMetric();
		metrics.add(locMetric);
		metrics.add(nocMetric);
		metrics.add(nomMetric);
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("loc", 21);
		hmap.put("noc", 3);
		hmap.put("nom", 3);
		assertEquals(mc.calculateMetrics(metrics), hmap);
	}
	
	@Test
	public void testCalculateMetricsWebStrcomp() throws IOException {
		List<Metric> metrics =new ArrayList<>();
		MetricsCalculator mc = new MetricsCalculator(TYPE_WEB, TEST_CLASS_WEB, TYPE_STRCOMP);
		LocMetric locMetric = new LocMetric();
		NocMetric nocMetric = new NocMetric();
		NomMetric nomMetric = new NomMetric();
		metrics.add(locMetric);
		metrics.add(nocMetric);
		metrics.add(nomMetric);
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("loc", 7);
		hmap.put("noc", 3);
		hmap.put("nom", 3);
		assertEquals(mc.calculateMetrics(metrics), hmap);
	}
}
