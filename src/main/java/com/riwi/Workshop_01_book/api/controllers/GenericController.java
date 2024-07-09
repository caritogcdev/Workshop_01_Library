package com.riwi.Workshop_01_book.api.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GenericController <RequestDTO, ResponseDTO, ID>{
    public ResponseEntity<ResponseDTO> create(RequestDTO request);
    public ResponseEntity<ResponseDTO> get(ID id);
    //public ResponseEntity<Page<ResponseDTO>> getAll (int page, int size);
    public ResponseEntity<List<ResponseDTO>> getAll();
    public ResponseEntity<ResponseDTO> update(RequestDTO request, ID id);
    public ResponseEntity<Void> delete(ID id);
}
