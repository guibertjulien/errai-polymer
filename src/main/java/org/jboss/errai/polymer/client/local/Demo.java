package org.jboss.errai.polymer.client.local;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.common.client.api.RemoteCallback;
import org.jboss.errai.enterprise.client.jaxrs.api.RestClient;
import org.jboss.errai.ioc.client.api.EntryPoint;
import org.jboss.errai.jpa.sync.client.local.ClientSyncManager;
import org.jboss.errai.jpa.sync.client.shared.SyncResponse;
import org.jboss.errai.polymer.client.shared.UserComplaint;
import org.jboss.errai.ui.nav.client.local.Navigation;
import org.slf4j.Logger;

import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

@EntryPoint
public class Demo {

	@Inject
	private Navigation navigation;

	@Inject
	private ClientSyncManager syncManager;

	@Inject
	private Logger logger;

	@PostConstruct
	private void init() {
		RestClient.setApplicationRoot("/errai-polymer/rest");
		RootPanel.get("console").add(navigation.getContentPanel());
		SimplePanel navPanel = (SimplePanel) navigation.getContentPanel();
		navPanel.getElement().addClassName("navroot");
	}

	/**
	 * Performs a full two-way data synchronization between the client and the
	 * server: the server gets all new and updated UserComplaint objects from
	 * us, and we get all new and updated UserComplaint objects from the server.
	 */
	public void sync() {
		sync(new RemoteCallback<List<SyncResponse<UserComplaint>>>() {
			@Override
			public void callback(List<SyncResponse<UserComplaint>> response) {
				logger.debug("Received sync response:" + response);
			}
		});
	}

	/**
	 * Performs a full two-way data synchronization between the client and the
	 * server: the server gets all new and updated UserComplaint objects from
	 * us, and we get all new and updated UserComplaint objects from the server.
	 * 
	 * @param callback
	 *            the callback to invoked upon completion of the data sync
	 *            request.
	 */
	public void sync(RemoteCallback<List<SyncResponse<UserComplaint>>> callback) {
		logger.debug("Sending sync:");
		syncManager.coldSync("allComplaints", UserComplaint.class,
				Collections.<String, Object> emptyMap(), callback, null);
	}
}