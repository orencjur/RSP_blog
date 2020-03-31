/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.corona.boys.blog.dao;

import the.corona.boys.blog.model.Article;
import the.corona.boys.blog.model.Topic;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;




@Repository
public class ArticleDao extends BaseDao<Article>{
    
    public ArticleDao(){
        super(Article.class);
    }
    
    @Override
    public List<Article> findAll() {
        return em.createQuery("SELECT a FROM Article a WHERE NOT a.removed", Article.class).getResultList();
    }
    
    public List<Article> findByTopic(Topic topic) {
        Objects.requireNonNull(topic);
        return em.createQuery("SELECT a FROM Article a WHERE :topic MEMBER OF a.topics AND NOT a.removed", Article.class).getResultList();
    }
    
    public List<Article> findByDate(LocalDateTime date) {
        Objects.requireNonNull(date);
        return em.createQuery("SELECT a FROM Article a WHERE a.created = ?1", Article.class).setParameter(1, date)
                 .getResultList();
    }
     
    public List<Article> findByTitle(String title){
        Objects.requireNonNull(title);
        return em.createQuery("SELECT a FROM Article a WHERE a.title = ?1", Article.class).setParameter(1, title)
                 .getResultList();
    }
    
      public Article findById(Integer Id){
        Objects.requireNonNull(Id);
        return em.createQuery("SELECT a FROM Article a WHERE a.id = ?1", Article.class).setParameter(1, Id)
                 .getSingleResult();
    }
    
    
}
