package org.jboss.errai.polymer.client.local;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.enterprise.client.jaxrs.api.RestClient;
import org.jboss.errai.ioc.client.api.EntryPoint;
import org.jboss.errai.ui.nav.client.local.Navigation;

import com.google.gwt.user.client.ui.RootPanel;

@EntryPoint
public class Demo {
	
	@Inject
	private Navigation navigation;

//	@Inject
//	@DataField
//	private SimplePanel console;

	@PostConstruct
	private void init() {
		RestClient.setApplicationRoot("/errai-polymer/rest");
		RootPanel.get("console").add( navigation.getContentPanel() );
	}
}