package com.riwi.Workshop_01_book.infraestructure.abstract_services;

import java.util.List;

public interface GenericService<RequestDTO, ResponseDTO, ID> {
    ResponseDTO create(RequestDTO request);
    ResponseDTO get(ID id);
    List<ResponseDTO> getAll();
    ResponseDTO update(ID id, RequestDTO request);
    void delete(ID id);
}
