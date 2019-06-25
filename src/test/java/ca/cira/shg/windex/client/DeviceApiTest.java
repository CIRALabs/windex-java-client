package ca.cira.shg.windex.client;

import ca.cira.shg.windex.ApiClient;
import ca.cira.shg.windex.model.Device;
import ca.cira.shg.windex.model.DeviceBody;
import ca.cira.shg.windex.model.InlineResponse200;
import ca.cira.shg.windex.model.ModelApiResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DeviceApi
 */
public class DeviceApiTest {

    private DeviceApi api;

    @Before
    public void setup() {
        api = new ApiClient("https://localhost:8443").createService(DeviceApi.class);
    }

    /**
     * Add a new device to the store
     *
     * 
     */
    @Test
    public void createDeviceTest() {
        DeviceBody deviceBody = null;
        // api.createDevice(deviceBody);

        // TODO: test validations
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
