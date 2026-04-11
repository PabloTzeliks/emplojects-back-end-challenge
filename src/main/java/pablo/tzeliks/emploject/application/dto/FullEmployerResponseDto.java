package pablo.tzeliks.emploject.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record FullEmployerResponseDto(

        @JsonProperty("employer")
        EmployerResponseDto employer,

        @JsonProperty("projects")
        List<ProjectResponseDto> projects
) { }
