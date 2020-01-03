package by.gsu.pms.repo;

import by.gsu.pms.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepo extends JpaRepository<User, Long> {
}
