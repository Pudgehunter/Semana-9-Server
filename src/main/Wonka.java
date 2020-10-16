package main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import events.OnMessageListener;
import model.Images;
import processing.core.PApplet;
import processing.core.PImage;

public class Wonka extends PApplet implements OnMessageListener{
	
	private UDP udp;
	private ArrayList<Images> images;
	private PImage imageUno, imageDos, imageTres, imageCuatro;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("main.Wonka");
	}
	
	public void settings() {
		size(500,500);
	}
	
	public void setup() {
		udp = new UDP();
		udp.setObserver(this);
		udp.start();
		
		//Lista de imagen
		imageUno = loadImage("images/uno.png");
		imageDos = loadImage("images/dos.png");
		imageTres = loadImage("images/tres.png");
		imageCuatro = loadImage("images/cuatro.png");
		
		images = new ArrayList<>();

	}
	
	public void draw() {
		background(255);
		
		textSize(10);
		fill(0);
		
		
		
		for (int i = 0; i < images.size(); i++) {
			Images imagen = images.get(i);
			
			if(imagen.getTipoImagen().equals("Chocolates")) {
				image(imageUno,imagen.getX(),(i*imagen.getY()),50,50);
				text("Chocolates",imagen.getX()+75,(i*imagen.getY()+25));
				//text(imagen.getTiempo(),imagen.getX()+75,(i*imagen.getY())+100);
			}
			if(imagen.getTipoImagen().equals("Salpicon")) {
				image(imageDos,imagen.getX(),(i*imagen.getY()),50,50);
				text("Salpicon",imagen.getX()+75,(i*imagen.getY()+25));
				//text(imagen.getTiempo(),imagen.getX()+75,(i*imagen.getY())+100);
			}
			if(imagen.getTipoImagen().equals("Helado")) {
				image(imageTres,imagen.getX(),(i*imagen.getY()),50,50);
				text("Helado",imagen.getX()+75,(i*imagen.getY()+25));
				//text(imagen.getTiempo(),imagen.getX()+75,(i*imagen.getY())+100);
			}
			if(imagen.getTipoImagen().equals("AlmuerzoWonka")) {
				image(imageCuatro,imagen.getX(),i*imagen.getY(),50,50);
				text("AlmuerzoWonka",imagen.getX()+75,(i*imagen.getY()+25));
				//text(imagen.getTiempo(),imagen.getX()+75,(i*imagen.getY())+100);
			}
			
		}
	}

	public void mouseClicked() {
		for (int i = 0; i < images.size(); i++) {
			
			if(mouseX > images.get(i).getX() && mouseX < images.get(i).getX() + 50 && mouseY > images.get(i).getY() && mouseY < images.get(i).getY()+ 50 ) {
				images.remove(1);
			}
		}
		
	}

	@Override
	public void onImagesReceive(Images image) {
		 images.add(image);
	}
}
