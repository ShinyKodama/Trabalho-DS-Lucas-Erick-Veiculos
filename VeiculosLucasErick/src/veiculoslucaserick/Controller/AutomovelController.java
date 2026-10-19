package veiculoslucaserick.Controller;

import veiculoslucaserick.Model.AutomovelModel;
import veiculoslucaserick.Model.AutomovelDAO;

import java.sql.SQLException;

public class AutomovelController {

    public void inserirModelo(AutomovelModel modelo) throws SQLException {
        AutomovelDAO dao = new AutomovelDAO();
        dao.inserirAutomovel(modelo);
    }

    public AutomovelModel localizarPorId(int id) throws SQLException {
        AutomovelDAO dao = new AutomovelDAO();
        return dao.localizarPorId(id);
    }

    public int alterarModelo(AutomovelModel automovel) throws SQLException {
        AutomovelDAO dao = new AutomovelDAO();
        return dao.alterarAutomovel(automovel);
    }

    public int excluirModelo(int id) throws SQLException {
        AutomovelDAO dao = new AutomovelDAO();
        return dao.excluirAutomovel(id);
    }
}
