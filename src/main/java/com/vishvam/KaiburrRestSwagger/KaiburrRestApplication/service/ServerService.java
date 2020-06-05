package com.vishvam.KaiburrRestSwagger.KaiburrRestApplication.service;
import com.vishvam.KaiburrRestSwagger.KaiburrRestApplication.model.Server;

import java.util.List;
import java.util.Optional;

public interface ServerService {
    List<Server> findByName(String name);
    Optional<Server> findById(String id);
    List<Server> findAll();
    void deleteById(String id);
    void save(Server s);
}
