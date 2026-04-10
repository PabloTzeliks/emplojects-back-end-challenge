package pablo.tzeliks.emploject.infrastructure.web.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pablo.tzeliks.emploject.application.dto.EmployerRequestDto;
import pablo.tzeliks.emploject.application.dto.EmployerResponseDto;
import pablo.tzeliks.emploject.application.service.EmployerService;

@RestController
@RequestMapping("/api/employer")
public class EmployerController {

    private EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @PostMapping
    public ResponseEntity<EmployerResponseDto> addEmployer(@Valid @RequestBody EmployerRequestDto requestDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(employerService.save(requestDto));
    }
}
