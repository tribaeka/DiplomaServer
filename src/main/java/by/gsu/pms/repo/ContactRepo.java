package by.gsu.pms.repo;

import by.gsu.pms.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "contact", path = "contact")
public interface ContactRepo extends JpaRepository<Contact, Long> {
}
