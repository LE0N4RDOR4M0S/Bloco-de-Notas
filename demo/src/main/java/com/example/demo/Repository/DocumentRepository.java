package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Domain.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    
}
