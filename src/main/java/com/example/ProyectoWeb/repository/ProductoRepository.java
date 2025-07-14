package com.example.ProyectoWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProyectoWeb.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}