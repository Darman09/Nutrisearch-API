package com.hitema.mongodb.springbootmongodb.document;

import org.springframework.data.annotation.Id;

public class Favoris {

    @Id
    private String id;

    /**
     * id du produit favoris
     */
    private String idproduit;


    public Favoris(String id, String idproduit) {
        this.id = id;
        this.idproduit = idproduit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(String idproduit) {
        this.idproduit = idproduit;
    }
}
