package com.Senac.Prova.controller;

import com.Senac.Prova.dto.CriarUsuarioDto;
import com.Senac.Prova.dto.JwtTokenDtoResponse;
import com.Senac.Prova.dto.LoginUsuarioDto;
import com.Senac.Prova.entity.Bolo;
import com.Senac.Prova.entity.Usuario;
import com.Senac.Prova.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping("/criarusuario")
    public ResponseEntity<Void>criarusuario(@RequestBody CriarUsuarioDto criarUsuarioDto){
      usuarioService.criarusuario(criarUsuarioDto);
      return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/listar")
    public ResponseEntity <List<Usuario>> listarTodos(){
        return ResponseEntity.ok(usuarioService.listarTodos());
    }

    @PostMapping("/login")
    public ResponseEntity<JwtTokenDtoResponse> loginusuario(@RequestBody LoginUsuarioDto loginUsuarioDto){
        JwtTokenDtoResponse tokenDto = usuarioService.autenticarUsuario(loginUsuarioDto);
        return new ResponseEntity<>(tokenDto, HttpStatus.OK);
    }

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    //todo criar usuario
}
