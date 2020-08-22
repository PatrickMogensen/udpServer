package com.company;

import javax.xml.crypto.Data;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
try {

    DatagramSocket dgs = new DatagramSocket(6780);
    System.out.println("Oprettet lytter efter klient");
    byte[] inArr = new  byte[1000];
    DatagramPacket inPacket = new DatagramPacket(inArr, inArr.length);

    Scanner scan = new Scanner(System.in);

    while (true){

        dgs.receive(inPacket);

        String inMessage = new String(inArr,0, inPacket.getLength());
        System.out.println(inMessage);
        String msg = scan.nextLine();

        byte[] outArr = msg.getBytes();

        DatagramPacket outPacket = new DatagramPacket(outArr, outArr.length, inPacket.getAddress(), inPacket.getPort());
        dgs.send(outPacket);


    }






}catch (Exception e){
    System.out.println(e);
}

    }
}
