DROP table if exists streams;

CREATE TABLE streams(
	stream_id serial NOT NULL,
	ts varchar(50),
	username varchar(50),
	platform varchar(100),
	ms_played int,
	conn_country varchar(20),
	ip_addr_decrypted varchar (25),
    user_agent_decrypted varchar (200),
    master_metadata_track_name varchar(200),
    master_metadata_album_artist_name varchar(200),
    master_metadata_album_album_name varchar(400),
	spotify_track_uri varchar(100),
    episode_name varchar(200),
    episode_show_name varchar(200),
    spotify_episode_uri varchar(100),
    reason_start varchar(30),
    reason_end varchar(30),
    shuffle BOOLEAN,
    skipped BOOLEAN,
    offline BOOLEAN,
    offline_timestamp varchar(40),
    incognito_mode BOOLEAN
);



select * from streams;

select * from streams
where stream_id = 2337;


select master_metadata_track_name, master_metadata_album_artist_name,master_metadata_album_album_name 
from streams;


select master_metadata_track_name, master_metadata_album_artist_name, master_metadata_album_album_name 
from streams
where master_metadata_album_artist_name = '';