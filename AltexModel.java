import java.text.ParseException;

import static java.lang.Math.abs;

public class AltexModel
{

    private Manager manager1 = new Manager("Pop Cornel Adrian", 35);
    private Store store = new Store("December-15-2002", manager1.getName());

    private Employee employee1 = new Employee("Alex", 20, 4500, 10, 18);
    private Employee employee2 = new Employee("Razvan", 24, 4000, 10, 18);
    private Laptop laptop1 = new Laptop(1, "ASUS", "LAPTOP", 3800, 3300, 4.0, 16, 1000, 15.6 );
    private Laptop laptop2 = new Laptop(2, "HP", "LAPTOP", 4000, 3500, 4.2, 32, 1000, 15.6 );

    public Manager getManager1() {
        return manager1;
    }

    public void setManager1(Manager manager1) {
        this.manager1 = manager1;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Employee getEmployee1() {
        return employee1;
    }

    public void setEmployee1(Employee employee1) {
        this.employee1 = employee1;
    }

    public Employee getEmployee2() {
        return employee2;
    }

    public void setEmployee2(Employee employee2) {
        this.employee2 = employee2;
    }

    public Laptop getLaptop1() {
        return laptop1;
    }

    public void setLaptop1(Laptop laptop1) {
        this.laptop1 = laptop1;
    }

    public Laptop getLaptop2() {
        return laptop2;
    }

    public void setLaptop2(Laptop laptop2) {
        this.laptop2 = laptop2;
    }

    public Laptop getLaptop3() {
        return laptop3;
    }

    public void setLaptop3(Laptop laptop3) {
        this.laptop3 = laptop3;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    Laptop laptop3 = new Laptop(3, "HP", "LAPTOP", 3000, 2500, 3.7, 8, 512, 15.6 );
    Laptop laptop4 = new Laptop(4, "HP", "LAPTOP", 3000, 2500, 3.7, 8, 512, 15.6 );
    Laptop laptop5 = new Laptop(5, "HP", "LAPTOP", 3000, 2500, 3.7, 8, 512, 15.6 );
    Laptop laptop6 = new Laptop(6, "HP", "LAPTOP", 3000, 2500, 3.7, 8, 512, 15.6 );
    Laptop laptop7 = new Laptop(7, "HP", "LAPTOP", 3000, 2500, 3.7, 8, 512, 15.6 );
    Laptop laptop8 = new Laptop(8, "HP", "LAPTOP", 3000, 2500, 3.7, 8, 512, 15.6 );
    Laptop laptop9 = new Laptop(9, "HP", "LAPTOP", 3000, 2500, 3.7, 8, 512, 15.6 );
    Laptop laptop10 = new Laptop(10, "HP", "LAPTOP", 3000, 2500, 3.7, 8, 512, 15.6 );
    Printer printer1 = new Printer(11, "ger", "PRINTER", 23, 23, false, "jet");
    PC pc1 = new PC(12, "uc", "PC", 34, 34, 34, 34, 43);
    Client client = new Client("David IKB");



    public AltexModel() throws ParseException {
        System.out.println(manager1.getName() + " este manager1 si are " + manager1.getAge() + " de ani");
        System.out.println(store);

        employee1.setManagerName(manager1.getName());
        employee1.addWorkingDays("Monday");
        employee1.addWorkingDays("Tuesday");
        employee1.addWorkingDays("Thursday");
        employee1.addWorkingDays("Wednesday");
        employee2.setManagerName(manager1.getName());
        employee2.addWorkingDays("Monday");
        employee2.addWorkingDays("Tuesday");
        employee2.addWorkingDays("Thursday");
        employee2.addWorkingDays("Wednesday");
        manager1.addEmployee(employee1, store);
        manager1.addEmployee(employee2, store);
        employee1.modifyStartAndFinishShift(11, 18);
        System.out.println(employee1.getFinishShiftEveryDay());
        System.out.println(employee1.getStartShiftEveryDay());
        manager1.verifyEmployee(employee1);

        store.addProductInDeposit(laptop1);
        store.addProductInDeposit(laptop2);
        store.addProductInDeposit(laptop3);
        store.addProductInDeposit(laptop4);
        store.addProductInDeposit(laptop5);
        store.addProductInDeposit(laptop6);
        store.addProductInDeposit(laptop7);
        store.addProductInDeposit(laptop8);
        store.addProductInDeposit(laptop9);
        store.addProductInDeposit(laptop10);
        store.addProductInDeposit(pc1);
        store.addProductInDeposit(printer1);
        System.out.println("--------" + employee1.getSalary());

        System.out.println(store);
        client.buysProduct(store, employee1, 2, 4000);
        System.out.println(store);

        manager1.checkAndRaiseSalary(store);
        System.out.println("--------" + employee1.getSalary());

        client.showCertainTypeProducts(store, "LAPTOP");
        client.showCertainTypeProducts(store, "PHONE");

        //client.showPriceOrderedProducts(store, "PHONE");

        client.checkAndApplySpecialOffer(store);

    }

}
