package com.github.navelogic.api.Service;

import com.github.navelogic.api.DTO.IssuerDTO;
import com.github.navelogic.api.Mapper.IssuerMapper;
import com.github.navelogic.api.Model.Issuer;
import com.github.navelogic.api.Repository.IssuerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IssuerCRUDService {

    private final IssuerRepository issuerRepository;

    public IssuerDTO create(IssuerDTO dto) {
        Issuer saved = issuerRepository.save(IssuerMapper.toEntity(dto));
        return IssuerMapper.toDTO(saved);
    }

    public List<IssuerDTO> findAll() {
        return issuerRepository.findAll()
                .stream()
                .map(IssuerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<IssuerDTO> findById(Long id) {
        return issuerRepository.findById(id)
                .map(IssuerMapper::toDTO);
    }

    public IssuerDTO update(Long id, IssuerDTO dto) {
        return issuerRepository.findById(id)
                .map(issuer -> {
                    issuer.setCnpj(dto.getCnpj());
                    issuer.setCorporateName(dto.getCorporateName());
                    issuer.setIssuerType(dto.getIssuerType());
                    issuer.setIssuerPort(dto.getIssuerPort());
                    issuer.setLatitude(dto.getLatitude());
                    issuer.setLongitude(dto.getLongitude());
                    issuer.setIsActive(dto.getIsActive());
                    return IssuerMapper.toDTO(issuerRepository.save(issuer));
                }).orElseThrow(() -> new RuntimeException("Emitente não encontrado"));
    }

    public void delete(Long id) {
        issuerRepository.deleteById(id);
    }
}
