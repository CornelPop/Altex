import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BD4bController
{
    private BD4bView bd4bView;
    private BD4bModel bd4bModel;

    public BD4bController(BD4bView bd4bView, BD4bModel bd4bModel)
    {
        this.bd4bView = bd4bView;
        this.bd4bModel = bd4bModel;
        bd4bView.pressLeaveButtonEx4bBD(new listenerLeaveButtonEx4bBD());
        bd4bView.pressShowResultButtonEx4bBD(new listenerShowResultButtonEx4bBD());
    }

    class listenerLeaveButtonEx4bBD implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            bd4bView.jframeEx4b.setVisible(false);
            bd4bView.getShowResultButton().setEnabled(true);
        }
    }

    class listenerShowResultButtonEx4bBD implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            bd4bView.getShowResultButton().setEnabled(false);
            int lenght = 0;
            try
            {
                //viewTable(DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root",""));
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root","");
                String query = "SELECT COUNT(DISTINCT a.model)\n" +
                        "FROM (Produs c JOIN Produs d ON c.fabricant!=d.fabricant) JOIN (PC a JOIN PC b ON a.viteza = b.viteza AND a.ram = b.ram AND a.hd = b.hd)\n" +
                        "WHERE a.model < b.model";
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
            }
            String[] dep = new String[lenght];
            int i = 0;
            try
            {
                //viewTable(DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root",""));
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root","");
                String query = "SELECT DISTINCT a.model AS model1, b.model AS model2\n" +
                        "FROM (Produs c JOIN Produs d ON c.fabricant!=d.fabricant) JOIN (PC a JOIN PC b ON a.viteza = b.viteza AND a.ram = b.ram AND a.hd = b.hd)\n" +
                        "WHERE a.model < b.model";
                try (Statement stmt = con.createStatement()) {
                    ResultSet rs = stmt.executeQuery(query);
                    while (rs.next()) {
                        int model1 = rs.getInt("model1");
                        int model2 = rs.getInt("model2");
                        dep[i++] = "                                            " + Integer.toString(model1) +
                                "                                                                                         " + Integer.toString(model2);
                    }
                }
            }
            catch (SQLException ex)
            {
                throw new RuntimeException(ex);
            }
            bd4bView.setMode(bd4bView.getMode(), dep);
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
