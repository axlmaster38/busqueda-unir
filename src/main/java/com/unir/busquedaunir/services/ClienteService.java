package com.unir.busquedaunir.services;

import java.util.List;

import com.unir.busquedaunir.entities.ClienteEntity;
import com.unir.busquedaunir.models.Dto.ClienteDto;

public interface ClienteService {


	public List<ClienteEntity> getCliente(ClienteDto clienteDto);

}
