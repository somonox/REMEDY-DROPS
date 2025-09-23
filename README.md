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
I used PostgreSQL with PostGIS extension for spatial data support.

according example, table `drop` create query should be like this:
```sql
CREATE TABLE drops (
    drop_id     uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id     uuid NOT NULL REFERENCES users(user_id),
    music_id    uuid NOT NULL REFERENCES music(music_id),
    content     text NOT NULL,
    coord       geography(Point) NOT NULL,
    expires_at  timestamptz NOT NULL
);

CREATE INDEX idx_drops_coord_gist ON drops USING GIST (coord);
```
table `music` create query should be like this:
```sql
CREATE TABLE music (
    music_id   uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    title      varchar(255) NOT NULL,
    artist     varchar(255) NOT NULL,
    album_img  text         NOT NULL,
    duration_seconds int    NOT NULL
);
```
table `users` create query should be like this:
```sql
CREATE TABLE users (
    user_id      uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    username     text        NOT NULL,
    email        text        NOT NULL UNIQUE,
    password_hash text       NOT NULL,
    created_at   timestamptz NOT NULL DEFAULT now()
);
```