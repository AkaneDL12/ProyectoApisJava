package com.example.ProyectoWeb.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

    private static final String UPLOAD_DIR = "uploads/";

    @PostMapping("/imagen")
    public ResponseEntity<String> subirImagen(@RequestParam("file") MultipartFile file) {
        try {
            String nombreArchivo = UUID.randomUUID() + "_" + file.getOriginalFilename();
            Path ruta = Paths.get(UPLOAD_DIR + nombreArchivo);
            Files.createDirectories(ruta.getParent());
            Files.copy(file.getInputStream(), ruta, StandardCopyOption.REPLACE_EXISTING);
            return ResponseEntity.ok(nombreArchivo);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al subir imagen: " + e.getMessage());
        }
    }
}