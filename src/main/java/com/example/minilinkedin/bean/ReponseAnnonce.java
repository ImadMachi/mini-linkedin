package com.example.minilinkedin.bean;

import javax.persistence.*;

@Entity
public class ReponseAnnonce{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ref;
    private String refAnnonce;
    private String messageReponse;
    @ManyToOne
    private User User;
    @ManyToOne
    private AnnonceEmploi annonceEmploi;
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

    public String getRefAnnonce() {
        return refAnnonce;
    }

    public void setRefAnnonce(String refAnnonce) {
        this.refAnnonce = refAnnonce;
    }

    public String getMessageReponse() {
        return messageReponse;
    }

    public void setMessageReponse(String messageReponse) {
        this.messageReponse = messageReponse;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User user) {
        User = user;
    }

    public AnnonceEmploi getAnnonceEmploi() {
        return annonceEmploi;
    }

    public void setAnnonceEmploi(AnnonceEmploi annonceEmploi) {
        this.annonceEmploi = annonceEmploi;
    }
}
