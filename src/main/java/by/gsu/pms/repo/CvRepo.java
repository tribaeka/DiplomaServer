package by.gsu.pms.repo;

import by.gsu.pms.domain.Cv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvRepo extends JpaRepository<Cv, Long> {
}

