package com.example.minilinkedin.bean;

import javax.persistence.*;

@Entity
public class ReponseAnnonce{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ref;
    private String messageReponse;
    @ManyToOne
    private User user;
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

    public String getMessageReponse() {
        return messageReponse;
    }

    public void setMessageReponse(String messageReponse) {
        this.messageReponse = messageReponse;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AnnonceEmploi getAnnonceEmploi() {
        return annonceEmploi;
    }

    public void setAnnonceEmploi(AnnonceEmploi annonceEmploi) {
        this.annonceEmploi = annonceEmploi;
    }
}
