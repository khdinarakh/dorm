package ru.flamexander.spring.security.jwt.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.flamexander.spring.security.jwt.entities.Dorm;
import ru.flamexander.spring.security.jwt.repositories.DormRepository;

import java.util.List;
import java.util.Objects;

@Service
public class DormServiceImpl implements DormService {
    private final DormRepository dormRepository;

    public DormServiceImpl(DormRepository dormRepository) {
        this.dormRepository = dormRepository;
    }

    @Override
    public List<Dorm> searchDorms(String query) {
        List<Dorm> dorms = dormRepository.searchDorms(query);
        return dorms;
    }

    @Override
    public Dorm createProduct(Dorm dorm) {
        return dormRepository.save(dorm);
    }

    @Override
    public Page<Dorm> findAll(PageRequest pageRequest) {

        return dormRepository.findAll(pageRequest);

    }

    @Override
    public Dorm updateDorm(Dorm dorm, Long id) {
        Dorm dormDB = dormRepository.findById(id).get();

        if (Objects.nonNull(dorm.getName()) && !"".equalsIgnoreCase(dorm.getName())) {
            dormDB.setName(dorm.getName());
        }

        if (Objects.nonNull(dorm.getDescription()) && !"".equalsIgnoreCase(dorm.getDescription())) {
            dormDB.setDescription(dorm.getDescription());
        }

        if (Objects.nonNull(dorm.getLocation()) && !"".equalsIgnoreCase(dorm.getLocation())) {
            dormDB.setLocation(dorm.getLocation());
        }

        if (Objects.nonNull(dorm.getPrice())) {
            dormDB.setPrice(dorm.getPrice());
        }

        if (Objects.nonNull(dorm.getImageUrl()) && !"".equalsIgnoreCase(dorm.getImageUrl())) {
            dormDB.setImageUrl(dorm.getImageUrl());
        }


        return dormRepository.save(dormDB);
    }

    @Override
    public void deleteDorm(Long id) {
        dormRepository.deleteById(id);
    }
}
