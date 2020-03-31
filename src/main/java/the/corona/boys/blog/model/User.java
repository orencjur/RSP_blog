/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.corona.boys.blog.model;

import java.util.List;
import javax.persistence.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Table(name="BlogUser")
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class User extends AbstractEntity {
    
    @Column(name = "firstname")
    @Basic(optional = false)
    private String firstName;
    
    
    @Column(name = "lastName")
    @Basic(optional = false)
    private String lastName;
    
    
    @Column(name = "username", unique = true)
    @Basic(optional = false)
    private String username;
    
    
    @Column(name = "password")
    @Basic(optional = false)
    private String password;
    
    
    @Enumerated(EnumType.STRING)
    private Role role;
    
    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
  //  @JoinColumn(name = "article_id")
    private List<Article> articles;
    
  
    
    public User() {
        this.role = Role.USER;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void encodePassword(PasswordEncoder encoder) {
        this.password = encoder.encode(password);
    }

    public void erasePassword() {
        this.password = null;
    }
    //===ROLE===
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    //===ARTICLE===
    public List<Article> getArticle(){
        return articles;
    }
    
    public void setArticle(List<Article> articles){
        this.articles = articles;
    }
    /*
     public void addArticle(Article article) {
        Objects.requireNonNull(article);
        if (article == null) {
            this.articles = new ArrayList<>();
        }
        articles.add(article);
    } 
    
    public void removeArticle(Article article) {
        Objects.requireNonNull(article);
        if (articles == null) {
            return;
        }
        articles.removeIf(c -> Objects.equals(c.getId(), article.getId()));
    }

    */

    @Override
    public String toString() {
        return "User{" +
                firstName + " " + lastName +
                "(" + username + ")}";
    }
    
}
