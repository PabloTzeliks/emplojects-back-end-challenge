package pablo.tzeliks.emploject.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateProjectRequestDto (

        @JsonProperty(value = "id")
        @NotNull(message = "ID cannot be null")
        Long id,

        @JsonProperty(value = "name")
        @NotBlank(message = "Name cannot be blank")
        String name,

        @JsonProperty(value = "description")
        @NotBlank(message = "Description cannot be blank")
        String description
) { }
