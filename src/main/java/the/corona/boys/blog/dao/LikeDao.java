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
    
     public List<Like> findAll(Article article) {
        Objects.requireNonNull(article);
        return em.createNamedQuery("Like.findByArticle", Like.class).setParameter("article", article)
                 .getResultList();
    }
    
     public Like find(Integer Id){
        Objects.requireNonNull(Id);
        return em.createNamedQuery("Like.findById", Like.class).setParameter("id", Id)
                 .getSingleResult();
    }
}
