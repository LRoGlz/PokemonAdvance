/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.pokemonadvance;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lrosellg
 */
public class PokemonAdvance {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int opLogin;
        int opMain;
        int opFight;
        String dataEmail;
        String dataPassword;
        String dataTrainerName;
        
        PokemonList pList = new PokemonList();
        pList.addPokemonList();
        BBDD.setPokemonsBBDD(Wild.getWildPokemons());
        
        do {
            System.out.println("Bienvenido a Pokemon Advance, ¿qué quieres hacer? \n 1- Iniciar sesión \n 2- Registrarse ");
            opLogin = Integer.parseInt(sc.nextLine());
            switch (opLogin){
                case 1: 
                    System.out.println("Introduce el email");
                    dataEmail = sc.nextLine();
                    System.out.println("Introduce la contraseña");
                    dataPassword = sc.nextLine();
                    Login l = new Login();
                    Trainer tLogged = l.myLogin(dataEmail, dataPassword, BBDD.getTrainersBBDD());
                    if(!tLogged.isFirstSession()){
                        tLogged.getFirstPokemon();
                    }
                    
                    
                    while(l.isLogged()){
                        System.out.println("¿Qué quieres hacer ahora? \n 1- Buscar pokemon \n 2- Entrenar pokemon \n 3- Pelear contra otro entrenador \n 4- Acceder a la pokeball \n 5- Cerrar sesión");
                        opMain = Integer.parseInt(sc.nextLine());
                        switch (opMain){
                            case 1:
                                Pokemon enemy = tLogged.findPokemon(BBDD.getPokemonsBBDD());
                                System.out.println("¿Quieres pelear o huir?\n 1-Pelear\n2-huir");
                                opFight = Integer.parseInt(sc.nextLine());
                                switch(opFight){
                                    case 1:
                                        System.out.println("Elige con que Pokemon quieres pelear");
                                        tLogged.showPokeball();
                                        int indexFight = Integer.parseInt(sc.nextLine()) - 1;
                                        Pokemon chose = tLogged.choosePokemon(indexFight);
                                        chose.fight(enemy);
                                        boolean win = chose.fight(enemy);
                                        if(win){
                                            tLogged.catchPokemon(enemy);
                                        }
                                        else{
                                            System.out.println(enemy.getName()+" escapó!");
                                        }
                                        break;      
                                                
                                }
                                
                        }
                    }
                    
                    //Hay que seguir rellenando con todas las opciones del usuario logeado
                    break;
                case 2:
                    System.out.println("Elige tu nombre de entrenador Pokemon");
                    dataTrainerName = sc.nextLine();
                    System.out.println("Introduce el email");
                    dataEmail = sc.nextLine();
                    System.out.println("Introduce la contraseña");
                    dataPassword = sc.nextLine();
                    Register r = new Register();
                    r.setRegister(dataTrainerName, dataPassword, dataEmail, BBDD.getTrainersBBDD());
                    break;
                    
                    
            }

        } while (opLogin == 1 || opLogin == 2);
    }
}
