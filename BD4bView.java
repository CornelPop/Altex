import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.sql.*;
import java.util.Properties;
import java.sql.*;

public class BD4bView extends Component {
    private final BD4bModel bd4bModel;
    JFrame jframeEx4b = new JFrame("Exercise 4b");
    JPanel contentPanel = new JPanel();
    JPanel topTablePanel = new JPanel();
    JPanel jCenter = new JPanel();
    JPanel jLeft = new JPanel();
    JPanel jRight = new JPanel();
    JPanel jTop = new JPanel();
    JPanel jBottom = new JPanel();
    JButton leaveButton = new JButton();
    JButton showResultButton = new JButton();
    JLabel modelLabel1 = new JLabel();
    JLabel modelLabel2 = new JLabel();
    JLabel cerintaLabel = new JLabel();
    JLabel cerintaLabel2 = new JLabel();
    DefaultListModel mode = new DefaultListModel();
    JList<Object> productsList = new JList<>(mode);

    public BD4bModel getBd4bModel() {
        return bd4bModel;
    }

    public JFrame getJframeEx4b() {
        return jframeEx4b;
    }

    public void setJframeEx4b(JFrame jframeEx4b) {
        this.jframeEx4b = jframeEx4b;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public void setContentPanel(JPanel contentPanel) {
        this.contentPanel = contentPanel;
    }

    public JPanel getTopTablePanel() {
        return topTablePanel;
    }

    public void setTopTablePanel(JPanel topTablePanel) {
        this.topTablePanel = topTablePanel;
    }

    public JPanel getjCenter() {
        return jCenter;
    }

    public void setjCenter(JPanel jCenter) {
        this.jCenter = jCenter;
    }

    public JPanel getjLeft() {
        return jLeft;
    }

    public void setjLeft(JPanel jLeft) {
        this.jLeft = jLeft;
    }

    public JPanel getjRight() {
        return jRight;
    }

    public void setjRight(JPanel jRight) {
        this.jRight = jRight;
    }

    public JPanel getjTop() {
        return jTop;
    }

    public void setjTop(JPanel jTop) {
        this.jTop = jTop;
    }

    public JPanel getjBottom() {
        return jBottom;
    }

    public void setjBottom(JPanel jBottom) {
        this.jBottom = jBottom;
    }

    public JButton getLeaveButton() {
        return leaveButton;
    }

    public void setLeaveButton(JButton leaveButton) {
        this.leaveButton = leaveButton;
    }

    public JButton getShowResultButton() {
        return showResultButton;
    }

    public void setShowResultButton(JButton showResultButton) {
        this.showResultButton = showResultButton;
    }

    public DefaultListModel getMode() {
        return mode;
    }

    public void setMode(DefaultListModel mode) {
        this.mode = mode;
    }

    public JList<Object> getProductsList() {
        return productsList;
    }

    public void setProductsList(JList<Object> productsList) {
        this.productsList = productsList;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    JScrollPane scrollPane = new JScrollPane(productsList);

    public void setMode(DefaultListModel mode, String[] dep) {
        for (int i = 0; i < dep.length; i++)
        {
            this.mode.add(i, dep[i]);
        }
        this.mode = mode;
    }

    public BD4bView(BD4bModel bd4bModel)
    {
        this.bd4bModel = bd4bModel;
        jframeEx4b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframeEx4b.setSize(1100,700);
        jframeEx4b.setLocationRelativeTo(null);

        String[] dep = new String[50];

        contentPanel.setBackground(Color.RED);
        jLeft.setBackground(Color.ORANGE);
        jRight.setBackground(Color.ORANGE);
        jTop.setBackground(Color.ORANGE);
        jBottom.setBackground(Color.ORANGE);
        jCenter.setBackground(Color.ORANGE);
        topTablePanel.setBackground(Color.ORANGE);
        productsList.setBackground(Color.ORANGE);

        contentPanel.setLayout(new BorderLayout());
        jLeft.setLayout(new BoxLayout(jLeft, BoxLayout.Y_AXIS));
        jRight.setLayout(new BoxLayout(jRight, BoxLayout.Y_AXIS));
        jTop.setLayout(new BoxLayout(jTop, BoxLayout.X_AXIS));
        jBottom.setLayout(new FlowLayout());
        jCenter.setLayout(new FlowLayout());
        topTablePanel.setLayout(new BoxLayout(topTablePanel, BoxLayout.X_AXIS));

        jLeft.setPreferredSize(new Dimension(250, 100));
        jRight.setPreferredSize(new Dimension(250, 100));
        jCenter.setPreferredSize(new Dimension(50, 100));
        jBottom.setPreferredSize(new Dimension(50, 100));
        jTop.setPreferredSize(new Dimension(50, 137));
        topTablePanel.setMinimumSize(new Dimension(575, 50));
        topTablePanel.setPreferredSize(new Dimension(575, 50));
        topTablePanel.setMaximumSize(new Dimension(575, 50));
        productsList.setMinimumSize(new Dimension(580, dep.length * 50));
        productsList.setPreferredSize(new Dimension(580, dep.length * 50));
        productsList.setMaximumSize(new Dimension(580, dep.length * 50));
        scrollPane.setMinimumSize(new Dimension(575, 210));
        scrollPane.setPreferredSize(new Dimension(575, 210));
        scrollPane.setMaximumSize(new Dimension(575, 210));
        modelLabel1.setMinimumSize(new Dimension(286, 46));
        modelLabel1.setPreferredSize(new Dimension(286, 46));
        modelLabel1.setMaximumSize(new Dimension(286, 46));
        modelLabel2.setMinimumSize(new Dimension(285, 46));
        modelLabel2.setPreferredSize(new Dimension(285, 46));
        modelLabel2.setMaximumSize(new Dimension(285, 46));
        productsList.setFixedCellHeight(50);
        productsList.setFixedCellWidth(100);

        modelLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        modelLabel1.setVerticalAlignment(SwingConstants.CENTER);
        modelLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        modelLabel2.setVerticalAlignment(SwingConstants.CENTER);

        jTop.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        jLeft.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        jRight.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        jBottom.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        jCenter.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        topTablePanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        modelLabel1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        modelLabel2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

        leaveButton.setMinimumSize(new Dimension(175, 50));
        leaveButton.setPreferredSize(new Dimension(175, 50));
        leaveButton.setMaximumSize(new Dimension(175, 50));
        showResultButton.setMinimumSize(new Dimension(175, 50));
        showResultButton.setPreferredSize(new Dimension(175, 50));
        showResultButton.setMaximumSize(new Dimension(175, 50));

        leaveButton.setText("Back");
        showResultButton.setText("Show the list");
        modelLabel1.setText("Model 1");
        modelLabel2.setText("Model 2");

        cerintaLabel.setText("Să se găsească perechi de modele (model1, model2) de pc-uri cu condiția să \n" +
                "aibă aceeași viteză, ram și hd, dar fabricanți diferiți.");
        cerintaLabel.setFont(new Font("Calibri", Font.BOLD, 20));

        jTop.add(Box.createHorizontalGlue());
        jTop.add(cerintaLabel);
        jTop.add(Box.createHorizontalGlue());

        ImageIcon image = new ImageIcon("D:\\Diverse/altex.png");
        ImageIcon image2 = new ImageIcon("D:\\Diverse/altex.png");
        JPanel imageTitle = new JPanel();
        JPanel imageTitle2 = new JPanel();
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();

        jLeft.add(imageTitle);
        label1.setIcon(image);
        imageTitle.add(label1);
        imageTitle.setBackground(Color.ORANGE);
        jRight.add(imageTitle2);
        label2.setIcon(image2);
        imageTitle2.add(label2);
        imageTitle2.setBackground(Color.ORANGE);

        contentPanel.add(jLeft, BorderLayout.WEST);
        contentPanel.add(jRight, BorderLayout.EAST);
        contentPanel.add(jTop, BorderLayout.NORTH);
        contentPanel.add(jBottom, BorderLayout.SOUTH);
        contentPanel.add(jCenter, BorderLayout.CENTER);

        topTablePanel.add(modelLabel1);
        topTablePanel.add(modelLabel2);

        jCenter.add(Box.createVerticalStrut(70));
        jCenter.add(showResultButton);
        jCenter.add(topTablePanel);
        jCenter.add(scrollPane);
        jCenter.add(Box.createVerticalStrut(70));
        jCenter.add(leaveButton);
        jCenter.add(Box.createVerticalStrut(45));

        jframeEx4b.setContentPane(contentPanel);
        jframeEx4b.setVisible(false);
    }

    public void pressLeaveButtonEx4bBD (BD4bController.listenerLeaveButtonEx4bBD l)
    {
        leaveButton.addActionListener(l);
    }
    public void pressShowResultButtonEx4bBD (BD4bController.listenerShowResultButtonEx4bBD l)
    {
        showResultButton.addActionListener(l);
    }
    void printErr(String errMessage)
    {
        JOptionPane.showMessageDialog(this, errMessage, "YOU REALLY ARE DUMB", JOptionPane.ERROR_MESSAGE);
    }
}
