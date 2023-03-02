package com.codecool.library.controller;

import com.codecool.library.repository.model.Writer;
import com.codecool.library.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class WriterController {
    private WriterService writerService;

    @Autowired
    public WriterController(WriterService writerService) {
        this.writerService = writerService;
    }

    @PostMapping("/writer")
    public void addWriter(@RequestBody Writer writer) {
        writerService.addWriter(writer);
    }
}
