package tn.models;

public class Room {
    private int idRoom;
    private String nameRoom;
    private String descriptionRoom;

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public String getDescriptionRoom() {
        return descriptionRoom;
    }

    public void setDescriptionRoom(String descriptionRoom) {
        this.descriptionRoom = descriptionRoom;
    }

    public Room() {
    }

    public Room(int idRoom, String nameRoom, String descriptionRoom) {
        this.idRoom = idRoom;
        this.nameRoom = nameRoom;
        this.descriptionRoom = descriptionRoom;
    }

    public Room(String nameRoom, String descriptionRoom) {
        this.nameRoom = nameRoom;
        this.descriptionRoom = descriptionRoom;
    }

    @Override
    public String toString() {
        return "Room{" +
                "idRoom=" + idRoom +
                ", nameRoom='" + nameRoom + '\'' +
                ", descriptionRoom='" + descriptionRoom + '\'' +
                '}';
    }
}
