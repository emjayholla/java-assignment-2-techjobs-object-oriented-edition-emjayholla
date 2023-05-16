package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static java.util.Objects.isNull;
import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId () {
        Job testJob = new Job();
        Job testJob2 = new Job();
        assertNotEquals(testJob.getId(), testJob2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", testJob3.getName());
        assertTrue(testJob3 instanceof Job);
        assertEquals("ACME", testJob3.getEmployer().getValue());
        assertTrue(testJob3.getEmployer() instanceof Employer);
        assertEquals("Desert", testJob3.getLocation().getValue());
        assertTrue(testJob3.getLocation() instanceof Location);
        assertEquals("Quality control", testJob3.getPositionType().getValue());
        assertTrue(testJob3.getPositionType() instanceof PositionType);
        assertEquals("Persistence", testJob3.getCoreCompetency().getValue());
        assertTrue(testJob3.getCoreCompetency() instanceof CoreCompetency);


    }

    @Test
    public void testJobsForEquality() {
        Job testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJob4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(testJob3, testJob4);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobData = testJob.toString();
        char firstChar = jobData.charAt(0);
        char lastChar = jobData.charAt(jobData.length()-1);
        assertEquals(firstChar, '\n');
        assertEquals(lastChar, '\n');

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobData = testJob.toString();
        String expectedJobData = "\n" +
                "ID: " + testJob.getId() +
                "\nName: Product Tester" +
                "\nEmployer: ACME" +
                "\nLocation: Desert" +
                "\nPosition Type: Quality control" +
                "\nCore Competency: Persistence" +
                "\n";
        assertEquals(jobData, expectedJobData);

    }
@Test
    public void testToStringHandlesEmptyField() {
    Job testJob = new Job("Product Tester", null, new Location("Desert"), null, new CoreCompetency("Persistence"));
    String jobData = testJob.toString();
    String expectedJobData = "\n" +
            "ID: " + testJob.getId() +
            "\nName: Product Tester" +
            "\nEmployer: Data not available" +
            "\nLocation: Desert" +
            "\nPosition Type: Data not available" +
            "\nCore Competency: Persistence" +
            "\n";
    assertEquals(expectedJobData, jobData);
    }
}
//complete