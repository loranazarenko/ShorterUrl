package com.project.shorterurl.dtos;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
public class ShortDto {
    private String fullUrl;
    private String shorter;

    public String getFullUrl() {
        return fullUrl;
    }

    public String getShorter() {
        return shorter;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public void setShorter(String shorter) {
        this.shorter = shorter;
    }
}


