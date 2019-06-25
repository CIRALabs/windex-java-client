# UserApi

All URIs are relative to *https://mud.nXXXXXX.router.securehomegateway.ca/api/1.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createUser**](UserApi.md#createUser) | **POST** administrators | Create user
[**getUser**](UserApi.md#getUser) | **GET** administrators/{id} | Get user by user id
[**listUsers**](UserApi.md#listUsers) | **GET** administrators | List users
[**updateUser**](UserApi.md#updateUser) | **PUT** administrators/{id} | Update an existing user



## createUser

> createUser(userBody)

Create user

This can only be done by the logged in administrator or user.

### Example

```java
// Import classes:
import ca.cira.shg.windex.ApiClient;
import ca.cira.shg.windex.ApiException;
import ca.cira.shg.windex.Configuration;
import ca.cira.shg.windex.models.*;
import ca.cira.shg.windex.client.UserApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://mud.nXXXXXX.router.securehomegateway.ca/api/1.0");

        UserApi apiInstance = new UserApi(defaultClient);
        UserBody userBody = new UserBody(); // UserBody | User object
        try {
            apiInstance.createUser(userBody);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserApi#createUser");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userBody** | [**UserBody**](UserBody.md)| User object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Object created |  * Location -  <br>  |
| **400** | Invalid request |  -  |
| **403** | Unauthorized |  -  |
| **409** | User with already exists |  -  |


## getUser

> User getUser(id)

Get user by user id

### Example

```java
// Import classes:
import ca.cira.shg.windex.ApiClient;
import ca.cira.shg.windex.ApiException;
import ca.cira.shg.windex.Configuration;
import ca.cira.shg.windex.models.*;
import ca.cira.shg.windex.client.UserApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://mud.nXXXXXX.router.securehomegateway.ca/api/1.0");

        UserApi apiInstance = new UserApi(defaultClient);
        Integer id = 56; // Integer | ID of the device
        try {
            User result = apiInstance.getUser(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserApi#getUser");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the device |

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | User info |  -  |
| **400** | Invalid request |  -  |
| **403** | Unauthorized |  -  |
| **404** | Object not found |  -  |


## listUsers

> InlineResponse2001 listUsers()

List users

### Example

```java
// Import classes:
import ca.cira.shg.windex.ApiClient;
import ca.cira.shg.windex.ApiException;
import ca.cira.shg.windex.Configuration;
import ca.cira.shg.windex.models.*;
import ca.cira.shg.windex.client.UserApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://mud.nXXXXXX.router.securehomegateway.ca/api/1.0");

        UserApi apiInstance = new UserApi(defaultClient);
        try {
            InlineResponse2001 result = apiInstance.listUsers();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserApi#listUsers");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | User info |  -  |
| **400** | Invalid request |  -  |
| **403** | Unauthorized |  -  |


## updateUser

> updateUser(id, userBody)

Update an existing user

### Example

```java
// Import classes:
import ca.cira.shg.windex.ApiClient;
import ca.cira.shg.windex.ApiException;
import ca.cira.shg.windex.Configuration;
import ca.cira.shg.windex.models.*;
import ca.cira.shg.windex.client.UserApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://mud.nXXXXXX.router.securehomegateway.ca/api/1.0");

        UserApi apiInstance = new UserApi(defaultClient);
        Integer id = 56; // Integer | ID of the device
        UserBody userBody = new UserBody(); // UserBody | User object
        try {
            apiInstance.updateUser(id, userBody);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserApi#updateUser");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of the device |
 **userBody** | [**UserBody**](UserBody.md)| User object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | User sucessfully updated |  -  |
| **400** | Invalid request |  -  |
| **403** | Unauthorized |  -  |
| **404** | Object not found |  -  |

