package com.example.ProyectoWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProyectoWeb.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}