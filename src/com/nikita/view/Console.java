package com.nikita.view;

import com.nikita.controller.Texts;
import com.nikita.exceptions.InvalidRangeException;
import com.nikita.exceptions.InvalidValueException;
import com.nikita.model.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.PrintStream;
import java.util.Scanner;

public class Console {
    private Scanner scan;
    private Logger logger;
    private Texts texts;

    public Console() {
        scan = new Scanner(System.in);
        logger = LogManager.getLogger();
        texts = Texts.getTexts();
    }

    public int getOption() {
        do {
            System.out.println(texts.getText("console.options.choose") + ":");
            System.out.println("\t1. " + texts.getText("console.options.all"));
            System.out.println("\t2. " + texts.getText("console.options.byAuthor"));
            System.out.println("\t3. " + texts.getText("console.options.byPublishing"));
            System.out.println("\t4. " + texts.getText("console.options.byYear"));
            System.out.println("\t5. " + texts.getText("console.options.locale"));
            System.out.println("\t6. " + texts.getText("console.options.exit"));

            int option = scan.nextInt();
            scan.nextLine();

            if (option < 1 || option > 6) {
                System.out.println(texts.getText("console.options.invalid"));
            } else {
                logger.debug(String.format("User chose option: %d", option));
                return option;
            }
        } while (true);
    }

    public int getYear() {
        System.out.print(texts.getText("console.options.get.byYear") + ": ");
        do {
            try {
                int year = scan.nextInt();
                scan.nextLine();
                Validator.validateYear(year);
                return year;
            } catch (InvalidRangeException err) {
                System.err.printf("InvalidRangeException: %s%n", err.getMessage());
                continue;
            }
        } while (true);
    }

    public String getPublishing() {
        System.out.print(texts.getText("console.options.get.byPublishing") + ": ");
        do {
            try {
                String publishing = scan.nextLine();
                Validator.validatePublishing(publishing);
                return publishing;
            } catch (InvalidValueException err) {
                System.err.printf("InvalidValueException: %s%n", err.getMessage());
                continue;
            }
        } while (true);
    }

    public String getAuthor() {
        System.out.print(texts.getText("console.options.get.byAuthor") + ": ");
        do {
            try {
                String author = scan.nextLine();
                Validator.validateAuthor(author);
                return author;
            } catch (InvalidValueException err) {
                System.err.printf("InvalidValueException: %s%n", err.getMessage());
                continue;
            }
        } while (true);
    }

    public char requestSaveToFile() {
        System.out.print(texts.getText("console.table.save") + " [Y/N]: ");
        char option = scan.nextLine().charAt(0);
        System.out.println();
        return option;
    }

    public void printBooks(Book[] books) {
        printBooks(books, System.out);
    }

    public void printBooks(Book[] books, PrintStream stream) {
        stream.println();
        if (books.length == 0) {
            stream.println(texts.getText("console.table.print.noData"));
        } else {
            stream.printf(
                "%-24s%-24s%-24s%-24s%-24s%n",
                texts.getText("console.table.columns.name"),
                texts.getText("console.table.columns.surname"),
                texts.getText("console.table.columns.publishing"),
                texts.getText("console.table.columns.year"),
                texts.getText("console.table.columns.price")
            );
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
        stream.println();
    }

    public void printOut(String data) {
        System.out.println(data);
    }

    public void printError(String data) {
        System.err.println(data);
    }
}