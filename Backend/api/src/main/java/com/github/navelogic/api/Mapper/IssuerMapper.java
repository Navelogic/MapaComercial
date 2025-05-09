package com.github.navelogic.api.Mapper;

import com.github.navelogic.api.DTO.IssuerDTO;
import com.github.navelogic.api.Model.Issuer;

public class IssuerMapper {
    public static IssuerDTO toDTO(Issuer issuer) {
        return IssuerDTO.builder()
                .id(issuer.getId())
                .cnpj(issuer.getCnpj())
                .corporateName(issuer.getCorporateName())
                .issuerType(issuer.getIssuerType())
                .issuerPort(issuer.getIssuerPort())
                .latitude(issuer.getLatitude())
                .longitude(issuer.getLongitude())
                .isActive(issuer.getIsActive())
                .build();
    }

    public static Issuer toEntity(IssuerDTO dto) {
        return Issuer.builder()
                .id(dto.getId())
                .cnpj(dto.getCnpj())
                .corporateName(dto.getCorporateName())
                .issuerType(dto.getIssuerType())
                .issuerPort(dto.getIssuerPort())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .isActive(dto.getIsActive() != null ? dto.getIsActive() : true)
                .build();
    }
}