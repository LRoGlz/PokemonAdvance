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
public class Trainer {
    
    private String name;
    private String password;
    private String email;
    //Esta lista tiene los pokemon de un entrenador, el que esté llamando a esa lista
    private ArrayList<Pokemon> pokeball = new ArrayList();
    
    public Trainer(String name, String password, String email){
        this.name=name;
        this.password=password;
        this.email=email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Pokemon> getPokeball() {
        return pokeball;
    }

    public void setPokeball(ArrayList<Pokemon> pokeball) {
        this.pokeball = pokeball;
    }
    
    
    
    
}
