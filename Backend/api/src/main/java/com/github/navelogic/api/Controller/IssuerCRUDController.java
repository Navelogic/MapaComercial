package com.github.navelogic.api.Controller;

import com.github.navelogic.api.DTO.IssuerDTO;
import com.github.navelogic.api.Service.IssuerCRUDService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/issuer/crud")
@RequiredArgsConstructor
public class IssuerCRUDController {

    private final IssuerCRUDService issuerCRUDService;

    @PostMapping
    public ResponseEntity<IssuerDTO> create(@Valid @RequestBody IssuerDTO dto) {
        return ResponseEntity.ok(issuerCRUDService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<IssuerDTO>> findAll() {
        return ResponseEntity.ok(issuerCRUDService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssuerDTO> findById(@PathVariable Long id) {
        return issuerCRUDService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<IssuerDTO> update(@PathVariable Long id, @Valid @RequestBody IssuerDTO dto) {
        return ResponseEntity.ok(issuerCRUDService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        issuerCRUDService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
