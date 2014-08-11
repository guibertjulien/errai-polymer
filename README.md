
Web Components usher in a new era of web development based on encapsulated and interoperable custom elements that extend HTML itself. Built atop these new standards, Polymer makes it easier and faster to create anything from a button to a complete application across desktop, mobile, and beyond.

Polymer core elements
-----------------------
Polymer's core elements are a set of visual and non-visual utility elements. They include elements for working with layout, user input, selection, and scaffolding apps.

Polymer paper elements
------------------------
Polymer's paper elements collection implements material design for the web. They're a set of highly visual, highly interactive elements that include things like controls, layouts, hero transitions, and scrolling effects.

Errai
------
In Errai, we use standard HTML and CSS for UI layout. Take an HTML file directly from your designer or brand team and use it in your application. No need to battle merge conflicts when bringing in design changes. The HTML files just serve as templates. All client-side logic is in companion Java classes that provide access to the fields in the templates. Check out this simple HTML form for filing complaints.

Errai brings Java EE to the browser. Leveraging the GWT compiler, Errai enables you to reuse existing Java EE code on the client. Simply persist your entities into the browser's local storage using JPA and keep them in sync with the server using Errai data sync module. Observe and fire CDI events on the client and exchange events between the client and server.

Construct type safe REST calls using JAX-RS annotations on shared interfaces. Errai handles the required communication and serialization logic.

Errai-Polymer
=============
Errai-polymer allows Errai-UI templates and Errai-DataBinding to utilize polymer web components in a manner that is simple and seamless.

Implemented Polymer Elements:
* core-input - widget, element, widget injection (@Inject), DOM templating (@DataField), and data-binding (@Bound)

* paper-input - widget, element, widget injection (@Inject), DOM templating (@DataField), and data-binding (@Bound)

* paper-checkbox - widget, element, widget injection (@Inject), DOM templating (@DataField), and data-binding (@Bound)

* core-selector - widget, element, widget injection (@Inject), DOM templating (@DataField), and data-binding (@Bound)

* paper-radio-button - widget, element, widget injection (@Inject), DOM templating (@DataField), and data-binding (@Bound)

* paper-radio-group - widget, element, widget injection (@Inject), DOM templating (@DataField), and data-binding (@Bound)