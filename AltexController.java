import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Objects;

public class AltexController
{
    private AltexView view;
    private AltexModel model;

    public AltexController(AltexView view, AltexModel model)
    {
        this.view = view;
        this.model = model;
        view.pressButtonAllProducts(new listenerButtonAllProducts());
        view.pressButtonAllProductsCategory(new listenerButtonAllProductsCategory());
        view.pressButtonBuyProduct(new listenerButtonBuyProduct());
        view.pressCategoryBox(new listenerCategoryBox());
        view.pressButtonEx3BD(new listenerButtonEx3BD());
        view.pressButtonEx4BD(new listenerButtonEx4BD());
        view.pressButtonEx5BD(new listenerButtonEx5BD());
        view.pressButtonEx6BD(new listenerButtonEx6BD());
    }

    class listenerButtonAllProducts implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (!view.getProductsList().isVisible())
            {
                view.getScrollPane().setVisible(true);
                view.getProductsList().setVisible(true);
            }
            view.categoryBox.setEnabled(false);

            String dep[] = new String[model.getStore().deposit.size()];
            for (int i = 0; i < model.getStore().deposit.size(); i++)
            {
                dep[i] = model.getStore().deposit.get(i).toString() + "  The id is " + model.getStore().deposit.get(i).model + ". The price is " + model.getStore().deposit.get(i).price;
            }
            view.setMode(view.mode, dep);
        }
    }

    class listenerButtonAllProductsCategory implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (view.getProductsList().isVisible())
            {
                //view.getProductsList().setVisible(false);
                //view.getScrollPane().setVisible(false);
            }
            view.categoryBox.setEnabled(true);
        }
    }

    class listenerButtonBuyProduct implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            //view.getProductsList().setVisible(false);
            //view.getScrollPane().setVisible(false);

            if (view.getTextFieldIdProduct().getText().length() == 0)
            {
                view.printErr("You did not write anything. Please write a number ffs.");
                return;
            }
            if (!onlyDigits(view.getTextFieldIdProduct().getText(), view.getTextFieldIdProduct().getText().length()))
            {
                view.printErr("You did not write a valid number. Please write a number ffs.");
                return;
            }

            try
            {
                model.getClient().buysProduct(model.getStore(), model.getEmployee1(), Integer.parseInt(view.getTextFieldIdProduct().getText()), Integer.parseInt(view.getTextFieldPriceProduct().getText()));
                view.printInfo("You bought the product. Now u don't have enough money to feed ur family");
            }
            catch (ParseException ex)
            {
                throw new RuntimeException(ex);
            }

            view.getTextFieldIdProduct().setText("");
            view.getTextFieldPriceProduct().setText("");
            view.getCategoryBox().setEnabled(false);
        }
    }

    class listenerCategoryBox implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String s = (String) view.categoryBox.getSelectedItem();
            String[] dep = new String[model.getStore().deposit.size()];

            switch (Objects.requireNonNull(s)) {
                case "LAPTOP" -> {

                    view.getMode().clear();
                    view.getProductsList().removeAll();
                    for (int i = 0; i < view.getMode().size(); i++)
                    {
                        view.getMode().remove(i);
                        view.getProductsList().remove(i);
                    }

                    boolean verify = false;
                    for (int i = 0; i < model.getStore().deposit.size(); i++)
                    {
                        if (model.getStore().deposit.get(i).category.equals("LAPTOP"))
                        {
                            dep[i] = model.getStore().deposit.get(i).toString() + "  The id is " + model.getStore().deposit.get(i).model + ". The price is " + model.getStore().deposit.get(i).price;                            verify = true;
                        }
                    }

                    if (!verify)
                    {
                        System.out.println("There are no products currently in this category. You can try other categories.");
                    }

                    view.setMode(view.getMode(), dep);
                    break;
                }
                case "PC" -> {

                    view.getMode().clear();
                    view.getProductsList().removeAll();
                    for (int i = 0; i < view.getMode().size(); i++)
                    {
                        view.getMode().remove(i);
                        view.getProductsList().remove(i);
                    }

                    boolean verify = false;
                    for (int i = 0; i < model.getStore().deposit.size(); i++)
                    {
                        if (model.getStore().deposit.get(i).category.equals("PC"))
                        {
                            dep[i] = model.getStore().deposit.get(i).toString() + "  The id is " + model.getStore().deposit.get(i).model + ". The price is " + model.getStore().deposit.get(i).price;                            verify = true;
                        }
                    }

                    if (!verify)
                    {
                        System.out.println("There are no products currently in this category. You can try other categories.");
                    }

                    view.setMode(view.getMode(), dep);
                    break;
                }
                case "PRINTER" -> {

                    view.getMode().clear();
                    view.getProductsList().removeAll();
                    for (int i = 0; i < view.getMode().size(); i++)
                    {
                        view.getMode().remove(i);
                        view.getProductsList().remove(i);
                    }

                    boolean verify = false;
                    for (int i = 0; i < model.getStore().deposit.size(); i++)
                    {
                        if (model.getStore().deposit.get(i).category.equals("PRINTER"))
                        {
                            dep[i] = model.getStore().deposit.get(i).toString() + "  The id is " + model.getStore().deposit.get(i).model + ". The price is " + model.getStore().deposit.get(i).price;                            verify = true;
                        }
                    }

                    if (!verify)
                    {
                        System.out.println("There are no products currently in this category. You can try other categories.");
                    }

                    view.setMode(view.getMode(), dep);
                    break;
                }
            }
        }
    }

    class listenerButtonEx3BD implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (view.getEx3a().isSelected())
            {
                view.bd3View.jframeEx3.setVisible(true);
                view.getEx3a().setSelected(false);
            }
            if (view.getEx3b().isSelected())
            {
                view.bd3bView.jframeEx3b.setVisible(true);
                view.getEx3b().setSelected(false);
            }
        }
    }

    class listenerButtonEx4BD implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (view.getEx4a().isSelected())
            {
                view.bd4View.jframeEx4.setVisible(true);
                view.getEx4a().setSelected(false);
            }
            if (view.getEx4b().isSelected())
            {
                view.bd4bView.jframeEx4b.setVisible(true);
                view.getEx4b().setSelected(false);
            }
        }
    }
    class listenerButtonEx5BD implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (view.getEx5a().isSelected())
            {
                view.bd5View.jframeEx5.setVisible(true);
                view.getEx5a().setSelected(false);
            }
            if (view.getEx5b().isSelected())
            {
                view.bd5bView.jframeEx5b.setVisible(true);
                view.getEx5b().setSelected(false);
            }
        }
    }
    class listenerButtonEx6BD implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (view.getEx6a().isSelected())
            {
                view.bd6View.jframeEx6.setVisible(true);
                view.getEx6a().setSelected(false);
            }
            if (view.getEx6b().isSelected())
            {
                view.bd6bView.jframeEx6b.setVisible(true);
                view.getEx6b().setSelected(false);
            }
        }
    }

    public static boolean
    onlyDigits(String str, int n)
    {
        // Traverse the string from
        // start to end
        for (int i = 0; i < n; i++) {

            // Check if character is
            // not a digit between 0-9
            // then return false
            if (str.charAt(i) < '0'
                    || str.charAt(i) > '9') {
                return false;
            }
        }
        // If we reach here, that means
        // all characters were digits.
        return true;
    }
}
