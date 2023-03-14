import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BD5bController
{
    private BD5bView bd5bView;
    private BD5bModel bd5bModel;

    public BD5bController(BD5bView bd5bView, BD5bModel bd5bModel)
    {
        this.bd5bView = bd5bView;
        this.bd5bModel = bd5bModel;
        bd5bView.pressLeaveButtonEx5bBD(new listenerLeaveButtonEx5bBD());
        bd5bView.pressShowResultButtonEx5bBD(new listenerShowResultButtonEx5bBD());
    }

    class listenerLeaveButtonEx5bBD implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            bd5bView.jframeEx5b.setVisible(false);
            bd5bView.getShowResultButton().setEnabled(true);
        }
    }

    class listenerShowResultButtonEx5bBD implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            bd5bView.getShowResultButton().setEnabled(false);
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
            String[] dep = new String[3];
            String input = bd5bView.getInputTextField().getText();
            int i = 0;
            try
            {
                //viewTable(DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root",""));
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root","");
                /*String query = "SELECT Produs.model, Imprimanta.culoare, Imprimanta.tip, Produs.fabricant, Produs.pret\n" +
                        "FROM Produs\n" +
                        "JOIN Imprimanta ON Produs.model = Imprimanta.model\n" +
                        "WHERE Produs.pret IN (SELECT pret\n" +
                        "                      FROM Produs\n" +
                        "                      WHERE model = 111)\n" +
                        "ORDER BY model";*/
                try (CallableStatement stmt = con.prepareCall("{CALL imprimanta_informatii(" + Integer.parseInt(input) +")}")) {

                    boolean hadResults = stmt.execute();

                    try (ResultSet rs = stmt.getResultSet()) {
                    while (rs.next()) {

                                int model = rs.getInt("model");
                                String culoare = rs.getString("culoare");
                                String tip = rs.getString("tip");
                                String fabricant = rs.getString("fabricant");
                                int pret = rs.getInt("pret");
                                dep[i++] = "                " + Integer.toString(model) + "                                 "
                                        + culoare + "                                "
                                        + tip + "                            "
                                        + fabricant  + "                             " + Integer.toString(pret);
                        }
                        hadResults = stmt.getMoreResults();
                    }
                }
            }
            catch (SQLException ex)
            {
                throw new RuntimeException(ex);
            }
            bd5bView.setMode(bd5bView.getMode(), dep);
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
