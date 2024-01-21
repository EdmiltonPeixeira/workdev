package com.dev.edmilton.workdev.controller;

import com.dev.edmilton.workdev.ata.AtaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/atas")
public class AtaController {

    @Autowired
    private AtaRepository ataRepository;

}
