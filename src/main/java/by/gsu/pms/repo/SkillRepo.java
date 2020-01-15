package by.gsu.pms.repo;

import by.gsu.pms.domain.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "skill", path = "skill")
public interface SkillRepo extends JpaRepository<Skill, Long> {
}
