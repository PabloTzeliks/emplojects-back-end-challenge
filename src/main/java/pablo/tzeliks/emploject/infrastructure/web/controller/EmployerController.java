package pablo.tzeliks.emploject.infrastructure.web.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pablo.tzeliks.emploject.application.dto.CreateEmployerRequestDto;
import pablo.tzeliks.emploject.application.dto.EmployerResponseDto;
import pablo.tzeliks.emploject.application.dto.UpdateEmployerRequestDto;
import pablo.tzeliks.emploject.application.service.EmployerService;

import java.util.List;

@RestController
@RequestMapping("/api/employer")
public class EmployerController {

    private EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @PostMapping
    public ResponseEntity<EmployerResponseDto> addEmployer(@Valid @RequestBody CreateEmployerRequestDto requestDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(employerService.save(requestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployerResponseDto> getEmployer(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(employerService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<EmployerResponseDto>> getAllEmployer() {

        return ResponseEntity.status(HttpStatus.OK).body(employerService.findAll());
    }

    @PatchMapping
    public ResponseEntity<EmployerResponseDto> updateEmployer(@Valid @RequestBody UpdateEmployerRequestDto requestDto) {

        return ResponseEntity.status(HttpStatus.OK).body(employerService.update(requestDto));
    }
}
