# Movies REST API(Hibernate, Postgres,Spring)

## Endpoints
Endpoints     | Type          | Description
------------- | ------------- | -------------
"/api/v1/movies"                           | (GET) | All movies
"/api/v1/movies"                           | (POST) | Adds a movies
"/api/v1/movies/{id}"                    | (PUT) | Updates/Replaces a movie
"/api/v1/movies/{id}"      | (DELETE)| Deletes a movie.
"/api/v1/movies/{movie_id}/actors/{actor_id}"      | (DELETE)| Deletes an actor from a movie.
"/api/v1/movies/actors"                    | (POST) | Adds a new movie WITH actors.
"/api/v1/movies/{id}"                | (GET)| Gets a specific movie
"/api/v1/movies/{movie_id}/actors/{actor_id}"      | (POST)| Adds an actor to a movie
"/api/v1/actors"       | (GET)| All Actors
"/api/v1/actors/{id}" | (GET)| Gets a specific actor.
"/api/v1/actors/{id}" | (DELETE)| Deletes an actor.
"/api/v1/directors"       | (GET)| All Directors
"/api/v1/directors/{id}" | (GET)| Gets a specific director.
"/api/v1/directors/{id}" | (DELETE)| Deletes an director.
"/api/v1/genre"       | (GET)| All Genre
"/api/v1/genre/{id}" | (GET)| Gets a specific genre.
"/api/v1/genre/{id}" | (DELETE)| Deletes an genre.

"/api/v1/actors/filter?from={date}&to={date}" | (GET)|  Gets an actor whose date of birth is between the two dates.
пример: http://localhost:8081/api/v1/actors/filter?from=1950-01-01&to=2000-10-10

"/api/v1/movies/search?title={string}" | (GET)|  Gets a movie based on title.

пример: http://localhost:8081/api/v1/directors/sort

Создание контейнера
docker run --name postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres

