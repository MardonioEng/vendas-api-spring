package io.github.devmarodrigues.rest.controller;

import io.github.devmarodrigues.domain.entity.Usuario;
import io.github.devmarodrigues.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Bean
    public PasswordEncoder enconderPassword() {
        return new BCryptPasswordEncoder();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar(@RequestBody @Valid Usuario usuario) {
        String senhaCriptografada = enconderPassword().encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada); 
        return usuarioService.salvar(usuario);
    }

}
