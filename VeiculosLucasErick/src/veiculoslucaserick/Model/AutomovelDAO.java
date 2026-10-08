package veiculoslucaserick.Model;

import veiculoslucaserick.Model.DatabaseConnection;
import veiculoslucaserick.Model.AutomovelModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AutomovelDAO {
    public void inserirAutomovel(AutomovelModel automovel) throws SQLException {
        String SQL = 
                "INSERT INTO modelos (Modelo, Valor, Ano, Cor, Opcionais, IDMarca, Imagem) VALUES"
            +   "(?, ?, ?, ?, ?, ?, ?)";
        try (
            Connection con = new DatabaseConnection().Connect();
            PreparedStatement ps = con.prepareStatement(SQL);
        ) {
            ps.setString(1, automovel.getModelo());
            ps.setFloat(2, automovel.getValor());
            ps.setInt(3, automovel.getAno());
            ps.setString(4, automovel.getCor());
            ps.setString(5, automovel.getOpcionais());
            ps.setInt(6, automovel.getIdMarca());
            ps.setInt(7, automovel.getIdMarca());
            ps.setBytes(8, automovel.getImagem());
            
            ps.executeUpdate();
        }
    }
}
