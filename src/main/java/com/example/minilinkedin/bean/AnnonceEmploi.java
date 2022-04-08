package com.example.minilinkedin.bean;

import javax.persistence.*;

@Entity
public class AnnonceEmploi {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String iceSociete;
    private String titreOffre;
    private String  descriptionOffre;


    public AnnonceEmploi() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getIceSociete() {
        return iceSociete;
    }

    public void setIceSociete(String iceSociete) {
        this.iceSociete = iceSociete;
    }

    public String getTitreOffre() {
        return titreOffre;
    }

    public void setTitreOffre(String titreOffre) {
        this.titreOffre = titreOffre;
    }

    public String getDescriptionOffre() {
        return descriptionOffre;
    }

    public void setDescriptionOffre(String descriptionOffre) {
        this.descriptionOffre = descriptionOffre;
    }


}