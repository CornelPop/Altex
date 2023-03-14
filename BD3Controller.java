import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BD3Controller
{
    private BD3View bd3View;
    private BD3Model bd3Model;

    public BD3Controller(BD3View bd3View, BD3Model bd3Model)
    {
        this.bd3View = bd3View;
        this.bd3Model = bd3Model;
        bd3View.pressLeaveButtonEx3BD(new listenerLeaveButtonEx3BD());
        bd3View.pressShowResultButtonEx3BD(new listenerShowResultButtonEx3BD());
    }

    class listenerLeaveButtonEx3BD implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            bd3View.jframeEx3.setVisible(false);
            bd3View.getShowResultButton().setEnabled(true);
        }
    }

    class listenerShowResultButtonEx3BD implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            bd3View.getShowResultButton().setEnabled(false);
            int lenght = 0;
            try
            {
                //viewTable(DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root",""));
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root","");
                String query = "SELECT COUNT(fabricant)\n" +
                        "FROM Produs\n" +
                        "WHERE model IN (SELECT model\n" +
                        "               FROM Laptop\n" +
                        "               WHERE pret < 1000)\n" +
                        "ORDER BY fabricant ASC";
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
            String input = bd3View.getInputTextField().getText();
            int i = 0;
            try
            {
                //viewTable(DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root",""));
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root","");
                String query = "SELECT fabricant\n" +
                        "FROM Produs\n" +
                        "WHERE model IN (SELECT model\n" +
                        "               FROM Laptop\n" +
                        "               WHERE pret < " + Integer.parseInt(input) + " )\n" +
                        "ORDER BY fabricant ASC".formatted(input);
                try (Statement stmt = con.createStatement()) {
                    ResultSet rs = stmt.executeQuery(query);
                    while (rs.next()) {
                        dep[i++] ="                                                                                     " +  rs.getString("fabricant");
                    }
                }
            }
            catch (SQLException ex)
            {
                throw new RuntimeException(ex);
            }
            bd3View.setMode(bd3View.getMode(), dep);
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
