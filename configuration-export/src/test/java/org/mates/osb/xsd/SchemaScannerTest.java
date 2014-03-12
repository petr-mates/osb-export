package org.mates.osb.xsd;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mates.osb.utils.FileUtils;
import org.mates.osb.xml.XmlHelper;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class SchemaScannerTest {

	private SchemaScanner schemaScanner = null;

	@Before
	public void init() throws SAXException, IOException {
		InputStream resourceAsStream = null;
		try {
			resourceAsStream = SchemaScannerTest.class.getResourceAsStream("SchemaScanner.xml");
			Document parse = XmlHelper.getDocumentBuilder().parse(resourceAsStream);
			schemaScanner = new SchemaScanner(parse);
		} finally {
			FileUtils.closeQuietly(resourceAsStream);
		}
	}

	@Test
	public void testGetIncludeLocations() throws SAXException, IOException {
		List<String> includeLocations = schemaScanner.getIncludeLocations();
		Assert.assertArrayEquals(new String[] { "include.xsd" }, includeLocations.toArray(new String[0]));
	}

	@Test
	public void testGetImportLocations() throws SAXException, IOException {
		List<ISchemaLocation> importLocations = schemaScanner.getImportLocations();

		ISchemaLocation iImport = importLocations.get(0);
		Assert.assertEquals("http://import/schema", iImport.getNamespace());
		Assert.assertEquals("import.xsd", iImport.getSchemaLocation());

		iImport = importLocations.get(1);
		Assert.assertEquals("http://import/schema2", iImport.getNamespace());
		Assert.assertEquals("import2.xsd", iImport.getSchemaLocation());

	}

	@Test
	public void testGetTargetNamespace() throws SAXException, IOException {
		Assert.assertEquals("http://default/schema", schemaScanner.getTargetNamespace());
		Assert.assertEquals("", new SchemaScanner(XmlHelper.getDocumentBuilder().newDocument()).getTargetNamespace());
	}
}
