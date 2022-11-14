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

    static Login l;
    static boolean session;
    static boolean win;
    static Trainer tLogged;
    static Scanner sc = new Scanner(System.in);
    static int opLogin;
    static int opMain;
    static int opFight;
    static String dataEmail;
    static String dataPassword;
    static String dataTrainerName;
    static BBDD bbdd = BBDD.getInstance();

    public static void main(String[] args) {
        PokemonList pList = new PokemonList();
        pList.addPokemonList();
        
        bbdd.setPokemonsBBDD(Wild.getWildPokemons());

        do {
            System.out.println("Bienvenido a Pokemon Advance, ¿qué quieres hacer? \n 1- Iniciar sesión \n 2- Registrarse ");
            opLogin = Integer.parseInt(sc.nextLine());
            switch (opLogin) {
                case 1:
                    session = login();
                    while (session) {
                        System.out.println("¿Qué quieres hacer ahora? \n 1- Buscar pokemon \n 2- Entrenar pokemon \n 3- Pelear contra otro entrenador \n 4- Acceder a la pokeball \n 5- Cerrar sesión");
                        opMain = Integer.parseInt(sc.nextLine());
                        switch (opMain) {
                            case 1:
                                searchPokemon();
                                break;
                            case 2:
                                trainPokemon();
                                break;
                            case 3:
                                fightEnemy();
                                break;
                            case 4:
                                tLogged.showPokeball();
                                break;
                                
                            case 5:
                                logOut();
                                break;

                        }
                    }

                    //Hay que seguir rellenando con todas las opciones del usuario logeado
                    break;
                case 2:
                    register();
                    System.out.println("Entrenador registrado.");
                    break;

            }

        } while (opLogin == 1 || opLogin == 2);
    }

    public static boolean login() {
        System.out.println("Introduce el email");
        dataEmail = sc.nextLine();
        System.out.println("Introduce la contraseña");
        dataPassword = sc.nextLine();
        l = new Login();
        tLogged = l.myLogin(dataEmail, dataPassword, bbdd.getTrainersBBDD());
        if (!tLogged.isFirstSession()) {
            tLogged.getFirstPokemon();
        }
        return l.isLogged();
    }

    public static void register() {
        System.out.println("Elige tu nombre de entrenador Pokemon");
        dataTrainerName = sc.nextLine();
        System.out.println("Introduce el email");
        dataEmail = sc.nextLine();
        System.out.println("Introduce la contraseña");
        dataPassword = sc.nextLine();
        Register r = new Register();
        r.setRegister(dataTrainerName, dataPassword, dataEmail, bbdd.getTrainersBBDD());
    }

    public static void searchPokemon() {
        Pokemon enemy = tLogged.findPokemon(BBDD.getPokemonsBBDD());
        System.out.println("¿Quieres pelear o huir?\n 1-Pelear\n2-huir");
        opFight = Integer.parseInt(sc.nextLine());
        switch (opFight) {
            case 1:
                System.out.println("Elige con que Pokemon quieres pelear");
                tLogged.showPokeball();
                int indexFight = Integer.parseInt(sc.nextLine()) - 1;
                Pokemon chose = tLogged.choosePokemon(indexFight);
                win = chose.comparePokemons(enemy);
                if (win) {
                    System.out.println("Has ganado!!");
                    tLogged.catchPokemon(enemy);
                } else {
                    System.out.println("Has Perdido!");
                    System.out.println(enemy.getName() + " escapó!");
                }
                break;

        }
    }

    public static void trainPokemon() {
        System.out.println("¿Qué pokemon quieres entrenar?");
        tLogged.showPokeball();
        int indexTrain = Integer.parseInt(sc.nextLine()) - 1;
        Pokemon chose = tLogged.choosePokemon(indexTrain);
        chose.train();
        System.out.println(chose.getName() + " ha subido a nivel " + chose.getLevel());

    }

    public static void fightEnemy() {
        System.out.println("¿Contra quién quieres luchar?");
        tLogged.showTrainers();
        int indexTrainer = Integer.parseInt(sc.nextLine()) - 1;
        Trainer choseEnemy = tLogged.chooseEnemy(indexTrainer);
        System.out.println("Elige con que Pokemon quieres pelear");
        tLogged.showPokeball();
        int indexFight = Integer.parseInt(sc.nextLine()) - 1;
        Pokemon chose = tLogged.choosePokemon(indexFight);
        Pokemon pokemonEnemy = chose.fightEnemy(choseEnemy);
        System.out.println("Vas a luchar contra un "+pokemonEnemy.getName()+" de fuerza "+pokemonEnemy.getPower());
        win = chose.comparePokemons(pokemonEnemy);
        if(win){
            System.out.println("Has ganado!");
            tLogged.catchPokemon(pokemonEnemy);
            System.out.println("Has robado a "+choseEnemy.getName()+" su "+pokemonEnemy.getName());
            choseEnemy.removePokemon(pokemonEnemy);
        }
            else {
                    choseEnemy.catchPokemon(chose);
                    tLogged.removePokemon(chose);
                    System.out.println("Has perdido y te han robado a "+chose.getName());
                    
                    
            }
        

    }
    
    public static void logOut(){
        session = false;
    }
}
