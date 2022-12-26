package test.example.first_scrum.service;

import org.example.first_scrum.service.ClassManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.example.first_scrum.controller.Runner.BASE_TIME_FOR_ANALYSIS;
import static org.example.first_scrum.controller.Runner.SUBJECT_TITLE;
import static org.example.first_scrum.entity.Student.RANDOM;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public final class ClassManagerTest {
    private final static String TEST_BASE_TIME_FOR_ANALYSIS_VALUE_MESSAGE
            = "Testing value of the field \"baseTimeForAnalysis\" for student = ";
    private final static int UPPER_BOUND_NUM_OF_STUDENTS_VALUE = 100;
    private final static int NUM_OF_STUDENTS_TYPE_1 = RANDOM.nextInt(
            UPPER_BOUND_NUM_OF_STUDENTS_VALUE);
    private final static int NUM_OF_STUDENTS_TYPE_2 = RANDOM.nextInt(
            UPPER_BOUND_NUM_OF_STUDENTS_VALUE);
    private final static int NUM_OF_STUDENTS_TYPE_3 = RANDOM.nextInt(
            UPPER_BOUND_NUM_OF_STUDENTS_VALUE);
    private static ClassManager classManager;

    private final static ByteArrayOutputStream out
            = new ByteArrayOutputStream();
    private final static PrintStream originalOut = System.out;

    @BeforeAll
    static void addStudents() {
        classManager = new ClassManager(NUM_OF_STUDENTS_TYPE_1,
                NUM_OF_STUDENTS_TYPE_2,
                NUM_OF_STUDENTS_TYPE_3, BASE_TIME_FOR_ANALYSIS, SUBJECT_TITLE);
    }

    @BeforeAll
    static void setOutStream() {
        System.setOut(new PrintStream(out));
    }

    @Test
    void testNumberOfStudents() {
        assertEquals(NUM_OF_STUDENTS_TYPE_1 + NUM_OF_STUDENTS_TYPE_2
                        + NUM_OF_STUDENTS_TYPE_3,
                classManager.getStudents().size());
    }

    @TestFactory
    Stream<DynamicTest> testBaseTimeForAnalysisValueFromStream() {
        return classManager.getStudents().stream()
                .map(x -> DynamicTest.dynamicTest(
                        TEST_BASE_TIME_FOR_ANALYSIS_VALUE_MESSAGE + x,
                        () -> assertNotNull(x.getBaseTimeForAnalysis())));
    }

    @Test
    void testPrintClassInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Subject: ").append(classManager.getSubjectTitle())
                .append("\r").append("\n");
        classManager.getStudents()
                .forEach(x -> sb.append(x).append("\r").append("\n"));
        classManager.printClassInfo();
        assertEquals(sb.toString(), out.toString());
    }

    @AfterAll
    static void restoreInitialOutStream() {
        System.setOut(originalOut);
    }
}
