/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.packetanalyzer;

/**
 *
 * @author nanribet
 */
import java.net.*;     /*importing java package for network functionalities*/
public class Packetanalyzer {

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(12345);){
             /*creating socket to capture network packets on specified port*/
            
            /*capture packets continously*/
            while (true) {
            
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                
                /*recieve packets*/
                socket.receive(packet);
                
                /*extract data from packet and print it*/
                String packetdata = new String(packet.getData(), 0, packet.getLength());
                logger.log("Packet recieved: " + packetdata);
               
                return;
                
        }
        }catch (Exception e){
            e.printStackTrace();
                }
    }
}

