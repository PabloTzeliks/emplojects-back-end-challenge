package pablo.tzeliks.emploject.application.mapper;

import org.springframework.stereotype.Component;
import pablo.tzeliks.emploject.application.dto.EmployerRequestDto;
import pablo.tzeliks.emploject.application.dto.EmployerResponseDto;
import pablo.tzeliks.emploject.domain.model.Employer;

@Component
public class EmployerMapper {

    public Employer toEntity(EmployerRequestDto requestDto) {

        return new Employer(
                requestDto.name(),
                requestDto.phoneNumber()
        );
    }

    public EmployerResponseDto toDto(Employer entity) {

        return new EmployerResponseDto(
                entity.getId(),
                entity.getNome(),
                entity.getPhoneNumber(),
                entity.getProjects()
        );
    }
}
