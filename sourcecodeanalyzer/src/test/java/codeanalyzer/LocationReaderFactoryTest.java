package codeanalyzer;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Test;

public class LocationReaderFactoryTest {
	LocationReaderFactory lrf = new LocationReaderFactory();
	
	@Test
	public void testCreateLocal() throws IOException {
        final String locationType = "local";
    	final String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";
        LocationReader locationReader = LocationReaderFactory.createLocationReader(locationType, TEST_CLASS_LOCAL);
        assertThat(locationReader, instanceOf(LocalFileReader.class));       
	}
	
	@Test
	public void testCreateWeb() throws IOException {
        final String locationType = "web";
        final String TEST_CLASS_WEB ="https://docs.google.com/document/d/1PavKCzYiXKUy3qHOjeC6rVDY8gquR-fEC7P1kmLZSBo/edit";
        LocationReader locationReader = LocationReaderFactory.createLocationReader(locationType, TEST_CLASS_WEB);
        assertThat(locationReader, instanceOf(WebFileReader.class));       
	}
	
	@Test
	public void testInvalidType() throws IOException {
        final String locationType = "abc";
    	final String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";
        LocationReader locationReader = LocationReaderFactory.createLocationReader(locationType, TEST_CLASS_LOCAL);
        assertNull(locationReader);        
	}
}
