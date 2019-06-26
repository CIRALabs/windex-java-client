package ca.cira.shg.windex.client;

import ca.cira.shg.windex.ApiClient;
import ca.cira.shg.windex.model.UserBody;
import okhttp3.tls.HeldCertificate;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * API tests for UserApi
 */
public class UserApiTest {

    private UserApi api;
    private HeldCertificate certificate;

    @Before
    public void setup() {
        // Generate a client certificate
        certificate = new HeldCertificate.Builder()
                .commonName("shg-client")
                .build();
        ApiClient client = new ApiClient("https://127.0.0.1:8443");
        client.setClientCertificate(certificate.keyPair(), certificate.certificate());
        api = client.createService(UserApi.class, true);
    }

    /**
     * Create user
     *
     * This can only be done by the logged in administrator or user.
     */
    @Test
    public void createUserTest() throws IOException {
        UserBody userBody = new UserBody();
        userBody.name("New");
        Response<Void> response = api.createUser(userBody).execute();
        assertTrue(response.isSuccessful());
        assertEquals(201, response.code());
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
