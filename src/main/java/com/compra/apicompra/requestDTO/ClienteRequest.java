package com.compra.apicompra.requestDTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class ClienteRequest {

    @NotNull
    private Long id;
}
