package veiculoslucaserick.Model;

public class MarcaModel {
    private final int idMarca;
    private final String marca;

    public MarcaModel(int idMarca, String marca) {
        this.idMarca = idMarca;
        this.marca = marca;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return marca;
    }
}
