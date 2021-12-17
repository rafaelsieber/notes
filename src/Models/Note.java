package Models;
import java.util.ArrayList;

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

    public static void listNotes(ArrayList<Note> notes, boolean active){
        for (int i = 0; i < notes.size(); i++) {
            if(notes.get(i).active == active){
                System.out.println(notes.get(i));
            }    
        }
    }

    @Override
    public String toString() {
        return this.id + " | " + this.description;
    }
}