package com.hitema.mongodb.springbootmongodb.repository;

import com.hitema.mongodb.springbootmongodb.document.Favoris;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FavorisRepository extends MongoRepository<Favoris, String> {

    @Query("{ 'nutrition_grades' : {$ne : null},'product_name_fr' : {$ne : null}  }")
    List<Favoris> findAllNotNullableProduct();

}