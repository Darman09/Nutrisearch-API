package com.hitema.mongodb.springbootmongodb.repository;

import com.hitema.mongodb.springbootmongodb.document.Nutri;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface NutriRepository extends MongoRepository<Nutri, String> {

    @Query("{ 'nutrition_grades' : {$ne : null},'product_name_fr' : {$ne : null}  }")
    List<Nutri> findAllNotNullableProduct();

    @Query("{ 'countries' : ?0,'product_name_fr' : {$ne : null}   }")
    List<Nutri> findAllByPays(String pays);

    @Query("{ 'nutrition_grades' : ?0,'product_name_fr' : {$ne : null}   }")
    List<Nutri> findAllByCodeNutriscore(String nutriscore);
}
