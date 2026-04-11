package pablo.tzeliks.emploject.application.mapper;

import org.springframework.stereotype.Component;
import pablo.tzeliks.emploject.application.dto.*;
import pablo.tzeliks.emploject.domain.model.Employer;
import pablo.tzeliks.emploject.domain.model.Project;

@Component
public class ProjectMapper {

    public Project toEntity(CreateProjectRequestDto requestDto) {

        return new Project(
                requestDto.nome(),
                requestDto.description()
        );
    }

    public Project toEntity(UpdateProjectRequestDto requestDto) {

        return new Project(
                requestDto.id(),
                requestDto.name(),
                requestDto.description()
        );
    }

    public ProjectResponseDto toDto(Project entity) {

        return new ProjectResponseDto(
                entity.getId(),
                entity.getNome(),
                entity.getDescription()
        );
    }
}
