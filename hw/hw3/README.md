# Homework III
### Requirements
Split [Wordladder](https://github.com/2quarius/se418/tree/master/hw/hw2)
into _microservices_.
### Overview
```aidl
.
├── README.md
├── docker-compose.yaml
├── login
│   ├── Dockerfile
│   ├── EnglishWords.txt
│   ├── HELP.md
│   ├── app.jar
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   └── src
│       ├── main
│       │   ├── java
│       │   │   └── com
│       │   │       └── sixplus
│       │   │           └── demo
│       │   │               ├── Bean
│       │   │               │   └── WebResponse.java
│       │   │               ├── Constant
│       │   │               │   ├── CommonResponse.java
│       │   │               │   └── HttpResponseStatusEnum.java
│       │   │               ├── Controller
│       │   │               │   └── Controller.java
│       │   │               ├── DemoApplication.java
│       │   │               ├── Entity
│       │   │               │   └── User.java
│       │   │               ├── JWT
│       │   │               │   └── CustomJWT.java
│       │   │               ├── Repository
│       │   │               │   └── UserRepository.java
│       │   │               └── Service
│       │   │                   ├── Impl
│       │   │                   │   └── BaseUserService.java
│       │   │                   └── UserService.java
│       │   └── resources
│       │       ├── application.yaml
│       │       └── static
│       │           └── EnglishWords.txt
│       └── test
│           └── java
│               └── com
│                   └── sixplus
│                       └── demo
│                           └── DemoApplicationTests.java
└── wordladder
    ├── Dockerfile
    ├── EnglishWords.txt
    ├── HELP.md
    ├── app.jar
    ├── mvnw
    ├── mvnw.cmd
    ├── pom.xml
    └── src
        ├── main
        │   ├── java
        │   │   └── com
        │   │       └── sixplus
        │   │           └── demo
        │   │               ├── Bean
        │   │               │   └── WebResponse.java
        │   │               ├── Config
        │   │               │   └── WebConfig.java
        │   │               ├── Constant
        │   │               │   ├── CommonResponse.java
        │   │               │   └── HttpResponseStatusEnum.java
        │   │               ├── Controller
        │   │               │   └── Controller.java
        │   │               ├── DemoApplication.java
        │   │               ├── Interceptor
        │   │               │   └── AuthInterceptor.java
        │   │               ├── JWT
        │   │               │   └── CustomJWT.java
        │   │               ├── Response.java
        │   │               └── WordLadder.java
        │   └── resources
        │       ├── application.yaml
        │       └── static
        │           └── EnglishWords.txt
        └── test
            └── java
                └── com
                    └── sixplus
                        └── demo
                            └── DemoApplicationTests.java
```
`login` and `wordladder` are two respective microservice. 
To build their images, you should run their `Dockerfile` respectively. 
### Preparation
- First and formost, `cd login`, run `Dockerfile` and rename it `login`.
- Secondly, do similarly in `wordladder`.
- Thirdly(I recommand you checked your docker images before doing the following),
run `docker-compose up`.
### Usage
Almost similar to [hw2](./hw2/HELP.md) except that 
- the `/login` and `/register` are exposed by port `8088`
- `wordladder` is exposed by port `8089`
- Header's `Cookie` is replaced by `token` 