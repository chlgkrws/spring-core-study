package com.study.autowired.test;

public class Client {

    Actor actor;

    public Client(Actor actor){
        this.actor = actor;
    }

    public void accept(){
        actor.acting();
    }

    public static void main(String[] args) {
        Client client = new Client(new A());   // or B

        client.accept();
    }
}
