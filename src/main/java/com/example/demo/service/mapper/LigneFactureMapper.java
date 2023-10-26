package com.example.demo.service.mapper;

import com.example.demo.dto.LigneFactureDto;
import com.example.demo.entity.Article;
import com.example.demo.entity.LigneFacture;
import org.springframework.stereotype.Component;

@Component
public class LigneFactureMapper {

    public LigneFactureDto ligneFactureDto(LigneFacture ligneFacture) {
        Article article = ligneFacture.getArticle();
        return new LigneFactureDto(article.getLibelle(),
                article.getPrix(),
                ligneFacture.getQuantite()
        );
    }
}
