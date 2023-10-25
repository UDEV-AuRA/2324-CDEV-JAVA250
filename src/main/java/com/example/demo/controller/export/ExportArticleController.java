package com.example.demo.controller.export;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.example.demo.dto.ArticleDto;
import com.example.demo.service.ArticleService;

/**
 * Controller pour réaliser l'export des articles.
 */
@Controller
@RequestMapping("export/articles")
public class ExportArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * Export des articles au format CSV.
     */
    @GetMapping("csv")
    public void exportCSV(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"export-articles.csv\"");
        PrintWriter writer = response.getWriter();
        writer.println("Article;Prix");

        List<ArticleDto> articles = articleService.findAll();
        for (ArticleDto article : articles) {
            writer.println(article.getLibelle() + ";" + article.getPrix());
        }
    }

}
