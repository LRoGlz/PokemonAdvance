/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemonadvance;

import java.util.ArrayList;

/**
 *
 * @author lrosellg
 */
public class Login {
    
    private boolean logged;
    
    public Trainer myLogin(String email, String password, ArrayList<Trainer> trainersList){
        for (Trainer t : trainersList){
            if (email.equals(t.getEmail()) && password.equals(t.getPassword())){
                logged=true;
                System.out.println("Ha iniciado sesión como "+t.getName());
                return t;
            }
        }
        System.out.println("La contraseña o el usuario no son correctos.");
        return null;
        
        
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    
    
    
}
