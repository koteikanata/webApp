package com.koteikanata.bookstore.service;

import com.koteikanata.bookstore.model.Book;

import java.util.List;

public interface BookService {
    Book getBookId(Long id); // получить книгу по id
    List<Book> getAllBooks(); // получить список всех книг
    void addBook(Book book); // добавить книгу
    List<Book> findByAuthor(String author);
    void editBook(Book book);
}
