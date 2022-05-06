package com.servicio.RotarMatriz.controllers;

import com.servicio.RotarMatriz.Models.Usuario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatrizController {

    @RequestMapping(value = "usuario")
    public Usuario getUsuario(){
        Usuario user = new Usuario();
        user.setApellido("rodr");
        user.setNombre("oli");
        return user;
    }
}
