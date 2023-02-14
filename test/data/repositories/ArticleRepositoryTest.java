package data.repositories;

import data.models.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticleRepositoryTest {

    private  ArticleRepository articleRepository;

    private Article article;
    @BeforeEach
    public void setUp(){
        articleRepository = new ArticleRepositoryImpl();
        article = new Article();
        article.setTitle("How I made 10million with #500");
        article.setBody("Hmmmmmm");

    }
    @Test public void saveOneArticle_countIsOne(){
        Article article = new Article();
        articleRepository.save(article);
        assertEquals(1, articleRepository.count());
    }
    @Test public void saveOneUser_IdOfUserIsOne(){
        Article savedArticle = articleRepository.save(article);
        assertEquals(1, savedArticle.getId());
    }

    @DisplayName("Update Article test")
    @Test public void saveTwoArticlesWithSameId_countIsOneTest(){
        Article savedArticle  = articleRepository.save(article);
        assertEquals(1, articleRepository.count());
        savedArticle.setBody("And so!");
        articleRepository.save(savedArticle);
        assertEquals(1, articleRepository.count());
    }
    @Test public void saveOneArticle_findUserByIdTest(){
        Article savedArticle = articleRepository.save(article);
        assertEquals(1, savedArticle.getId());
        Article foundArticle = articleRepository.findById(1);
        assertEquals(foundArticle, savedArticle);
    }
    @Test public void saveOneComment_deleteOneComment_countIsZero(){
        articleRepository.save(article);
        assertEquals(1, articleRepository.count());
        articleRepository.delete(1);
        assertEquals(0, articleRepository.count());

    }

}