/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;
import APClasses.APConsole;
import java.util.InputMismatchException;
public class Library 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        APConsole console = new APConsole("Library Program");
        
        console.println("Hey user, please check out three books. \nGive me your first book's title");
        String title1 = console.nextLine();
        console.println("Give me your first book's author");
        String author1 = console.nextLine();
        Book book1 = new Book(title1, author1);
        
        console.println("\nGive me your second book's title");
        String title2 = console.nextLine();
        console.println("Give me your second book's author");
        String author2 = console.nextLine();
        Book book2 = new Book(title2, author2);
        
        console.println("\nGive me your third book's title");
        String title3 = console.nextLine();
        console.println("Give me your third book's author");
        String author3 = console.nextLine();
        Book book3 = new Book(title3, author3);
       
        Patron newPatron = new Patron(book1, book2, book3);
        
        int response = 0;
        
        while(response != 6)
        {   
            console.println("\nTo examine a book, press 1, to see if a book is borrowed, press 2, \nto return a book press 3, to borrow a book press 4,\n to see all books, press 5,and to exit, press 6");
            response = console.nextInt();
            if(response == 1)
            {
              console.println("\nEnter 1,2, or 3 (which book you want to examine)");
              int choice = 0;
                try
                {
                    choice = console.nextInt();
                    
                }
                catch(InputMismatchException e)
                {
                    console.println("Give me a number from 1 - 3");
                    console.nextLine();
                }
                if(choice > 3)
                    {
                        console.println("Give me a 1, 2, or 3");
                        choice = console.nextInt();
                    }
                if(choice == 1)
                {
                    console.println(book1.toString());
                }
                if(choice == 2)
                {
                    console.println(book2.toString());
                }
                if(choice == 3)
                {
                    console.println(book3.toString());
                }
            }

            if(response == 2)
            {
                console.println("\ngive me the title of the book");
                String choice = "";
                try
                {
                    choice = console.nextLine();
                }
                catch(InputMismatchException e)
                {
                    console.println("Give me a word, not a number");
                    console.nextLine();
                }
                if(newPatron.isBorrowed(choice))
                {
                    console.println("The book is borrowed");
                }
                else
                    console.println("The book isn't borrowed");
            }

            if(response == 3)
            {
                console.println("\ngive me the title of the book");
                String choice = "";
                try
                {
                    choice = console.nextLine();
                }
                catch(InputMismatchException e)
                {
                    console.println("Give me a word, not a number");
                    console.nextLine();
                }
                newPatron.returnBook(choice);
            }

            if(response == 4)
            {
                console.println("\ngive me the title of the book");
                String choice1 = "";
                try
                {
                    choice1 = console.nextLine();
                }
                catch(InputMismatchException e)
                {
                    console.println("Give me a word, not a number");
                    console.nextLine();
                }
                console.println("\ngive me the author of the book");
               
                String choice2 = "";
                try
                {
                    choice2 = console.nextLine();
                }
                catch(InputMismatchException e)
                {
                    console.println("Give me a word, not a number");
                    console.nextLine();
                }
                newPatron.borrowBook(choice1, choice2);
                console.println("The book was checked out");
            }
            if(response == 5)
            {
                console.println(newPatron.toString());
            }
            
        }
        if(response == 6)
            {
                console.println("\n bye");
            }
        
       
    Book b1 = new Book("Goose Girl", "Shannon Hale");
    Book b2 = new Book("Jungle Book", "Rudyard Kipling");
    Book b3 = new Book("Matilda", "Roald Dahl");
    Patron patron = new Patron(b1,b2,b3);
    
    System.out.println(b1.toString());
    System.out.println(b2.toString());
    System.out.println(b3.toString());
    
    System.out.println(patron.isBorrowed("Goose Girl"));
    System.out.println(patron.isBorrowed("Jungle Book"));
    System.out.println(patron.isBorrowed("Matilda"));
    System.out.println(patron.isBorrowed("a"));
    System.out.println(patron.isBorrowed("b"));
    
    patron.returnBook("Goose Girl");
    System.out.println(patron.borrowBook("Enna Burning", "Shannon Hale"));
    System.out.println(b1.toString());
    
    System.out.println(patron.toString());
        
        
        
      }
    
    
}
