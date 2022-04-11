package projectGroup.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DAO {
    Connection getConnection();

    void select(String request) throws SQLException;

    void update(String request) throws SQLException;

    void delete(String request) throws SQLException;

    void insert(String request) throws SQLException;
}
