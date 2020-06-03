package com.nikita.controller;

import com.nikita.model.Book;
import com.nikita.model.QuerySave;
import com.nikita.model.Service;
import com.nikita.view.Console;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Controller {
    private Console console;
    private Service service;
    private Logger logger;
    private Texts texts;
    private static Controller controller;

    private Controller() {
        console = new Console();
        logger = LogManager.getLogger();
        texts = Texts.getTexts();
        try {
            service = new Service();
        } catch (IOException err) {
            logger.fatal(String.format("Error with data source loading: %s", err.getMessage()));
            console.printError(texts.getText("datasource.error"));
        }
    }

    public static Controller getController() {
        controller = controller == null ? new Controller() : controller;
        return controller;
    }

    public void action() {
        do {
            Book[] books;
            switch (console.getOption()) {
                case 1: {
                    logger.info("Search all books");
                    books = service.getBooks();
                    break;
                }
                case 2: {
                    logger.info("Search books by author");
                    String author = console.getAuthor();
                    books = service.getBooksByAuthor(author);
                    break;
                }
                case 3: {
                    logger.info("Search books by publishing");
                    String publishing = console.getPublishing();
                    books = service.getBooksByPublishing(publishing);
                    break;
                }
                case 4: {
                    logger.info("Search books by year");
                    int year = console.getYear();
                    books = service.getBooksByYear(year);
                    break;
                }
                case 5: {
                    logger.info("Change locale");
                    texts.setOppositeLocale();
                    continue;
                }
                case 6: {
                    logger.info("Exit the program");
                    return;
                }
                default: {
                    logger.info("Search all books");
                    books = service.getBooks();
                    break;
                }
            }

            logger.debug(String.format("Books found: %d", books.length));

            console.printBooks(books);
            if (books.length == 0) {
                continue;
            }
            if (console.requestSaveToFile(books) == 'y') {
                String path = QuerySave.getSaveFilePath();
                try {
                    QuerySave.save(path, books);
                    logger.info(String.format("Table was saved to %s", path));
                    console.printOut(texts.getText("console.table.saved") + " " + path);
                } catch (IOException err) {
                    logger.error(String.format("Failed to save query result (file path: %s)", path));
                    console.printError(texts.getText("console.table.saved.error") + " " + path);
                }
            }
        } while (true);
    }
}
