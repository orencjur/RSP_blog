/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.corona.boys.blog.dao;

import the.corona.boys.blog.model.Article;
import the.corona.boys.blog.model.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Amy
 */

@Repository
public class CommentDao extends BaseDao<Comment>{
    
    public CommentDao(){
        super(Comment.class);
    }
    @Override
    public List<Comment> findAll() {
        return em.createQuery("SELECT c FROM Comment c", Comment.class).getResultList();
    }
    
    public List<Comment> findAll(Article article) {
        Objects.requireNonNull(article);
        return em.createNamedQuery("Comment.findByArticle", Comment.class).setParameter("article", article)
                 .getResultList();
    }
    
     public Comment findAll(Integer Id){
        Objects.requireNonNull(Id);
        return em.createNamedQuery("Comment.findById", Comment.class).setParameter("id", Id)
                 .getSingleResult();
    }
}
