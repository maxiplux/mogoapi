package api.mongodb.livemarket.business.mogoapi.repository;


import api.mongodb.livemarket.business.mogoapi.models.items.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "item", path = "items")
public interface ItemRepository extends MongoRepository<Item, String> {



    List<Item> findByName(String term);

    List<Item> findByNameContainingIgnoreCase(String term);

    void deleteById(String id);

    List<Item> findByNameStartingWithIgnoreCase(String term);

}
