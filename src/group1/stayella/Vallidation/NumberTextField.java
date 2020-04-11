package group1.stayella.Vallidation;

import javafx.scene.control.TextField;

import java.util.ArrayList;

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
        return text.length() > 9;
    }

    public boolean numberOfGuestValidation(String text) {
        if (text.isEmpty()) {
            return false;
        }
        return (Integer.parseInt(text) > 0 && Integer.parseInt(text) <= 10);
    }

    public boolean idNumberValidation(String text) {
        return text.length() == 9;
    }

    public boolean ageValidation(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        int age = Integer.parseInt(text);
        return (age > 19 && age < 100);
    }

    public boolean cardNumberValidation(String text) {
        return text.length() == 12;
    }

    public boolean securityCodeValidation(String text) {
        return text.length() == 3;
    }

    public boolean expirationDateValidation(String text) {
        return (text.length() == 4 && Integer.parseInt(text.substring(0, 2)) <= 12 &&
                ((Integer.parseInt(text.substring(2, 4)) >= 21) ||
                        (Integer.parseInt(text.substring(2, 4)) == 20 && Integer.parseInt(text.substring(0, 2)) > 6)));
    }
}
