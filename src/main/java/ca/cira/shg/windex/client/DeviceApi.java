package ca.cira.shg.windex.client;

import ca.cira.shg.windex.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import ca.cira.shg.windex.model.Device;
import ca.cira.shg.windex.model.DeviceBody;
import ca.cira.shg.windex.model.InlineResponse200;
import ca.cira.shg.windex.model.ModelApiResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DeviceApi {
  /**
   * Add a new device to the store
   * 
   * @param deviceBody Device object (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("devices")
  Call<Void> createDevice(
    @retrofit2.http.Body DeviceBody deviceBody
  );

  /**
   * Get a device information
   * 
   * @param id ID of the device (required)
   * @return Call&lt;Device&gt;
   */
  @GET("devices/{id}")
  Call<Device> getDevice(
    @retrofit2.http.Path("id") Integer id
  );

  /**
   * List devices
   * 
   * @return Call&lt;InlineResponse200&gt;
   */
  @GET("devices")
  Call<InlineResponse200> listDevices();
    

  /**
   * Update an existing device
   * 
   * @param id ID of the device (required)
   * @param deviceBody Device object (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("devices/{id}")
  Call<Void> updateDevice(
    @retrofit2.http.Path("id") Integer id, @retrofit2.http.Body DeviceBody deviceBody
  );

}
