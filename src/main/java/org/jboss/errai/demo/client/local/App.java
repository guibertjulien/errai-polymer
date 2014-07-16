package org.jboss.errai.demo.client.local;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.enterprise.client.jaxrs.api.RestClient;
import org.jboss.errai.ioc.client.api.EntryPoint;
import org.jboss.errai.ui.nav.client.local.Navigation;
import org.jboss.errai.ui.shared.api.annotations.DataField;

import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

@EntryPoint
public class App {
	
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