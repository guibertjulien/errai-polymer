package org.jboss.errai.polymer.client.local;

import java.util.Arrays;

import javax.inject.Inject;

import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.polymer.client.local.paperelements.PaperCheckBox;
import org.jboss.errai.polymer.client.local.paperelements.PaperInput;
import org.jboss.errai.polymer.client.local.paperelements.PaperRadioGroup;
import org.jboss.errai.polymer.client.shared.UserComplaint;
import org.jboss.errai.polymer.client.shared.UserComplaintEndpoint;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.PageShown;
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


@Page(path="home", role=DefaultPage.class)
@Templated("ComplaintForm.html#app-template")
public class ComplaintForm extends Composite {

	@Inject
	private Logger log;

	@Inject
	@Model
	private UserComplaint userComplaint;

	@Inject
	@Bound @DataField
	private PaperInput name;

	@Inject
	@Bound @DataField
	private PaperInput email;

	@Inject
	@Bound @DataField
	private PaperInput text;

	@Inject @DataField
	private PaperRadioGroup<String> radioGrp;// = new PaperRadioGroup<String>();
	
	@Inject
	@Bound @DataField
	private PaperCheckBox done;

	@DataField
	private Element submit = DOM.createElement("paper-button");

	@Inject
	private Caller<UserComplaintEndpoint> endpoint;

	@Inject
	private TransitionTo<ComplaintSubmitted> complaintSubmittedPage;

	@Inject
	@DataField
	private TransitionAnchor<Admin> admin;
	
	public ComplaintForm() {
		super();
	}
	
	@PageShown
	public void pageShown(){
//		Event.sinkEvents(name, Event.ONBLUR | Event.ONCHANGE);
//	    Event.setEventListener(name, new EventListener() {
//			@Override
//			public void onBrowserEvent(Event event) {
//				int evtType = event.getTypeInt();
//				if(Event.ONBLUR == evtType || Event.ONCHANGE == evtType){
//					log.info("onName value : " + name.getAttribute("value"));
//				}
//			}
//		});

	    //onShow();
		radioGrp.setAcceptableValues( Arrays.asList("Normal", "Urgent", "Critical") );
	}
	
//	@EventHandler("link")
//	@SinkNative(Event.ONBLUR | Event.ONCHANGE)
//	private void onCoreInputChange(Event e){
//		log.info("sunk value : " + coreinput.getInputValue());
//	}

	@EventHandler("submit")
	private void onSubmit(ClickEvent e) {
		log.info("userComplaint : " + userComplaint);
		log.info("selected : " + radioGrp.getValue());
	}

	private final native void onShow() /*-{
				
	}-*/;
}