/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.corona.boys.blog.model;


import javax.persistence.*;


@Entity
@Table(name="Likes")
public class Like extends AbstractEntity {

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private User user;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Article article;
    
    public Like(){
    }
    
    public Like(User user){
        this.user = user;
    }
    
    public User getUser(){
        return user;
    }
    
    public void setUser(User user){
        this.user= user;
    }
    
    public Article getArticle(){
        return article;
    }
    
    public void setArticle(Article article){
        this.article = article;
    }
    
    
}
