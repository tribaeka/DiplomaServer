package by.gsu.pms.repo;

import by.gsu.pms.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepo extends JpaRepository<Location, Long> {
}
