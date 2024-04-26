package com.example.demo.Controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Domain.Document;
import com.example.demo.Services.DocumentService;

@Controller
@RequestMapping("/user")
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @GetMapping("/")
    private String getAll(Model model) {
        model.addAttribute("documents", documentService.getAllDocuments());
        return "index";
    }

    @GetMapping("/document/{id}")
    private String documentId(@PathVariable Long id, Model model) {
        Document document = documentService.getDocument(id);
        model.addAttribute("document", document);
        return "document";
    }

    @GetMapping("/document/new")
    private String newDocument(Model model) {
        model.addAttribute("document", new Document());
        return "new_document";
    }

    @PostMapping("/document/save")
    private String saveDocument(@ModelAttribute Document document) {
        document.setData(LocalDate.now());
        documentService.saveDocument(document);
        return "redirect:/user/";
    }

    @GetMapping("/document/edit/{id}")
    public ModelAndView editDocument(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("edit_document");
        Document document = documentService.getDocument(id);
        modelAndView.addObject("document", document);
        return modelAndView;
    }

    @PostMapping("/document/update/{id}")
    public String updateDocument(@PathVariable Long id, @ModelAttribute Document document) {
        document.setId(id);
        document.setData(LocalDate.now());
        documentService.saveDocument(document);
        return "redirect:/user/";
    }

    @GetMapping("/document/delete/{id}")
    public String deleteDocument(@PathVariable Long id) {
        documentService.deleteDocument(id);
        return "redirect:/user/";
    }
}
