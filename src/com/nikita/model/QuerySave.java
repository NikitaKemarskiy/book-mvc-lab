package com.nikita.model;

import com.nikita.helpers.RandomHelper;

import java.io.IOException;
import java.io.PrintStream;

public class QuerySave {
    public static String getSaveFilePath() {
        return String.format("data/save/%s.txt", RandomHelper.randomString(12));
    }

    public static void save(String path, Book[] books) throws IOException {
        try (PrintStream stream = new PrintStream(path)) {
            stream.printf("%-24s%-24s%-24s%-24s%-24s%n", "Name", "Surname", "Publishing", "Year", "Price");
            for (Book book : books) {
                stream.printf(
                        "%-24s%-24s%-24s%-24d%-24.2f%n",
                        book.getName(),
                        book.getAuthor(),
                        book.getPublishing(),
                        book.getYear(),
                        book.getPrice()
                );
            }
        }
    }
}
