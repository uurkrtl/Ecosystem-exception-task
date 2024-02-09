import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StudentServiceTest {

    @Test
    void getStudentById() {
        StudentService studentService = new StudentService();

        Student newStudent = Student.builder()
                .name("Florian")
                .subject("Geschichte")
                .build();
        studentService.addNewStudent(newStudent);

        assertThrows(IllegalStateException.class, () -> studentService.getStudentById("123"));

        //assertEquals(savedStudent, studentService.getStudentById(savedStudent.id()));
    }
}