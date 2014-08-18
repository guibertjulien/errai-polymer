package org.jboss.errai.polymer.client.local;

import java.util.Arrays;

import javax.inject.Inject;

import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.enterprise.client.jaxrs.api.ResponseCallback;
import org.jboss.errai.polymer.client.local.paperelements.PaperButton;
import org.jboss.errai.polymer.client.local.paperelements.PaperDialog;
import org.jboss.errai.polymer.client.local.paperelements.PaperFab;
import org.jboss.errai.polymer.client.local.paperelements.PaperInput;
import org.jboss.errai.polymer.client.local.paperelements.PaperRadioGroup;
import org.jboss.errai.polymer.client.shared.UserComplaint;
import org.jboss.errai.polymer.client.shared.UserComplaintEndpoint;
import org.jboss.errai.ui.client.widget.ValueImage;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.PageShown;
import org.jboss.errai.ui.nav.client.local.TransitionTo;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Model;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.slf4j.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.googlecode.gwtphonegap.client.camera.Camera;
import com.googlecode.gwtphonegap.client.camera.PictureCallback;
import com.googlecode.gwtphonegap.client.camera.PictureOptions;

@Page(path = "home", role = DefaultPage.class)
@Templated("ComplaintForm.html#app-template")
public class ComplaintForm extends Composite {

	@Inject
	private Logger log;

	@Inject
	@Model
	private UserComplaint userComplaint;

	@Inject
	@Bound
	@DataField
	private PaperInput name;

	@Inject
	@Bound
	@DataField
	private PaperInput email;

	@Inject
	@Bound
	@DataField
	private PaperInput text;

	@Inject
	@Bound
	@DataField
	private ValueImage image;

	@Inject
	private Camera camera;

	@Inject
	@DataField
	private PaperButton takePicture;

//	@Inject
//	@DataField
//	private PaperRadioGroup<String> radioGrp;
	
	@Inject @DataField
	private PaperDialog review;

	// @Inject
	// @Bound @DataField
	// private PaperCheckBox done;

	@Inject
	@DataField
	private PaperButton submit;

	@Inject
	private Caller<UserComplaintEndpoint> endpoint;

//	@Inject
//	private TransitionTo<ComplaintSubmitted> complaintSubmittedPage;

	@Inject
	private TransitionTo<Admin> adminView;

	@Inject
	@DataField
	private PaperFab admin;

	public ComplaintForm() {
		super();
	}

	@PageShown
	public void pageShown() {
//		radioGrp.setAcceptableValues(Arrays.asList("Normal", "Urgent",
//				"Critical"));
		
		String p1 ="Your complaint has been recorded, and we will respond as soon as possible! In the mean time, you can review documentation and FAQs from the polymer-project.org";
		review.addParagraphContent(p1);
		
		PaperButton cancel = new PaperButton();
		cancel.setLabel("Dismiss");
		
		PaperButton ok = new PaperButton();
		ok.setLabel("Got it!");
		review.addActionButtons(cancel, 0, ok);
	}

	@EventHandler("submit")
	private void onSubmit(ClickEvent e) {
		endpoint.call(new ResponseCallback() {
			@Override
			public void callback(Response response) {
				log.info("Back From Submiting UserComplaint. Response is : " + response.getStatusCode());
				if (response.getStatusCode() == Response.SC_CREATED) {
					review.toggle();
				}
			}
		}).create(userComplaint);
		
		log.info("Submiting UserComplaint : " + userComplaint);
//		log.info("Priority : " + radioGrp.getValue());
		
	}

	@EventHandler("admin")
	private void toAdmin(ClickEvent evt) {
		adminView.go();
	}

	@EventHandler("takePicture")
	private void onTakePictureClick(ClickEvent e) {
		PictureOptions options = new PictureOptions(25);
		options.setDestinationType(PictureOptions.DESTINATION_TYPE_DATA_URL);
		options.setSourceType(PictureOptions.PICTURE_SOURCE_TYPE_CAMERA);

		camera.getPicture(options, new PictureCallback() {
			@Override
			public void onSuccess(String data) {
				// On success, we will store the image as a data URL
				// (https://en.wikipedia.org/wiki/Data_URI_scheme) in our JPA
				// entity.
				image.setVisible(true);
				image.setValue("data:image/jpeg;base64," + data, true);
			}
			
			@Override
			public void onFailure(String error) {
				Window.alert("Could not take picture: " + error);
			}
		});
	}

}