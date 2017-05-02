package com.epam.webproject.domain;

public class Book {
    private int id;
    private String name;
    private int authorId;

    public Book(String name, int authorId) {
        this.name = name;
        this.authorId = authorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAuthorId() {
        return authorId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authorId=" + authorId +
                '}';
    }
}
