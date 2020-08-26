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
public class Queue 
{
    int maxSize;
    int currentSize;
    LinkedList lst;
    Node tail;
    
    // Tester
    public static void main(String[] args)
    {
        Queue q = new Queue(10);
        q.dequeue();
        System.out.println(q.lst);
        
        for (int i = 0; i < q.maxSize; i++)
        {
            q.enqueue(new Node(i+1, null));
        }
        q.peek();
        q.dequeue();
        q.enqueue(new Node(11,null));
        q.peek();
    }
    
    // Constructs a new queue, which is bounded
    public Queue(int maxSize)
    {
        lst = new LinkedList();
        this.maxSize = maxSize;
        currentSize = 0;
    }
    
    // Adds a new Node object to the top of the stack
    public void enqueue(Node n)
    {
        if (currentSize > maxSize)
        {
            System.out.println("\n*** Stack Overflow ***");
            return;
        }
        
        lst.insert(currentSize, n);
        
        currentSize++;
        System.out.println(String.format("\nEnqueueing %s..."
                                                  + "\n%s",n.toString(), lst.toString()));
    }
    // Removes the top node from the stack
    public Node dequeue()
    {
        if (currentSize == 0)
        {
            System.out.println("\n*** Stack Underflow ***");
            return null;
        }
        
        Node first = lst.getHead();
        lst.delete(0);
        System.out.println(String.format("\nDequeueing %s..."
                                                  + "\n%s",first.toString(), lst.toString()));
        
        return first;
    }
    // Returns and prints the top node of the stack without removing anything
    public Node peek()
    {
        System.out.println(String.format("\nPeeping from stack...\n%s", lst.getHead().toString()));
        return lst.getHead();
    }
}
