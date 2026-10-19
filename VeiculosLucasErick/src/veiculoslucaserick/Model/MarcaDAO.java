package veiculoslucaserick.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarcaDAO {

    public List<MarcaModel> listarMarcas() throws SQLException {
        List<MarcaModel> marcas = new ArrayList<>();

        String sql = "SELECT ID, Marca FROM marcas ORDER BY Marca";
        DatabaseConnection db = new DatabaseConnection();

        try (Connection conn = db.Connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idMarca = rs.getInt("ID");
                String nomeMarca = rs.getString("Marca");
                marcas.add(new MarcaModel(idMarca, nomeMarca));
            }
        }

        return marcas;
    }
}
