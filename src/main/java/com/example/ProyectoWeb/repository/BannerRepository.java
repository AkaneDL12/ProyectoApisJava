package com.example.ProyectoWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProyectoWeb.models.Banner;

public interface BannerRepository extends JpaRepository<Banner, Long> {
}