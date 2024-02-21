package ru.flamexander.spring.security.jwt.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PagedDataDto<T> {
    private List<T> data;
    private long total;
}
