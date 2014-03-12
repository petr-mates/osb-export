package org.mates.osb.resources.services;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mates.osb.reference.IReference;
import org.mates.osb.reference.Reference;
import org.mates.osb.resources.ExportItem;
import org.mates.osb.resources.IResource;
import org.mates.osb.resources.ReferenceType;
import org.mates.osb.resources.ResourceType;
import org.mates.osb.resources.folders.Project;

public class ServiceProviderTest {

	protected IResource getService() {
		return new SimpleService(new File("file"), new Project(new File("folder")), ResourceType.PROXY) {
			@Override
			public List<IReference> getReferences() {
				List<IReference> references = super.getReferences();
				Reference reference = new org.mates.osb.reference.Reference(ReferenceType.WSDL, "../folder/webservice",
						"TST/folder/webservice");
				references.add(reference);
				return references;
			}
		};
	}

	@Test
	public void testGetExportItem() {
		ServiceProvider serviceProvider = new ServiceProvider(getService()) {

			@Override
			public ReferenceType getReferenceType() {
				return ReferenceType.ProxyService;
			}

			@Override
			protected String getFilename() {
				return "test";
			}
		};

		ExportItem exportItem = serviceProvider.getExportItem();
		Assert.assertEquals(ReferenceType.ProxyService.toString(), exportItem.getTypeId());
		Assert.assertEquals("folder/file", exportItem.getInstanceId());
		Assert.assertEquals(ReferenceType.ProxyService.getClazz(), exportItem.getDataClass());
		Assert.assertEquals(ReferenceType.ProxyService.getVersion() + "", exportItem.getRepresentationVersion());
		Assert.assertEquals("false", exportItem.getIsEncrypted());
		Assert.assertEquals("folder/file.ProxyService", exportItem.getJarEntry());		
		Assert.assertEquals("WSDL$TST$folder$webservice", exportItem.getExtRefs().get(0));
	}

}
