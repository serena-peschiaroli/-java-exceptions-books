package org.experis.librarymanager;

import com.sun.org.apache.xpath.internal.objects.XString;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LibraryDb {
    public static void main(String[] args) {
        //oggetto scanner per prendere input utente
        Scanner scan = new Scanner(System.in);
        //definire dimensione dell'array books
        System.out.println("How many books would you like to insert?");
        int size = Integer.parseInt(scan.nextLine());
        //inizializza l'array di oggetti Book
        Book[] books = new Book[size];
        //loop attraverso l'array per popolarlo con Book obj
        for (int i = 0; i <books.length ; i++) {

            try{
                //per ogni libro, chiede all'utente le informazioni necessarie
                System.out.println("Insert the title: ");
                String title = scan.nextLine();

                System.out.println("Insert the number of pages: ");
                int pages = Integer.parseInt(scan.nextLine());

                System.out.println("Insert the author: ");
                String author = scan.nextLine();

                System.out.println("Insert the publisher: ");
                String publisher = scan.nextLine();
                //crea un nuovo oggetto Book
                System.out.println("New book successfully added.");
                books[i] = new Book(title, author, publisher, pages);
            }catch (IllegalArgumentException e){
                //se non viene rispettata qualche condizione del costrutture, messaggio di errore e decremento indice
                System.out.println("There was an error with your input: " + e.getMessage());
                System.out.println("Please try entering the book's information again.");
                //i-- per riprovare l'inserimento del libro correttamente
                i--;
            }



        }

        scan.close();
        //crea un oggetto File
        File file = new File("./resources/list.txt");
        //try-with-resources per chiudere automaticamente filewriter dopo il blocck
        try(FileWriter fileWriter = new FileWriter(file)){
            //itera attraverso l'array di libri
            for(Book book : books){
                //scrive ogni informazione nel file, formattato come una linea singola
                fileWriter.write(book.getTitle() + ", " + book.getAuthor() + ", " + book.getPublisher() + ", " + book.getPages() + "\n");
            }

        }catch(IOException e){

            System.out.println("An error occurred while writing to the file:  " + e.getMessage());
        }

        //try-with-resources per chiedere automaticamente lo scanner dopo il blocco
        try (Scanner fileReader = new Scanner(new File("./resources/list.txt"))) {
            while (fileReader.hasNextLine()) {
                System.out.println(fileReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file could not be found or opened.");
        }



    }
}
