/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ST10318621;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;

/**
 *
 * @author Ethan
 */
public class LoginTest {
    
   Login login = new Login(); 
    public LoginTest() {
    }

    @Test //testing to see if username is correctly formatted
    public void testRegisterUserValid() {
        login.registerUser("Kyle", "Ligma", "kyl_1", "Ch&&sec@ke99!”");
        assertEquals(true, login.loginUser("kyl_1", "Ch&&sec@ke99!”"));//expected true because username is formatted correctly
    }
    
    @Test //testing to see when username is incorrectly formatted
    public void testRegisterUserInvalid() {
        login.registerUser("Kyle", "Ligma", "kyle!!!!!!!", "Pa$$w0rd");
        assertEquals(false, login.loginUser("kyle!!!!!!!", "Pa$$w0rd"));//expected false because username is formatted incorrectly
    }

    @Test //testing for when the password is correctly formattedd
    public void testLoginUserValid() {
       login.registerUser("Kyle", "Ligma", "kyl_1", "Ch&&sec@ke99!”");
       assertEquals(true, login.loginUser("kyl_1", "Ch&&sec@ke99!”"));//expected true because password is formatted correctly 
    }
    
    @Test //testing to see when password is incorrectly formatted
    public void testLoginUserInvalid() {
        login.registerUser("Kyle", "Ligma", "kyl_1", "password");
        assertEquals(false, login.loginUser("kyl_1", "password"));//expected false because password is formatted incorrectly
    }
    
}
