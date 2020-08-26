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

// a class that holds one piece of data, along with a pointer to another Node
public class Node 
{
    private Double data;
    private Node next;
    
    public static void main(String[] args)
    {
        Node x = new Node(1, null);
        Node y = new Node(2, x);
        System.out.println(y.getNext().getData());
    }
    
    public Node(double d, Node nx)
    {
        data = d;
        next = nx;
    }
    public Node(Node nx)
    {
        data = null;
        next = nx;
    }
    
    //getters
    public Double getData()
    {
        return data;
    }
    public Node getNext()
    {
        return next;
    }
    
    //setters
    public void setData(double d)
    {
        data = d;
    }
    public void setNext(Node n)
    {
        next  = n;
    }
    
    public String toString()
    {
        return String.format("Node with val %.1f", this.getData());
    }
}
