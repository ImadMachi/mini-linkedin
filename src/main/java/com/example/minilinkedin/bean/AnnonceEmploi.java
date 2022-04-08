package com.example.minilinkedin.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class AnnonceEmploi {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ref;
    private String iceSociete;
    private String titreOffre;
    private String  descriptionOffre;
    @OneToMany (mappedBy = "annonceEmploi")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    List<ReponseAnnonce> reponseAnnonces;

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

    public List<ReponseAnnonce> getReponseAnnonceEmplois() {
        return reponseAnnonces;
    }

    public void setReponseAnnonceEmplois(List<ReponseAnnonce> reponseAnnonceEmplois) {
        this.reponseAnnonces = reponseAnnonceEmplois;
    }
}