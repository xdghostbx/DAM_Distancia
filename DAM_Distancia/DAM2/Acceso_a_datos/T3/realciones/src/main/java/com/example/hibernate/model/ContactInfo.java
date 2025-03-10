package com.example.hibernate.model;
// Generated 18 feb 2025 15:27:13 by Hibernate Tools 6.6.0.Final


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import org.hibernate.annotations.GenericGenerator;

/**
 * Contactinfo generated by hbm2java
 */
@Entity
@Table(name="contactinfo"
    , uniqueConstraints = @UniqueConstraint(columnNames="email") 
)
public class ContactInfo  implements java.io.Serializable {


     private Integer profesorId;
     private Profesor profesor;
     private String email;
     private String tlfMovil;

    public ContactInfo() {
    }

	
    public ContactInfo(Profesor profesor, String email) {
        this.profesor = profesor;
        this.email = email;
    }
    public ContactInfo(Profesor profesor, String email, String tlfMovil) {
       this.profesor = profesor;
       this.email = email;
       this.tlfMovil = tlfMovil;
    }
   
     //@GenericGenerator(name="com.example.hibernate.model.ContactinfoIdGenerator", strategy="foreign")@Id @GeneratedValue(generator="com.example.hibernate.model.ContactinfoIdGenerator")
    @Id @GeneratedValue
    
    @Column(name="profesorId", unique=true, nullable=false)
    public Integer getProfesorId() {
        return this.profesorId;
    }
    
    public void setProfesorId(Integer profesorId) {
        this.profesorId = profesorId;
    }

@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public Profesor getProfesor() {
        return this.profesor;
    }
    
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    
    @Column(name="email", unique=true, nullable=false, length=255)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="tlf_movil", length=15)
    public String getTlfMovil() {
        return this.tlfMovil;
    }
    
    public void setTlfMovil(String tlfMovil) {
        this.tlfMovil = tlfMovil;
    }




}


