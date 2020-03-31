/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.corona.boys.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import javax.persistence.*;


@Entity
@Table
public class Comment extends AbstractEntity {
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private User user;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonIgnore
    private Article article;
    
    @Basic(optional = false)
    @Column(nullable = false)
    private String content;
    
    //@Basic(optional = false)
    @Column
    private LocalDateTime created;
    
    
    public Comment(){
    }
    
    public Comment(String content, User user) {
        this.content = content;
        this.user = user;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return created;
    }

    public void setDate(LocalDateTime date) {
        this.created = date;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    
    @JsonIgnore
    public Article getArticle(){
        return article;
    }
    @JsonIgnore
    public void setArticle(Article article){
        this.article = article;
    }
    
    @Override
    public String toString() {
        return "Comment{" +
                "created=" + created +
                ", author=" + user +
                ", content=" + content +
                "}";
    }


    
}
