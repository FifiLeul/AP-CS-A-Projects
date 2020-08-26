/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author ft196725
 */
public class Patron 
{
    public String name;
    public Book book1;
    public Book book2;
    public Book book3;
    
    public Patron(Book book1, Book book2, Book book3)
    {
        this.book1 = book1;
        this.book2 = book2;
        this.book3 = book3;
    }
    public boolean isBorrowed(String title)
    {
        if(book1.getTitle().equalsIgnoreCase(title) && book1 != null)
        {
            return true;
        }
        else if(book2.getTitle().equalsIgnoreCase(title)&& book2 != null)
        {
            return true;
        }
        else if(book3.getTitle().equalsIgnoreCase(title)&& book2 != null)
        {
            return true;
        }
        else
            return false;
    }
    public void returnBook(String title)
    {
        if(book1.getTitle().equalsIgnoreCase(title)&& book1 != null)
        {
            book1 = null;
        }
        else if(book2.getTitle().equalsIgnoreCase(title)&& book2 != null)
        {
            book2 = null;
        }
        else if(book3.getTitle().equalsIgnoreCase(title)&& book3 != null)
        {
            book3 = null;
        }
        else
        {
            System.out.println("This book wasn't checked out");
        }
    }
    
    public boolean borrowBook(String title, String author)
    {
        Book newBook = new Book(title, author);
        if(book1 == null)
        {
           book1 = newBook;
           return true;
        }
        else if(book2 == null)
        {
           book2 = newBook;
           return true;
        }
        else if(book3 == null)
        {
           book3 = newBook;
           return true;
        }
        else
            return false;
    }

    public String toString()
    {
        String toStr = "";
        if(book1 != null)
        {
            toStr += "\nBook 1:     " + book1.toString();
        }
        if(book2 != null)
        {
            toStr += "\nBook 2:     " + book2.toString();
        }
        if(book3 != null)
        {
            toStr += "\nBook 3:     " + book3.toString();
        }
        return toStr;
    }
    
    
    
}
