import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class Client
{
    private String clientName;

    public Client(String clientName)
    {
        this.clientName = clientName;
    }

    public void buysProduct(Store store, Employee employee, int model, int price) throws ParseException {
        boolean verify = false;
        for (Product prod : store.deposit)
        {
            if (prod.model == model)
            {
                verify = true;
                break;
            }
        }
        if (verify)
        {
            for (int i = 0; i < store.deposit.size(); i++)
            {
                if (store.deposit.get(i).model == model)
                {
                    if (checkAndApplySpecialOffer(store))
                    {
                        if (price >= store.deposit.get(i).promotionalPrice)
                        {
                            store.deposit.remove(store.deposit.get(i));
                            System.out.println("The client bought the product with the id = " + model + " at a PROMOTIONAL price. Congrats!");
                            employee.salesNumber++;
                            break;
                        }
                        else
                        {
                            System.out.println("The client did not have enough money.");
                            break;
                        }
                    }
                    if (!checkAndApplySpecialOffer(store))
                    {
                        if (price >= store.deposit.get(i).price)
                        {
                            store.deposit.remove(store.deposit.get(i));
                            System.out.println("The client bought the product with the id = " + model + " . Congrats!");
                            employee.salesNumber++;
                            break;
                        }
                        else
                        {
                            System.out.println("The client did not have enough money.");
                            break;
                        }
                    }
                }
            }
        }
        else
        {
            System.out.println("There is no product with this id in this store!");
        }
    }

    public void showCertainTypeProducts (Store store, String category)
    {
        System.out.println("The products from the " + category + " category are (model, fabricant, pret):");

        boolean verify = false;
        for (Product prod : store.deposit)
        {
            if (prod.category.equals(category))
            {
                System.out.println(prod.model + " " + prod.fabricant + " " + prod.price + " with the next specifics : " + prod + "\n");
                verify = true;
            }
        }

        if (!verify)
        {
            System.out.println("There are no products currently in this category. You can try other categories.");
        }
    }

    public void showPriceOrderedProducts (Store store, String category)
    {
        System.out.println("Here are the products ordered by price: ");

        boolean verify = false;
        Collections.sort(store.deposit);
        for (Product prod : store.deposit)
        {
            if (prod.category.equals(category))
            {
                System.out.println("Model: " + prod.model + " Fabricant: " + prod.fabricant + " Proce: " + prod.price + " with the next specifics : " + prod + "\n");
                verify = true;
            }
        }

        if (!verify)
        {
            System.out.println("There are no products currently in this category. You can try other categories.");
        }
    }

    public boolean checkAndApplySpecialOffer(Store store) throws ParseException
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = simpleDateFormat.parse("2022-12-01");
        Date date2 = simpleDateFormat.parse("2022-12-31");
        Date obj = new Date();
        return obj.after(date1) && obj.before(date2);
    }

    public String getClientName()
    {
        return clientName;
    }

    public void setClientName(String clientName)
    {
        this.clientName = clientName;
    }
}
