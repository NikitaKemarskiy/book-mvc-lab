package com.nikita.model;

import java.io.IOException;

public class Service {
    private Book[] books;

    private static Book[] getSliceOfArray(Book[] arr, int start, int end) {
        Book[] slice = new Book[end - start];
        for (int i = 0; i < slice.length; i++) {
            slice[i] = arr[start + i];
        }
        return slice;
    }

    public Service() throws IOException {
        DataSource.init();
        books = DataSource.getBooks();
    }

    public Book[] getBooks() {
        return books;
    }

    public Book[] getBooksByAuthor(String author) {
        Book[] booksByAuthor = new Book[books.length];
        int num = 0;
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                booksByAuthor[num++] = book;
            }
        }
        return getSliceOfArray(booksByAuthor, 0, num);
    }

    public Book[] getBooksByPublishing(String publishing) {
        Book[] booksByPublishing = new Book[books.length];
        int num = 0;
        for (Book book : books) {
            if (book.getPublishing().equals(publishing)) {
                booksByPublishing[num++] = book;
            }
        }
        return getSliceOfArray(booksByPublishing, 0, num);
    }

    public Book[] getBooksByYear(int year) {
        Book[] booksByYear = new Book[books.length];
        int num = 0;
        for (Book book : books) {
            if (book.getYear() > year) {
                booksByYear[num++] = book;
            }
        }
        return getSliceOfArray(booksByYear, 0, num);
    }
}
