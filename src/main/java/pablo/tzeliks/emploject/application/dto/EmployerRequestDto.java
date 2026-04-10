package pablo.tzeliks.emploject.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record EmployerRequestDto(

        @JsonProperty(value = "name")
        @NotBlank
        String name,

        @JsonProperty(value = "phone_number")
        @NotBlank
        String phoneNumber
) { }
