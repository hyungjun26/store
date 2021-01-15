package com.study.store.interfaces;

import com.study.store.model.network.Header;

public interface CrudInterface<Request, Response> {
    Header<Response> create(Header<Request> request);

    Header<Response> read(Long id);

    Header<Response> update(Header<Request> request);

    Header delete(Long id);
}
