import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    public void ExceptionTest() {

        User user = null;
        List<User> allUsers = new ArrayList<User>();

        assertThrows(RuntimeException.class,()->{
            SILab2.function(user,allUsers);
        });
    }

    @Test
    public void Test1(){

        User user =new User(null,"miles_","milestojmenov@yahoo.com");
        User realUser1 =new User("trajko","hehehe","trajkotrajkov@yahoo.com");
        User realUser2 =new User("ivannn","hahaha","ivanivanov@yahoo.com");
        List<User> allUsers = new ArrayList<User>();
        allUsers.add(realUser1);
        allUsers.add(realUser2);

        assertEquals(false,SILab2.function(user,allUsers));
    }

    @Test
    public void Test2(){
        User user =new User("miles_","miles_","milestojmenovyahoocom");
        User realUser1 =new User("trajko","hehehe","trajkotrajkov@yahoo.com");
        User realUser2 =new User("ivannn","hahaha","ivanivanov@yahoo.com");
        List<User> allUsers = new ArrayList<User>();
        allUsers.add(realUser1);
        allUsers.add(realUser2);

        assertEquals(false,SILab2.function(user,allUsers));
    }

    @Test
    public void Test3_valid(){

        User user =new User("mile","stojmenov_","milestojmenov@yahoo.com");
        User realUser1 =new User("mile","stojmenov_","milestojmenov@yahoo.com");
        User realUser2 =new User("ivannn","hahaha","ivanivanov@yahoo.com");
        List<User> allUsers = new ArrayList<User>();
        allUsers.add(realUser1);
        allUsers.add(realUser2);

        assertEquals(false,SILab2.function(user,allUsers));
    }

    @Test
    public void multipleConditionTest() {
//      Multiple condition
//      TFF/FTF/FFT/FFF
//      Test for TFF:

        User user1 = null;
        List<User> allUsers1 = new ArrayList<>();
        try {
            SILab2.function(user1, allUsers1);
            fail("Expected RuntimeException to be thrown");
        } catch (RuntimeException e) {
            assertEquals("Mandatory information missing!", e.getMessage());
        }


//      Test for FTF:

        User user2 = new User("trajkov", null, "trajkotrajkov");
        List<User> allUsers2 = new ArrayList<>();
        try {
            SILab2.function(user2, allUsers2);
            fail("Expected RuntimeException to be thrown");
        } catch (RuntimeException e) {
            assertEquals("Mandatory information missing!", e.getMessage());
        }

//      Test for FFT:

        User user3 = new User("trajkov", "trajkovski", null);
        List<User> allUsers3 = new ArrayList<>();
        try {
            SILab2.function(user3, allUsers3);
            fail("Expected RuntimeException to be thrown");
        } catch (RuntimeException e) {
            assertEquals("Mandatory information missing!", e.getMessage());
        }

//      Test for FFF:

        User user4 = new User("trajkov", "hehehe", "trajkotrajkovski@yahoo.com");
        List<User> allUsers4 = new ArrayList<>();
        allUsers4.add(user4);

        assertEquals(false, SILab2.function(user4, allUsers4));

    }
}