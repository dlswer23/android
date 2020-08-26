# Json 읽어오는 방법

+ Parsing 할 JSON 텍스트 준비

  기본적인 스트링으로 해도 되고, 안드로이드의 string 리소스에 넣어두어도 됩니다.

//String str = "[{'name' : '이은별','age' : 17, 'address': '대전'}]"



+ 위에 준비된 텍스트로 JSON 객체 생성

  

  //JSONArray jarray = new JSONArray(str);  // JSONArray 생성



+ JSONArray 객체의 getJSONObject(i) 메소드로 child object 들을 차례대로 추출
    이때 child 의 개수는 length() 메소드로 체크 가능.
    추출된 child object 들은 JSONObject 로 받습니다.

  

  // for(int i=0; i < jarray.length(); i++){

    JSONObject jObject = jarray.getJSONObject(i); 

  }

  

  

  + 각 JSONObject 객체에서 get\**\*("~~") 메소드를 통해 '값' 을 받습니다.
    이때 get메소드의 매개변수는 **'키'**값 입니다.

  

  