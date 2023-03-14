import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.sql.*;
import java.util.Properties;
import java.sql.*;

public class BD5bView extends Component {
    private final BD5bModel bd5bModel;
    JFrame jframeEx5b = new JFrame("Exercise 5b");
    JPanel contentPanel = new JPanel();
    JPanel topTablePanel = new JPanel();
    JPanel jCenter = new JPanel();
    JPanel jLeft = new JPanel();
    JPanel jRight = new JPanel();
    JPanel jTop = new JPanel();
    JPanel jBottom = new JPanel();
    JButton leaveButton = new JButton();
    JButton showResultButton = new JButton();
    JLabel modelLabel = new JLabel();
    JLabel culoareLabel = new JLabel();
    JLabel tipLabel = new JLabel();
    JLabel fabricantLabel = new JLabel();
    JLabel pretLabel = new JLabel();
    JLabel cerintaLabel = new JLabel();
    DefaultListModel mode = new DefaultListModel();
    JList<Object> productsList = new JList<>(mode);
    JTextField inputTextField = new JTextField();

    public BD5bModel getBd5bModel() {
        return bd5bModel;
    }

    public JFrame getJframeEx5b() {
        return jframeEx5b;
    }

    public void setJframeEx5b(JFrame jframeEx5b) {
        this.jframeEx5b = jframeEx5b;
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

    public JTextField getInputTextField() {
        return inputTextField;
    }

    public void setInputTextField(JTextField inputTextField) {
        this.inputTextField = inputTextField;
    }

    public BD5bView(BD5bModel bd5bModel)
    {
        this.bd5bModel = bd5bModel;
        jframeEx5b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframeEx5b.setSize(1100,700);
        jframeEx5b.setLocationRelativeTo(null);

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
        modelLabel.setMinimumSize(new Dimension(114, 46));
        modelLabel.setPreferredSize(new Dimension(114, 46));
        modelLabel.setMaximumSize(new Dimension(114, 46));
        culoareLabel.setMinimumSize(new Dimension(114, 46));
        culoareLabel.setPreferredSize(new Dimension(114, 46));
        culoareLabel.setMaximumSize(new Dimension(114, 46));
        tipLabel.setMinimumSize(new Dimension(114, 46));
        tipLabel.setPreferredSize(new Dimension(114, 46));
        tipLabel.setMaximumSize(new Dimension(114, 46));
        fabricantLabel.setMinimumSize(new Dimension(114, 46));
        fabricantLabel.setPreferredSize(new Dimension(114, 46));
        fabricantLabel.setMaximumSize(new Dimension(114, 46));
        pretLabel.setMinimumSize(new Dimension(115, 46));
        pretLabel.setPreferredSize(new Dimension(115, 46));
        pretLabel.setMaximumSize(new Dimension(115, 46));
        inputTextField.setMinimumSize(new Dimension(50, 25));
        inputTextField.setPreferredSize(new Dimension(50, 25));
        inputTextField.setMaximumSize(new Dimension(50, 25));
        productsList.setFixedCellHeight(50);
        productsList.setFixedCellWidth(100);

        modelLabel.setHorizontalAlignment(SwingConstants.CENTER);
        modelLabel.setVerticalAlignment(SwingConstants.CENTER);
        culoareLabel.setHorizontalAlignment(SwingConstants.CENTER);
        culoareLabel.setVerticalAlignment(SwingConstants.CENTER);
        tipLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tipLabel.setVerticalAlignment(SwingConstants.CENTER);
        fabricantLabel.setHorizontalAlignment(SwingConstants.CENTER);
        fabricantLabel.setVerticalAlignment(SwingConstants.CENTER);
        pretLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pretLabel.setVerticalAlignment(SwingConstants.CENTER);

        jTop.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        jLeft.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        jRight.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        jBottom.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        jCenter.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        topTablePanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        modelLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        culoareLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        tipLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        fabricantLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        pretLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

        leaveButton.setMinimumSize(new Dimension(175, 50));
        leaveButton.setPreferredSize(new Dimension(175, 50));
        leaveButton.setMaximumSize(new Dimension(175, 50));
        showResultButton.setMinimumSize(new Dimension(175, 50));
        showResultButton.setPreferredSize(new Dimension(175, 50));
        showResultButton.setMaximumSize(new Dimension(175, 50));

        leaveButton.setText("Back");
        showResultButton.setText("Show the list");
        modelLabel.setText("model");
        culoareLabel.setText("culoare");
        tipLabel.setText("tip");
        fabricantLabel.setText("fabricant");
        pretLabel.setText("pret");
        inputTextField.setToolTipText("Introduceti valoarea dorita");

        cerintaLabel.setText("Să se găsească imprimantele (model, culoare, tip, fabricant, preț) care au \n" +
                "același preț ca și imprimanta ce are modelul 111.");
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

        //topTablePanel.add(Box.createHorizontalStrut(30));
        topTablePanel.add(modelLabel);
        topTablePanel.add(culoareLabel);
        topTablePanel.add(tipLabel);
        topTablePanel.add(fabricantLabel);
        topTablePanel.add(pretLabel);

        jCenter.add(Box.createVerticalStrut(70));
        jCenter.add(inputTextField);
        jCenter.add(showResultButton);
        jCenter.add(topTablePanel);
        jCenter.add(scrollPane);
        jCenter.add(Box.createVerticalStrut(70));
        jCenter.add(leaveButton);
        jCenter.add(Box.createVerticalStrut(45));

        jframeEx5b.setContentPane(contentPanel);
        jframeEx5b.setVisible(false);
    }

    public void pressLeaveButtonEx5bBD (BD5bController.listenerLeaveButtonEx5bBD l)
    {
        leaveButton.addActionListener(l);
    }
    public void pressShowResultButtonEx5bBD (BD5bController.listenerShowResultButtonEx5bBD l)
    {
        showResultButton.addActionListener(l);
    }
    void printErr(String errMessage)
    {
        JOptionPane.showMessageDialog(this, errMessage, "YOU REALLY ARE DUMB", JOptionPane.ERROR_MESSAGE);
    }
}
