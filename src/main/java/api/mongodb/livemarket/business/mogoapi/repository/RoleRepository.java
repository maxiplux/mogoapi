package api.mongodb.livemarket.business.mogoapi.repository;

import api.mongodb.livemarket.business.mogoapi.models.users.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {

    Optional<Role> findByName(String name);
}
