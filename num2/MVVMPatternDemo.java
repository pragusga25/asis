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
  private StudentViewModel viewModel;

  public StudentView(StudentViewModel viewModel) {
    this.viewModel = viewModel;
  }

  public void printStudentDetails(String studentName, String studentNpm) {
    System.out.println("---");
    System.out.println("Name: " + studentName);
    System.out.println("NPM: " + studentNpm);
  }

  public void setStudentName(String studentName) {
    viewModel.setStudentName(studentName);
  }

  public void updateView() {
    printStudentDetails(viewModel.getStudentName(), viewModel.getStudentNpm());
  }
}

class StudentViewModel {
  private Student model;

  public StudentViewModel(Student model) {
    this.model = model;
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

}

public class MVVMPatternDemo {
  public static void main(String[] args) {

    // fetch student record based on his roll no from the database
    Student model = retriveStudentFromDatabase();

    StudentViewModel viewModel = new StudentViewModel(model);

    // Create a view : to write student details on console
    StudentView view = new StudentView(viewModel);

    view.updateView();

    // update model data
    view.setStudentName("John");
    view.updateView();
  }

  private static Student retriveStudentFromDatabase() {
    Student student = new Student();
    student.setName("Robert");
    student.setNpm("2006123456");
    return student;
  }
}
