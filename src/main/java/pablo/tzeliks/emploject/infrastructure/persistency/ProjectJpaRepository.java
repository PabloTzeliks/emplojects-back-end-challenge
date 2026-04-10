package pablo.tzeliks.emploject.infrastructure.persistency;

import org.springframework.data.jpa.repository.JpaRepository;
import pablo.tzeliks.emploject.domain.model.Project;

public interface ProjectJpaRepository extends JpaRepository<Project, Long> {
}
