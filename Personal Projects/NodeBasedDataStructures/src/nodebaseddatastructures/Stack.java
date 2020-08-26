/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodebaseddatastructures;

/**
 *
 * @author mercyougothis
 */
public class Stack 
{
    static LinkedList lst;
    static int maxSize;
    static int currentSize;
    
    // Tester
    public static void main(String[] args)
    {
        Stack s = new Stack(13);
        s.pop();
        System.out.println(s.lst);
        
        for (int i = 0; i < s.maxSize-2; i++)
        {
            s.push(new Node(i+1, null));
        }
        s.pop();
        s.push(new Node(13,null));
        s.peek();
    }
    
    // Constructs a new queue, which is bounded
    public Stack(int maxSize)
    {
        lst = new LinkedList();
        this.maxSize = maxSize;
        currentSize = 0;
    }
    
    // Adds a new Node object to the top of the stack   
    public void push(Node newNode)
    {
        if(currentSize != maxSize)
        {
            currentSize++;
            lst.insert(0, newNode);
            System.out.println(String.format("\nPushing %s to stack..."
                                                  + "\n%s",newNode.toString(), lst.toString()));
        }
        else
            System.out.println("\n*** Stack Overflow ***");
    }
    // Removes the top node from the top of the stack
    public Node pop()
    {
        Node oldHead = lst.getHead();
        if(currentSize == 0)
            System.out.println("\n*** Stack Underflow ***");
        else
        {
           currentSize++;
          
           lst.delete(0);
           System.out.println(String.format("\nPopping %s from stack..."
                                                  + "\n%s",oldHead.toString(), lst.toString()));
        }
        
        return oldHead;
    }
    // Returns and prints the top node of the stack without removing anything 
    public Node peek()
    {
        System.out.println(String.format("\nPeeping from stack...\n%s", lst.getHead().toString()));
        return lst.getHead();
    }
    
}
