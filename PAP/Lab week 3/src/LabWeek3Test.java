import org.junit.Test;

import static org.junit.Assert.*;

public class LabWeek3Test
{
    private final LabWeek3 lab = new LabWeek3();

    @Test
    public void Tax()
    {
        assertEquals(8750.00, lab.Tax(60000.00), 0.00f);
    }
}
