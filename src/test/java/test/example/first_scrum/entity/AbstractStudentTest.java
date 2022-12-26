package test.example.first_scrum.entity;

import org.example.first_scrum.entity.Student;
import org.example.first_scrum.entity.impl.StudentType1;
import org.example.first_scrum.entity.impl.StudentType2;
import org.example.first_scrum.entity.impl.StudentType3;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.example.first_scrum.entity.Student.RANDOM;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static test.example.first_scrum.entity.StudentType1Test.TESTS_NUM;
import static test.example.first_scrum.entity.StudentType1Test.UPPER_BOUND_BASE_TIME_FOR_ANALYSIS_VALUE;

public final class AbstractStudentTest {
    private final static String TEST_GET_TALENT_MESSAGE
            = "Testing method getTalent() for student = ";
    private final static String TEST_GET_TYPE_MESSAGE
            = "Testing method getType() for student = ";
    private final static String TEST_GET_TOTAL_TIME_MESSAGE
            = "Testing method getTotalTime() for student = ";
    private final static List<Student> STUDENTS = new ArrayList<>();

    @BeforeAll
    static void addStudents() {
        for (int i = 0; i < TESTS_NUM; ++i) {
            Student studentType1 = new StudentType1((double) (RANDOM.nextInt(
                    UPPER_BOUND_BASE_TIME_FOR_ANALYSIS_VALUE)));
            STUDENTS.add(studentType1);
            Student studentType2 = new StudentType2((double) (RANDOM.nextInt(
                    UPPER_BOUND_BASE_TIME_FOR_ANALYSIS_VALUE)));
            STUDENTS.add(studentType2);
            Student studentType3 = new StudentType3((double) (RANDOM.nextInt(
                    UPPER_BOUND_BASE_TIME_FOR_ANALYSIS_VALUE)));
            STUDENTS.add(studentType3);
        }
    }

    @TestFactory
    Stream<DynamicTest> testGetTalentFromStream() {
        return STUDENTS.stream()
                .map(x -> DynamicTest.dynamicTest(TEST_GET_TALENT_MESSAGE + x,
                        () -> assertAll(() -> assertTrue(x.getTalent() >= 0.1),
                                () -> assertTrue(x.getTalent() <= 1.0))));
    }

    @TestFactory
    Stream<DynamicTest> testGetTypeFromStream() {
        return STUDENTS.stream()
                .map(x -> DynamicTest.dynamicTest(TEST_GET_TYPE_MESSAGE + x,
                        () -> assertEquals(x.getType(),
                                x.getClass().getSimpleName())));
    }

    @TestFactory
    Stream<DynamicTest> testGetTotalTimeFromStream() {
        return STUDENTS.stream().map(x -> DynamicTest.dynamicTest(
                TEST_GET_TOTAL_TIME_MESSAGE + x,
                () -> assertEquals(x.getTotalTime(),
                        x.getAnalysisTime() + x.getPracticeTime()
                                + x.getFlowTime())));
    }

    @AfterAll
    static void clearStudents() {
        STUDENTS.clear();
    }
}
