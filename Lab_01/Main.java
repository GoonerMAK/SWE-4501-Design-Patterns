import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Student student = new Student("MAK");
        Employee employee = new Employee("SAM");
        Faculty faculty = new Faculty("MAN");
        Staff staff = new Staff("KAM");
        FullTime fullTime = new FullTime("DAN", 1000000.00);
        PartTime partTime = new PartTime("YAN");

        System.out.print("Enter working hours: ");
        double workingHours = scanner.nextDouble();
        partTime.setWorkingHours(workingHours);

        System.out.print("Enter rate per hour: ");
        double ratePerHour = scanner.nextDouble();
        partTime.setRatePerHour(ratePerHour);

        scanner.close();

        /*partTime.setWorkingHours(60);
        partTime.setRatePerHour(10);*/

        System.out.println(student);
        System.out.println(employee);
        System.out.println(faculty);
        System.out.println(staff);
        System.out.println(fullTime);
        System.out.println(partTime);

        fullTime.getSalary();
        partTime.getSalary();
    }
}

