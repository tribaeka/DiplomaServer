package by.gsu.pms.repo;

import by.gsu.pms.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepo extends PagingAndSortingRepository<User, Long> {
}
