package raphael.business;

import junit.framework.TestCase;
import raphael.entities.activities.AssemblyLineActivity;

public class ExtractAssemblyLineActivitiesFromInputTest extends TestCase {
    public void testIfExtractionFromOneLineCoherent(){
        String lineTest = "Cutting wood to feed heat machine 10min";
        AssemblyLineActivity expected = new AssemblyLineActivity(10,"Cutting wood to feed heat machine 10min");
        AssemblyLineActivity tested = ExtractAssemblyLineActivitiesFromInput.extractActivityFromOneLine(lineTest);
        boolean assertionOne = (expected.getDurationInMinutes() == tested.getDurationInMinutes()
                && expected.getDescription().equals(tested.getDescription()));


        String lineTest2 = "Assembly line cooling - maintenance";
        AssemblyLineActivity expected2 = new AssemblyLineActivity(5,"Assembly line cooling ");
        AssemblyLineActivity tested2 = ExtractAssemblyLineActivitiesFromInput.extractActivityFromOneLine(lineTest2);
        boolean assertionTwo = (expected2.getDurationInMinutes() == tested2.getDurationInMinutes()
                && expected2.getDescription().equals(tested2.getDescription()));

        assertTrue(assertionOne && assertionTwo);
    }

    public void testIfProtectedAgainstIncoherentLines(){
        String incoherentLineTest[] = {"-----", "daaaa12",null, "blocked aq 12 12 13","end" };

        for(String testedLine:incoherentLineTest) {
            try {
                AssemblyLineActivity testedOutput = ExtractAssemblyLineActivitiesFromInput.extractActivityFromOneLine(testedLine);
            }catch(Exception e){
                assertNotNull(e);
                if("end".equals(testedLine)){
                    break;
                }else{
                    continue;
                }
            }
                fail("Incoherent instance produced");
        }
    }

}