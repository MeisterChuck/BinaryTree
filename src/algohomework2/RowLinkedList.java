package algohomework2;

public class RowLinkedList{
    private RowLinkedListNode head;
    private RowLinkedListNode tail;
    
    private RowLinkedListNode newNode;
    
    public void insert(int row){
        newNode = new RowLinkedListNode(row);
        
        if(empty()){
            head = newNode;
        }else{
            tail.next = newNode;
        }
        
        newNode.previous = tail;
        tail = newNode;
    }
    
    public void display(){
        RowLinkedListNode list = head;
        
        while(list != null){
            // Try-Catch used if next is NULL
            try{
                list.display();
                
                if(list.next != null){
                    System.out.print(",");
                }
                
                list = list.next;
            }catch(NullPointerException e){
                System.out.println();
            }
        }
        
        System.out.println();
    }
    
    public boolean empty(){
        return (head == null);
    }
    
    private class RowLinkedListNode{
        private int row;
        
        RowLinkedListNode next;
        RowLinkedListNode previous;
        
        public RowLinkedListNode(int row){
            this.row = row;
        }
        
        public int getRow(){
            return row;
        }
        
        public void display(){
            System.out.print(" " + row);
        }
    }
}
