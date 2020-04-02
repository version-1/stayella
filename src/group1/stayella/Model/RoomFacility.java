package group1.stayella.Model;

public class RoomFacility {
    private int id;
    private int roomId;
    private String key;
    private String label;
    private boolean value;

    public RoomFacility(int id, int  roomId, String key, String label) {
        this.id = id;
        this.roomId = roomId;
        this.key = key;
        this.label = label;
        this.value = true;
    }

    public String getKey() {
        return this.key;
    }

    public String getLabel() {
        return this.label;
    }

    public boolean getValue() {
        return this.value;
    }

    public int getId() {
        return this.id;
    }

    public int getRoomId() {
        return this.roomId;
    }
}
