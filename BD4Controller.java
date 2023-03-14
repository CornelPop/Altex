import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BD4Controller
{
    private BD4View bd4View;
    private BD4Model bd4Model;

    public BD4Controller(BD4View bd4View, BD4Model bd4Model)
    {
        this.bd4View = bd4View;
        this.bd4Model = bd4Model;
        bd4View.pressLeaveButtonEx4BD(new listenerLeaveButtonEx4BD());
        bd4View.pressShowResultButtonEx4BD(new listenerShowResultButtonEx4BD());
    }

    class listenerLeaveButtonEx4BD implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            bd4View.jframeEx4.setVisible(false);
            bd4View.getShowResultButton().setEnabled(true);
        }
    }

    class listenerShowResultButtonEx4BD implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            bd4View.getShowResultButton().setEnabled(false);
            int lenght = 0;
            try
            {
                //viewTable(DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root",""));
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root","");
                String query = "SELECT COUNT(*)\n" +
                        "FROM Produs\n" +
                        "JOIN Imprimanta ON Produs.model = Imprimanta.model \n" +
                        "WHERE Produs.fabricant = 'HP'\n" +
                        "ORDER BY imprimanta.culoare ASC, Imprimanta.tip ASC, Produs.pret ASC";
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
                String query = "SELECT Produs.model, Imprimanta.culoare, Imprimanta.tip, Produs.pret\n" +
                        "FROM Produs\n" +
                        "JOIN Imprimanta ON Produs.model = Imprimanta.model \n" +
                        "WHERE Produs.fabricant = 'HP'\n" +
                        "ORDER BY imprimanta.culoare ASC, Imprimanta.tip ASC, Produs.pret ASC";
                try (Statement stmt = con.createStatement()) {
                    ResultSet rs = stmt.executeQuery(query);
                    while (rs.next()) {
                        int model = rs.getInt("model");
                        String culoare = rs.getString("culoare");
                        String tip = rs.getString("tip");
                        int pret = rs.getInt("pret");
                        dep[i++] = "                     " + Integer.toString(model)
                                + "                                         " + culoare
                                + "                                        " + tip
                                + "                                         " + Integer.toString(pret);
                    }
                }
            }
            catch (SQLException ex)
            {
                throw new RuntimeException(ex);
            }
            bd4View.setMode(bd4View.getMode(), dep);
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
