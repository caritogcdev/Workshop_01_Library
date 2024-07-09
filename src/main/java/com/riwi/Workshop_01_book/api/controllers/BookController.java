package com.riwi.Workshop_01_book.api.controllers;

import com.riwi.Workshop_01_book.api.dto.request.BookRequest;
import com.riwi.Workshop_01_book.api.dto.response.BookResponse;
import com.riwi.Workshop_01_book.infraestructure.abstract_services.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/books")
public class BookController implements GenericController<BookRequest, BookResponse, Long>{

    @Autowired
    private final IBookService bookService;

    @PostMapping
    @Override
    public ResponseEntity<BookResponse> create(
            @Validated @RequestBody BookRequest request) {
        return ResponseEntity.ok(this.bookService.create(request));
    }

    @GetMapping(path = "/{id}")
    @Override
    public ResponseEntity<BookResponse> get(
            @PathVariable Long id) {
        return ResponseEntity.ok(bookService.get(id));
    }

    @GetMapping
    @Override
    public ResponseEntity<List<BookResponse>> getAll() {
        return ResponseEntity.ok(this.bookService.getAll());
    }

    @PutMapping(path = "/{id}")
    @Override
    public ResponseEntity<BookResponse> update(
            @Validated @RequestBody BookRequest request, 
            @PathVariable Long id) {
        return ResponseEntity.ok(this.bookService.update(id, request));
    }

    @DeleteMapping(path = "/{id}")
    @Override
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {
        this.bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
