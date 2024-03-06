package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Domain.Document;
import com.example.demo.Repository.DocumentRepository;

@Service
public class DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    @SuppressWarnings("null")
    public Document getDocument(Long id) {
        return documentRepository.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    public void saveDocument(Document document) {
        documentRepository.save(document);
    }

    @SuppressWarnings("null")
    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }
}
