package org.jboss.errai.demo.client.local;

import javax.inject.Inject;

import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.demo.client.shared.UserComplaint;
import org.jboss.errai.demo.client.shared.UserComplaintEndpoint;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.TransitionAnchor;
import org.jboss.errai.ui.nav.client.local.TransitionTo;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Model;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.slf4j.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Composite;


@Page(role = DefaultPage.class)
@Templated("ComplaintForm.html#app-template")
public class ComplaintForm extends Composite {

	@Inject
	private Logger logger;

	@Inject
	@Model
	private UserComplaint userComplaint;

	@Bound
	@DataField
	private Element name = DOM.createElement("paper-input");

	@Bound
	@DataField
	private Element email = DOM.createElement("paper-input");

	@Bound
	@DataField
	private Element text = DOM.createElement("paper-input");

	@DataField
	private Element submit = DOM.createElement("paper-button");

	@Inject
	private Caller<UserComplaintEndpoint> endpoint;

	@Inject
	private TransitionTo<ComplaintSubmitted> complaintSubmittedPage;

	@Inject
	@DataField
	private TransitionAnchor<Admin> admin;

	@EventHandler("submit")
	private void onSubmit(ClickEvent e) {
		logger.info("userComplaint : " + userComplaint);
		logger.info("input : " + name.getElementsByTagName("input").getLength());
	}
}