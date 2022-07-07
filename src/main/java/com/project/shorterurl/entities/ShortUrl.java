package com.project.shorterurl.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "SHORT_URL")
public class ShortUrl {
    @Id
    private String shortUrl;
    @Column(length = 10000)
    private String fullUrl;
}