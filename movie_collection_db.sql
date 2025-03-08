create table actor(
id serial primary key,
surname varchar(20) not null,
name varchar(20) not null
);

create table movie(
id serial primary key,
title varchar(60) not null,
release date
);

create table genre(
id serial primary key,
title varchar(20) not null
);

create table role(
id serial primary key,
id_actor int not null,
id_movie int not null,
role varchar(40) not null,
foreign key (id_actor) references actor,
foreign key (id_movie) references movie
);

create table movie_genre(
id serial primary key,
id_genre int not null,
id_movie int not null,
foreign key (id_genre) references genre,
foreign key (id_movie) references movie
);
