# Retrofit 이란

Retrofit은 오픈소스 라이브러리로 REST API를 안드로이드에서 쉽게 이용할 수 있게 하는 도구 입니다.



## 여기서 Rest api란..

**REST(REpresentational State Transfer)** 로 Rest를 통하여 서비스 API를 구현하는 것을 말합니다 .

REST의 구성요소는 자원(resouce) ,method,message로 이루어져 있습니다.



REST에는 **4가지**의 속성이 존재 합니다.

1. 서버에 있는 모든 소스는 각 소스당 클라이언트가 바로 접근 할 수 있는 고유 URI가 존재 합니다
2. 모든 요청은 클라이언트가 요청할 때 마다 필요한 정보를 주기 주기 때문에 서버에서는 세션 정보를 보관할 필요가 없습니다. 그렇기 때문에 서비스에 자유도가 높아지고 유연한 아키텍쳐 적응이 가능합니다.
3. HTTP 메소드를 사용한다는 점입니다. 모든 resource는 일반적으로 http 인터페이스인 GET, POST, PUT, DELETE 4개의 메소드로 접근 되어야한다는 것입니다.
   - POST : 리소스 생성
   - GET : 리소스 조회 및 획득
   - PUT : 리소스 수정
   - DELETE : 리소스 삭제
4.  서비스 내에 하나의 resource가 주변에 연관 된 리소스들과 연결되어 표현이 되어야 한다는 점입니다.



## Retrofit 사용하기

### 환경구축하기

+ gradle에  `dependencies { }`안에 사용해주면 바로 이용가능합니다

  (예시)

  ```
  // Retrofit
  implementation 'com.google.code.gson:gson:2.8.5'
  implementation 'com.squareup.retrofit2:retrofit:2.6.0'
  implementation 'com.squareup.retrofit2:converter-gson:2.6.0'
  ```

+ 인터넷을 사용하기 때문에 `AndroidManifest.xml` 에 `<manifest>` 사이에 아래 권한을 추가해주어야 합니다.

  (예시)

  ```
  <uses-permission android:name="android.permission.INTERNET"/>
  ```

### Retrofit 사용 방법

+ 우선 사용하고자 하는 REST API의 요청 방식과 응답 방식이 어떤지 확인을 해야 합니다

  +사용하고자 하는 API는 요청방식과 응답방식이 전부 다르기 때문에 확인을 해야 합니다.

+ [Repuest] 앱 키를 헤더에 담아 GET으로 요청 합니다.

```
GET /v2/search/image HTTP/1.1
Host: dapi.kakao.com
Authorization: KakaoAK {app_key}
```

```
curl -v -X GET "https://dapi.kakao.com/v2/search/image" \
--data-urlencode "query=[검색 키워드]" \
-H "Authorization: KakaoAK [발급받은 앱 키]"
```

+ [Response] 응답 바디는 JSON 객체로 meta와 documents로 구성됩니다.

  **meta**

  ![image-20200823185510649](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20200823185510649.png)

**document**

![image-20200823185621815](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20200823185621815.png)

이러면 Retrofit2는 Gson( *GSON : JSON 구조를 JAVA 객체로 직렬화, 역직렬화 해주는 라이브러리 입니다.*)을 제공하기 때문에 응답바디와 동일한 data class를 만들어두면 응답 바디에 있는 json을 자동으로 파싱하여 객체를 받을 수 있습니다.



+ Retrofit Interface 만들기

  (이러한 형식으로 interface를 만들면 됌)

  ```
  import com.byjw.jungwoon.util.retrofit.scheme.kakaoApi.Image
  import retrofit2.Call
  import retrofit2.http.GET
  import retrofit2.http.Headers
  import retrofit2.http.Query
  
  interface RetrofitService {
  
      @Headers("Authorization: KakaoAK [발급받은 앱 키]")
      @GET("/v2/search/image")
      fun requestSearchImage(
          @Query("query") keyword: String,
          @Query("sort") sort: String = "recency",
          @Query("page") page: Int,
          @Query("size") size: Int = 10
      ): Call<Image>
  
  }
  ```

+ Retrofit Service.kt 

  - @GET : 리소스 조회 및 획득
  - @POST : 리소스 생성
  - @PUT : 리소스 수정
  - @DELETE : 리소스 삭제

  이걸 이용하여 HTTP Methon별로 서버를 요청 할 수 있습니다.

+ 호출하고자 하는 함수를 지정한 이후 같이 URL에 파라미터가 있는 경우

  @Query()` 어노테이션을 사용해서 값을 넣어줍니다.

```
@Query("query") keyword: String,
@Query("sort") sort: String,
@Query("page") page: Int
```

만약 계층 구조 URL로 되어 있다면,

https://sample.com/members/`alex`*/address* 이러한 형식으로 사용가능 합니다.

```
@GET("members/{user}/address")
fun getUserAddress(@Path("user") userName: String): Call<Address>
```

+ ## 서비스 만들어 주기(가장 중요)

```
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SearchRetrofit {
    // 위에서 만든 RetrofitService를 연결해줍니다.
    fun getService(): RetrofitService = retrofit.create(RetrofitService::class.java)

    private val retrofit =
        Retrofit.Builder()
            .baseUrl("https://dapi.kakao.com") // 도메인 주소
            .addConverterFactory(GsonConverterFactory.create()) // GSON을 사요아기 위해 ConverterFactory에 GSON 지정
            .build()
}
```

최종적인 형식이 이렇게 되면 된다.



+ Search Retrofit.kt

이렇게 되면 SerarchRetofit을 통해서 쉽게 REST API를 호출할 수 있습니다.

(호출)

```
// 위에서 만든 Image.kt의 data class로 받기 때문에 Image 객체를 통해 손쉽게 접근할 수 있습니다.
val response = SearchRetrofit.getService().requestSearchImage(keyword = "iPhone", page = 1).execute()
if (response.isSuccessful) {
    val image = response.body()
    ...
}
```