drop table if exists mma CASCADE;

create table mma (
	id bigint auto_increment,
	age integer not null,
	draws integer not null,
	losses integer not null, 
	name varchar(255),
	no_contests integer not null,
	wins integer not null,
	primary key (id)
);