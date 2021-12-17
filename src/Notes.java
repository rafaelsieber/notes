import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Models.Note;

public class Notes {
    public static void main(String[] args) throws FileNotFoundException, IOException{

        if(args.length > 0){
            FileWriter fileWriter = new FileWriter("../res/notes",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();  
            bufferedWriter.append(args[0]);
            bufferedWriter.close();
        }
        
        ArrayList<Note> notes = new ArrayList();
        FileReader fileReader = new FileReader("../res/notes");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
    
        int idCount = 0;
        while (bufferedReader.ready()){
            notes.add(new Note(idCount,bufferedReader.readLine())); 
            idCount++;
        }
        bufferedReader.close();
    
        System.out.println(notes);
        

    }
}
