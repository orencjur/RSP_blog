/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.corona.boys.blog.dao;

import the.corona.boys.blog.model.Article;
import the.corona.boys.blog.model.Like;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;


@Repository
public class LikeDao extends BaseDao<Like> {
    
    public LikeDao(){
        super(Like.class);
    }

    public List<Like> findAll() {
        return em.createQuery("SELECT l FROM Like l", Like.class).getResultList();
    }
    
     public List<Like> findByArticle(Article article) {
        Objects.requireNonNull(article);
        return em.createQuery("SELECT l FROM Like l inner join l.article la WHERE la=?1", Like.class).setParameter(1, article)
                 .getResultList();
    }
    
     public Like findById(Integer Id){
        Objects.requireNonNull(Id);
        return em.createQuery("SELECT l FROM Like l WHERE l.id = ?1", Like.class).setParameter(1, Id)
                 .getSingleResult();
    }
}
