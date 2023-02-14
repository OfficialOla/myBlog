package data.repositories;

import data.models.Article;

import java.util.List;

public interface ArticleRepository {
    Article save(Article article);

    Article findById(int id);

    long count();

    List<Article> findAll();

    void delete(int id);

    void delete(Article article);

    void deleteAll();
}

