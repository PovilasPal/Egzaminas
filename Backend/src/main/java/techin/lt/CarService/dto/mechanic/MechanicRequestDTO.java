package techin.lt.CarService.dto.mechanic;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MechanicRequestDTO(

        @NotNull(message = "First name cannot be null")
        @Size(min = 2, max = 100, message = "First name must be between 2 and 100 characters")
        String firstName,

        @NotNull(message = "Last name cannot be null")
        @Size(min = 2, max = 100, message = "Last name must be between 2 and 100 characters")
        String lastName,

        @NotNull(message = "Specialization cannot be null")
        @Size(min = 2, max = 100, message = "Specialization must be between 2 and 100 characters")
        String specialization,

        @NotNull(message = "City cannot be null")
        @Size(min = 2, max = 100, message = "City must be between 2 and 100 characters")
        String city,

        Long serviceId // ID of the CarService
) {
}
