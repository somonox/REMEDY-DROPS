# /drops [POST]
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

| Name            | Type    | Required | Description            |
|-----------------|---------|----------|------------------------|
| drop_id         | UUID    | O        | ID of the created drop |

# Example request:
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

# Example response:
```json
{
    "drop_id": "0000-0000-0000-0000-000000000000"
}
```
