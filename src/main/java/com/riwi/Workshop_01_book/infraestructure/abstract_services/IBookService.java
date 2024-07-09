package com.riwi.Workshop_01_book.infraestructure.abstract_services;

import com.riwi.Workshop_01_book.api.dto.request.BookRequest;
import com.riwi.Workshop_01_book.api.dto.response.BookResponse;

public interface IBookService extends GenericService<BookRequest, BookResponse, Long>{

}
