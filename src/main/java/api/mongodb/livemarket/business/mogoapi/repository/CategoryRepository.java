package api.mongodb.livemarket.business.mogoapi.repository;


import api.mongodb.livemarket.business.mogoapi.models.items.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "category", path = "categories")
public interface CategoryRepository extends MongoRepository<Category, String> {


}
