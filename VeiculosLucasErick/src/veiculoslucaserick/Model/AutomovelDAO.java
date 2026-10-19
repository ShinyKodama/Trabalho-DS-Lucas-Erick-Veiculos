package veiculoslucaserick.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class AutomovelDAO {

    public void inserirAutomovel(AutomovelModel automovel)
            throws SQLException {

        String sql = "INSERT INTO modelos "
                + "(Modelo, Valor, Ano, Cor, Opcionais, "
                + "IDMarca, Imagem, NomeImagem) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (
                Connection con = new DatabaseConnection().Connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, automovel.getModelo());
            ps.setFloat(2, automovel.getValor());
            ps.setInt(3, automovel.getAno());
            ps.setString(4, automovel.getCor());
            ps.setString(5, automovel.getOpcionais());
            ps.setInt(6, automovel.getIdMarca());
            ps.setBytes(7, automovel.getImagem());
            ps.setString(8, automovel.getNomeImagem());

            ps.executeUpdate();
        }
    }

    public AutomovelModel localizarPorId(int id)
            throws SQLException {

        String sql = "SELECT * FROM modelos WHERE ID = ?";

        try (
                Connection con = new DatabaseConnection().Connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    AutomovelModel automovel = new AutomovelModel();

                    automovel.setId(rs.getInt("ID"));
                    automovel.setModelo(rs.getString("Modelo"));
                    automovel.setValor(rs.getFloat("Valor"));
                    automovel.setAno(rs.getInt("Ano"));
                    automovel.setCor(rs.getString("Cor"));
                    automovel.setOpcionais(rs.getString("Opcionais"));
                    automovel.setIdMarca(rs.getInt("IDMarca"));
                    automovel.setImagem(rs.getBytes("Imagem"));
                    automovel.setNomeImagem(rs.getString("NomeImagem"));

                    return automovel;
                }
            }
        }

        return null;
    }

    public int alterarAutomovel(AutomovelModel automovel)
            throws SQLException {

        String sql = "UPDATE modelos SET "
                + "Modelo = ?, Valor = ?, Ano = ?, "
                + "Cor = ?, Opcionais = ?, IDMarca = ?, "
                + "Imagem = COALESCE(?, Imagem), "
                + "NomeImagem = COALESCE(?, NomeImagem) "
                + "WHERE ID = ?";

        try (
                Connection con = new DatabaseConnection().Connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, automovel.getModelo());
            ps.setFloat(2, automovel.getValor());
            ps.setInt(3, automovel.getAno());
            ps.setString(4, automovel.getCor());
            ps.setString(5, automovel.getOpcionais());
            ps.setInt(6, automovel.getIdMarca());

            if (automovel.getImagem() != null) {
                ps.setBytes(7, automovel.getImagem());
            } else {
                ps.setNull(7, Types.BLOB);
            }

            ps.setString(8, automovel.getNomeImagem());
            ps.setInt(9, automovel.getId());

            return ps.executeUpdate();
        }
    }

    public int excluirAutomovel(int id) throws SQLException {

        String sql = "DELETE FROM modelos WHERE ID = ?";

        try (
                Connection con = new DatabaseConnection().Connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            return ps.executeUpdate();
        }
    }
}
