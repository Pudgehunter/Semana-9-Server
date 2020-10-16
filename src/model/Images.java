package model;

public class Images {

    //private String type = "Images";

	private String tipoImagen;
    private int x,y;
    private String tiempo;
    
    public Images(){}

    public Images(String tipoImagen, int x, int y, String tiempo) {
        this.tipoImagen = tipoImagen;
        this.x = x;
        this.y = y;
        this.tiempo = tiempo;
    }

    //Metodos
    public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getTipoImagen() {
        return tipoImagen;
    }

    public void setTipoImagen(String tipoImagen) {
        this.tipoImagen = tipoImagen;
    }
}
