package Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Models.Note;

public class NoteService {
    public static ArrayList<Note> getNotes() throws FileNotFoundException, IOException {
        ArrayList<Note> notes = new ArrayList<Note>();
        FileReader fileReader = new FileReader("../res/notes");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int idCount = 0;
        while (bufferedReader.ready()) {
            notes.add(new Note(idCount, bufferedReader.readLine()));
            idCount++;
        }
        bufferedReader.close();
        return notes;
    }

    public static void addNote(String note) throws FileNotFoundException, IOException {
        FileWriter fileWriter = new FileWriter("../res/notes", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.newLine();
        bufferedWriter.append(note + ";true");
        bufferedWriter.close();
    }
}