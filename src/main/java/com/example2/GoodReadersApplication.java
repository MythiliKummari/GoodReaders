package com.example2;
import com.example2.goodreads.controller.BookController;
import com.example2.goodreads.model.*;
import com.example2.goodreads.repository.*;
import com.example2.goodreads.service.BookMYSQLService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication



public class GoodReadersApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodReadersApplication.class, args);
	}

}
