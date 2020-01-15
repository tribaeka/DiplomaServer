package by.gsu.pms.repo;

import by.gsu.pms.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "job", path = "job")
public interface JobRepo extends JpaRepository<Job, Long> {
}
