import java.util.ArrayList;

import static java.lang.Math.abs;

public class Employee
{
    public String managerName;
    private final String name;
    private final int age;
    public int salary;
    public int startShiftEveryDay;
    public int finishShiftEveryDay;
    public int hoursWorkedPerDay;
    public int salesNumber;
    public final ArrayList <String> workingDays = new ArrayList<>();

    public Employee(String name, int age, int salary, int startShiftEveryDay, int finishShiftEveryDay) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.startShiftEveryDay = startShiftEveryDay;
        this.finishShiftEveryDay = finishShiftEveryDay;
        this.hoursWorkedPerDay = abs(finishShiftEveryDay - startShiftEveryDay);
        this.salesNumber = 0;
    }

    public void setManagerName(String managerName)
    {
        this.managerName = managerName;
    }

    public void modifyStartAndFinishShift (int startShift, int endShift)
    {
        this.startShiftEveryDay = startShift;
        this.finishShiftEveryDay = endShift;
    }

    public String getManagerName() {
        return managerName;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public void setStartShiftEveryDay(int startShiftEveryDay) {
        this.startShiftEveryDay = startShiftEveryDay;
    }

    public void setFinishShiftEveryDay(int finishShiftEveryDay) {
        this.finishShiftEveryDay = finishShiftEveryDay;
    }

    public void setHoursWorkedPerDay(int hoursWorkedPerDay) {
        this.hoursWorkedPerDay = hoursWorkedPerDay;
    }

    public int getStartShiftEveryDay() {
        return startShiftEveryDay;
    }

    public int getFinishShiftEveryDay() {
        return finishShiftEveryDay;
    }

    public int getHoursWorkedPerDay() {
        return hoursWorkedPerDay;
    }

    public ArrayList<String> getWorkingDays() {
        return workingDays;
    }

    public int getSalesNumber() {
        return salesNumber;
    }

    public void setSalesNumber(int salesNumber) {
        this.salesNumber = salesNumber;
    }

    public void addWorkingDays(String day)
    {
        boolean verify = false;
        for (String string : workingDays)
        {
            if (string.equals(day))
            {
                verify = true;
                break;
            }
        }
        if (!verify)
        {
            workingDays.add(day);
            System.out.println(name + " added " + day + "as a working day.");
        }
        else
        {
            System.out.println(name + " already inserted this working day.");
        }
    }

    public void deleteWorkingDay(String day)
    {
        boolean verify = false;
        for (String string : workingDays)
        {
            if (string.equals(day))
            {
                verify = true;
                break;
            }
        }
        if (verify)
        {
            for (String string : workingDays)
            {
                if (string.equals(day))
                {
                    workingDays.remove(day);
                    System.out.println(name + " removed " + day + "from the working days.");
                }
            }
        }
        else
        {
            System.out.println(name + " doesn't have this day in his working days.");
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
