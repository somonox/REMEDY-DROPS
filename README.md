# RE:MEDY
Drop system implementation
Designed for high availability and low latency

## Note
I normalized the database schema to reduce redundancy and improve data integrity.
for example, a drop in a map doesn't require all music information, so I created a separate `music` table to store music details and referenced it in the `drop` table using a foreign key.
And I changed response model little bit because it is awkward that drop only contains drop_id, latitude and longitude.
If user trying to open a drop, client will request for additional drop information, and client also need to request for music information,
this will cause additional latency and more complex client logic.
So I included all necessary information in the drop response model.
And I used Spatial Index for coordinate to improve performance of location-based queries.

## API Specification
### /drops [POST]
| Name            | Type    | Required | Description                      |
|-----------------|---------|----------|----------------------------------|
| user_id         | UUID    | O        | ID of the user creating the drop |
| music           | Object  | O        | Music information                |
| music.title     | String  | O        | Title of the music               |
| music.artist    | String  | O        | Artist of the music              |
| music.album_img | String  | O        | URL of the album image           |
| music.time      | Integer | O        | Duration of the music in seconds |
| content         | String  | O        | Content of the drop              |
| latitude        | Float   | O        | Latitude of the drop location    |
| longitude       | Float   | O        | Longitude of the drop location   |
| expires_at      | String  | O        | Expiration time of the drop      |
example request body:
```json
{
    "user_id": "0000-0000-0000-0000-000000000000",
    "music": {
        "title": "Sample Music Title",
        "artist": "Sample Artist",
        "album_img": "http://example.com/album.jpg",
        "time": 240
    },
    "content": "This is a sample drop content.",
    "latitude": 37.7749,
    "longitude": -122.4194,
    "expires_at": "2024-12-31T23:59:59Z"
}
```
| Name            | Type    | Required | Description            |
|-----------------|---------|----------|------------------------|
| drop_id         | UUID    | O        | ID of the created drop |
example response:
```json
{
    "drop_id": "0000-0000-0000-0000-000000000000"
}
```

### /drops?latitude={latitude}&longitude={longitude}&radius={radius} [GET]
| Name  | Type  | Required | Description                                              |
| ----- | ----- | -------- | -------------------------------------------------------- |
| drops | Array | O        | List of drop objects returned for the given radius query |
drops[] Item

| Name        | Type   | Required | Description                                                    |
| ----------- | ------ | -------- | -------------------------------------------------------------- |
| drop\_id    | UUID   | O        | Unique identifier of the drop                                  |
| user\_id    | UUID   | O        | Identifier of the user who created the drop                    |
| music\_id   | UUID   | O        | Identifier of the associated music record                      |
| content     | String | O        | Text content of the drop                                       |
| latitude    | Float  | O        | Latitude (WGS84), range −90 to 90                              |
| longitude   | Float  | O        | Longitude (WGS84), range −180 to 180                           |
| expires\_at | String | O        | Expiration time in ISO 8601 UTC (e.g., `2024-12-31T23:59:59Z`) |


example response:

```json
{
  "drops":[
    {
      "drop_id": "0000-0000-0000-0000-000000000000",
      "user_id": "0000-0000-0000-0000-000000000000",
      "music_id": "0000-0000-0000-0000-000000000000",
      "content": "This is a sample drop content.",
      "latitude": 37.7749,
      "longitude": -122.4194,
      "expires_at": "2024-12-31T23:59:59Z"
    },
    {
      "drop_id": "0000-0000-0000-0000-000000000000",
      "user_id": "0000-0000-0000-0000-000000000000",
      "music_id": "0000-0000-0000-0000-000000000000",
      "content": "This is a sample drop content.",
      "latitude": 37.7749,
      "longitude": -122.4194,
      "expires_at": "2024-12-31T23:59:59Z"
    },
    {
      "drop_id": "0000-0000-0000-0000-000000000000",
      "user_id": "0000-0000-0000-0000-000000000000",
      "music_id": "0000-0000-0000-0000-000000000000",
      "content": "This is a sample drop content.",
      "latitude": 37.7749,
      "longitude": -122.4194,
      "expires_at": "2024-12-31T23:59:59Z"
    }
  ]
}
```
| Name             | Type    | Required | Description                                                    |
| ---------------- | ------- | -------- | -------------------------------------------------------------- |
| drop\_id         | UUID    | O        | Unique identifier of the drop                                  |
| user             | Object  | O        | Embedded user object                                           |
| user.user\_id    | UUID    | O        | Unique identifier of the user                                  |
| user.username    | String  | O        | Display name of the user                                       |
| music            | Object  | O        | Embedded music object                                          |
| music.music\_id  | UUID    | O        | Unique identifier of the music record                          |
| music.title      | String  | O        | Title of the track                                             |
| music.artist     | String  | O        | Artist name                                                    |
| music.album\_img | String  | O        | URL of the album cover image                                   |
| music.time       | Integer | O        | Duration of the track in seconds                               |
| content          | String  | O        | Text content of the drop                                       |
| latitude         | Float   | O        | Latitude (WGS84), range −90 to 90                              |
| longitude        | Float   | O        | Longitude (WGS84), range −180 to 180                           |
| expires\_at      | String  | O        | Expiration time in ISO 8601 UTC (e.g., `2024-12-31T23:59:59Z`) |

### /drops/details?drop_id={drop_id} [GET]
```json
{
    "drop_id": "0000-0000-0000-0000-000000000000",
    "user": {
        "user_id": "0000-0000-0000-0000-000000000000",
        "username": "sampleuser"
    },
    "music": {
      "music_id": "0000-0000-0000-0000-000000000000",
      "title": "Sample Music Title",
      "artist": "Sample Artist",
      "album_img": "http://example.com/album.jpg",
      "time": 240
    },
    "content": "This is a sample drop content.",
    "latitude": 37.7749,
    "longitude": -122.4194,
    "expires_at": "2024-12-31T23:59:59Z"
}
```

## Database Schema

according example, table `drop` create query should be like this:
```sql
CREATE TABLE drop (
    drop_id UUID PRIMARY KEY,
    user_id UUID NOT NULL,
    music_id UUID NOT NULL,
    content TEXT NOT NULL,
    coord POINT NOT NULL SRID 4326,
    expires_at TIMESTAMP NOT NULL,
    FOREIGN KEY (music_id) REFERENCES music(music_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    SPATIAL INDEX (coord)
);
```
table `music` create query should be like this:
```sql
CREATE TABLE music (
    music_id UUID PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    artist VARCHAR(255) NOT NULL,
    album_img TEXT NOT NULL,
    time INT NOT NULL
);
```
table `users` create query should be like this:
```sql
CREATE TABLE users (
    user_id UUID PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password_hash TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```