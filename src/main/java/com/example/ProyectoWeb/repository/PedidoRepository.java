package com.example.ProyectoWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProyectoWeb.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}