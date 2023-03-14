import java.util.ArrayList;

public class Store
{
    public final ArrayList<Product> deposit = new ArrayList<>();
    public final ArrayList<Employee> employees = new ArrayList<>();

    private String openingDate;
    private String managerName;

    public Store(String openingDate, String managerName)
    {
        this.openingDate = openingDate;
        this.managerName = managerName;
    }

    public void addProductInDeposit (Product product)
    {
        boolean verify = true;
        for (Product prod : deposit)
        {
            if (prod.model == product.model)
            {
                verify = false;
                break;
            }
        }
        if (verify)
        {
            deposit.add(product);
        }
        else
        {
            System.out.println("The id " + product.model +" is already in the deposit. Please change the model of the product!");
        }
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Store{" +
                "deposit=" + deposit +
                ", employees=" + employees +
                ", openingDate='" + openingDate + '\'' +
                ", managerName='" + managerName + '\'' +
                '}';
    }
}
