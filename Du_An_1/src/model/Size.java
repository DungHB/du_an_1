package model;

public class Size {

    private int idSize;
    private String maSize;
    private int size;

    public Size() {
    }

    public Size(int idSize, String maSize, int size) {
        this.idSize = idSize;
        this.maSize = maSize;
        this.size = size;
    }

    public int getIdSize() {
        return idSize;
    }

    public void setIdSize(int idSize) {
        this.idSize = idSize;
    }

    public String getMaSize() {
        return maSize;
    }

    public void setMaSize(String maSize) {
        this.maSize = maSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
