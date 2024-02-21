package ru.flamexander.spring.security.jwt.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import ru.flamexander.spring.security.jwt.entities.Dorm;

import java.util.List;

public interface DormService {
    List<Dorm> searchDorms(String query);

    Dorm createProduct(Dorm dorm);

    Page<Dorm> findAll(PageRequest of);

    Dorm updateDorm(Dorm dorm, Long id);
    void deleteDorm(Long id);
}
