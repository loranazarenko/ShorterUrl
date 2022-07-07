package com.project.shorterurl.services;

import com.project.shorterurl.dtos.ShortDto;
import com.project.shorterurl.entities.ShortUrl;
import com.project.shorterurl.repositories.ShortUrlRep;
import com.project.shorterurl.utilities.CodeGenerator;
import org.apache.commons.validator.routines.UrlValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.net.URI;
import java.net.URLDecoder;
import java.util.Optional;

@Service
public class ShortService {
    Logger logger = LoggerFactory.getLogger(ShortService.class.getSimpleName());

    @Autowired
    ShortUrlRep shortUrlRep;
    private final CodeGenerator codeGenerator;
    @Value("${shorter.length}")
    private Integer shorterLength;

    @Autowired
    public ShortService(final ShortUrlRep shortUrlRep) {
        this.shortUrlRep = shortUrlRep;
        this.codeGenerator = new CodeGenerator();
    }

    public String createShorter(ShortDto shorter, Model model) {
        UrlValidator validator = new UrlValidator();
        if (validator.isValid(shorter.getFullUrl())) {
           String fullUrl = shorter.getFullUrl();
            Optional<ShortUrl> optShortUrl = shortUrlRep.getByFullUrl(fullUrl).stream().findFirst();
            if (optShortUrl.isEmpty()) {
                String hash = codeGenerator.generate(shorterLength);
                logger.info(hash);
                String shorterString = URLDecoder.decode(shorter.getFullUrl());
                logger.info(shorterString);
                shorter.setShorter(hash);
                ShortUrl shortUrl = new ShortUrl(hash, shorterString);
                shortUrlRep.save(shortUrl);
            } else {
                logger.info(optShortUrl.get().getShortUrl());
                shorter.setShorter(optShortUrl.get().getShortUrl());
            }
            model.addAttribute("shortDto", shorter);
            return "links";
        }
        return "invalid";
    }

    public ResponseEntity<Void> redirectShorter(String hash) {
        logger.info(hash);
        Optional<ShortUrl> link = shortUrlRep.getByShortUrl(hash).stream().findFirst();
        if (link.isPresent()) {
            var url = link.get().getFullUrl();
            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(URI.create(url))
                    .build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
