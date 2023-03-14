import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Math.abs;

public class Manager
{
    private final String name;
    private final int age;


    public Manager(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public void addEmployee(Employee employee, Store store)
    {
        if (store.deposit.size() <= 10)
        {
            if (verifyEmployee(employee))
            {
                store.employees.add(employee);
                System.out.println(employee.getName() + " is now working at the store.");
            }
        }
        else
        {
            System.out.println("We can not hire " + employee.getName() + ", we have no openings.");
        }

    }

    public boolean verifyEmployee(Employee employee)
    {
        if (employee.workingDays.size() == 0)
        {
            System.out.println(employee.getName() + " didn't specify in what days he would like to work.");
            return false;
        }
        if (employee.workingDays.size() < 4)
        {
            System.out.println(employee.managerName + " doesn't agree with the program, you do not work enough days.");
            return false;
        }
        //else if (employee.hoursWorkedPerDay < 8) asta nu merge nuj dc
        else if (abs(employee.finishShiftEveryDay - employee.startShiftEveryDay) < 8)
        {
            System.out.println(employee.managerName + " doesn't agree with the program, you do not work enough hours per day.");
            return false;
        }
        else
        {
            System.out.println(employee.managerName + " agrees with your program.");
            return true;
        }
    }

    public void checkAndRaiseSalary(Store store)
    {
        for (int i = 0; i < store.employees.size(); i++)
        {
            for (int n = 1; n < 100000; n = n + 100)
            {
                if (store.employees.get(i).salesNumber >= n)
                {
                    setSalary(store.employees.get(i), store.employees.get(i).salary + 50);
                    break;
                }
            }
        }
    }

    public void setSalary(Employee employee, int salary)
    {
        employee.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
