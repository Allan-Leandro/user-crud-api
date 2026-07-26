package com.allan.user_crud_api.controller;


import com.allan.user_crud_api.Service.UsuarioService;
import com.allan.user_crud_api.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarTodos(){
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id){
        return usuarioService.buscarPorId(id);
    }

    @PostMapping
    public Usuario criar(@Valid @RequestBody Usuario usuario){
        return usuarioService.criar(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuario){
        return usuarioService.atualizar(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        usuarioService.deletar(id);
    }
}
