package com.firecode.app.controller.rule;

import com.firecode.app.controller.dto.ClienteDto;
import com.firecode.app.model.entity.PessoaEntity;
import com.firecode.app.model.service.ClienteService;
import com.firecode.app.model.service.PessoaService;
import java.net.URI;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class ClienteRule {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ClienteService clienteService;

    private ClienteDto clienteDto;

    public ResponseEntity<ClienteDto> create(ClienteDto dto, HttpServletResponse response) {
        clienteDto = new ClienteDto();
        PessoaEntity pessoa = pessoaService.create(clienteDto.create(dto));
        
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(pessoa.getClienteEntity().getId()).toUri();
        response.setHeader("Location", uri.toASCIIString());

        ClienteDto cliente = clienteDto.responseObject(pessoa);

        return ResponseEntity.created(uri).body(cliente);
    }

    public ResponseEntity<Iterable<ClienteDto>> findAll() {
        clienteDto = new ClienteDto();
        List<ClienteDto> clientes = clienteDto.list(clienteService.findAll("id"));
        return !clientes.isEmpty() ? ResponseEntity.ok(clientes) : ResponseEntity.status(204).build();
    }

    public ResponseEntity<ClienteDto> findById(int id) {
        clienteDto = new ClienteDto();
        ClienteDto cliente = clienteDto.find(clienteService.findById(id));
        return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.status(404).build();

    }

}
