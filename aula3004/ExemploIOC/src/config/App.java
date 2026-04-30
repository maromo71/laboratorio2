package config;

import core.Engine;
import infrastructure.EletricEngine;
import services.Car;

public class App {
    public static void main(String[] args) {
        //Nos atuamos como o Container IoC manual neste ponto
        Engine engine = new EletricEngine();
        //Injetando a dependencia do motor no carro
        Car car = new Car(engine);
        car.drive();
        
    }
}
