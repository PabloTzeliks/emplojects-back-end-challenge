package pablo.tzeliks.emploject.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record FullProjectResponseDto(

        @JsonProperty("project")
        ProjectResponseDto project,

        @JsonProperty("employers")
        List<EmployerResponseDto> employers
) { }
