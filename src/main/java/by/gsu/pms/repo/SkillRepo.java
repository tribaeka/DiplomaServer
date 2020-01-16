package by.gsu.pms.repo;

import by.gsu.pms.domain.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepo extends JpaRepository<Skill, Long> {
}
