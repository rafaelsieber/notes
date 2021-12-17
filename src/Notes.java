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

            if(args[0].equals("-a")){
                FileWriter fileWriter = new FileWriter("../res/notes",true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.newLine();  
                bufferedWriter.append(args[1] + ";true");
                bufferedWriter.close();
            }
        }
        
        ArrayList<Note> notes = new ArrayList<Note>();
        FileReader fileReader = new FileReader("../res/notes");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
    
        int idCount = 0;
        while (bufferedReader.ready()){
            notes.add(new Note(idCount,bufferedReader.readLine())); 
            idCount++;
        }
        bufferedReader.close();
    
        for (int i = 0; i < notes.size(); i++) {
            if(notes.get(i).active == true){
                System.out.println(notes.get(i));
            }    
        }


        System.out.println("Use -a \"New note\" to add or -d [id] to remove");
        

    }
}
