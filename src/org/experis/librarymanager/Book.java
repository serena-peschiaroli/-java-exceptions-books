package org.experis.librarymanager;

public class Book {
    String title, author, publisher;
    int pages;

    public Book(String title, String author, String publisher, int pages) {

        if(title == null || title.isEmpty() || author == null || author.isEmpty() || publisher == null || publisher.isEmpty()){
            throw new IllegalArgumentException("Title, author and publisher must not be empty");
        }

        if (pages <= 0){
            throw new IllegalArgumentException("Page count must be greater than zero.");
        }
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pages = pages;
    }

    @Override
    public String toString(){
        return "Title: " + title + ", author: " + author + ", publisher: " + publisher + ", pages: " + pages;
    }

    //getters


    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public int getPages() {
        return this.pages;
    }
}
