package projectGroup.dao;

import projectGroup.JDBCUtils;
import projectGroup.entity.anotations.*;
import projectGroup.entity.Entity;

import java.sql.*;

public class EntityDAO implements DAO {

    private Connection conn;

    public EntityDAO() {
        try {
            conn = DriverManager.getConnection(JDBCUtils.getUrl(), JDBCUtils.getUser(), JDBCUtils.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
        return conn;
    }

    private static boolean checkTableName(String query) {
        String tableName = Entity.class.getAnnotation(MyTable.class).name();
        if (!query.contains(tableName)) {
            System.out.println("Ошибка обработки запроса: такой таблицы нет");
            return false;
        }
        return true;
    }

    @Override
    public void select(String request) {
        System.out.println("Выполняется запрос в базу данных...");
        if (!checkTableName(request)) {
            return;
        }
        System.out.println("===========================================");
        try (Statement statement = getConnection().createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(request)) {
                String temp = "";
                while (resultSet.next()) {
                    for (int i = 1; i < resultSet.getMetaData().getColumnCount() + 1; i++) {
                        temp = temp + resultSet.getObject(i) + " ";
                    }
                    System.out.println(temp);
                    temp = "";
                }
                System.out.println("Запрос обработан!");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.out.println("Ошибка обработки запроса!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(String request) {
        System.out.println("База данных обновляется...");
        if (!checkTableName(request)) {
            return;
        }
        System.out.println("===========================================");
        try (Statement statement = getConnection().createStatement()) {
            statement.executeUpdate(request);
            System.out.println("База данных успешно обновлена!");
        } catch (SQLException throwables) {
            System.out.println("Ошибка обновления базы данных!");
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(String request) {
        System.out.println("Информация удаляется из базы данных...");
        if (!checkTableName(request)) {
            return;
        }
        System.out.println("===========================================");
        try (Statement statement = getConnection().createStatement()) {
            statement.executeUpdate(request);
            System.out.println("Информация в базе данных успешно удалена!");
        } catch (SQLException throwables) {
            System.out.println("Ошибка удаления из базы данных!");
            throwables.printStackTrace();
        }
    }

    @Override
    public void insert(String request) {
        System.out.println("Информация в базе данных обновляется...");
        if (!checkTableName(request)) {
            return;
        }
        System.out.println("===========================================");
        try (Statement statement = getConnection().createStatement()) {
            statement.executeUpdate(request);
            System.out.println("Информация в базе данных успешно обновлена!");
        } catch (SQLException throwables) {
            System.out.println("Ошибка обновления информации в базе данных!");
            throwables.printStackTrace();
        }
    }
}
