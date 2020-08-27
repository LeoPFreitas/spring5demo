package com.lfreitas.spring5demo.repositories;

import com.lfreitas.spring5demo.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}