package com.koteikanata.bookstore.mapper;

import com.koteikanata.bookstore.dao.BookEntity;
import com.koteikanata.bookstore.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookToEntityMapper {
    BookEntity bookToBookEntity(Book book);

    Book bookEntityToBook(BookEntity bookEntity);
}
