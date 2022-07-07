package com.project.shorterurl.repositories;

import com.project.shorterurl.entities.ShortUrl;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ShortUrlRep extends CrudRepository<ShortUrl, String> {
    Optional<ShortUrl> getByFullUrl(String fullUrl);
    Optional<ShortUrl> getByShortUrl(String hash);
}