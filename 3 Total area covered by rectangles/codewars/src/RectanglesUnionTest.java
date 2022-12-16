import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RectanglesUnionTest {
    @Test
    public void testZeroRectangles() {
        int[][] recs = {};
        Assert.assertEquals("Zero rectangles", 0, RectanglesUnion.calculateSpace(recs));
    }

    @Test
    public void testOneRectangle() {
        int[][] recs = {{0, 4, 11, 6}};
        Assert.assertEquals("One rectangle [0, 4, 11, 6] => 22", 22, RectanglesUnion.calculateSpace(recs));
    }

    @Test
    public void testExample() {
        int[][] recs = new int[][]{{3,3,8,5}, {6,3,8,9}, {11,6,14,12}};
        Assert.assertEquals(36, RectanglesUnion.calculateSpace(recs));
    }
}