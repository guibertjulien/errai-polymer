package org.jboss.errai.polymer.client.local.paperelements;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

public class PaperFab extends PaperIconButton {
	
	public static final String STYLE = "errai-paper-fab"; 
	
	public PaperFab() {
		this(Document.get().createElement(PaperFabElement.TAG), STYLE);
	}
	
	public PaperFab(Element element, String styleName){
		super(element, styleName);
	}
	
	@Override
	protected PaperFabElement getPaperElement() {
		return getElement().cast();
	}

}
