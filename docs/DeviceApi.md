# DeviceApi

All URIs are relative to *https://mud.nXXXXXX.router.securehomegateway.ca/api/1.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createDevice**](DeviceApi.md#createDevice) | **POST** devices | Add a new device to the store
[**getDevice**](DeviceApi.md#getDevice) | **GET** devices/{id} | Get a device information
[**listDevices**](DeviceApi.md#listDevices) | **GET** devices | List devices
[**updateDevice**](DeviceApi.md#updateDevice) | **PUT** devices/{id} | Update an existing device



## createDevice

> createDevice(deviceBody)

Add a new device to the store

### Example

```java
// Import classes:
import ca.cira.shg.windex.ApiClient;
import ca.cira.shg.windex.ApiException;
import ca.cira.shg.windex.Configuration;
import ca.cira.shg.windex.models.*;
import ca.cira.shg.windex.client.DeviceApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://mud.nXXXXXX.router.securehomegateway.ca/api/1.0");

        DeviceApi apiInstance = new DeviceApi(defaultClient);
        DeviceBody deviceBody = new DeviceBody(); // DeviceBody | Device object
        try {
            apiInstance.createDevice(deviceBody);
        } catch (ApiException e) {
            System.err.println("Exception when calling DeviceApi#createDevice");
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
 **deviceBody** | [**DeviceBody**](DeviceBody.md)| Device object |

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
| **409** | Device with the same MAC address already exists |  -  |


## getDevice

> Device getDevice(id)

Get a device information

### Example

```java
// Import classes:
import ca.cira.shg.windex.ApiClient;
import ca.cira.shg.windex.ApiException;
import ca.cira.shg.windex.Configuration;
import ca.cira.shg.windex.models.*;
import ca.cira.shg.windex.client.DeviceApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://mud.nXXXXXX.router.securehomegateway.ca/api/1.0");

        DeviceApi apiInstance = new DeviceApi(defaultClient);
        Integer id = 56; // Integer | ID of the device
        try {
            Device result = apiInstance.getDevice(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DeviceApi#getDevice");
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

[**Device**](Device.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Device info |  -  |
| **400** | Invalid request |  -  |
| **403** | Unauthorized |  -  |


## listDevices

> InlineResponse200 listDevices()

List devices

### Example

```java
// Import classes:
import ca.cira.shg.windex.ApiClient;
import ca.cira.shg.windex.ApiException;
import ca.cira.shg.windex.Configuration;
import ca.cira.shg.windex.models.*;
import ca.cira.shg.windex.client.DeviceApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://mud.nXXXXXX.router.securehomegateway.ca/api/1.0");

        DeviceApi apiInstance = new DeviceApi(defaultClient);
        try {
            InlineResponse200 result = apiInstance.listDevices();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DeviceApi#listDevices");
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

[**InlineResponse200**](InlineResponse200.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Device info |  -  |
| **400** | Invalid request |  -  |
| **403** | Unauthorized |  -  |


## updateDevice

> updateDevice(id, deviceBody)

Update an existing device

### Example

```java
// Import classes:
import ca.cira.shg.windex.ApiClient;
import ca.cira.shg.windex.ApiException;
import ca.cira.shg.windex.Configuration;
import ca.cira.shg.windex.models.*;
import ca.cira.shg.windex.client.DeviceApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://mud.nXXXXXX.router.securehomegateway.ca/api/1.0");

        DeviceApi apiInstance = new DeviceApi(defaultClient);
        Integer id = 56; // Integer | ID of the device
        DeviceBody deviceBody = new DeviceBody(); // DeviceBody | Device object
        try {
            apiInstance.updateDevice(id, deviceBody);
        } catch (ApiException e) {
            System.err.println("Exception when calling DeviceApi#updateDevice");
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
 **deviceBody** | [**DeviceBody**](DeviceBody.md)| Device object |

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
| **200** | Device updated |  -  |
| **400** | Invalid request |  -  |
| **403** | Unauthorized |  -  |
| **404** | Object not found |  -  |

