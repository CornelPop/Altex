import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class AltexView extends JFrame
{
    private final AltexModel model;

    public BD3View bd3View;
    public BD3bView bd3bView;
    public BD4View bd4View;
    public BD4bView bd4bView;
    public BD5View bd5View;
    public BD5bView bd5bView;
    public BD6View bd6View;
    public BD6bView bd6bView;

    DefaultListModel mode = new DefaultListModel();
    JList<Object> productsList = new JList<>(mode);
    JScrollPane scrollPane = new JScrollPane(productsList);

    JFrame jframe = new JFrame("Altex from wish");
    JPanel contentPanel = new JPanel();
    JPanel imageTitle = new JPanel();
    JPanel jCenter = new JPanel();
    JPanel jLeft = new JPanel();
    JPanel jRight = new JPanel();
    JPanel jTop = new JPanel();
    JPanel jBottom = new JPanel();

    JButton buttonAllProducts = new JButton();
    JButton buttonAllProductsCategory = new JButton();
    JButton buttonBuyProduct = new JButton();
    JButton buttonEx3BD = new JButton();
    JButton buttonEx4BD = new JButton();
    JButton buttonEx5BD = new JButton();
    JButton buttonEx6BD = new JButton();

    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();

    JCheckBox ex3a = new JCheckBox("a)");
    JCheckBox ex3b = new JCheckBox("b)");
    JCheckBox ex4a = new JCheckBox("a)");
    JCheckBox ex4b = new JCheckBox("b)");
    JCheckBox ex5a = new JCheckBox("a)");
    JCheckBox ex5b = new JCheckBox("b)");
    JCheckBox ex6a = new JCheckBox("a)");
    JCheckBox ex6b = new JCheckBox("b)");

    String[] category = {"PC", "LAPTOP", "PRINTER"};

    public JCheckBox getEx3a() {
        return ex3a;
    }

    public void setEx3a(JCheckBox ex3a) {
        this.ex3a = ex3a;
    }

    public JCheckBox getEx3b() {
        return ex3b;
    }

    public void setEx3b(JCheckBox ex3b) {
        this.ex3b = ex3b;
    }

    public JCheckBox getEx4a() {
        return ex4a;
    }

    public void setEx4a(JCheckBox ex4a) {
        this.ex4a = ex4a;
    }

    public JCheckBox getEx4b() {
        return ex4b;
    }

    public void setEx4b(JCheckBox ex4b) {
        this.ex4b = ex4b;
    }

    public JCheckBox getEx5a() {
        return ex5a;
    }

    public void setEx5a(JCheckBox ex5a) {
        this.ex5a = ex5a;
    }

    public JCheckBox getEx5b() {
        return ex5b;
    }

    public void setEx5b(JCheckBox ex5b) {
        this.ex5b = ex5b;
    }

    public JCheckBox getEx6a() {
        return ex6a;
    }

    public void setEx6a(JCheckBox ex6a) {
        this.ex6a = ex6a;
    }

    public JCheckBox getEx6b() {
        return ex6b;
    }

    public void setEx6b(JCheckBox ex6b) {
        this.ex6b = ex6b;
    }

    JComboBox<String> categoryBox = new JComboBox<>(category);

    JTextField textFieldIdProduct = new JTextField();
    JTextField textFieldPriceProduct = new JTextField();

    public JFrame getJframe() {
        return jframe;
    }

    public void setJframe(JFrame jframe) {
        this.jframe = jframe;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public void setContentPanel(JPanel contentPanel) {
        this.contentPanel = contentPanel;
    }

    public JPanel getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(JPanel imageTitle) {
        this.imageTitle = imageTitle;
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

    public JButton getButtonAllProducts() {
        return buttonAllProducts;
    }

    public void setButtonAllProducts(JButton buttonAllProducts) {
        this.buttonAllProducts = buttonAllProducts;
    }

    public JButton getButtonAllProductsCategory() {
        return buttonAllProductsCategory;
    }

    public void setButtonAllProductsCategory(JButton buttonAllProductsCategory) {
        this.buttonAllProductsCategory = buttonAllProductsCategory;
    }

    public JButton getButtonBuyProduct() {
        return buttonBuyProduct;
    }

    public void setButtonBuyProduct(JButton buttonBuyProduct) {
        this.buttonBuyProduct = buttonBuyProduct;
    }

    public JLabel getLabel1() {
        return label1;
    }

    public void setLabel1(JLabel label1) {
        this.label1 = label1;
    }

    public String[] getCategory() {
        return category;
    }

    public void setCategory(String[] category) {
        this.category = category;
    }

    public JComboBox<String> getCategoryBox() {
        return categoryBox;
    }

    public void setCategoryBox(JComboBox<String> categoryBox) {
        this.categoryBox = categoryBox;
    }

    public JList<Object> getProductsList() {
        return productsList;
    }

    public void setProductsList(JList<Object> productsList) {
        this.productsList = productsList;
    }

    public DefaultListModel getMode() {
        return mode;
    }

    public void setMode(DefaultListModel mode, String[] dep) {
        for (int i = 0; i < dep.length; i++)
        {
            this.mode.add(i, dep[i]);
        }
        this.mode = mode;
    }

    public JTextField getTextFieldIdProduct() {
        return textFieldIdProduct;
    }

    public void setTextFieldIdProduct(JTextField textFieldIdProduct) {
        this.textFieldIdProduct = textFieldIdProduct;
    }

    public ImageIcon getImage() {
        return image;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    ImageIcon image = new ImageIcon("D:\\Diverse/altex.png");


    public JTextField getTextFieldPriceProduct() {
        return textFieldPriceProduct;
    }

    public void setTextFieldPriceProduct(JTextField textFieldPriceProduct) {
        this.textFieldPriceProduct = textFieldPriceProduct;
    }

    public AltexModel getModel() {
        return model;
    }

    public AltexView(AltexModel model, BD3View bd3View, BD3bView bd3bView, BD4View bd4View, BD4bView bd4bView, BD5View bd5View, BD5bView bd5bView, BD6View bd6View, BD6bView bd6bView)
    {

        this.model = model;
        this.bd3View = bd3View;
        this.bd3bView = bd3bView;
        this.bd4View = bd4View;
        this.bd4bView = bd4bView;
        this.bd5View = bd5View;
        this.bd5bView = bd5bView;
        this.bd6View = bd6View;
        this.bd6bView = bd6bView;

        String[] dep = new String[model.getStore().deposit.size()];

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(1100,700);
        jframe.setLocationRelativeTo(null);

        categoryBox.setEnabled(false);
        productsList.setVisible(false);

        productsList.setSelectedIndex(0);
        //scrollPane.setVisible(false);

        textFieldIdProduct.setToolTipText("Type the id of the product.");
        textFieldPriceProduct.setToolTipText("Type the price you want to buy the product at.");

        contentPanel.setBackground(Color.RED);
        imageTitle.setBackground(Color.ORANGE);
        productsList.setBackground(Color.ORANGE);
        scrollPane.setBackground(Color.ORANGE);
        jLeft.setBackground(Color.ORANGE);
        jRight.setBackground(Color.ORANGE);
        jTop.setBackground(Color.ORANGE);
        jBottom.setBackground(Color.ORANGE);
        jCenter.setBackground(Color.ORANGE);
        ex3a.setBackground(Color.ORANGE);
        ex3b.setBackground(Color.ORANGE);
        ex4a.setBackground(Color.ORANGE);
        ex4b.setBackground(Color.ORANGE);
        ex5a.setBackground(Color.ORANGE);
        ex5b.setBackground(Color.ORANGE);
        ex6a.setBackground(Color.ORANGE);
        ex6b.setBackground(Color.ORANGE);
        label2.setBackground(null);

        jLeft.setLayout(new BoxLayout(jLeft, BoxLayout.Y_AXIS));
        jRight.setLayout(new BoxLayout(jRight, BoxLayout.Y_AXIS));
        jTop.setLayout(new FlowLayout());
        jBottom.setLayout(new FlowLayout());
        jCenter.setLayout(new FlowLayout());

        jLeft.setPreferredSize(new Dimension(250, 100));
        jRight.setPreferredSize(new Dimension(250, 100));
        jCenter.setPreferredSize(new Dimension(50, 100));
        jBottom.setPreferredSize(new Dimension(50, 90));
        jTop.setPreferredSize(new Dimension(50, 137));
        imageTitle.setPreferredSize(new Dimension(300, 127));
        productsList.setFixedCellHeight(50);
        productsList.setFixedCellWidth(100);

        jTop.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        jLeft.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        jRight.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        jBottom.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        jCenter.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(jLeft, BorderLayout.WEST);
        contentPanel.add(jRight, BorderLayout.EAST);
        contentPanel.add(jTop, BorderLayout.NORTH);
        contentPanel.add(jBottom, BorderLayout.SOUTH);
        contentPanel.add(jCenter, BorderLayout.CENTER);

        buttonAllProducts.setMinimumSize(new Dimension(175, 50));
        buttonAllProducts.setPreferredSize(new Dimension(175, 50));
        buttonAllProducts.setMaximumSize(new Dimension(175, 50));
        buttonAllProductsCategory.setMinimumSize(new Dimension(175, 50));
        buttonAllProductsCategory.setPreferredSize(new Dimension(175, 50));
        buttonAllProductsCategory.setMaximumSize(new Dimension(175, 50));
        buttonBuyProduct.setMinimumSize(new Dimension(175, 50));
        buttonBuyProduct.setPreferredSize(new Dimension(175, 50));
        buttonBuyProduct.setMaximumSize(new Dimension(175, 50));
        categoryBox.setMinimumSize(new Dimension(175, 25));
        categoryBox.setPreferredSize(new Dimension(175, 25));
        categoryBox.setMaximumSize(new Dimension(175, 25));
        textFieldIdProduct.setMinimumSize(new Dimension(175, 25));
        textFieldIdProduct.setPreferredSize(new Dimension(175, 25));
        textFieldIdProduct.setMaximumSize(new Dimension(175, 25));
        textFieldPriceProduct.setMinimumSize(new Dimension(175, 25));
        textFieldPriceProduct.setPreferredSize(new Dimension(175, 25));
        textFieldPriceProduct.setMaximumSize(new Dimension(175, 25));
        productsList.setMinimumSize(new Dimension(580, dep.length * 50));
        productsList.setPreferredSize(new Dimension(580, dep.length * 50));
        productsList.setMaximumSize(new Dimension(580, dep.length * 50));
        scrollPane.setMinimumSize(new Dimension(580, 410));
        scrollPane.setPreferredSize(new Dimension(580, 410));
        scrollPane.setMaximumSize(new Dimension(580, 410));
        buttonEx3BD.setMinimumSize(new Dimension(175, 50));
        buttonEx3BD.setPreferredSize(new Dimension(175, 50));
        buttonEx3BD.setMaximumSize(new Dimension(175, 50));
        buttonEx4BD.setMinimumSize(new Dimension(175, 50));
        buttonEx4BD.setPreferredSize(new Dimension(175, 50));
        buttonEx4BD.setMaximumSize(new Dimension(175, 50));
        buttonEx5BD.setMinimumSize(new Dimension(175, 50));
        buttonEx5BD.setPreferredSize(new Dimension(175, 50));
        buttonEx5BD.setMaximumSize(new Dimension(175, 50));
        buttonEx6BD.setMinimumSize(new Dimension(175, 50));
        buttonEx6BD.setPreferredSize(new Dimension(175, 50));
        buttonEx6BD.setMaximumSize(new Dimension(175, 50));

        buttonBuyProduct.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonAllProducts.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonAllProductsCategory.setAlignmentX(Component.CENTER_ALIGNMENT);
        textFieldIdProduct.setAlignmentX(Component.CENTER_ALIGNMENT);
        textFieldPriceProduct.setAlignmentX(Component.CENTER_ALIGNMENT);
        categoryBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonEx3BD.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonEx4BD.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonEx5BD.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonEx6BD.setAlignmentX(Component.CENTER_ALIGNMENT);
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonAllProducts.setText("All products");
        buttonAllProductsCategory.setText("All products by category");
        buttonBuyProduct.setText("Buy product");
        buttonEx3BD.setText("Exercise 3 BD");
        buttonEx4BD.setText("Exercise 4 BD");
        buttonEx5BD.setText("Exercise 5 BD");
        buttonEx6BD.setText("Exercise 6 BD");
        label2.setText("The filters for the most wanted products!");

        jTop.add(imageTitle);

        label1.setIcon(image);
        imageTitle.add(label1);
        jLeft.add(Box.createVerticalStrut(15));
        jLeft.add(buttonAllProducts);
        jLeft.add(Box.createVerticalStrut(65));
        jLeft.add(buttonAllProductsCategory);
        jLeft.add(Box.createVerticalStrut(10));
        jLeft.add(categoryBox);
        jLeft.add(Box.createVerticalStrut(65));
        jLeft.add(buttonBuyProduct);
        jLeft.add(Box.createVerticalStrut(10));
        jLeft.add(textFieldIdProduct);
        jLeft.add(Box.createVerticalStrut(10));
        jLeft.add(textFieldPriceProduct);
        jLeft.add(Box.createVerticalStrut(15));

        jRight.add(Box.createVerticalStrut(5));
        jRight.add(label2);
        jRight.add(Box.createVerticalStrut(5));
        jRight.add(buttonEx3BD);
        jRight.add(ex3a);
        jRight.add(ex3b);
        jRight.add(Box.createVerticalStrut(3));
        jRight.add(buttonEx4BD);
        jRight.add(ex4a);
        jRight.add(ex4b);
        jRight.add(Box.createVerticalStrut(3));
        jRight.add(buttonEx5BD);
        jRight.add(ex5a);
        jRight.add(ex5b);
        jRight.add(Box.createVerticalStrut(3));
        jRight.add(buttonEx6BD);
        jRight.add(ex6a);
        jRight.add(ex6b);
        jRight.add(Box.createVerticalStrut(3));

        jCenter.add(scrollPane);

        jframe.setContentPane(contentPanel);
        jframe.setVisible(true);

    }

    public void pressButtonAllProducts(AltexController.listenerButtonAllProducts l)
    {
        buttonAllProducts.addActionListener(l);
    }

    public void pressButtonAllProductsCategory(AltexController.listenerButtonAllProductsCategory l)
    {
        buttonAllProductsCategory.addActionListener(l);
    }

    public void pressButtonBuyProduct(AltexController.listenerButtonBuyProduct l)
    {
        buttonBuyProduct.addActionListener(l);
    }

    public void pressButtonEx3BD(AltexController.listenerButtonEx3BD l)
    {
        buttonEx3BD.addActionListener(l);
    }
    public void pressButtonEx4BD(AltexController.listenerButtonEx4BD l)
    {
        buttonEx4BD.addActionListener(l);
    }
    public void pressButtonEx5BD(AltexController.listenerButtonEx5BD l)
    {
        buttonEx5BD.addActionListener(l);
    }
    public void pressButtonEx6BD(AltexController.listenerButtonEx6BD l)
    {
        buttonEx6BD.addActionListener(l);
    }

    public void pressCategoryBox(AltexController.listenerCategoryBox l)
    {
        categoryBox.addActionListener(l);
    }

    void printErr(String errMessage)
    {
        JOptionPane.showMessageDialog(this, errMessage, "YOU REALLY ARE DUMB", JOptionPane.ERROR_MESSAGE);
    }

    void printInfo(String infoMessage)
    {
        JOptionPane.showMessageDialog(this, infoMessage, "YOU REALLY ARE DUMB", JOptionPane.INFORMATION_MESSAGE);
    }

    /*----------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------*/

}
