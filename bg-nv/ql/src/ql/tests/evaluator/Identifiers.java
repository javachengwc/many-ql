package ql.tests.evaluator;

import org.junit.Test;
import ql.semantics.ValueTable;
import ql.semantics.values.BoolValue;
import ql.tests.TestHelper;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by bore on 24/02/15.
 */
public class Identifiers
{
    @Test
    public void idInt()
    {
        ValueTable table = new ValueTable();
        table.storeValue("hasHouse", new BoolValue(true));
        BoolValue v = TestHelper.as(TestHelper.evaluate("hasHouse", table), BoolValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }
}
