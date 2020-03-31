/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.corona.boys.blog.dao;

import the.corona.boys.blog.model.Topic;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;


@Repository
public class TopicDao extends BaseDao<Topic>{
    
    public TopicDao(){
        super(Topic.class);
    }
    
    @Override
    public List<Topic> findAll() {
        return em.createQuery("SELECT t FROM Topic t", Topic.class).getResultList();
    }
    
     public List<Topic> findAll(String name){
        Objects.requireNonNull(name);
        return em.createNamedQuery("Topic.findByName", Topic.class).setParameter("name", name)
                 .getResultList();
    }
    
    
}
