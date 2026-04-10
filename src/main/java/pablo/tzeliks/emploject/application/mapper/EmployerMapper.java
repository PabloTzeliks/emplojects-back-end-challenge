package pablo.tzeliks.emploject.application.mapper;

import org.springframework.stereotype.Component;
import pablo.tzeliks.emploject.application.dto.CreateEmployerRequestDto;
import pablo.tzeliks.emploject.application.dto.EmployerResponseDto;
import pablo.tzeliks.emploject.application.dto.UpdateEmployerRequestDto;
import pablo.tzeliks.emploject.domain.model.Employer;

@Component
public class EmployerMapper {

    public Employer toEntity(CreateEmployerRequestDto requestDto) {

        return new Employer(
                requestDto.name(),
                requestDto.phoneNumber()
        );
    }

    public Employer toEntity(UpdateEmployerRequestDto requestDto) {

        return new Employer(
                requestDto.id(),
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
