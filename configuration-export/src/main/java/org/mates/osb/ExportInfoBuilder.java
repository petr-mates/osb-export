package org.mates.osb;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.mates.osb.export.IExportItem;

public class ExportInfoBuilder {

	private static final String LF = "\n";

	private static final String TAB = "    ";

	protected static final String WL_OSB_EXPORT = "http://www.bea.com/wli/config/importexport";

	private XMLStreamWriter outX = null;

	public void build(OutputStream out, List<IExportItem> items) throws IOException {
		XMLOutputFactory newFactory = XMLOutputFactory.newFactory();
		newFactory.setProperty(XMLOutputFactory.IS_REPAIRING_NAMESPACES, true);
		try {
			outX = newFactory.createXMLStreamWriter(out);
			outX.setPrefix("imp", WL_OSB_EXPORT);
			writeHeader();

			writeProperties(getHeaderEntries());

			System.out.println(items.size());
			
			for (IExportItem iExportItem : items) {
				writeExportedItemInfo(iExportItem.getInstanceId(), iExportItem.getTypeId(),
						convertItemToEntries(iExportItem));
			}

			close();
		} catch (XMLStreamException e) {
			throw new IOException("cannot write correct xml exportInfo", e);
		}
	}

	protected List<Entry> convertItemToEntries(IExportItem item) {
		List<Entry> list = new ArrayList<Entry>();
		list.add(new Entry(IExportItem.REPRESENTATION_VERSION, item.getRepresentationVersion()));
		list.add(new Entry(IExportItem.DATA_CLASS, item.getDataClass()));
		list.add(new Entry(IExportItem.IS_ENCRYPTED, item.getIsEncrypted()));
		list.add(new Entry(IExportItem.JAR_ENTRY_NAME, item.getJarEntry()));

		List<String> extRefs = item.getExtRefs();
		for (String ref : extRefs) {
			list.add(new Entry(IExportItem.EXT_REFS, ref));
		}

		Map<String, String> properties = item.getProperties();
		for (Map.Entry<String, String> entry : properties.entrySet()) {
			list.add(new Entry(entry.getKey(), entry.getValue()));
		}

		return list;
	}

	/**
	 * <pre>
	 * 	&lt;imp:property name="username" value="none" /&gt;
	 * 		&lt;imp:property name="description" value="configuration-export" /&gt;
	 * 		&lt;imp:property name="exporttime" value="Tue Jan 28 12:36:00 CET 2014" /&gt;
	 * 		&lt;imp:property name="productname" value="Oracle Service Bus" /&gt;
	 * 		&lt;imp:property name="productversion" value="11.1.1.5" /&gt;
	 * 		&lt;imp:property name="projectLevelExport" value="true" /&gt;
	 * </pre>
	 * 
	 * @return
	 */
	protected List<Entry> getHeaderEntries() {
		List<Entry> list = new ArrayList<Entry>();
		list.add(new Entry("username", "node"));
		list.add(new Entry("description", "configuration-export"));
		list.add(new Entry("exporttime", new SimpleDateFormat("E MMM d HH:mm:ss z yyyy", Locale.ENGLISH)
				.format(new Date())));
		list.add(new Entry("productname", "Oracle Service Bus"));
		list.add(new Entry("productversion", "11.1.1.5"));
		list.add(new Entry("projectLevelExport", "true"));
		return list;
	}

	/**
	 * writes xml-fagment with name and version
	 * 
	 * @throws XMLStreamException
	 */
	protected void writeHeader() throws XMLStreamException {
		outX.writeStartDocument();
		outX.writeCharacters(LF);
		outX.writeStartElement("xml-fragment");
		outX.writeAttribute("name", "ALSB-IDE_build_1373550650267");
		outX.writeAttribute("version", "v2");
		outX.writeCharacters(LF);
	}

	/**
	 * writes imp:properties
	 * 
	 * @param entries
	 * @throws XMLStreamException
	 */
	protected void writeProperties(List<Entry> entries) throws XMLStreamException {
		outX.writeCharacters(TAB);
		outX.writeStartElement(WL_OSB_EXPORT, "properties");
		for (Entry entry : entries) {
			writeProperty(entry);
		}
		outX.writeCharacters(LF + TAB);
		outX.writeEndElement();
	}

	/**
	 * write single imp:exportItemInfo with properties.
	 * 
	 * @param instanceId
	 * @param typeId
	 * @param entries
	 * @throws XMLStreamException
	 */
	protected void writeExportedItemInfo(String instanceId, String typeId, List<Entry> entries)
			throws XMLStreamException {
		outX.writeCharacters(LF);
		outX.writeStartElement(WL_OSB_EXPORT, "exportedItemInfo");
		outX.writeAttribute("instanceId", instanceId);
		outX.writeAttribute("typeId", typeId);
		outX.writeCharacters(LF);

		writeProperties(entries);

		outX.writeCharacters(LF);
		outX.writeEndElement();
		outX.writeCharacters(LF);
	}

	/**
	 * write single imp:protpery with name and value
	 */
	protected void writeProperty(Entry entry) throws XMLStreamException {
		outX.writeCharacters(LF + TAB + TAB);
		outX.writeStartElement(WL_OSB_EXPORT, "property");
		System.out.println("x " +entry.getKey() + " " + entry.getValue());
		
		outX.writeAttribute("name", entry.getKey());
		outX.writeAttribute("value", entry.getValue());
		outX.writeEndElement();
	}

	/**
	 * close xml-fagment and document
	 * 
	 * @throws XMLStreamException
	 */
	protected void close() throws XMLStreamException {
		outX.writeCharacters(LF);
		outX.writeEndElement();
		outX.writeCharacters(LF);
		outX.writeEndDocument();
		outX.writeCharacters(LF);
		outX.close();
	}

	private static class Entry {
		private String key;
		private String value;

		Entry(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public String getValue() {
			return value;
		}
	}
}
