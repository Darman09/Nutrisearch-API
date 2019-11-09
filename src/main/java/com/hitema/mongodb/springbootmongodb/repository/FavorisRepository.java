package com.hitema.mongodb.springbootmongodb.repository;

import com.hitema.mongodb.springbootmongodb.document.Favoris;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FavorisRepository extends MongoRepository<Favoris, String> {

    @Query("{}")
    List<Favoris> findAllNotNullableProduct();

    @Query("{'idproduit' : ?0}")
    List<Favoris> findProduitById(String idProduit);

}