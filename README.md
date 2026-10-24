# Controller de Produtos

Introdução a controllers REST com Spring Boot

Atividade de **Desenvolvimento de Sistemas Corporativos** (DSC) — IFRN.

## Stack

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) ![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white) ![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white) ![H2](https://img.shields.io/badge/H2-1F4E79?style=for-the-badge)

## Como rodar

```bash
./mvnw spring-boot:run
```

A API sobe em `http://localhost:8080`.

## Endpoints

| Rota | Ação |
|---|---|
| `GET /produtos` | Lista os produtos |
| `GET /produtos/{id}` | Busca um produto |
| `POST /produtos` | Cria um produto |
| `PUT /produtos/{id}` | Atualiza um produto |
| `DELETE /produtos/{id}` | Remove um produto |
