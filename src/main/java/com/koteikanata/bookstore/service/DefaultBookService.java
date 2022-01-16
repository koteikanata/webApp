package com.koteikanata.bookstore.service;

import com.koteikanata.bookstore.dao.BookEntity;
import com.koteikanata.bookstore.dao.BookRepository;
import com.koteikanata.bookstore.exception.BookNotFoundException;
import com.koteikanata.bookstore.mapper.BookToEntityMapper;
import com.koteikanata.bookstore.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // создание объекта класса с помощью спринга
@RequiredArgsConstructor // генерация конструктора с параметром bookRepository
public class DefaultBookService implements BookService {
    private final BookRepository bookRepository;
    private final BookToEntityMapper mapper;

    @Override
    public Book getBookId(Long id) {
        BookEntity bookEntity = bookRepository
                .findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found: id = " + id));
        return mapper.bookEntityToBook(bookEntity);
    }

    @Override
    public List<Book> getAllBooks() {
        Iterable<BookEntity> iterable = bookRepository.findAll();
        ArrayList<Book> books = new ArrayList<>();
        for (BookEntity bookEntity : iterable) {
            books.add(mapper.bookEntityToBook(bookEntity));
        }
        return books;
    }

    @Override
    public void addBook(Book book) {
        BookEntity bookEntity = mapper.bookToBookEntity(book);
        bookRepository.save(bookEntity);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        Iterable<BookEntity> iterable = bookRepository.findAllByAuthorContaining(author);
        ArrayList<Book> books = new ArrayList<>();
        for (BookEntity bookEntity : iterable) {
            books.add(mapper.bookEntityToBook(bookEntity));
        }
        return books;
    }

    @Override
    public void editBook(Book book) {
        if (!bookRepository.existsById(book.getId())) {
            throw new BookNotFoundException("Book not found: id = " + book.getId());
        }
        BookEntity bookEntity = mapper.bookToBookEntity(book);
        bookRepository.save(bookEntity);
    }
}
