package techin.lt.CarService.dto.mechanic;

public record MechanicResponseDTO(
        Long id,
        String firstName,
        String lastName,
        String specialization,
        String city,
        Long serviceId
) {
}
