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


/**
 *
 * @author Amy
 */

@Repository
public class ArticleDao extends BaseDao<Article>{
    
    public ArticleDao(){
        super(Article.class);
    }
    
    @Override
    public List<Article> findAll() {
        return em.createQuery("SELECT a FROM Article a WHERE NOT a.removed", Article.class).getResultList();
    }
    
    public List<Article> findAll(Topic topic) {
        Objects.requireNonNull(topic);
        return em.createNamedQuery("Article.findByTopic", Article.class).setParameter("topic", topic)
                 .getResultList();
    }
    
    public List<Article> findAll(LocalDateTime date) {
        Objects.requireNonNull(date);
        return em.createNamedQuery("Article.findByDate", Article.class).setParameter("date", date)
                 .getResultList();
    }
     
    public List<Article> findAll(String title){
        Objects.requireNonNull(title);
        return em.createNamedQuery("Article.findByTitle", Article.class).setParameter("title", title)
                 .getResultList();
    }
    
      public Article findAll(Integer Id){
        Objects.requireNonNull(Id);
        return em.createNamedQuery("Article.findById", Article.class).setParameter("id", Id)
                 .getSingleResult();
    }
    
    
}
