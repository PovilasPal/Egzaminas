package techin.lt.CarService.dto.carservice;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CarServiceRequestDTO(
        @NotNull(message = "Service name cannot be null")
        @Size(min = 2, max = 100, message = "Service name must be between 2 and 100 characters")
        String name,

        @Size(max = 255, message = "Address can be at most 255 characters")
        String address,

        @Size(min = 2, max = 100, message = "Manager name must be between 2 and 100 characters")
        String manager
) {
}
