import java.util.ArrayList;
import java.util.List;

class Main{
  public static void main(String[] args) {
    Institute ca = new Institute("Christ Academy");
    Student s11 = new Student("Vigyan", ca);
    Student s12 = new Student("Vedanshi", ca);
    Student s13 = new Student("Jahnvi", ca);
    Student s14 = new Student("Abhiraj", ca);
    Student[] ca_students = { s11, s12, s13, s14 };
    ca.addStudent(ca_students);

    Institute vibgyor = new Institute("VIBGYOR");
    Student s21 = new Student("Sai", vibgyor);
    Student s22 = new Student("Pragati", vibgyor);
    Student s23 = new Student("Mukil", vibgyor);
    Student[] vibgyor_students = { s21, s22, s23 };
    vibgyor.addStudent(vibgyor_students);

    System.out.println(ca);
    System.out.println(vibgyor);
  }
}

class Institute{
  private final String name;
  private final List<Student> students = new ArrayList<Student>();
  public int numberOfStudents = 1;

  public Institute(String name) {
    this.name = name;
  }

  public void addStudent(Student s) {
    students.add(s);
  }

  public void addStudent(Student[] array) {
    for(Student stud : array){
        students.add(stud);
    }
  }

  public String toString() {
    StringBuilder result = new StringBuilder(name + ": ");
    for (Student stud : students) {
        result.append(stud.toString()).append(", ");
    }
    return result.toString();
  }

}

class Student {
  private final String name;
  private final int rollNumber;
  private final Institute institute;

  public Student(String n, Institute institute) {
    this.name = n;
    this.institute = institute;
    this.rollNumber = this.institute.numberOfStudents++;
  }

  public String toString() {
    return this.name + " " + this.rollNumber;
  }
}