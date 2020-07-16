## Kaiburr Swagger REST API

A task project for the Kaiburr recruitment process.

---

### Features

* GET endpoints in spring boot
* PUT endpoint in spring boot
* DELETE endpoint in spring boot
* Swagger UI
* Dockerized image
* Docker compose orchestration

---

### Pre-requisites

* OpenJDK 8
* Maven
* SpringFox
* MongoDB
* Docker (note that if you have docker then you do not need any of the above pre-requisites)

---

### How to run

The following command will run a local mongoDB instance in a docker container binded to port `27017` and a maven application bound to port `8080` and forwarded to port `6969`.

```sh
docker-compose up -d
```

---

### How to query

| Description | Method | Payload | Response |
|:--:|:--:|:--:|:--:|
| Insert data | PUT | name,id,language,framework as JSON | Status: 201 |
| Read all data | GET | `134.209.153.237:6969/rest/user/` | status 200, data name,id,language,framework as JSON |
| Read by ID | GET | url parameter `134.209.153.237:6969/rest/user/{id}` | status 200 name,id,language,framework as JSON|
| Delete by ID | DELETE | url parameter `134.209.153.237:6969/rest/user/{id}` | 200 |

![testing](./testing.png)
--- 

Made with :heart: by Vishvam Vyas
