package raphael.utilities.timemanager;

import junit.framework.TestCase;

public class TimeConversionTest extends TestCase {
    public void testGetTimeFormated(){
       String reference = "09:10";
       int tested = TimeConversion.convertTimeInMinutes(9,10);
       String result = TimeConversion.getTimeFormated(tested);
       assertTrue(reference.equals(result));
    }
}