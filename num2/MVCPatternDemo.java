package num2;

class Student {
  private String npm;
  private String name;

  public String getNpm() {
    return npm;
  }

  public void setNpm(String npm) {
    this.npm = npm;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

class StudentView {
  public void printStudentDetails(String studentName, String studentNpm) {
    System.out.println("---");
    System.out.println("Name: " + studentName);
    System.out.println("NPM: " + studentNpm);
  }
}

class StudentController {
  private Student model;
  private StudentView view;

  public StudentController(Student model, StudentView view) {
    this.model = model;
    this.view = view;
  }

  public void setStudentName(String name) {
    model.setName(name);
  }

  public String getStudentName() {
    return model.getName();
  }

  public void setStudentNpm(String npm) {
    model.setNpm(npm);
  }

  public String getStudentNpm() {
    return model.getNpm();
  }

  public void updateView() {
    view.printStudentDetails(model.getName(), model.getNpm());
  }
}

public class MVCPatternDemo {
  public static void main(String[] args) {

    // fetch student record based on his roll no from the database
    Student model = retriveStudentFromDatabase();

    // Create a view : to write student details on console
    StudentView view = new StudentView();

    StudentController controller = new StudentController(model, view);
    controller.updateView();

    // update model data
    controller.setStudentName("John");
    controller.updateView();
  }

  private static Student retriveStudentFromDatabase() {
    Student student = new Student();
    student.setName("Robert");
    student.setNpm("2006123456");
    return student;
  }
}
