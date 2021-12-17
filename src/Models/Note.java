package Models;

public class Note {
    public Integer id;
    public String description;

    public Note(Integer id, String description){
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.description;
    }
}