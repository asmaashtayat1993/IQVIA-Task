package com.iqvia.usermanagement.dto;

import java.util.List;

public class PageResponse<T> {
    private List<T> content;
    private int totalElements;
    private int totalPages;


    // Constructors, getters, and setters
    public PageResponse() {}

    public PageResponse(List<T> content, int totalElements, int totalPages, int size, int number) {
        this.content = content;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }


}