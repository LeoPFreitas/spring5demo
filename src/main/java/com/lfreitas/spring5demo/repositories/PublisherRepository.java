package com.lfreitas.spring5demo.repositories;

import com.lfreitas.spring5demo.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
