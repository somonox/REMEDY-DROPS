# /drops/details?drop_id={drop_id} [GET]
# Request
| Name    | Type | Required | Description                   |
| ------- | ---- | -------- | ----------------------------- |
| drop_id | UUID | O        | Unique identifier of the drop |

# Response
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
# Example Request:
```json
{
    "drop_id": "0000-0000-0000-0000-000000000000"
}
```

# Example Response:
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