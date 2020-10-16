package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import com.google.gson.Gson;

import events.OnMessageListener;
import model.Images;

public class UDP extends Thread {

	private DatagramSocket socket;
	private OnMessageListener observer;
	
	public void setObserver(OnMessageListener observer) {
		this.observer = observer;
	}
	
	public void run() {
		
		try {
			//1. Escuchar
			socket = new DatagramSocket(5000);
			
			//2 Esperar mensajes: DatagramSocket
			
			while(true) {
				//2 Params en constructor
				byte[] buffer = new byte[100];
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				System.out.println("Esperando datagrama");
				socket.receive(packet);
				
				//Aquí recibo los mensajes de Android
				String mensaje = new String(packet.getData()).trim();		
				System.out.println("Datagrama recibido: "+ mensaje);
				
				Gson gson = new Gson();
				
				//No es necesario los Generic porque solo tengo una clase, si tuviera más deberia crearlo.
				Images images = gson.fromJson(mensaje, Images.class);
				System.out.println("Imagen :" + images);
				observer.onImagesReceive(images);
			}
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String mensaje) {
		//4 params, datagrama de envio
		new Thread(
			() -> {
				try {
					InetAddress ip = InetAddress.getByName("192.168.1.18");
					DatagramPacket packet = new DatagramPacket(mensaje.getBytes(),mensaje.getBytes().length,ip, 6000);
					socket.send(packet);
					
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		).start();	
	}
	
}
