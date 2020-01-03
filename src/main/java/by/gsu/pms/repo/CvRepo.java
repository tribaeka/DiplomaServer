package by.gsu.pms.repo;

import by.gsu.pms.domain.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "cv", path = "cv")
public interface CvRepo extends JpaRepository<Cv, Long> {
}

