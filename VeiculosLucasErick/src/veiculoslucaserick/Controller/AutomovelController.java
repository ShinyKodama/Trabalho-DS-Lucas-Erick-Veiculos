package veiculoslucaserick.Controller;

import veiculoslucaserick.Model.AutomovelModel;
import veiculoslucaserick.Model.AutomovelDAO;
import veiculoslucaserick.Model.DatabaseConnection;

import java.sql.SQLException;

public class AutomovelController {
    public void inserirModelo(AutomovelModel modelo) throws SQLException {        
        AutomovelDAO dao = new AutomovelDAO();
        dao.inserirAutomovel(modelo);
    }
}
