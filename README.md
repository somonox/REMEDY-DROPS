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
[Query Regional Drops](./query_regional.md)

[Query Drop Details](./query_detail.md)

[Add Drop](./add_drop.md)

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