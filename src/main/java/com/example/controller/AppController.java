package com.example.controller;

import com.example.model.Book;
import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    Simple controller to test OneToOne
*/
@RestController
public class AppController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/allbooks")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable("id") Long bookId) {
        return bookRepository.findById(bookId).get();
    }

    /* Data
    {
        "title": "หนังสือเรียนภาษาอังกฤษ",
        "description": "ภาษาอังกฤษ ม.6",
        "author": {
            "name": "ทดสอบ",
            "email": "dej@gmail.com"
        }
    }
    */
    @PostMapping("/book/save")
    public Book saveNewBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    /* Data
    {
        "id": 2,
        "title": "หนังสือเรียนภาษาอังกฤษ",
        "description": "ภาษาอังกฤษ ม.5",
        "author": {
            "id": 2,
            "name": "ศักดา",
            "email": "dej@gmail.com"
        }
    }
    */
    @PutMapping("/book/update")
    public Book updateBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/book/delete/{id}")
    public void deleteBook(@PathVariable("id") Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
