# crypto-rates
Small Spring Boot example project that fetches data from an API, stores it in a DB and provides a REST interface for the data.

This app depends on a Postgres server running on localhost.

(re)start Postgres via Docker:
* `docker stop postgres`
* `docker run --rm --name postgres -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 postgres`

connect to Postgres via Docker:
* `docker exec -it postgres psql -h localhost -U postgres`

API documentation:
- http://localhost:8080/swagger-ui/index.html

