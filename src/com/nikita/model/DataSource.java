package com.nikita.model;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class DataSource {
    private static Book[] books;

    private DataSource() {}

    public static void init() throws IOException {
        if (books != null) {
            return;
        }
        Gson gson = new Gson();
        try (Reader reader = new FileReader("data/init/books.json")){
            books = gson.fromJson(reader, Book[].class);
        }
    }

    public static Book[] getBooks() {
        return books;
    }
}
