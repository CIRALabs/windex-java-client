package ca.cira.shg.windex;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.threeten.bp.format.DateTimeFormatter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class ApiClient {

  private Map<String, Interceptor> apiAuthorizations;
  private OkHttpClient.Builder okBuilder;
  private Retrofit.Builder adapterBuilder;
  private JSON json;

  public ApiClient(String baseUrl) {
    apiAuthorizations = new LinkedHashMap<String, Interceptor>();
    createDefaultAdapter(baseUrl);
  }

  public void createDefaultAdapter(String baseUrl) {
    json = new JSON();
    okBuilder = new OkHttpClient.Builder();

    if (!baseUrl.endsWith("/"))
      baseUrl = baseUrl + "/";

    adapterBuilder = new Retrofit
      .Builder()
      .baseUrl(baseUrl)
      .addConverterFactory(ScalarsConverterFactory.create())
      .addConverterFactory(GsonCustomConverterFactory.create(json.getGson()));
  }

  public <S> S createService(Class<S> serviceClass) {
    return adapterBuilder
      .client(okBuilder.build())
      .build()
      .create(serviceClass);
  }

  public ApiClient setDateFormat(DateFormat dateFormat) {
    this.json.setDateFormat(dateFormat);
    return this;
  }

  public ApiClient setSqlDateFormat(DateFormat dateFormat) {
    this.json.setSqlDateFormat(dateFormat);
    return this;
  }

  public ApiClient setOffsetDateTimeFormat(DateTimeFormatter dateFormat) {
    this.json.setOffsetDateTimeFormat(dateFormat);
    return this;
  }

  public ApiClient setLocalDateFormat(DateTimeFormatter dateFormat) {
    this.json.setLocalDateFormat(dateFormat);
    return this;
  }


  /**


  /**
   * Adds an authorization to be used by the client
   * @param authName Authentication name
   * @param authorization Authorization interceptor
   * @return ApiClient
   */
  public ApiClient addAuthorization(String authName, Interceptor authorization) {
    if (apiAuthorizations.containsKey(authName)) {
      throw new RuntimeException("auth name \"" + authName + "\" already in api authorizations");
    }
    apiAuthorizations.put(authName, authorization);
    okBuilder.addInterceptor(authorization);
    return this;
  }

  public Map<String, Interceptor> getApiAuthorizations() {
    return apiAuthorizations;
  }

  public ApiClient setApiAuthorizations(Map<String, Interceptor> apiAuthorizations) {
    this.apiAuthorizations = apiAuthorizations;
    return this;
  }

  public Retrofit.Builder getAdapterBuilder() {
    return adapterBuilder;
  }

  public ApiClient setAdapterBuilder(Retrofit.Builder adapterBuilder) {
    this.adapterBuilder = adapterBuilder;
    return this;
  }

  public OkHttpClient.Builder getOkBuilder() {
    return okBuilder;
  }

  public void addAuthsToOkBuilder(OkHttpClient.Builder okBuilder) {
    for(Interceptor apiAuthorization : apiAuthorizations.values()) {
      okBuilder.addInterceptor(apiAuthorization);
    }
  }

  /**
   * Clones the okBuilder given in parameter, adds the auth interceptors and uses it to configure the Retrofit
   * @param okClient An instance of OK HTTP client
   */
  public void configureFromOkclient(OkHttpClient okClient) {
    this.okBuilder = okClient.newBuilder();
    addAuthsToOkBuilder(this.okBuilder);
  }
}

/**
 * This wrapper is to take care of this case:
 * when the deserialization fails due to JsonParseException and the
 * expected type is String, then just return the body string.
 */
class GsonResponseBodyConverterToString<T> implements Converter<ResponseBody, T> {
  private final Gson gson;
  private final Type type;

  GsonResponseBodyConverterToString(Gson gson, Type type) {
    this.gson = gson;
    this.type = type;
  }

  @Override public T convert(ResponseBody value) throws IOException {
    String returned = value.string();
    try {
      return gson.fromJson(returned, type);
    }
    catch (JsonParseException e) {
      return (T) returned;
    }
  }
}

class GsonCustomConverterFactory extends Converter.Factory
{
  private final Gson gson;
  private final GsonConverterFactory gsonConverterFactory;

  public static GsonCustomConverterFactory create(Gson gson) {
    return new GsonCustomConverterFactory(gson);
  }

  private GsonCustomConverterFactory(Gson gson) {
    if (gson == null)
      throw new NullPointerException("gson == null");
    this.gson = gson;
    this.gsonConverterFactory = GsonConverterFactory.create(gson);
  }

  @Override
  public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
    if (type.equals(String.class))
      return new GsonResponseBodyConverterToString<Object>(gson, type);
    else
      return gsonConverterFactory.responseBodyConverter(type, annotations, retrofit);
  }

  @Override
  public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
    return gsonConverterFactory.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit);
  }
}
