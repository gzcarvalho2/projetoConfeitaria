package com.Senac.Prova.service;

import com.Senac.Prova.config.SecurityConfiguration;
import com.Senac.Prova.dto.CriarUsuarioDto;
import com.Senac.Prova.dto.JwtTokenDtoResponse;
import com.Senac.Prova.dto.LoginUsuarioDto;
import com.Senac.Prova.entity.Role;
import com.Senac.Prova.entity.RoleName;
import com.Senac.Prova.entity.Usuario;
import com.Senac.Prova.repository.UsuarioRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RoleService roleService;
    private final SecurityConfiguration securityConfiguration;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenService jwtTokenService;

    public UsuarioService(UsuarioRepository usuarioRepository, RoleService roleService, SecurityConfiguration securityConfiguration, AuthenticationManager authenticationManager, JwtTokenService jwtTokenService) {
        this.usuarioRepository = usuarioRepository;
        this.roleService = roleService;
        this.securityConfiguration = securityConfiguration;
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
    }

    public void criarusuario(CriarUsuarioDto criarUsuarioDto) {
        Role role;
        RoleName roleName = criarUsuarioDto.getRole();
        role = roleService.getRoleByName(roleName);

        Usuario usuario = new Usuario();
        usuario.setLogin(criarUsuarioDto.getLogin());
        usuario.setSenha(securityConfiguration.passwordEncoder().encode(criarUsuarioDto.getSenha()));
        usuario.setStatus(1);
        usuario.setRoles(List.of(role));

        Usuario usuarioSave = usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public JwtTokenDtoResponse autenticarUsuario(LoginUsuarioDto loginUsuarioDto) {

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken;
        usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginUsuarioDto.getLogin(),loginUsuarioDto.getSenha());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return new JwtTokenDtoResponse(jwtTokenService.generateToken(userDetails));
    }
}
