package com.example.ProyectoWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProyectoWeb.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}