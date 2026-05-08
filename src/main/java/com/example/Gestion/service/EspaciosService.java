package com.example.Gestion.service;

import org.springframework.stereotype.Service;

import com.example.Gestion.repository.EspaciosRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class EspaciosService {

    private final EspaciosRepository espaciosRepository;
}