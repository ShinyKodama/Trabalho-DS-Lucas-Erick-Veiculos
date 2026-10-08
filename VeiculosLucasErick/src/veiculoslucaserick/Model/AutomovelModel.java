package veiculoslucaserick.Model;

import lombok.Data;

@Data
public class AutomovelModel {
    private int id;
    private String modelo;
    private float valor;
    private int ano;
    private String cor;
    private String opcionais;
    private int idMarca;
    private byte[] imagem;
}
