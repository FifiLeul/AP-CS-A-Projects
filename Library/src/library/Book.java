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
public class Book 
{
    public String title;
    public String author;
    public Book(String name, String author)
    {
        title = name;
        this.author = author;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public String getAuthor()
    {
        return author;
    }
  
    public String toString()
    {
        String toStr = "Title: " + this.title + "   Author: " + this.author;
        return toStr;
    }
}
