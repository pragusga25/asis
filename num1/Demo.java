package num1;

class StringUtils {
  public static boolean isPalindrome(String name) {
    boolean palindrome = false;

    if (name.length() % 2 == 0) {
      for (int i = 0; i < name.length() / 2 - 1; i++) {
        if (name.charAt(i) != name.charAt(name.length() - i - 1)) {
          return false;
        } else {
          palindrome = true;
        }
      }
    } else {
      for (int i = 0; i < (name.length() - 1) / 2 - 1; i++) {
        if (name.charAt(i) != name.charAt(name.length() - i - 1)) {
          return false;
        } else {
          palindrome = true;
        }
      }
    }

    return palindrome;
  }
}

abstract class Person {
  public String id = null;
  public String address = null;
  public String name = null;

  public Person(String id, String name, String address) {
    this.id = id;
    this.address = address;
    this.name = name;
  }

  public String getID() {
    return this.id;
  }

  public String getAddress() {
    return this.address;
  }

  public void setID(String id) {
    this.id = id;
  }

  public void setAddress(String addr) {
    this.address = addr;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public abstract String toString();

  public abstract void study();

  public abstract void work();
}

class Employee extends Person {
  public double salary = 0.0;

  public Employee(String id, String name, String address, double salary) {
    super(id, name, address);
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "ID: " + this.id + ", Name: " + this.name
        + ", Address: " + this.address + ", Salary: " + this.salary;
  }

  public double getSalary() {
    boolean isPalindrome = StringUtils.isPalindrome(this.name);
    if (isPalindrome) {
      return 1.1 * this.salary;
    } else {
      return this.salary;
    }
  }

  public void setSalary(double sal) {
    this.salary = sal;
  }

  @Override
  public void study() {
    System.out.println("Study the advanced technology for industry");
  }

  @Override
  public void work() {
    System.out.println("Works on office tasks");
  }

}

class Student extends Person {
  public double GPA = 0.0;

  public Student(String id, String name, String addr, double gpa) {
    super(id, name, addr);
    this.GPA = gpa;
  }

  public double getGPA() {
    return this.GPA;
  }

  @Override
  public String toString() {
    return "ID: " + this.id + ", Name: " + this.name
        + ", Address: " + this.address + ", GPA: " + this.GPA;
  }

  @Override
  public void study() {
    System.out.println("Study basic science and technology");
  }

  @Override
  public void work() {
    System.out.println("Works on campus assignments");
  }

}

public class Demo {

  public static void main(String[] args) {
    Person person1 = new Employee("Kary101", "NABABAN", "Jakarta", 1000);
    Person person2 = new Student("Stud101", "Budihardjo", "Bandung", 3.01);
    System.out.println(person1.toString());
    person1.study();
    person1.work();
    System.out.println(person2.toString());
    person2.study();
    person2.work();
    person2 = new Employee("Kary102", "Budihardjo", "Bandung", 900);
    System.out.println(person2.toString());
    person2.study();
    person2.work();
  }
}
