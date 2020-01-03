package by.gsu.pms.repo;

import by.gsu.pms.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "company", path = "company")
public interface CompanyRepo extends JpaRepository<Company, Long> {
}
