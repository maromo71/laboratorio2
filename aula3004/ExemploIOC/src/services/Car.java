package services;

import core.Engine;

public class Car {
    private final Engine engine;

    public Car(Engine engine){
        this.engine = engine;
    }

    public void drive(){
        //Iniciar o carro para dirigir
        this.engine.start();
        System.out.println("Carro em Movimento");
    }
}
