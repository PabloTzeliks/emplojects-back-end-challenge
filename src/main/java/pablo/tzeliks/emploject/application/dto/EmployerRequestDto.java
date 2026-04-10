package pablo.tzeliks.emploject.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record EmployerRequestDto(

        @JsonProperty(value = "name")
        @NotBlank(message = "Phone Number cannot be blank")
        String name,

        @JsonProperty(value = "phone_number")
        @NotBlank(message = "Phone Number cannot be blank")
        String phoneNumber
) { }
