package group1.stayella.Vallidation;

import javafx.scene.control.TextField;

public class TextTextField extends TextField {
    @Override
    public void replaceText(int start, int end, String text) {
        if (!text.matches("[!#%&*()+=|<>?{}~]") || text.isEmpty()) {
            super.replaceText(start, end, text);
        }
    }

    @Override
    public void replaceSelection(String replacement) {
        super.replaceSelection(replacement);
    }

    public boolean nameValidation(String text) {
        if (text == null) {
            return false;
        }
        return (text.indexOf(' ') >= 0 && text.matches("^[ A-Za-z]+$"));
    }

    public boolean emailValidation(String text) {
        if (text == null) {
            return false;
        }
        return (text.indexOf('@') >= 0 && text.indexOf('.') >= 0);
    }

}
