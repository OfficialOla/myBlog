package data.repositories;

import data.models.Article;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepositoryImpl implements ArticleRepository{
    private int count;
    private  List<Article> articles = new ArrayList<>();
    @Override
    public Article save(Article article) {
        boolean articleHasNotBeenSaved = article.getId() == 0;
        if (articleHasNotBeenSaved) saveNew(article);
        return article;
    }

    private void saveNew(Article article) {
        article.setId(generateId());
        articles.add(article);
        count++;
    }

    private int generateId() {
       return count+1;
    }

    @Override
    public Article findById(int id) {
        for (Article article : articles) if (article.getId() == id ) return  article;
        return null;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public List<Article> findAll() {
        return null;
    }

    @Override
    public void delete(int id) {
        for(Article article : articles){
            boolean articleHasNotBeenSaved = article.getId() ==id;
            if (articleHasNotBeenSaved){
                articles.remove(article);
                count--;
                break;
            }
        }
    }

    @Override
    public void delete(Article article) {

    }

    @Override
    public void deleteAll() {

    }
}
