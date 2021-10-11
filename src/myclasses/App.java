/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclasses;

import entity.Reader;
import entity.Book;
import entity.Author;
import entity.History;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Melnikov
 */
public class App {
    Scanner scanner = new Scanner(System.in);
    Book[] books = new Book[10];
    Reader[] readers=new Reader[10];
    History[] history=new History[10];
    History[] histories=new History[10];
    public App() {
    }
    
    public void run(){
        String repeat = "y";
        do{
            System.out.println("Выберите задачу: ");
            System.out.println("0: Закончить программу");
            System.out.println("1: Добавить книгу");
            System.out.println("2: Список книг");
            System.out.println("3: Добавить читателя");
            System.out.println("4: Список читателей");
            System.out.println("5: Выдача книг");
            System.out.println("6: Список читателей с книгами");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task) {
                case 0: 
                    repeat="q";
                    System.out.println("Программа закончена");
                    break;
                case 1: 
                    System.out.println("Добавление книги: ");
                    for (int i = 0; i < books.length; i++) {
                        if(books[i] == null){
                            books[i] = addBook();
                            break;
                        }
                    }
                    break;
                    case 3: 
                    System.out.println("Добавление читателя: ");
                    for (int i = 0; i < readers.length; i++) {
                        if(readers[i] == null){
                            readers[i] = addReader();
                            break;
                        }
                    }
                    break;
                     case 4: 
                    System.out.println("Список читателей: ");
                    for (int i = 0; i < readers.length; i++) {
                        if(readers[i] != null){
                            System.out.println(readers[i].toString());
                        }
                    }
                    break;
                case 2: 
                    System.out.println("Список книг: ");
                    for (int i = 0; i < books.length; i++) {
                        if(books[i] != null){
                            System.out.println(books[i].toString());
                        }
                    }
                    break;
              case 5:
                System.out.println("Выдача книги: ");
                for (int i=0; i < histories.length; i++){
                     if(histories[i] != null){
                         histories[i]=addHistory();
                        break;
                    }
                }
            break;
            case 6:
            System.out.println("Список выданных книг");
            for(int i=0; i<histories.length;i++){
                if(histories[i] !=null)
                    System.out.printf("%d. Книгу: %d читает %a %s%n",
                            i+1,
                histories[i].getBook().getCaption(),
                histories[i].getReader().getFirstname(),
                histories[i].getReader().getLastname()
        
                    );
            }
            }
           break;
        }
        while("y".equals(repeat));
    }
    
    private Book addBook(){
        Book book = new Book();
        System.out.print("Введите название книги: ");
        book.setCaption(scanner.nextLine());
        System.out.print("Введите год издания: ");
        book.setPublishedYear(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Сколько авторов у книги: ");
        int countAuthors=scanner.nextInt();
        scanner.nextLine();
        Author[] authors = new Author[countAuthors];
        for (int i = 0; i < authors.length; i++) {
            System.out.println("Добавление автора "+(i+1));
            Author author = new Author();
            System.out.print("Имя автора: ");
            author.setName(scanner.nextLine());
            System.out.print("Фамилия автора: ");
            author.setLastname(scanner.nextLine());
            System.out.print("Год рождения автора: ");
            author.setYear(scanner.nextInt());
            System.out.print("День рождения автора: ");
            author.setDay(scanner.nextInt());
            System.out.print("Месяц рождения автора: ");
            author.setMonth(scanner.nextInt());
            scanner.nextLine();
            authors[i]= author;
        }
        book.setAuthor(authors);
        return book;
    }
   
  private Reader addReader(){
        Reader reader = new Reader();
        System.out.print("Введите имя читателя: ");
        reader.setFirstname(scanner.nextLine());
        System.out.print("Введите фамилию читателя: ");
        reader.setLastname(scanner.nextLine());
        System.out.print("Введите номер телефона читателя: ");
        reader.setPhone(scanner.nextLine());
        return reader;
    }
  private History addHistory(){
      History history1=new History();
      System.out.println("Список читателей");
         for (int i = 0; i < books.length; i++) {
                        if(books[i] == null){
                            System.out.printf("%d. %s%n",i+1,books[i].toString());
                            
                        }
                    }
         int bookNumber=scanner.nextInt();scanner.nextLine();
         history1.setBook(books[bookNumber-1]);
          for (int i = 0; i < readers.length; i++) {
                        if(readers[i] == null){
                            System.out.printf("%d. %s%n",i+1,readers[i].toString());
                            
                        }
                    }
         int readersNumber=scanner.nextInt();scanner.nextLine();
         history1.setReader(readers[readersNumber-1]);
      return history1;
    
}
//        //System.out.println("Hello");
//        Book book1 = new Book();
//        book1.setCaption("Voina i Mir");
//        Author author1 = new Author();
//        author1.setName("Lev");
//        author1.setLastname("Tolstoy");
//        author1.setYear(1828);
//        author1.setDay(9);
//        author1.setMonth(9);
//        Author[] authors = new Author[1];
//        authors[0]=author1;
//        book1.setAuthor(authors);
//        book1.setPublishedYear(2005);
//        Book book2 = new Book();
//        book2.setCaption("Otsi i deti");
//        Author author2 = new Author();
//        author2.setName("Ivan");
//        author2.setLastname("Turgenev");
//        author2.setDay(9);
//        author2.setMonth(11);
//        author2.setYear(1818);
//        Author[] authors2 = new Author[1];
//        authors2[0]=author2;
//        book2.setAuthor(authors2);
//        book2.setPublishedYear(2007);
//        
//        Reader reader1 = new Reader();
//        reader1.setFirstname("Ivan");
//        reader1.setLastname("Ivanov");
//        reader1.setPhone("4564545345");
//        
//        History history1 = new History();
//        history1.setBook(book1);
//        history1.setReader(reader1);
//        Calendar c = new GregorianCalendar();
//        history1.setGivenDate(c.getTime());
//        System.out.println("history1 = "+history1.toString());
//        System.out.println(" --------------- ");
//        history1.setReturnDate(c.getTime());
//        System.out.println("history1 = "+history1.toString());
//        
//    }


    
    
    
}
