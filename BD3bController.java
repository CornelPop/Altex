import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BD3bController
{
    private BD3bView bd3bView;
    private BD3bModel bd3bModel;

    public BD3bController(BD3bView bd3bView, BD3bModel bd3bModel)
    {
        this.bd3bView = bd3bView;
        this.bd3bModel = bd3bModel;
        bd3bView.pressLeaveButtonEx3bBD(new listenerLeaveButtonEx3bBD());
        bd3bView.pressShowResultButtonEx3bBD(new listenerShowResultButtonEx3bBD());
    }

    class listenerLeaveButtonEx3bBD implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            bd3bView.jframeEx3b.setVisible(false);
            bd3bView.getShowResultButton().setEnabled(true);
        }
    }

    class listenerShowResultButtonEx3bBD implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            bd3bView.getShowResultButton().setEnabled(false);
            int lenght = 0;
            try
            {
                //viewTable(DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root",""));
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root","");
                String query = "SELECT COUNT(*) \n" +
                        "FROM Laptop\n" +
                        "WHERE ecran = 15.6\n" +
                        "ORDER BY ram DESC, hd ASC";
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
            String input = bd3bView.getInputTextField().getText();
            int i = 0;
            try
            {
                //viewTable(DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root",""));
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root","");
                String query = "SELECT * \n" +
                        "FROM Laptop\n" +
                        "WHERE ecran =  " + Float.parseFloat(input) + "\n" +
                        "ORDER BY ram DESC, hd ASC";
                try (Statement stmt = con.createStatement()) {
                    ResultSet rs = stmt.executeQuery(query);
                    while (rs.next()) {
                        int model = rs.getInt("model");
                        float viteza = rs.getFloat("viteza");
                        int ram = rs.getInt("ram");
                        int hd = rs.getInt("hd");
                        float ecran = rs.getFloat("ecran");
                        dep[i++] = "                " + Integer.toString(model) + "                        " +
                                "      " +  Float.toString(viteza) + "                              " +
                                "      " +  Integer.toString(ram) + "                           " +
                                "       " +  Integer.toString(hd) + "                         " +  Float.toString(ecran);
                    }
                }
            }
            catch (SQLException ex)
            {
                throw new RuntimeException(ex);
            }
            bd3bView.setMode(bd3bView.getMode(), dep);
            bd3bView.getInputTextField().setText("");
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
