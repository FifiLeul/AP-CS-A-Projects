/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodebaseddatastructures;
//import nodebaseddatastructures.Node.*;

/**
 *
 * @author mercyougothis
 */
public class LinkedList 
{
    static Node head;
    
    public static void main(String[] args)
    {
        Node h = new Node(1, init(40, 2));
        LinkedList lst = new LinkedList(h);
        
        lst.insert(10, 10.5);
        
        //prints out the linked list
        System.out.println(lst.toString());
    }
          
    public LinkedList(Node head)
    {
        setHead(head);
    }
    public LinkedList()
    {
        setHead(new Node(null));
    }
    
    public static void setHead(Node n)
    {
        head = n;
    }
    public static Node getHead()
    {
        return head;
    }
    
    //recursively creates a linked list, where the parameter for the next pointer creates a reference to its pointer
    public static Node init(int n, int count)
    {
        if (count != n)
            return new Node(count, init(n, count + 1));
        else
            return new Node(count, null);
    }
    
    public static int find(double n)
    {
        Node currentNode = head;
        int count = 0;
        
        while (currentNode.getData() != n)
        {
            currentNode = currentNode.getNext();
            count++;
        }
        return count;
    }
    public static int find(Node n)
    {
        Node currentNode = head;
        int count = 0;
        
        while (currentNode != n)
        {
            currentNode = currentNode.getNext();
            count++;
        }
        return count;
    }
    
    public void insert(int pos, double val)
    {
        if(head.getData() == null)
        {
            head = new Node(val, null);
            return;
        }
        if(pos == 0)
        {
            Node inserting = new Node(val, null);
            inserting.setNext(head);
            head = inserting;
            return;
        }
        Node nodeBefore = head;
        for (int j = 1; j < pos; j++)
        {
            if(nodeBefore.getNext() == null)
            {   nodeBefore.setNext(new Node(val, null));
                return;
            }
               
            nodeBefore = nodeBefore.getNext();
        }
        
        Node inserted = new Node(val, nodeBefore.getNext());
        nodeBefore.setNext(inserted);
    }
    public void insert(int pos, Node inserting)
    {
        Node nodeBefore = head;
        if (head.getData() == null)
        {
            head = inserting;
            return;
        }
        if(pos == 0)
        {
            inserting.setNext(head);
            head = inserting;
            return;
        }
            
        for (int j = 1; j < pos; j++)
        {
            if (nodeBefore.getNext() == null)
            {
                nodeBefore.setNext(inserting);
                return;
            }
            nodeBefore = nodeBefore.getNext();
        }
        nodeBefore.setNext(inserting);
    }
    
    public void delete(int pos)
    {
        Node nodeBefore = head;
        for (int j = 0; j < pos; j++)
        {
            nodeBefore = nodeBefore.getNext();
        }
        
        setHead(nodeBefore.getNext());
    }
    
    @Override
    public String toString()
    {
        String summary = "Linked List: \n";
        Node currentNode = head;
        
        while(currentNode.getNext() != null)
        {
            summary += String.format("%.1f -> ", currentNode.getData());
            currentNode = currentNode.getNext();
        }
        summary += String.format("%s", currentNode.getData());
        
        return summary;
    }
    
}
