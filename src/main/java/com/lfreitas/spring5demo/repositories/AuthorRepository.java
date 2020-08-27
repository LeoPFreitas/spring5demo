package com.lfreitas.spring5demo.repositories;

import com.lfreitas.spring5demo.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}