package group1.stayella.Model.HotelFacility;

public abstract class HotelFacility {
    private int id;
    private String key;
    private String label;
    private boolean value;

    public HotelFacility(int id, String key, String label, boolean value){
        this.id = id;
        this.key = key;
        this.label = label;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getLabel() {
        return label;
    }
    public boolean getValue() {
        return value;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
