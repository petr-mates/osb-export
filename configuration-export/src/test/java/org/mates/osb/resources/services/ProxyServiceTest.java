package org.mates.osb.resources.services;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;
import org.mates.osb.resources.ResourceType;
import org.mates.osb.resources.folders.Project;

public class ProxyServiceTest {

	private ProxyService getFakeProxy() {
		return new ProxyService(new File(""), new Project(new File("")));
	}

	@Test
	public void testGetType() {
		ProxyService proxyService = getFakeProxy();
		Assert.assertEquals(ResourceType.PROXY, proxyService.getType());
	}

	@Test
	public void testExportProvider() {
		ProxyService proxyService = getFakeProxy();
		Assert.assertNotNull(proxyService.getExportProvider());
	}

}
