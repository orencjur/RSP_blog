/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.corona.boys.blog.dao;

import the.corona.boys.blog.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;


@Repository
public class UserDao extends BaseDao<User> {

    public UserDao() {
        super(User.class);
    }

    public User findByUsername(String username) {
        try {
            return em.createNamedQuery("User.findByUsername", User.class).setParameter("username", username)
                     .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
