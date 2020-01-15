package by.gsu.pms.repo;

import by.gsu.pms.domain.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "cv", path = "cv")
public interface CvRepo extends JpaRepository<Cv, Long> {
}

