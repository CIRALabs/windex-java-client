package ca.cira.shg.windex.client;

import ca.cira.shg.windex.ApiClient;
import ca.cira.shg.windex.model.Device;
import ca.cira.shg.windex.model.DeviceBody;
import ca.cira.shg.windex.model.InlineResponse200;
import ca.cira.shg.windex.model.ModelApiResponse;
import ca.cira.shg.windex.model.UserBody;
import okhttp3.tls.HeldCertificate;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * API tests for DeviceApi
 */
public class DeviceApiTest {

    private DeviceApi api;
    private UserApi userApi;
    private HeldCertificate certificate;

    @Before
    public void setup() throws IOException {
        // Generate a client certificate
        certificate = new HeldCertificate.Builder()
                .commonName("shg-client")
                .build();
        ApiClient client = new ApiClient("https://127.0.0.1:8443");
        client.setClientCertificate(certificate.keyPair(), certificate.certificate());
        api = client.createService(DeviceApi.class, true);

        // Need to create the admin user here as we are using TOFU for now, would need to retrieve an existing admin cert
        userApi = client.createService(UserApi.class, true);
        UserBody userBody = new UserBody();
        userBody.name("My user");
        userApi.createUser(userBody).execute();
    }

    /**
     * Add a new device to the store
     *
     * 
     */
    @Test
    public void createDeviceTest() throws IOException {
        DeviceBody deviceBody = new DeviceBody();
        deviceBody.setName("My test device");
        Response<Void> response = api.createDevice(deviceBody).execute();
        assertTrue(response.isSuccessful());
        assertEquals(201, response.code());
    }
    /**
     * Get a device information
     *
     * 
     */
    @Test
    public void getDeviceTest() {
        Integer id = null;
        // Device response = api.getDevice(id);

        // TODO: test validations
    }
    /**
     * List devices
     *
     * 
     */
    @Test
    public void listDevicesTest() {
        // InlineResponse200 response = api.listDevices();

        // TODO: test validations
    }
    /**
     * Update an existing device
     *
     * 
     */
    @Test
    public void updateDeviceTest() {
        Integer id = null;
        DeviceBody deviceBody = null;
        // api.updateDevice(id, deviceBody);

        // TODO: test validations
    }
}
