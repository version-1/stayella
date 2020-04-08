package group1.stayella.Resources.Images;

import java.util.HashMap;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Icon {
  public final static String BASE_PATH = "group1/stayella/Resources/Images/Icons/";
  public final static String CALENDAR = BASE_PATH + "calendar-dark.png";
  public final static String CIGARETTE = BASE_PATH + "cigarette-dark.png";
  public final static String CIGARETTE_LIGHT = BASE_PATH + "cigarette-light.png";
  public final static String CLEAN = BASE_PATH + "clean-dark.png";
  public final static String CLEAN_LIGHT = BASE_PATH + "clean-light.png";
  public final static String DOLLAR = BASE_PATH + "dollar-dark.png";
  public final static String EDIT = BASE_PATH + "edit-dark.png";
  public final static String PEOPLE = BASE_PATH + "edit-dark.png";
  public final static String PET = BASE_PATH + "pet-dark.png";
  public final static String PET_LIGHT = BASE_PATH + "pet-light.png";
  public final static String RELOAD = BASE_PATH + "reload-dark.png";

  public static ImageView get(String path) {
    ImageView imageView = new ImageView();
    imageView.setImage(new Image(path));
    return imageView;

  }
  public static ImageView getWithLayout(String path, int width, int height)  {
    ImageView view = get(path);
    view.setFitWidth(width);
    view.setFitHeight(height);
    return view;
  }
}