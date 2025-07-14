package com.example.ProyectoWeb.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProyectoWeb.models.Banner;
import com.example.ProyectoWeb.repository.BannerRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/banners")
@RequiredArgsConstructor
public class BannerController {

    private final BannerRepository bannerRepository;

    @GetMapping
    public List<Banner> listarTodos() {
        return bannerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Banner> obtenerPorId(@PathVariable Long id) {
        return bannerRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Banner crear(@RequestBody Banner banner) {
        return bannerRepository.save(banner);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Banner> actualizar(@PathVariable Long id, @RequestBody Banner banner) {
        return bannerRepository.findById(id)
                .map(b -> {
                    banner.setId(id);
                    return ResponseEntity.ok(bannerRepository.save(banner));
                })
                .orElse(ResponseEntity.notFound().build());
    }

}