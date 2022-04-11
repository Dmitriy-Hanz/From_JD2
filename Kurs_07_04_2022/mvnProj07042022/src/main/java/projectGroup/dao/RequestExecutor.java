package projectGroup.dao;

import java.sql.SQLException;

public class RequestExecutor {
    public static void execute(String query) {
        String command = query.split("[ ]")[0];
        try {
            if (command.equalsIgnoreCase("SELECT")) {
                DAOFactory.getInstance().getImplThroughDAO().select(query);
            } else if (command.equalsIgnoreCase("INSERT")) {
                DAOFactory.getInstance().getImplThroughDAO().insert(query);
            } else if (command.equalsIgnoreCase("UPDATE")) {
                DAOFactory.getInstance().getImplThroughDAO().update(query);
            } else if (command.equalsIgnoreCase("DELETE")) {
                DAOFactory.getInstance().getImplThroughDAO().delete(query);
            } else {
                System.out.println("Некорректный запрос для работы с базой данных, попробуйте еще раз!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
