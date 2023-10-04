package com.example2.goodreads.repository;
import com.example2.goodreads.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookJpaRepository extends JpaRepository<Book,Integer>

{

}

