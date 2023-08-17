public class Person
{
    private String name;
    private String address;
    private String phone;
    private String email;

    public Person(String name)
    {
        this.name = name;
    }

    @Override
    public String toString() {
        return "The Class: " + getClass().getSimpleName() + "  The Person's name: " + name;
    }

}


class Student extends Person
{
    private String status;

    public Student(String name)
    {
        super(name);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Employee extends Person
{
    private String office;
    private double salary;
    private String dateHired;

    public Employee(String name)
    {
        super(name);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


class Faculty extends Employee
{
    private String office;
    private double hours;
    private String rank;

    public Faculty(String name)
    {
        super(name);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Staff extends Employee
{
    private String title;

    public Staff(String name)
    {
        super(name);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class FullTime extends Staff
{
    private double salary;

    public FullTime(String name, double salary)
    {
        super(name);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + "  Salary: " + salary + "/=";
    }
}

class PartTime extends Staff
{
    private double hoursWorked;
    private double ratePerHour;

    public PartTime(String name)
    {
        super(name);
    }

    public void setWorkingHours(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    @Override
    public String toString() {
        return super.toString() + "  Salary: " + ratePerHour*hoursWorked + "/=";
    }
}


class MyDate
{
    private int day;
    private int month;
    private int year;
}



/*

abstract class Staff extends Employee {
    private String title;

    public Staff(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    // Abstract method to calculate earnings
    public abstract double calculateEarnings();
}


class FullTime extends Staff {
    private double salary;

    public FullTime(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public double calculateEarnings() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + "  Salary: " + calculateEarnings() + "/=";
    }
}

class PartTime extends Staff {
    private double hoursWorked;
    private double ratePerHour;

    public PartTime(String name) {
        super(name);
    }

    public void setWorkingHours(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    @Override
    public double calculateEarnings() {
        return ratePerHour * hoursWorked;
    }

    @Override
    public String toString() {
        return super.toString() + "  Salary: " + calculateEarnings() + "/=";
    }
}
*/
