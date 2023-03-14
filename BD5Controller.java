import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BD5Controller
{
    private BD5View bd5View;
    private BD5Model bd5Model;

    public BD5Controller(BD5View bd5View, BD5Model bd5Model)
    {
        this.bd5View = bd5View;
        this.bd5Model = bd5Model;
        bd5View.pressLeaveButtonEx5BD(new listenerLeaveButtonEx5BD());
        bd5View.pressShowResultButtonEx5BD(new listenerShowResultButtonEx5BD());
    }

    class listenerLeaveButtonEx5BD implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            bd5View.jframeEx5.setVisible(false);
            bd5View.getShowResultButton().setEnabled(true);
        }
    }

    class listenerShowResultButtonEx5BD implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            bd5View.getShowResultButton().setEnabled(false);
            int lenght = 0;
            try
            {
                //viewTable(DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root",""));
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root","");
                String query = "SELECT COUNT(fabricant)\n" +
                        "FROM produs\n" +
                        "WHERE pret = \n" +
                        "\t(SELECT Produs.pret\n" +
                        "\tFROM Laptop\n" +
                        "\tJOIN Produs ON Laptop.model = Produs.model\n" +
                        "\tWHERE Laptop.hd = 256 AND Produs.pret IN (SELECT Produs.pret\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t   FROM Produs\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t   WHERE Produs.categorie = 'LAPTOP'\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t   )\n" +
                        "\tORDER BY Produs.pret ASC\n" +
                        "\tLIMIT 1)";
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
            String input = bd5View.getInputTextField().getText();
            int i = 0;
            try
            {
                //viewTable(DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root",""));
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root","");
                String query = "SELECT fabricant\n" +
                        "FROM produs\n" +
                        "WHERE pret = \n" +
                        "\t(SELECT Produs.pret\n" +
                        "\tFROM Laptop\n" +
                        "\tJOIN Produs ON Laptop.model = Produs.model\n" +
                        "\tWHERE Laptop.hd = "+ Integer.parseInt(input) + " AND Produs.pret IN (SELECT Produs.pret\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t   FROM Produs\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t   WHERE Produs.categorie = 'LAPTOP'\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t   )\n" +
                        "\tORDER BY Produs.pret ASC\n" +
                        "\tLIMIT 1)";
                try (Statement stmt = con.createStatement()) {
                    ResultSet rs = stmt.executeQuery(query);
                    while (rs.next()) {
                        dep[i++] = "                                    " +
                                "                                                 " + rs.getString("fabricant");
                    }
                }
            }
            catch (SQLException ex)
            {
                throw new RuntimeException(ex);
            }
            bd5View.setMode(bd5View.getMode(), dep);
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
