package Models;

public class Note {
    public Integer id;
    public String description;
    public Boolean active;

    public Note(Integer id, String content){
        this.id = id;
        String[] contentAndActive = content.split(";");
        this.description = contentAndActive[0];
        active = ( contentAndActive[1].equals("false")) ? false : true;
    }

    @Override
    public String toString() {
        return this.id + " | " + this.description;
    }
}