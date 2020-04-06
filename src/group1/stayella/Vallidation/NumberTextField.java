package group1.stayella.Vallidation;

import javafx.scene.control.TextField;

public class NumberTextField extends TextField {

    @Override
    public void replaceText(int start, int end, String text) {
        if (text.matches("[0-9]+") || text.isEmpty()) {
            super.replaceText(start, end, text);
        }
    }

    @Override
    public void replaceSelection(String replacement) {
        super.replaceSelection(replacement);
    }

    public boolean phoneNumberValidation (String text) {
        return (text.length() == 10);
    }

    public boolean idNumberValidation (String text) {
        return (text.length() == 9);
    }

    public boolean ageValidation (String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        int age = Integer.parseInt(text);
        return (age > 19 && age < 100);
    }

    public boolean numOfGuest (String text) {
        if (text == null) {
            return false;
        }
        int guests = Integer.parseInt(text);
        return (guests > 0 && guests < 10);
    }
}
