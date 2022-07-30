package com.compra.apicompra.mapper;

import com.compra.apicompra.model.Entrega;
import com.compra.apicompra.requestDTO.EntregaRequest;
import com.compra.apicompra.response.EntregaResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class EntregaMapper {

    private ModelMapper modelMapper;

    public EntregaResponse toModel(Entrega entrega){
        return modelMapper.map(entrega, EntregaResponse.class);

    }

    public List<EntregaResponse> toCollectionService(List<Entrega> entregas){
        return entregas.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
    public Entrega toEntity(EntregaRequest entregaRequest){
        return modelMapper.map(entregaRequest, Entrega.class);
    }
}
