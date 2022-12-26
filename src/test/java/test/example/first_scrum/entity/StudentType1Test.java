package test.example.first_scrum.entity;

import org.example.first_scrum.entity.Student;
import org.example.first_scrum.entity.impl.StudentType1;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.example.first_scrum.entity.Student.RANDOM;
import static org.junit.jupiter.api.Assertions.assertEquals;

public final class StudentType1Test {
    public final static int TESTS_NUM = 100;
    public final static int UPPER_BOUND_BASE_TIME_FOR_ANALYSIS_VALUE = 1000;
    public final static String TEST_GET_ANALYSIS_TIME_MESSAGE
            = "Testing method getAnalysisTime() for student = ";
    public final static String TEST_GET_PRACTICE_TIME_MESSAGE
            = "Testing method getPracticeTime() for student = ";
    public final static String TEST_GET_FLOW_TIME_MESSAGE
            = "Testing method getFlowTime() for student = ";
    private final static List<Student> STUDENTS = new ArrayList<>();

    @BeforeAll
    static void addStudents() {
        for (int i = 0; i < TESTS_NUM; ++i) {
            Student student = new StudentType1((double) (RANDOM.nextInt(
                    UPPER_BOUND_BASE_TIME_FOR_ANALYSIS_VALUE)));
            STUDENTS.add(student);
        }
    }

    @TestFactory
    Stream<DynamicTest> testGetAnalysisTimeFromStream() {
        return STUDENTS.stream().map(x -> DynamicTest.dynamicTest(
                TEST_GET_ANALYSIS_TIME_MESSAGE + x,
                () -> assertEquals(x.getAnalysisTime(),
                        x.getBaseTimeForAnalysis() / x.getTalent())));
    }

    @TestFactory
    Stream<DynamicTest> testGetPracticeTimeFromStream() {
        return STUDENTS.stream().map(x -> DynamicTest.dynamicTest(
                TEST_GET_PRACTICE_TIME_MESSAGE + x,
                () -> assertEquals(x.getPracticeTime(),
                        x.getBaseTimeForAnalysis() / x.getTalent())));
    }

    @TestFactory
    Stream<DynamicTest> testGetFlowTimeFromStream() {
        return STUDENTS.stream().map(x -> DynamicTest.dynamicTest(
                TEST_GET_FLOW_TIME_MESSAGE + x,
                () -> assertEquals(x.getFlowTime(),
                        x.getBaseTimeForAnalysis() / x.getTalent())));
    }

    @AfterAll
    static void clearStudents() {
        STUDENTS.clear();
    }
}
