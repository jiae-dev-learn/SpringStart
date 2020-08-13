package com.example.demo.controller.ifs;


import com.example.demo.model.network.Header;

public interface CrudInterface<Request, Response> {
    Header<Response> create(Header<Request> request); // TODO request object 추가
    
    Header<Response> read(Long id);
    
    Header<Response> update(Header<Request> request);

    Header delete(Long id);
}
