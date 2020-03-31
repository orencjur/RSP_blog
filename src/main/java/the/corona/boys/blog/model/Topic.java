/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.corona.boys.blog.model;

import javax.persistence.*;


@Entity
@Table(name="Topic")
public class Topic extends AbstractEntity {

    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Topic{" +
                "name='" + name + '\'' +
                "}";
    }

   
    
}
