package pablo.tzeliks.emploject.application.service;

import org.springframework.stereotype.Service;
import pablo.tzeliks.emploject.application.dto.CreateProjectRequestDto;
import pablo.tzeliks.emploject.application.dto.ProjectResponseDto;
import pablo.tzeliks.emploject.application.mapper.ProjectMapper;
import pablo.tzeliks.emploject.domain.exception.ResourceNotFoundException;
import pablo.tzeliks.emploject.infrastructure.persistency.ProjectJpaRepository;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectJpaRepository projectRepository;
    private final ProjectMapper mapper;

    public ProjectService(ProjectJpaRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.mapper = projectMapper;
    }

    public ProjectResponseDto addProject(CreateProjectRequestDto project) {

        var projectEntity = mapper.toEntity(project);

        var projectSaved = projectRepository.save(projectEntity);

        return mapper.toDto(projectSaved);
    }

    public ProjectResponseDto findById(Long id) {

        var projectEntity = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));

        return mapper.toDto(projectEntity);
    }

    public List<ProjectResponseDto> findAll() {

        var projectEntities = projectRepository.findAll();

        if (projectEntities.isEmpty()) {
            throw new ResourceNotFoundException("Project not found");
        }

        return projectEntities.stream()
                .map(mapper::toDto)
                .toList();
    }

    public ProjectResponseDto updateProject(Long id, CreateProjectRequestDto project) {

        if (!projectRepository.existsById(id)) {
            throw new ResourceNotFoundException("Project not found");
        }

        var projectEntity = mapper.toEntity(project);

        return mapper.toDto(projectRepository.save(projectEntity));
    }

    public void deleteProject(Long id) {

        if (!projectRepository.existsById(id)) {
            throw new ResourceNotFoundException("Project not found");
        }

        projectRepository.deleteById(id);
    }
}
