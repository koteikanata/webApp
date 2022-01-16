package com.koteikanata.bookstore.mapper;

import com.koteikanata.bookstore.model.Book;
import com.koteikanata.bookstore.model.BookRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookToDtoMapper {
    Book AddBookRequestToBook(BookRequest bookRequest);
    Book EditBookRequestToBook(Long id, BookRequest bookRequest);
}
