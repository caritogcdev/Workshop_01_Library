package com.riwi.Workshop_01_book.infraestructure.services;

import com.riwi.Workshop_01_book.api.dto.request.BookRequest;
import com.riwi.Workshop_01_book.api.dto.response.BookResponse;
import com.riwi.Workshop_01_book.domain.entities.BookEntity;
import com.riwi.Workshop_01_book.domain.repositories.BookRepository;
import com.riwi.Workshop_01_book.infraestructure.abstract_services.IBookService;
import com.riwi.Workshop_01_book.infraestructure.helpers.mappers.BookMapper;
import com.riwi.Workshop_01_book.util.exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BookService implements IBookService {
    @Autowired
    private final BookRepository bookRepository;

    @Autowired
    private final BookMapper bookMapper;

    @Override
    public BookResponse create(BookRequest request) {
        //Transform request to entity
        BookEntity bookEntity = this.bookMapper.toBookEntity(request);

        // Set empty lists
        bookEntity.setLoans(new ArrayList<>());
        bookEntity.setReservations(new ArrayList<>());

        return this.bookMapper.toBookResponse(this.bookRepository.save(bookEntity));
    }

    @Override
    public BookResponse get(Long id) {
        BookEntity bookEntity = this.bookRepository.findById(id)
                .orElseThrow(()->new BadRequestException("Book id is invalid"));
        return this.bookMapper.toBookResponse(bookEntity);
    }

    @Override
    public List<BookResponse> getAll() {
        return this.bookMapper.BookListToResponseList(this.bookRepository.findAll());
    }

    @Override
    public BookResponse update(Long id, BookRequest request) {

        this.bookRepository.findById(id)
                .orElseThrow(()-> new BadRequestException("Book id is invalid"));

        //Convert to entity
        BookEntity bookEntity = this.bookMapper.toBookEntity(request);

        //bookEntity.setId(id);
        bookEntity.setTitle(request.getTitle());
        bookEntity.setAuthor(request.getAuthor());
        bookEntity.setPublicationYear(request.getPublicationYear());
        bookEntity.setGenre(request.getGenre());
        bookEntity.setIsbn(request.getIsbn());

        return this.bookMapper.toBookResponse(this.bookRepository.save(bookEntity));
    }

    @Override
    public void delete(Long id) {
        BookEntity bookEntity = this.bookRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Book id is invalid"));

        this.bookRepository.delete(bookEntity);

    }
}
