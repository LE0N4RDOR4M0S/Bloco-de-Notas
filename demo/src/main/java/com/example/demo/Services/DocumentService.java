package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Domain.Document;
import com.example.demo.Repository.DocumentRepository;

@Service
public class DocumentService {

    public final DocumentRepository documentRepository;

    @Autowired
    public final DocumentService(DocumentRepository documentRepository){
        this.documentRepository = documentRepository;
    }

    /**
     *
     * @return todos os documentos no sistema
     */
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    /**
     *
     * @param id identificador no documento
     * @return documento com respectivo id
     */
    public Document getDocument(Long id) {
        return documentRepository.findById(id).orElse(null);
    }

    /**
     *
     * @param document documento a ser salvo
     */
    public void saveDocument(Document document) {
        documentRepository.save(document);
    }

    public Document updateDocument(Long id, Document new_document){
        Optional<Document>
    }

    /**
     *
     * @param id identificadro do documento a ser deletado
     */
    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }
}
