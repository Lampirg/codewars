import Main.PaginationHelper;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThrowWithoutThrowingTest {
    @Test
    void testSomething() {
        PaginationHelper<Character> helper =new PaginationHelper
                (Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        assertEquals(2, helper.pageCount()); //should == 2
        assertEquals(6, helper.itemCount()); //should == 6
        assertEquals(4, helper.pageItemCount(0)); //should == 4
        assertEquals(2, helper.pageItemCount(1)); // last page - should == 2
        assertEquals(-1, helper.pageItemCount(2)); // should == -1 since the page is invalid
        assertEquals(1, helper.pageIndex(5)); //should == 1 (zero based index)
        assertEquals(0, helper.pageIndex(0)); //should == 0
        assertEquals(-1, helper.pageIndex(20)); //should == -1
        assertEquals(-1, helper.pageIndex(-10)); //should == -1

        helper = new PaginationHelper(List.of(), 4);
        assertEquals(0, helper.pageCount());
        assertEquals(0, helper.itemCount());
        assertEquals(-1, helper.pageItemCount(0));
        assertEquals(-1, helper.pageIndex(5));

        helper = new PaginationHelper(List.of(), 0);
        assertEquals(0, helper.pageCount());
        assertEquals(0, helper.itemCount());
        assertEquals(-1, helper.pageItemCount(0));
        assertEquals(-1, helper.pageIndex(5));
    }
}
