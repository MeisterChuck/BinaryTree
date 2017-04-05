package algohomework2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFile {

    private String line;
    private int row = 1;
    
    public ReadFile(WordTree tree){
        // Get File
        try{
            File newFile = new File("src/test/test2.txt");
            
            FileInputStream file = new FileInputStream(newFile);
            InputStreamReader reader = new InputStreamReader(file);
            
            try (BufferedReader br = new BufferedReader(reader)) {
                // Line by Line
                while ((line = br.readLine()) != null) {
                    if(!line.equals("")){
                        String[] words = line.split(" ");

                        // Word by Word
                        for(String word : words) {
                            
                            // Add word and row to Tree
                            tree.addNode(word, row);
                        }
                        
                        // Increase row index by 1 at end of while-loop
                        row++;
                    }
                }
            }
        }catch(FileNotFoundException e1){
            System.out.println("File not Found");
        }catch(IOException e2){
            System.out.println("IOException");
        }
    }
}
