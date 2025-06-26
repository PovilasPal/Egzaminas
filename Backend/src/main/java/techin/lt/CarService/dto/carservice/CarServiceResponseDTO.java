package techin.lt.CarService.dto.carservice;

public record CarServiceResponseDTO(
        Long id,
        String name,
        String address,
        String manager
) {
}
