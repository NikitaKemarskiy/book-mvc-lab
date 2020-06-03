package com.nikita.view;

import com.nikita.controller.Texts;
import com.nikita.exceptions.InvalidRangeException;
import com.nikita.exceptions.InvalidValueException;

public class Validator {
    private static Texts texts;

    static {
        texts = Texts.getTexts();
    }

    public static void validateAuthor(String author) {
        if (!author.matches("Name\\d+ Surname\\d+")) {
            throw new InvalidValueException(texts.getText("validator.error.author"));
        }
    }

    public static void validatePublishing(String publishing) {
        if (!publishing.matches("Publishing\\d+")) {
            throw new InvalidValueException(texts.getText("validator.error.publishing"));
        }
    }

    public static void validateYear(int year) {
        if (year <= 0 || year >= 2021) {
            throw new InvalidRangeException(texts.getText("validator.error.year"));
        }
    }
}
