package com.iqvia.usermanagement.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PageResponse<T> {
    private List<T> content;
    private int totalElements;
    private int totalPages;

}