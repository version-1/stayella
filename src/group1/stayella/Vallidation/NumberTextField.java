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

    public boolean phoneNumberValidation(String text) {
        return (text.length() > 9);
    }

    public boolean numberOfGuestValidation(String text) {
        if (text.isEmpty()) {
            return false;
        }
        return (Integer.parseInt(text) > 0 && Integer.parseInt(text) <= 10);
    }

    public boolean idNumberValidation(String text) {
        return (text.length() == 9);
    }

    public boolean ageValidation(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        int age = Integer.parseInt(text);
        return (age > 19 && age < 100);
    }
}
