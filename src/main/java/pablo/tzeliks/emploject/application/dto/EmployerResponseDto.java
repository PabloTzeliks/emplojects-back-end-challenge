package pablo.tzeliks.emploject.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import pablo.tzeliks.emploject.domain.model.Project;

import java.util.List;

public record EmployerResponseDto(

        @JsonProperty(value = "id")
        Long id,

        @JsonProperty(value = "name")
        String name,

        @JsonProperty(value = "phone_number")
        String phoneNumber,

        @JsonProperty(value = "projects")
        List<Project> projects
) { }
