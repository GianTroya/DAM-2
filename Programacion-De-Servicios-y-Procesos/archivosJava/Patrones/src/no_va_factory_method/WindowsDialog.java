package no_va_factory_method;

public class WindowsDialog extends Dialog {
	   @Override
	    public Button createButton() {
	        return new WindowsButton();
	    }
}
