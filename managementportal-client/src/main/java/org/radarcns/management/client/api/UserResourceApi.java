/*
 * ManagementPortal API
 * ManagementPortal API documentation
 *
 * OpenAPI spec version: 0.0.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package org.radarcns.management.client.api;

import org.radarcns.management.client.ApiCallback;
import org.radarcns.management.client.ApiClient;
import org.radarcns.management.client.ApiException;
import org.radarcns.management.client.ApiResponse;
import org.radarcns.management.client.Configuration;
import org.radarcns.management.client.Pair;
import org.radarcns.management.client.ProgressRequestBody;
import org.radarcns.management.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import org.radarcns.management.client.model.ManagedUserVM;
import org.radarcns.management.client.model.ProjectDTO;
import org.radarcns.management.client.model.ResponseEntity;
import org.radarcns.management.client.model.UserDTO;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserResourceApi {
    private ApiClient apiClient;

    public UserResourceApi() {
        this(Configuration.getDefaultApiClient());
    }

    public UserResourceApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for createUserUsingPOST */
    private com.squareup.okhttp.Call createUserUsingPOSTCall(ManagedUserVM managedUserVM, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = managedUserVM;
        
        // create path and map variables
        String localVarPath = "/api/users".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "*/*"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call createUserUsingPOSTValidateBeforeCall(ManagedUserVM managedUserVM, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'managedUserVM' is set
        if (managedUserVM == null) {
            throw new ApiException("Missing the required parameter 'managedUserVM' when calling createUserUsingPOST(Async)");
        }
        
        
        com.squareup.okhttp.Call call = createUserUsingPOSTCall(managedUserVM, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * createUser
     * 
     * @param managedUserVM managedUserVM (required)
     * @return ResponseEntity
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResponseEntity createUserUsingPOST(ManagedUserVM managedUserVM) throws ApiException {
        ApiResponse<ResponseEntity> resp = createUserUsingPOSTWithHttpInfo(managedUserVM);
        return resp.getData();
    }

    /**
     * createUser
     * 
     * @param managedUserVM managedUserVM (required)
     * @return ApiResponse&lt;ResponseEntity&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ResponseEntity> createUserUsingPOSTWithHttpInfo(ManagedUserVM managedUserVM) throws ApiException {
        com.squareup.okhttp.Call call = createUserUsingPOSTValidateBeforeCall(managedUserVM, null, null);
        Type localVarReturnType = new TypeToken<ResponseEntity>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * createUser (asynchronously)
     * 
     * @param managedUserVM managedUserVM (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createUserUsingPOSTAsync(ManagedUserVM managedUserVM, final ApiCallback<ResponseEntity> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = createUserUsingPOSTValidateBeforeCall(managedUserVM, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResponseEntity>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for deleteUserUsingDELETE */
    private com.squareup.okhttp.Call deleteUserUsingDELETECall(String login, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/api/users/{login}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "login" + "\\}", apiClient.escapeString(login.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "*/*"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteUserUsingDELETEValidateBeforeCall(String login, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'login' is set
        if (login == null) {
            throw new ApiException("Missing the required parameter 'login' when calling deleteUserUsingDELETE(Async)");
        }
        
        
        com.squareup.okhttp.Call call = deleteUserUsingDELETECall(login, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * deleteUser
     * 
     * @param login login (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteUserUsingDELETE(String login) throws ApiException {
        deleteUserUsingDELETEWithHttpInfo(login);
    }

    /**
     * deleteUser
     * 
     * @param login login (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteUserUsingDELETEWithHttpInfo(String login) throws ApiException {
        com.squareup.okhttp.Call call = deleteUserUsingDELETEValidateBeforeCall(login, null, null);
        return apiClient.execute(call);
    }

    /**
     * deleteUser (asynchronously)
     * 
     * @param login login (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteUserUsingDELETEAsync(String login, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteUserUsingDELETEValidateBeforeCall(login, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for getAllUsersUsingGET */
    private com.squareup.okhttp.Call getAllUsersUsingGETCall(Integer page, Integer size, String projectName, String authority, List<String> sort, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/api/users".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (page != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "page", page));
        if (size != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "size", size));
        if (projectName != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "projectName", projectName));
        if (authority != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "authority", authority));
        if (sort != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "sort", sort));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "*/*"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getAllUsersUsingGETValidateBeforeCall(Integer page, Integer size, String projectName, String authority, List<String> sort, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        
        com.squareup.okhttp.Call call = getAllUsersUsingGETCall(page, size, projectName, authority, sort, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * getAllUsers
     * 
     * @param page Page number of the requested page (optional)
     * @param size Size of a page (optional)
     * @param projectName projectName (optional)
     * @param authority authority (optional)
     * @param sort Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
     * @return List&lt;UserDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<UserDTO> getAllUsersUsingGET(Integer page, Integer size, String projectName, String authority, List<String> sort) throws ApiException {
        ApiResponse<List<UserDTO>> resp = getAllUsersUsingGETWithHttpInfo(page, size, projectName, authority, sort);
        return resp.getData();
    }

    /**
     * getAllUsers
     * 
     * @param page Page number of the requested page (optional)
     * @param size Size of a page (optional)
     * @param projectName projectName (optional)
     * @param authority authority (optional)
     * @param sort Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
     * @return ApiResponse&lt;List&lt;UserDTO&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<UserDTO>> getAllUsersUsingGETWithHttpInfo(Integer page, Integer size, String projectName, String authority, List<String> sort) throws ApiException {
        com.squareup.okhttp.Call call = getAllUsersUsingGETValidateBeforeCall(page, size, projectName, authority, sort, null, null);
        Type localVarReturnType = new TypeToken<List<UserDTO>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * getAllUsers (asynchronously)
     * 
     * @param page Page number of the requested page (optional)
     * @param size Size of a page (optional)
     * @param projectName projectName (optional)
     * @param authority authority (optional)
     * @param sort Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getAllUsersUsingGETAsync(Integer page, Integer size, String projectName, String authority, List<String> sort, final ApiCallback<List<UserDTO>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getAllUsersUsingGETValidateBeforeCall(page, size, projectName, authority, sort, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<UserDTO>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for getUserProjectsUsingGET */
    private com.squareup.okhttp.Call getUserProjectsUsingGETCall(String login, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/api/users/{login}/projects".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "login" + "\\}", apiClient.escapeString(login.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "*/*"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getUserProjectsUsingGETValidateBeforeCall(String login, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'login' is set
        if (login == null) {
            throw new ApiException("Missing the required parameter 'login' when calling getUserProjectsUsingGET(Async)");
        }
        
        
        com.squareup.okhttp.Call call = getUserProjectsUsingGETCall(login, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * getUserProjects
     * 
     * @param login login (required)
     * @return List&lt;ProjectDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<ProjectDTO> getUserProjectsUsingGET(String login) throws ApiException {
        ApiResponse<List<ProjectDTO>> resp = getUserProjectsUsingGETWithHttpInfo(login);
        return resp.getData();
    }

    /**
     * getUserProjects
     * 
     * @param login login (required)
     * @return ApiResponse&lt;List&lt;ProjectDTO&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<ProjectDTO>> getUserProjectsUsingGETWithHttpInfo(String login) throws ApiException {
        com.squareup.okhttp.Call call = getUserProjectsUsingGETValidateBeforeCall(login, null, null);
        Type localVarReturnType = new TypeToken<List<ProjectDTO>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * getUserProjects (asynchronously)
     * 
     * @param login login (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getUserProjectsUsingGETAsync(String login, final ApiCallback<List<ProjectDTO>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getUserProjectsUsingGETValidateBeforeCall(login, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<ProjectDTO>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for getUserUsingGET */
    private com.squareup.okhttp.Call getUserUsingGETCall(String login, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/api/users/{login}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "login" + "\\}", apiClient.escapeString(login.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "*/*"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getUserUsingGETValidateBeforeCall(String login, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'login' is set
        if (login == null) {
            throw new ApiException("Missing the required parameter 'login' when calling getUserUsingGET(Async)");
        }
        
        
        com.squareup.okhttp.Call call = getUserUsingGETCall(login, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * getUser
     * 
     * @param login login (required)
     * @return UserDTO
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UserDTO getUserUsingGET(String login) throws ApiException {
        ApiResponse<UserDTO> resp = getUserUsingGETWithHttpInfo(login);
        return resp.getData();
    }

    /**
     * getUser
     * 
     * @param login login (required)
     * @return ApiResponse&lt;UserDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<UserDTO> getUserUsingGETWithHttpInfo(String login) throws ApiException {
        com.squareup.okhttp.Call call = getUserUsingGETValidateBeforeCall(login, null, null);
        Type localVarReturnType = new TypeToken<UserDTO>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * getUser (asynchronously)
     * 
     * @param login login (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getUserUsingGETAsync(String login, final ApiCallback<UserDTO> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getUserUsingGETValidateBeforeCall(login, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<UserDTO>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for updateUserUsingPUT */
    private com.squareup.okhttp.Call updateUserUsingPUTCall(ManagedUserVM managedUserVM, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = managedUserVM;
        
        // create path and map variables
        String localVarPath = "/api/users".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "*/*"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateUserUsingPUTValidateBeforeCall(ManagedUserVM managedUserVM, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'managedUserVM' is set
        if (managedUserVM == null) {
            throw new ApiException("Missing the required parameter 'managedUserVM' when calling updateUserUsingPUT(Async)");
        }
        
        
        com.squareup.okhttp.Call call = updateUserUsingPUTCall(managedUserVM, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * updateUser
     * 
     * @param managedUserVM managedUserVM (required)
     * @return UserDTO
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UserDTO updateUserUsingPUT(ManagedUserVM managedUserVM) throws ApiException {
        ApiResponse<UserDTO> resp = updateUserUsingPUTWithHttpInfo(managedUserVM);
        return resp.getData();
    }

    /**
     * updateUser
     * 
     * @param managedUserVM managedUserVM (required)
     * @return ApiResponse&lt;UserDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<UserDTO> updateUserUsingPUTWithHttpInfo(ManagedUserVM managedUserVM) throws ApiException {
        com.squareup.okhttp.Call call = updateUserUsingPUTValidateBeforeCall(managedUserVM, null, null);
        Type localVarReturnType = new TypeToken<UserDTO>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * updateUser (asynchronously)
     * 
     * @param managedUserVM managedUserVM (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateUserUsingPUTAsync(ManagedUserVM managedUserVM, final ApiCallback<UserDTO> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateUserUsingPUTValidateBeforeCall(managedUserVM, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<UserDTO>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
