package com.unir.busquedaunir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.busquedaunir.entities.ClienteEntity;
import com.unir.busquedaunir.models.Dto.ClienteDto;
import com.unir.busquedaunir.repositories.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
	public List<ClienteEntity> getCliente(ClienteDto clienteDto) {
		if (clienteDto.getNombre() != null)
			return clienteRepository.findByNombre(clienteDto.getNombre());
		if (clienteDto.getApellido() != null)
			return clienteRepository.findByApellido(clienteDto.getApellido());
		if (clienteDto.getTipoDocumento() != null)
			return clienteRepository.findByTipoDocumento(clienteDto.getTipoDocumento());
		if (clienteDto.getDocumento() != null)
			return clienteRepository.findByDocumento(clienteDto.getDocumento());
		if (clienteDto.getTelefono() != null)
			return clienteRepository.findByTelefono(clienteDto.getTelefono());
		

		return null;
	}
}
