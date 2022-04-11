package projectGroup;

import org.junit.BeforeClass;
import org.junit.Test;
import projectGroup.dao.DAOFactory;
import projectGroup.dao.RequestExecutor;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;


public class EntityDAOTest {

    private static Statement STATEMENT;

    @BeforeClass
    public static void Presets(){
        try {
            Connection connection = getConnection("jdbc:h2:mem:database_test");
            STATEMENT = connection.createStatement();
            STATEMENT.execute("create schema database_test");
            STATEMENT.execute("create table car(id int not null auto_increment primary key, name char(50), " +
                    "color char(50), price int)");
            STATEMENT.execute("insert into car(name, color, price) values ('Lada X-ray', 'Red', 12000)");
            STATEMENT.execute("insert into car(name, color, price) values ('Lada Vesta', 'Silver', 10000)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void TestOfExecuteFunk() throws SQLException {
        RequestExecutor.execute("select * from car");
        RequestExecutor.execute("insert into car(name, color, price) values ('Volvo', 'Black', 4000)");
        RequestExecutor.execute("update car set price = 8000 where name = 'Volvo'");
        RequestExecutor.execute("delete from car where name = 'Volvo'");
    }

    @Test
    public void TestOfSelectFunk() throws SQLException {
        DAOFactory.getInstance().getImplThroughDAO().select("select * from car");
    }

    @Test
    public void TestOfInsertFunk() throws SQLException {
        DAOFactory.getInstance().getImplThroughDAO().insert("insert into car(name, color, price) values ('Volvo', 'Black', 4000)");
    }

    @Test
    public void TestOfUpdateFunk() throws SQLException {
        DAOFactory.getInstance().getImplThroughDAO().update("update car set price = 8000 where name = 'Volvo'");
    }

    @Test
    public void TestOfDeleteFunk() throws SQLException {
        DAOFactory.getInstance().getImplThroughDAO().delete("delete from car where name = 'Volvo'");
    }
}

//import static org.junit.Assert.assertTrue;
//
//        import org.junit.Test;
//
///**
// * Unit test for simple App.
// */
//public class AppTest
//{
//    /**
//     * Rigorous Test :-)
//     */
//    @org.junit.Test
//    public void shouldAnswerWithTrue()
//    {
//        assertTrue( true );
//    }
//}