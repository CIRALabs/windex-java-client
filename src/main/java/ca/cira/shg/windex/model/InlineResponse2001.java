/*
 * CIRA SHG Windex API
 * CIRALabs SecureHomeGateway Windex API: between smartphone and router
 *
 * The version of the OpenAPI document: 1.0.0-current
 * Contact: securehomegateway@cira.ca
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package ca.cira.shg.windex.model;

import java.util.Objects;
import java.util.Arrays;
import ca.cira.shg.windex.model.User;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * InlineResponse2001
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-06-25T12:38:14.452071-04:00[America/Toronto]")
public class InlineResponse2001 {
  public static final String SERIALIZED_NAME_ADMINISTRATORS = "administrators";
  @SerializedName(SERIALIZED_NAME_ADMINISTRATORS)
  private List<User> administrators = new ArrayList<User>();

  public InlineResponse2001 administrators(List<User> administrators) {
    this.administrators = administrators;
    return this;
  }

  public InlineResponse2001 addAdministratorsItem(User administratorsItem) {
    if (this.administrators == null) {
      this.administrators = new ArrayList<User>();
    }
    this.administrators.add(administratorsItem);
    return this;
  }

   /**
   * Get administrators
   * @return administrators
  **/
  @ApiModelProperty(value = "")
  public List<User> getAdministrators() {
    return administrators;
  }

  public void setAdministrators(List<User> administrators) {
    this.administrators = administrators;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse2001 inlineResponse2001 = (InlineResponse2001) o;
    return Objects.equals(this.administrators, inlineResponse2001.administrators);
  }

  @Override
  public int hashCode() {
    return Objects.hash(administrators);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2001 {\n");
    sb.append("    administrators: ").append(toIndentedString(administrators)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

