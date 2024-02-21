package ru.flamexander.spring.security.jwt.controllers;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.flamexander.spring.security.jwt.dtos.PagedDataDto;
import ru.flamexander.spring.security.jwt.entities.Dorm;
import ru.flamexander.spring.security.jwt.service.DormService;

import java.util.List;

@RestController
@RequestMapping("/dorm")
public class DormController {
    private final DormService dormService;

    public DormController(DormService dormService) {
        this.dormService = dormService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Dorm>> searchProducts(@RequestParam("query") String query) {
        return ResponseEntity.ok(dormService.searchDorms(query));
    }

    @GetMapping
    public PagedDataDto<Dorm> findAll(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ) {
       Page<Dorm> pagedData = dormService.findAll(PageRequest.of(page, size));
        PagedDataDto<Dorm> pagedDataDto = new PagedDataDto<>();
        pagedDataDto.setData(pagedData.getContent());
        pagedDataDto.setTotal(pagedData.getTotalElements());
        return pagedDataDto;
    }

    @PostMapping
    public Dorm createProduct(@RequestBody Dorm dorm) {
        return dormService.createProduct(dorm);
    }

    @PostMapping("/{id}")
    public Dorm updateDorm(@RequestBody Dorm dorm,
                           @PathVariable("id") Long id) {
        return dormService.updateDorm(dorm, id);

    }

    @DeleteMapping("/{id}")
    public String deleteDorm(@PathVariable("id") Long id) {
        dormService.deleteDorm(id);
        return "Deleted Successfully";
    }


}
