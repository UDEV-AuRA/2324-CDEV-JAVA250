package com.example.demo.service.mapper;

import com.example.demo.dto.ArticleDto;
import com.example.demo.entity.Article;
import org.springframework.stereotype.Component;

@Component
public class ArticleMapper {

    public ArticleDto articleDto(Article article) {
        return new ArticleDto(article.getId(), article.getLibelle(), article.getPrix(), article.getImageUrl());
    }

}
