<h1 align="center"> STORE-JPA </h1> <br>

## 목차

- [소개](#소개)

- [실행](#실행)

- [Generic and Abstract](#generic-and-abstract)

- [REST API Reference](#rest-api-reference)

- [ERD](#erd)

## 소개
Store를 주제로 서버, 관리 페이지 개발 - JPA를 학습하고 추가적으로 Store에서 사용될 API를 개발

## 기술스택
* Server : Java 11, Spring Boot 2.4.1, JPA, MySql, Junit5, AWS EC2 

## 실행
1. repo clone
```
git clone https://github.com/hyungjun26/store-jpa.git
```
2. build
```
cd store-jpa/store-api
./gradlew build
```
3. jar 실행
```
cd build/libs
java -jar store-0.0.1-SNAPSHOT.jar
```

## Generic and Abstract
 - 제네릭 적용으로 타입변환의 이점을 얻고 안정성과 작업 효율성을 개선
 - 미 적용시 DTO에 대한 타입변환 또는 각 DTO에 매칭되도록 작성해야한다
```
public class Header<T> {
    ...중략
    // OK
    public static <T> Header<T> OK(T data){
        return (Header<T>) Header.builder()
                ...데이터
                .build();
    }
```

- 추상화 적용으로 기본 작업(CRUD 등) 구현
- 적용 전 : 기존 각 controller마다 인터페이스를 상속하여 CRUD를 반복적으로 정의(반복 작업으로 시간 소비)
- 적용 후 : 반복 작업 감소 및 비즈니스 로직에 집중 가능(작업 효율 개선)
```
public abstract class CrudController<Request, Response, Entity> implements CrudInterface<Request, Response> {

    @Autowired(required = false)
    protected BaseService<Request, Response, Entity> baseService;

    @Override
    @PostMapping("")
    public Header<Response> create(@RequestBody Header<Request> request) {
        return baseService.create(request);
    }
    ..중략
}
```

## REST API Reference 
- Swagger Doc: <http://ec2-13-125-59-76.ap-northeast-2.compute.amazonaws.com/swagger-ui.html#/>
![API](./images/swagger.png)

| Method | Mapping               | Description                |
|--------|-----------------------|----------------------------|
| POST   | /api/adminUser        | 관리자 계정 생성           |
| PUT    | /api/adminUser        | 관리자 계정 수정           |
| GET    | /api/adminUser/{id}   | 관리자 ID로 정보 조회      |
| DELETE | /api/adminUser/{id}   | 관리자 ID로 정보 삭제      |
| POST   | /api/user             | 일반 사용자 계정 생성      |
| PUT    | /api/user             | 일반 사용자 계정 수정      |
| GET    | /api/user/{id}        | 일반 사용자 ID로 정보 조회 |
| DELETE | /api/user/{id}        | 일반 사용자 ID로 정보 삭제 |
| POST   | /api/partner          | 파트너사 계정 생성         |
| PUT    | /api/partner          | 파트너사 계정 수정         |
| GET    | /api/partner/{id}     | 파트너사 ID로 정보 조회    |
| DELETE | /api/partner/{id}     | 파트너사 ID로 정보 삭제    |
| POST   | /api/category         | 카테고리 생성              |
| PUT    | /api/category         | 카테고리 수정              |
| GET    | /api/category/{id}    | 카테고리 정보 조회         |
| DELETE | /api/category/{id}    | 카테고리 정보 삭제         |
| POST   | /api/item             | 상품 생성                  |
| PUT    | /api/item             | 상품 수정                  |
| GET    | /api/item/{id}        | 상품 정보 조회             |
| DELETE | /api/item/{id}        | 상품 정보 삭제             |
| POST   | /api/orderGroup       | 거래 내역 생성             |
| PUT    | /api/orderGroup       | 거래 내역 수정             |
| GET    | /api/orderGroup/{id}  | 거래 내역 정보 조회        |
| DELETE | /api/orderGroup/{id}  | 거래 내역 정보 삭제        |
| POST   | /api/orderDetail      | 거래 상세 정보 생성        |
| PUT    | /api/orderDetail      | 거래 상세 정보 수정        |
| GET    | /api/orderDetail/{id} | 거래 상세 정보 조회        |
| DELETE | /api/orderDetail/{id} | 거래 상세 정보 삭제        |

## API 동작 구조

![API](./images/API.png)

## ERD
- admin_user : 관리자 정보
- partner : 제휴 파트너 정보
- item : 상품 정보
- category : 상품 카테고리 정보
- order_group : 거래 정보
- order_detail : 거래 상세 정보
- user : 고객 정보

![ERD](./images/STORE_ERD.jpg)
