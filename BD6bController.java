import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BD6bController
{
    private BD6bView bd6bView;
    private BD6bModel bd6bModel;

    public BD6bController(BD6bView bd6bView, BD6bModel bd6bModel)
    {
        this.bd6bView = bd6bView;
        this.bd6bModel = bd6bModel;
        bd6bView.pressLeaveButtonEx6bBD(new listenerLeaveButtonEx6bBD());
        bd6bView.pressShowResultButtonEx6bBD(new listenerShowResultButtonEx6bBD());
    }

    class listenerLeaveButtonEx6bBD implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            bd6bView.jframeEx6b.setVisible(false);
            bd6bView.getShowResultButton().setEnabled(true);
        }
    }

    class listenerShowResultButtonEx6bBD implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            bd6bView.getShowResultButton().setEnabled(false);
            int lenght = 0;
            /*try
            {
                //viewTable(DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root",""));
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root","");
                String query = "SELECT COUNT(Produs.model)\n" +
                        "FROM Produs\n" +
                        "JOIN Imprimanta ON Produs.model = Imprimanta.model\n" +
                        "WHERE Produs.pret IN (SELECT pret\n" +
                        "                      FROM Produs\n" +
                        "                      WHERE model = 111)\n" +
                        "ORDER BY model";
                try (Statement stmt = con.createStatement()) {
                    ResultSet rs = stmt.executeQuery(query);
                    while (rs.next()) {
                        lenght = rs.getInt(1);
                    }
                }
            }
            catch (SQLException ex)
            {
                throw new RuntimeException(ex);
            }*/
            String[] dep = new String[6];
            int i = 0;
            try
            {
                //viewTable(DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root",""));
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root","");
                String query = "SELECT MIN(Produs.pret), MAX(Produs.pret), AVG(Produs.pret), Imprimanta.culoare, Imprimanta.tip\n" +
                        "FROM Produs\n" +
                        "JOIN Imprimanta ON Produs.model = Imprimanta.model\n" +
                        "GROUP BY Imprimanta.culoare, Imprimanta.tip";
                try (Statement stmt = con.createStatement()) {
                    ResultSet rs = stmt.executeQuery(query);
                    while (rs.next()) {
                        dep[i++] = "               " + rs.getFloat(1) +
                                "                         " + rs.getFloat(2) +
                                "                            " + rs.getFloat(3) +
                                "                           " + rs.getString(4) +
                                "                                " + rs.getString(5);
                    }
                }
            }
            catch (SQLException ex)
            {
                throw new RuntimeException(ex);
            }
            bd6bView.setMode(bd6bView.getMode(), dep);
        }
    }

    /*public void viewTable(Connection con) throws SQLException {
        String query = "select * from produs";
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int model = rs.getInt("model");
                String fabricant = rs.getString("fabricant");
                String categorie = rs.getString("categorie");
                String moneda = rs.getString("moneda");
                int pret = rs.getInt("pret");
                System.out.println(model + " " + fabricant + " " + categorie + " " + pret + " " + moneda);
            }
        }
    }*/
}
