import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BD6Controller
{
    private BD6View bd6View;
    private BD6Model bd6Model;

    public BD6Controller(BD6View bd6View, BD6Model bd6Model)
    {
        this.bd6View = bd6View;
        this.bd6Model = bd6Model;
        bd6View.pressLeaveButtonEx6BD(new listenerLeaveButtonEx6BD());
        bd6View.pressShowResultButtonEx6BD(new listenerShowResultButtonEx6BD());
    }

    class listenerLeaveButtonEx6BD implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            bd6View.jframeEx6.setVisible(false);
            bd6View.getShowResultButton().setEnabled(true);
        }
    }

    class listenerShowResultButtonEx6BD implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            bd6View.getShowResultButton().setEnabled(false);
            int lenght = 0;
            try
            {
                //viewTable(DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root",""));
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root","");
                String query = "SELECT COUNT(model)\n" +
                        "FROM produs\n" +
                        "WHERE pret = ANY (SELECT MIN(pret) \n" +
                        "                  FROM produs\n" +
                        "                  GROUP BY categorie)";
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
                String query = "SELECT categorie, pret, moneda, fabricant, model\n" +
                        "FROM produs\n" +
                        "WHERE pret = ANY (SELECT MIN(pret) \n" +
                        "                  FROM produs\n" +
                        "                  GROUP BY categorie)";
                try (Statement stmt = con.createStatement()) {
                    ResultSet rs = stmt.executeQuery(query);
                    while (rs.next()) {
                        int model = rs.getInt("model");
                        String fabricant = rs.getString("fabricant");
                        dep[i++] = "                                            " + Integer.toString(model) +
                                "                                                                                   " + fabricant;
                    }
                }
            }
            catch (SQLException ex)
            {
                throw new RuntimeException(ex);
            }
            bd6View.setMode(bd6View.getMode(), dep);
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
