package com.github.navelogic.api.DTO;

import com.github.navelogic.api.Enum.IssuerPortEnum;
import com.github.navelogic.api.Enum.IssuerTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IssuerDTO {
    private Long id;

    @CNPJ
    @NotBlank
    private String cnpj;

    @NotBlank
    private String corporateName;

    @NotNull
    private IssuerTypeEnum issuerType;

    @NotNull
    private IssuerPortEnum issuerPort;

    private Double latitude;
    private Double longitude;

    private Boolean isActive;
}
