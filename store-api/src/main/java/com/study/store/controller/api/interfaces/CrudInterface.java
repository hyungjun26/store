package com.study.store.controller.api.interfaces;

import com.study.store.model.network.Header;

public interface CrudInterface {
    Header create();

    Header read(Long id);

    Header update();

    Header delete(Long id);
}
