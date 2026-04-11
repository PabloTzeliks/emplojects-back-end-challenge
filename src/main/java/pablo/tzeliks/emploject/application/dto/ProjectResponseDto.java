package pablo.tzeliks.emploject.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProjectResponseDto(

        @JsonProperty(value = "name")
        Long id,

        @JsonProperty(value = "name")
        String name,

        @JsonProperty(value = "description")
        String description
) { }
