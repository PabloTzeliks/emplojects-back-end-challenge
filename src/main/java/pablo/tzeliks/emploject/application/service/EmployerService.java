package pablo.tzeliks.emploject.application.service;

import org.springframework.stereotype.Service;
import pablo.tzeliks.emploject.application.dto.EmployerRequestDto;
import pablo.tzeliks.emploject.application.dto.EmployerResponseDto;
import pablo.tzeliks.emploject.application.mapper.EmployerMapper;
import pablo.tzeliks.emploject.domain.exception.InvalidPhoneNumberException;
import pablo.tzeliks.emploject.domain.model.Employer;
import pablo.tzeliks.emploject.infrastructure.persistency.EmployerJpaRepository;

import java.util.List;

@Service
public class EmployerService {

    private final EmployerJpaRepository employerRepository;
    private final EmployerMapper mapper;

    public EmployerService(EmployerJpaRepository employerRepository, EmployerMapper mapper) {
        this.employerRepository = employerRepository;
        this.mapper = mapper;
    }

    public EmployerResponseDto save(EmployerRequestDto requestDto) {

        if (requestDto.phoneNumber().length() != 11) {
            throw new InvalidPhoneNumberException("Invalid phone number, must be 11 digits");
        }

        var employer = mapper.toEntity(requestDto);

        var savedEmployer = employerRepository.save(employer);

        return mapper.toDto(savedEmployer);
    }

    public Employer findById(Long id) {

        return null;
    }

    public List<Employer> findAll() {

        return null;
    }

    public void delete(Long id) {
    }

    public Employer update(Employer employer) {

        return null;
    }
}
