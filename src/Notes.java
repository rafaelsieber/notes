import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import Models.Note;
import Service.NoteService;

public class Notes {
    public static void main(String[] args) throws FileNotFoundException, IOException{

        ArrayList<Note> notes = NoteService.getNotes();

        if(args.length > 0){

            if(args[0].equals("-a")){
                NoteService.addNote(args[1]);
            }

            if(args[0].equals("-h")){
                System.out.println((char)27 + "[32m" + "How to Use" + (char)27 + "[39m");
                System.out.println("Use -a \"New note\" to add");
                System.out.println("Use -d id number to delete");
                System.out.println("Use -t to show notes in the trash");
                System.out.println("Use -r id number to remove it from the trash");
            }

            if(args[0].equals("-t")){
                System.out.println((char)27 + "[31m" + "Notes on trash" + (char)27 + "[39m");
                Note.listNotes(notes, false);
            }


            if(args[0].equals("-d")){
                System.out.println((char)27 + "[31m" + "Deleting note with id = " + args[1] + (char)27 + "[39m");
                NoteService.removeNote(args[1],false);
            }

            if(args[0].equals("-r")){
                System.out.println((char)27 + "[33m" + "removing note with id = " + args[1] + " from trash" + (char)27 + "[39m");
                NoteService.removeNote(args[1],true);
            }

    
        } else {
            System.out.println((char)27 + "[32m" + "Notes" + (char)27 + "[39m");
            Note.listNotes(notes, true);
        }
    }
}
