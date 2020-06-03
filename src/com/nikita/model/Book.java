package com.nikita.model;

import java.math.BigDecimal;

public class Book {
    private int id;
    private String name;
    private String author;
    private String publishing;
    private int year;
    private int pagesAmount;
    private BigDecimal price;

    public Book(String name) {
        this.name = name;
        this.id = IdGenerator.getId();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPagesAmount() {
        return pagesAmount;
    }

    public void setPagesAmount(int pagesAmount) {
        this.pagesAmount = pagesAmount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = new BigDecimal(price);
    }

    @Override
    public String toString() {
        return String.format("\"%s\" by %s", name, author);
    }
}