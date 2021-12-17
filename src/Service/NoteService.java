package Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Models.Note;

public class NoteService {

    static File file = new File("../res/notes");
    static File tmpFile = new File("../res/notesTMP");

    public static ArrayList<Note> getNotes() throws FileNotFoundException, IOException {
        ArrayList<Note> notes = new ArrayList<Note>();
        FileReader fileReader = new FileReader(file);
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
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.append(note + ";true");
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    public static void removeNote(String id, boolean removeFromTrash) throws FileNotFoundException, IOException {

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tmpFile));

        String currentLine;
        int lineToRemove = Integer.parseInt(id);
        int count = 0;
        while((currentLine = reader.readLine()) != null) {
            if(count == lineToRemove) {
                String newLine;
                if(removeFromTrash){
                    newLine = currentLine.replace("false", "true");
                } else {
                    newLine = currentLine.replace("true", "false");
                }
                writer.write(newLine);
            } else {
                writer.write(currentLine);
            }
            writer.newLine();
            count++;
        }

        tmpFile.renameTo(file);

        reader.close();
        writer.close();



    }
}