package algohomework2;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;

public class WordTree{
    WordTreeNode root;
    
    public void addNode(String addData, int addRow){
        // Create new Node and initialize
        WordTreeNode newNode = new WordTreeNode(addData, addRow);
        
        // If Root is empty
        if(root == null){
            root = newNode;
        }else{
            // Set Root as starting point
            WordTreeNode focusNode = root;
            // Future Parents
            WordTreeNode parent;
            
            while(true){
                // Root is main parent
                parent = focusNode;
                
                // Check if newNode is smaller or larger
                if(addData.compareToIgnoreCase(focusNode.getData()) < 0){
                    // Switch focus to left
                    focusNode = focusNode.leftChild;
                    
                    // If left child has no children
                    if(focusNode == null){
                        parent.leftChild = newNode;
                        parent.leftChild.addToList(addRow);
                        return;
                    }
                }else if(addData.compareToIgnoreCase(focusNode.getData()) == 0){
                    parent.addToList(addRow);
                    return;
                }else{ // Go to right child
                    focusNode = focusNode.rightChild;
                    
                    // If child has no children
                    if(focusNode == null){
                        parent.rightChild = newNode;
                        parent.rightChild.addToList(addRow);
                        return;
                    }
                }
            }
        }
    }
    
    public void traverse(WordTreeNode focusNode){
        if(focusNode != null){
            
            
            traverse(focusNode.leftChild);
            
            System.out.print(focusNode.getData() + ":");
            focusNode.displayRows();
            
            
            traverse(focusNode.rightChild);
            
        }
    }

    public void writeFile(WordTreeNode focusNode){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            
            String lineFromInput = in.readLine();
            
            PrintStream out = new PrintStream(new FileOutputStream("src/test/results.txt"));
            
            System.setOut(out);
            
            out.close();
        }catch(IOException e){
            System.out.println("Error");
        }
    }
    
    public void write(WordTreeNode focusNode, PrintWriter output){
        if(focusNode != null){
            write(focusNode.leftChild, output);
            output.println(focusNode.getData() + ": ");
            write(focusNode.rightChild, output);
        }
    }
}

class WordTreeNode {
    private String data;
    private int row;
    
    private RowLinkedList listRow = new RowLinkedList();
    
    WordTreeNode leftChild;
    WordTreeNode rightChild;
    
    WordTreeNode(String data, int row){
        this.data = data;
        this.row = row;
    }   
    
    public String getData(){
        return data;
    }
    
    //public String getListRow(){
    //    
    //}
    
    public void addToList(int row){
        listRow.insert(row);
    }
    
    public void displayRows(){
        listRow.display();
    }
}
