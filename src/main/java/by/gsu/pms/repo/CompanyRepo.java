package by.gsu.pms.repo;

import by.gsu.pms.domain.Company;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "company", path = "company")
public interface CompanyRepo extends PagingAndSortingRepository<Company, Long> {
}
