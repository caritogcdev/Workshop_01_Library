package com.riwi.Workshop_01_book.infraestructure.abstract_services;

public interface GenericService<RequestDTO, ResponseDTO, ID> {
    ResponseDTO create(RequestDTO request);
    ResponseDTO get(ID id);
    ResponseDTO update(ID id, RequestDTO request);
    void delete(ID id);
}
