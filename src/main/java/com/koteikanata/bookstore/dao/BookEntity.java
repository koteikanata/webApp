package com.koteikanata.bookstore.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data //добавляет getters и setters
@NoArgsConstructor //конструкторы без параметров
@AllArgsConstructor //конструкторы с параметрами
// аннотации относящиеся к JPA
@Entity // указание на то, что это объект БД
@Table(name = "books", indexes = {
        @Index(name = "idx_books_author", columnList = "author")
}) // название таблицы
public class BookEntity {
    @Id // первичный ключ
    @GeneratedValue(strategy = GenerationType.AUTO) // автоматическая генерация
    private Long id;
    private String author;
    private String title;
    private Double price;
}
