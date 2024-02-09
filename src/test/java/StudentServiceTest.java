import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StudentServiceTest {

    @Test
    void getStudentById_whenNoStudentThenException() {
        StudentService studentService = new StudentService();

        Student newStudent = Student.builder()
                .name("Florian")
                .subject("Geschichte")
                .build();
        studentService.addNewStudent(newStudent);

        assertThrows(IllegalStateException.class, () -> studentService.getStudentById("123"));

        //assertEquals(savedStudent, studentService.getStudentById(savedStudent.id()));
    }

    @Test
    void getStudentById_whenStudent() {
        StudentRepo studentRepo = new StudentRepo();

        Student expected = studentRepo.save(new Student("123", "Florian", "Geschichte"));
        Student actual = studentRepo.findStudentById("123").orElseThrow();

        assertEquals(expected, actual);
    }
}