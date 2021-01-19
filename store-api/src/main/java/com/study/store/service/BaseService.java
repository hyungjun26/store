package com.study.store.service;

import com.study.store.interfaces.CrudInterface;
import com.study.store.model.network.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseService<Request, Response, Entity> implements CrudInterface<Request, Response> {

    @Autowired(required = false)
    protected JpaRepository<Entity, Long> baseRepository;

}
