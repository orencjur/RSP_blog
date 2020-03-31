
package the.corona.boys.blog.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.time.LocalDateTime;
import java.util.*;
import javax.persistence.*;


@Entity
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Article extends AbstractEntity {
    
    @Basic(optional = false)
    @Column(nullable = false)
    private String title;
   
    @Basic(optional = false)
    @Column(nullable = false)
    private String content;
    
    //@Basic(optional = false)
    @Column
    private LocalDateTime created;  
    
    @ManyToMany
    @OrderBy("name")
    private List<Topic> topics;
    
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Comment> comments;
    
    @OneToMany(mappedBy = "article")
    private List<Like> likes;
    
    @ManyToOne
    private User author;
    
    private Boolean removed = false;
  
    public Article() {
    }

    public Article(String title, String content, LocalDateTime created, User author) {
        this.title = title;
        this.content = content;
        this.created = created;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    //====TOPIC====
    public List<Topic> getTopics() {
        return topics;
    }
    
    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
    
    public void addTopic(Topic topic) {
        Objects.requireNonNull(topic);
        if (topics == null) {
            this.topics = new ArrayList<>();
        }
        topics.add(topic);
    } 
    
    public void removeTopic(Topic topic) {
        Objects.requireNonNull(topic);
        if (topics == null) {
            return;
        }
        topics.removeIf(c -> Objects.equals(c.getId(), topic.getId()));
    }

    public Boolean isRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }
    
   //====COMMENT=====
    @JsonIgnore
    public List<Comment> getComments() {
        return comments;
    }
    
    @JsonIgnore
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
     
    public void addComment(Comment comment) {
        Objects.requireNonNull(comment);
        if (comments == null) {
            this.comments = new ArrayList<>();
        }
        comments.add(comment);
        comment.setArticle(this);
    }
    
    
    public void removeComment(Comment comment) {
        Objects.requireNonNull(comment);
        if (comments == null) {
            return;
        }
        comments.removeIf(c -> Objects.equals(c.getId(), comment.getId()));
        comment.setArticle(null);
    } 
    
    //===AUTHOR==
    public User getUser() {
        return author;
    }
    public void setUser(User author) {
        this.author = author;
    }
    //===LIKES===
    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }
    
     public void addLike(Like like) {
          Objects.requireNonNull(like);
        if (likes == null) {
            this.likes = new ArrayList<>();
        }
        likes.add(like);
    }
    public void removeLike(Like like) {
        Objects.requireNonNull(like);
        if (likes == null) {
            return;
        }
        likes.removeIf(c -> Objects.equals(c.getId(), like.getId()));
    } 
    
    
    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", created=" + created +
                ", author=" + author +
                ", topics=" + topics +
                ", content=" + content +
              //  ", comments=" + comments +
              //  ", likes=" + likes +
                "}";
    }

    
}
