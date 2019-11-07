package com.hitema.mongodb.springbootmongodb.document;

import org.springframework.data.annotation.Id;

public class Nutri {

    @Id
    private String id;

    /**
     * Nom du produit
     */
    private String product_name_fr;

    /**
     * Grade de nutrition
     */
    private String nutrition_grades;
    private String packaging;
    private String countries;
    private String manufacturing_places;
    private String categories;
    private String ingredients_text_with_allergens_fr;
    private String quantity;


    public Nutri(String id, String product_name_fr, String nutrition_grades, String packaging, String manufacturing_places, String countries, String categories, String ingredients_text_with_allergens_fr, String quantity) {
        this.id = id;
        this.product_name_fr = product_name_fr;
        this.nutrition_grades = nutrition_grades;
        this.packaging = packaging;
        this.manufacturing_places = manufacturing_places;
        this.countries = countries;
        this.categories = categories;
        this.ingredients_text_with_allergens_fr = ingredients_text_with_allergens_fr;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNutritionGrade() {
        return nutrition_grades;
    }

    public void setNutritionGrade(String nutritionGrade) {
        this.nutrition_grades = nutritionGrade;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public String getPaysOrigine() {
        return countries;
    }

    public void setPaysOrigine(String paysOrigine) {
        this.countries = paysOrigine;
    }

    public String getPaysVente() {
        return manufacturing_places;
    }

    public void setPaysVente(String paysVente) {
        this.manufacturing_places = paysVente;
    }

    public String getCategorie() {
        return categories;
    }

    public void setCategorie(String categorie) {
        this.categories = categorie;
    }

    public String getIngredientDescription() {
        return ingredients_text_with_allergens_fr;
    }

    public void setIngredientDescription(String ingredientDescription) {
        this.ingredients_text_with_allergens_fr = ingredientDescription;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getNomProduit() {
        return product_name_fr;
    }

    public void setNomProduit(String nomProduit) {
        this.product_name_fr = nomProduit;
    }
}
