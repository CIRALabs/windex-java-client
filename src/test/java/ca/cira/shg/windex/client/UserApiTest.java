package ca.cira.shg.windex.client;

import ca.cira.shg.windex.ApiClient;
import ca.cira.shg.windex.model.InlineResponse2001;
import ca.cira.shg.windex.model.ModelApiResponse;
import ca.cira.shg.windex.model.User;
import ca.cira.shg.windex.model.UserBody;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for UserApi
 */
public class UserApiTest {

    private UserApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(UserApi.class);
    }

    /**
     * Create user
     *
     * This can only be done by the logged in administrator or user.
     */
    @Test
    public void createUserTest() {
        UserBody userBody = null;
        // api.createUser(userBody);

        // TODO: test validations
    }
    /**
     * Get user by user id
     *
     * 
     */
    @Test
    public void getUserTest() {
        Integer id = null;
        // User response = api.getUser(id);

        // TODO: test validations
    }
    /**
     * List users
     *
     * 
     */
    @Test
    public void listUsersTest() {
        // InlineResponse2001 response = api.listUsers();

        // TODO: test validations
    }
    /**
     * Update an existing user
     *
     * 
     */
    @Test
    public void updateUserTest() {
        Integer id = null;
        UserBody userBody = null;
        // api.updateUser(id, userBody);

        // TODO: test validations
    }
}
