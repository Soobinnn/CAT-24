# REST API 설계 
### RESTful API란?
REST(Representational State Transfer)
 : 웹서비스에서 통신을 위한 아키텍쳐
   리소스 중심으로 설계하고, 기능에 맞게 
   GET,POST,PUT,PATCH, DELETE 등의 메소드를 정의


### REST API 설계   
#### 1. REST는 간략하고 직관적이게 디자인
- REST API는 URL이 의미하는 바를 알 수 있어야함.
- 길게만들지 말고 짧게 만들어 제공 (최대 2 Depth)
- URL은 가능하면 명사를 사용하자(복수형으로)
- 리소스에 대한 행위는 HTTP METHOD를 통해 표현하는 것이 좋다.
CRUD (생성 : POST, 읽기 : GET, 수정 : PUT, 삭제 : DELETE)

> EX) [잘못된 예]
>  HTTP POST : /getDevices
>  HTTP POST : /setDevices

> [올바른 예]
> HTTP GET : /devices
> HTTP POST : /devices/{cleaner}


### 디자인 가이드
#### 1. CREATE
	1-1> HTTP POST : /devices  ----- devices생성
	1-2> HTTP POST : /devices/cleaner  ----- 에러
#### 2. READ
	2-1> HTTP GET : /devices  ----- 모든 devices 정보 조회
	2-2> HTTP GET : /devices/cleaner  ----- cleaner 정보 조회
#### 3. UPDATE
	3-1> HTTP PUT : /devices  ----- 모든 devices 업데이트
	3-2> HTTP PUT : /devices/cleaner  -----cleaner 정보 업데이트
#### 4. DELETE
	4-1> HTTP DELETE : /devices  ----- 모든 devices 삭제
	4-2> HTTP DELETE : /devices/cleaner ----- cleaner 삭제
	

#### 리소스간에 관계를 표현하는 방법
2-1. 서브 리소스 표현방법

	HTTP GET : /users/tom/cars  ----- 사용자 tom이 소유하고 있는 car들 정보조회
	HTTP GET : /users/tom/likes/subjects ----- 사용자 tom이 좋아하는 과목 정보 조회
				
>
	
   
#### 에러처리
에러 처리는 HTTP Response Code의 정의를 따라야함.
ResponseBody에 error에 대한 구체적인 정보를 담아서 사용자에게 제공해주자.

* HTTP에 정의된 Response Code는 REST API에서 모두 사용가능함.
  단, 모두 사용하게되면 관리 및 운영에 어려움이 따를 수 있기 때문에, 아래 Code를 포함하여 제공하는 API 서비스에 맞게 Response Code를 추가적으로 사용하도록 해야함.

- 200 : Success
- 400 : Bad Request
- 401 : Unauthorized
- 404 : Not Found
- 500 : Internal Server Error


* 기업별 사용하고 있는 HTTP Response Code 정보
>  Google GData [10개] : 200, 201, 304, 400, 401, 403, 404, 409, 410, 500  
>  Netflix [9개] : 200, 201, 304, 400, 401, 403, 404, 412, 500  

__Error 상세 정보__
HTTP Response Code의 에러에 대한 상세정보를 제공해줘야함.

에러에 대한 상세 정보는 HTTP BODY에 정의해서 사용자에게 전달해 주면 됨.

	EX) 
	HTTP STatus Code : 401
	{
		"error":{
			"code" : 403,
			"message" : The Request is missing a valid API key",
			"status" : "Permission_denied",
			"code" : 12312312,
			"info" : www.test.com/doc/xxxx
		}
	}

*Error Statck 정보가 필요하다면 API서비스 개발시
dev모드와 proc모드를 구분하여 운영하고 알맞게 에러메시지가 반환될 수 있도록 구현하는 것 추천

#### API버전 관리하는 법
이미 서비스 되고 있는 API에 새로운 기능이 추가 되어 새로운 버전이 나오게 되면 하위 호환성을 유지한 상태로 새로운 기능이 추가된 API 서비스를 사용자에게 제공해야 하기 때문이다.

/{servicename}/{version}/{REST URL}

#### API에 페이징 개념 적용하는 법
__5-1. 페이징 디자인__

	Facebook : /record?offset=100&limit=25 : 100번째 부터 25개 레코드 조회  
	LinkedIn : /record?start=50&count=25 : 50번째 부터 25개 레코드 조회

__5-2. Partial Response 처리하기__
리소스의 일부 정보만 조회하고자 할 때 사용
ex) user 리소스에 해당하는 정보중 id와 이름말 필요할 경우, 필요한 정보만 제공

	Facebook : /terry/friends?fields=id,name  
	Google : /fields=title,media:group(media:thumnail)  

#### API로 검색
__6-1. API에서 검색 조건 디자인__
API에 검색 조건은 하나의 Query String으로 정의하여 사용하는 것이 좋다

	ex) /user?q=name%3Dcho,region%3Dseoul&offset=20&limit=10  
	위 예에서 검색 조건에 해당하는 부분은 URL Encode를 사용해 작성한
	q=name%3Dcho,region%3Dseoul(실제 : q=name=cho,region=seoul)에 해당한다.  

이와 같이 검색 조건을 별도로 정의하여 사용하는 이유는 아래와 같다.  
/users?name=cho&region=seoul 이와 같이 검색 조건을 정의 하였다고 생각해보자. 검색 조건만 있을 경우에는 크게 문제가 되지 않지만 위 내용에 페이징 관련 내용을 추가하여 /users?name=cho&region=seoul&offset=20&limit=10와 같이 쓰게 된다면 어디까지가 검색 조건이고 어디까지가 페이징 조건인지 알 수 없게 된다. 이와 같은 문제 때문에 검색 조건을 별도로 정의하여 사용하는 것이다.  

__6-2. 검색 범위별 디자인__

	<전체 검색>  
	전체 리소스에 대한 검색을 요청하는 API의 경우에는 /search와 같은 전역 검색을 뜯하는 URL를 정의하여 사용하면 된다.  
	예 > /search?q=name%3Dlee : 이름이 lee인 모든 리소스를 조회  
  
	<리소스 검색>  
	특정 리소스에 대한 검색을 원할 경우에는 지금까지 예제로 들어왔던 것과 동일하게 리소스를 명시하고 뒤에 검색 조건을 작성하면 된다.  
	예 > /students?q=name%Dlee 이름이 lee인 학생들 조회  

