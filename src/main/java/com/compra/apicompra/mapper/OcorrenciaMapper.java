package com.compra.apicompra.mapper;

import com.compra.apicompra.model.Ocorrencia;
import com.compra.apicompra.response.OcorrenciaResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OcorrenciaMapper {

    private ModelMapper modelMapper;

    public OcorrenciaResponse toModel(Ocorrencia ocorrencia){
        return modelMapper.map(ocorrencia, OcorrenciaResponse.class);
    }
    public List<OcorrenciaResponse> toCollectionModel(List<Ocorrencia> ocorrencias){
        return ocorrencias.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

}
