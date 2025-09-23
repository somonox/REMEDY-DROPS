
# /drops?latitude={latitude}&longitude={longitude}&radius={radius} [GET]
# Request
| Name      | Type  | Required | Description                          |
| --------- | ----- | -------- |--------------------------------------|
| latitude  | Float | O        | Latitude (WGS84), range −90 to 90    |
| longitude | Float | O        | Longitude (WGS84), range −180 to 180 |
| radius    | Int   | O        | Search radius in meters              |

# Response
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

# Example request:
```json
{
  "latitude": 37.7749,
  "longitude": -122.4194,
  "radius": 5
}
```

# Example response:

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