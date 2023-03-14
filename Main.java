import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.sql.*;
import java.util.Properties;
import java.sql.*;
import java.text.ParseException;


public class Main
{
    public static void main(String[] args) throws ParseException, SQLException, ClassNotFoundException {
        BD3Model bd3Model = new BD3Model();
        BD3View bd3View = new BD3View(bd3Model);
        BD3Controller bd3Controller = new BD3Controller(bd3View, bd3Model);

        BD3bModel bd3bModel = new BD3bModel();
        BD3bView bd3bView = new BD3bView(bd3bModel);
        BD3bController bd3bController = new BD3bController(bd3bView, bd3bModel);

        BD4Model bd4Model = new BD4Model();
        BD4View bd4View = new BD4View(bd4Model);
        BD4Controller bd4Controller = new BD4Controller(bd4View, bd4Model);

        BD4bModel bd4bModel = new BD4bModel();
        BD4bView bd4bView = new BD4bView(bd4bModel);
        BD4bController bd4bController = new BD4bController(bd4bView, bd4bModel);

        BD5Model bd5Model = new BD5Model();
        BD5View bd5View = new BD5View(bd5Model);
        BD5Controller bd5Controller = new BD5Controller(bd5View, bd5Model);

        BD5bModel bd5bModel = new BD5bModel();
        BD5bView bd5bView = new BD5bView(bd5bModel);
        BD5bController bd5bController = new BD5bController(bd5bView, bd5bModel);

        BD6Model bd6Model = new BD6Model();
        BD6View bd6View = new BD6View(bd6Model);
        BD6Controller bd6Controller = new BD6Controller(bd6View, bd6Model);

        BD6bModel bd6bModel = new BD6bModel();
        BD6bView bd6bView = new BD6bView(bd6bModel);
        BD6bController bd6bController = new BD6bController(bd6bView, bd6bModel);

        AltexModel model = new AltexModel();
        AltexView view = new AltexView(model, bd3View, bd3bView, bd4View, bd4bView, bd5View, bd5bView, bd6View, bd6bView);
        AltexController controller = new AltexController(view, model);

        //Class.forName("com.mysql.jdbc.Driver");


    }
}