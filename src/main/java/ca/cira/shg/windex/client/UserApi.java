package ca.cira.shg.windex.client;

import ca.cira.shg.windex.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import ca.cira.shg.windex.model.InlineResponse2001;
import ca.cira.shg.windex.model.ModelApiResponse;
import ca.cira.shg.windex.model.User;
import ca.cira.shg.windex.model.UserBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserApi {
  /**
   * Create user
   * This can only be done by the logged in administrator or user.
   * @param userBody User object (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("administrators")
  Call<Void> createUser(
    @retrofit2.http.Body UserBody userBody
  );

  /**
   * Get user by user id
   * 
   * @param id ID of the device (required)
   * @return Call&lt;User&gt;
   */
  @GET("administrators/{id}")
  Call<User> getUser(
    @retrofit2.http.Path("id") Integer id
  );

  /**
   * List users
   * 
   * @return Call&lt;InlineResponse2001&gt;
   */
  @GET("administrators")
  Call<InlineResponse2001> listUsers();
    

  /**
   * Update an existing user
   * 
   * @param id ID of the device (required)
   * @param userBody User object (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("administrators/{id}")
  Call<Void> updateUser(
    @retrofit2.http.Path("id") Integer id, @retrofit2.http.Body UserBody userBody
  );

}
