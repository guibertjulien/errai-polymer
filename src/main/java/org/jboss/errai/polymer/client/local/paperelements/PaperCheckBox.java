package org.jboss.errai.polymer.client.local.paperelements;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

public class PaperCheckBox extends PaperRadioButton {
	
	public static final String STYLE = "errai-paper-checkbox";

	protected PaperCheckBox(Element elem) {
		super(elem);
	}

	public PaperCheckBox() {
		this(Document.get().createElement(PaperCheckBoxElement.TAG), STYLE);
	}

	public PaperCheckBox(Element element, String styleName) {
		this(element);
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
	}

}
