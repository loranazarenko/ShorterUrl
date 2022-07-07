package com.project.shorterurl.controllers;

import com.project.shorterurl.dtos.ShortDto;
import com.project.shorterurl.services.ShortService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ShortController {
    Logger logger = LoggerFactory.getLogger(ShortController.class.getSimpleName());
    @Autowired
    ShortService shortService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/links")
    public String sendForm(Model model) {
        model.addAttribute("shortDto", new ShortDto());
        return "links";
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{hash}")
    public ResponseEntity<Void> redirectShorter(@PathVariable("hash") String hash) {
        return shortService.redirectShorter(hash);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/links")
    public String shorter(@ModelAttribute ShortDto shortDto, Model model) {
        return shortService.createShorter(shortDto, model);
    }
}
