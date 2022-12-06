import Main.User;
import org.junit.jupiter.api.Assertions;

class UserTest {

    @org.junit.jupiter.api.Test
    void testUser() {
        User user = new User();
        Assertions.assertEquals(-8, user.rank);
        Assertions.assertEquals(0, user.progress);
        user.incProgress(-7);
        Assertions.assertEquals(10, user.progress);
        user.incProgress(-5);
        Assertions.assertEquals(0, user.progress);
        Assertions.assertEquals(-7, user.rank);
        user.incProgress(-3);
        Assertions.assertEquals(60, user.progress);
        Assertions.assertEquals(-6, user.rank);
        user.incProgress(-1);
        Assertions.assertEquals(10, user.progress);
        Assertions.assertEquals(-3, user.rank);
    }

    @org.junit.jupiter.api.Test
    void testCountProgress() {
        Assertions.assertEquals(10, User.countProgress(-8, -7));
        Assertions.assertEquals(40, User.countProgress(-8, -6));
        Assertions.assertEquals(90, User.countProgress(-8, -5));
        Assertions.assertEquals(160, User.countProgress(-8, -4));
        Assertions.assertEquals(10, User.countProgress(-1, 1));
        Assertions.assertEquals(1, User.countProgress(-5, -6));
        Assertions.assertEquals(0, User.countProgress(-5, -7));
        Assertions.assertEquals(250, User.countProgress(-6, -1));
    }
}