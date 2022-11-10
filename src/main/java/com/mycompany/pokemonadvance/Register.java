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
public class Register {
    
    //Este método añade entrenadores a la base de datos
    
    public void setRegister(String name, String password, String email, ArrayList<Trainer> trainersList){
        Trainer trainer = new Trainer(name,password,email);
        trainersList.add(trainer);
        System.out.println("Entrenador registrado.");
    }
    
}
