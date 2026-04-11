package pablo.tzeliks.emploject.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateEmployerRequestDto(

        @JsonProperty(value = "id")
        @NotNull(message = "ID cannot be null")
        Long id,

        @JsonProperty(value = "name")
        @NotBlank(message = "Name cannot be blank")
        String name,

        @JsonProperty(value = "phone_number")
        @NotBlank(message = "Phone Number cannot be blank")
        String phoneNumber
) { }
