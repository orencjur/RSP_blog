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


@Repository
public class CommentDao extends BaseDao<Comment>{
    
    public CommentDao(){
        super(Comment.class);
    }
    @Override
    public List<Comment> findAll() {
        return em.createQuery("SELECT c FROM Comment c", Comment.class).getResultList();
    }

    public List<Comment> findByArticle(Article article) {
        Objects.requireNonNull(article);
        return em.createQuery("SELECT c FROM Comment c inner join c.article ca WHERE ca= ?1", Comment.class).setParameter(1,article).getResultList();
    }
    
     public Comment findById(Integer Id){
        Objects.requireNonNull(Id);
        return em.createQuery("SELECT c FROM Comment c WHERE c.id = ?1", Comment.class).setParameter(1, Id).getSingleResult();
    }
}
