package co.domi.semana9.model;

public class Images {

    private String type = "Images";

    private String tipoImagen;

    public Images(){}

    public Images(String tipoImagen) {
        this.tipoImagen = tipoImagen;
    }

    public String getTipoImagen() {
        return tipoImagen;
    }

    public void setTipoImagen(String tipoImagen) {
        this.tipoImagen = tipoImagen;
    }
}
