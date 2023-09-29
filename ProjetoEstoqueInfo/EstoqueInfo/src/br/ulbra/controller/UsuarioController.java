/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.controller;

import br.ulbra.model.Usuario;
import br.ulbra.model.UsuarioDAO;
import com.sun.istack.internal.logging.Logger;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import sun.util.logging.PlatformLogger;

public class UsuarioController {

    private UsuarioDAO usuarioDAO;

    public UsuarioController() {
        usuarioDAO = new UsuarioDAO();
    }

    public boolean autenticarLogin(String login, String senha) {
        if (usuarioDAO.autenticar(login, senha)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Login ou senha incorreta! ");
            return false;
        }

    }

    
}
