package pablo.tzeliks.emploject.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record CreateProjectRequestDto(

        @JsonProperty(value = "nome")
        @NotBlank
        String nome,

        @JsonProperty(value = "description")
        @NotBlank
        String description
) { }
