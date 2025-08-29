create schema if not exists studentdb;
use studentdb;
create table if not exists student (
    s_rollnumber varchar(10) primary key,
    s_name varchar(50) not null,
    s_year int not null,
    s_email varchar(50) not null unique
);

create schema if not exists coursedb;
use coursedb;
create table if not exists course (
    c_id varchar(10) primary key,
    c_name varchar(50) not null,
    c_credit int not null
);

create schema if not exists enrollmentdb;
use enrollmentdb;
create table if not exists enrollment (
    s_id varchar(10) not null,
    c_id varchar(10) not null
);


create table if not exists teacher (
    t_id varchar(10) primary key,
    t_name varchar(50) not null,
    t_email varchar(50) not null unique
);



create table if not exists users (
	u_name varchar(50) not null,
    u_email varchar(50) not null unique,
    u_password varchar(256) not null
);