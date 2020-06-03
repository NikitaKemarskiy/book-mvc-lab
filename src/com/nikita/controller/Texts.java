package com.nikita.controller;

import java.util.Locale;
import java.util.ResourceBundle;

public class Texts {
    private Locale locale;
    private ResourceBundle resourceBundle;

    private static Texts appLocale;
    private static final Locale DEFAULT_LOCALE = Locale.ENGLISH;
    private static final String BUNDLE_NAME = "texts";

    private Texts() {
        locale = DEFAULT_LOCALE;
        resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
    }

    public static Texts getTexts() {
        if (appLocale != null) {
            return appLocale;
        }
        return appLocale = new Texts();
    }

    public Locale getLocale() {
        return locale;
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
    }

    public void setOppositeLocale() {
        if (locale.equals(Locale.ENGLISH)) {
            setLocale(new Locale("ru"));
        } else {
            setLocale(Locale.ENGLISH);
        }
    }

    public String getText(String key) {
        return resourceBundle.getString(key);
    }
}
