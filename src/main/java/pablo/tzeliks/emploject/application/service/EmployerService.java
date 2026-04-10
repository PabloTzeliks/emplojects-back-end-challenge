package pablo.tzeliks.emploject.application.service;

import org.springframework.stereotype.Service;
import pablo.tzeliks.emploject.application.dto.CreateEmployerRequestDto;
import pablo.tzeliks.emploject.application.dto.EmployerResponseDto;
import pablo.tzeliks.emploject.application.dto.UpdateEmployerRequestDto;
import pablo.tzeliks.emploject.application.mapper.EmployerMapper;
import pablo.tzeliks.emploject.domain.exception.InvalidPhoneNumberException;
import pablo.tzeliks.emploject.domain.exception.ResourceNotFoundException;
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

    public EmployerResponseDto save(CreateEmployerRequestDto requestDto) {

        if (requestDto.phoneNumber().length() != 11) {
            throw new InvalidPhoneNumberException("Invalid phone number, must be 11 digits");
        }

        var employer = mapper.toEntity(requestDto);

        var savedEmployer = employerRepository.save(employer);

        return mapper.toDto(savedEmployer);
    }

    public EmployerResponseDto findById(Long id) {

        var savedEmployer = employerRepository.findById(id);

        if (savedEmployer.isEmpty()) {
            throw new ResourceNotFoundException("Employee with id " + id + " not found");
        }

        return mapper.toDto(savedEmployer.get());
    }

    public List<EmployerResponseDto> findAll() {

        var savedEmployers = employerRepository.findAll();

        if (savedEmployers.isEmpty()) {
            throw new ResourceNotFoundException("There are no employers");
        }

        return savedEmployers.stream()
                .map(mapper::toDto)
                .toList();
    }

    public void delete(Long id) {

        if (!employerRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employee with id " + id + " not found");
        }

        employerRepository.deleteById(id);
    }

    public EmployerResponseDto update(UpdateEmployerRequestDto requestDto) {

        if (!employerRepository.existsById(requestDto.id())) {
            throw new ResourceNotFoundException("Employee with id " + requestDto.id() + " not found");
        }

        var employer = mapper.toEntity(requestDto);

        var updatedEmployer = employerRepository.save(employer);

        return mapper.toDto(updatedEmployer);
    }
}
