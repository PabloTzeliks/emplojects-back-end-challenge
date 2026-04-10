package pablo.tzeliks.emploject.infrastructure.persistency;

import org.springframework.data.jpa.repository.JpaRepository;
import pablo.tzeliks.emploject.domain.model.Employer;

public interface EmployerJpaRepository extends JpaRepository<Employer, Long> {
}
