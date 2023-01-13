package com.project.project.controllers;

import com.project.project.dao.UsuarioDao;
import com.project.project.models.Usuario;
import com.project.project.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// gestionar el inicio de sesion
@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value="api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){

        Usuario usuarioLog = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
        if(usuarioLog != null){
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLog.getId()), usuarioLog.getEmail());
            return tokenJwt;
        }
        return "FAIL";
    }

}
