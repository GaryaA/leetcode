CREATE TABLE IF NOT EXISTS person
(
    id         integer primary key,
    last_name  text,
    first_name text
);
CREATE TABLE IF NOT EXISTS address
(
    id        integer primary key,
    person_id integer,
    city      text,
    state     text
);

CREATE TABLE IF NOT EXISTS result
(
    first_name text,
    last_name  text,
    city       text,
    state      text
);

insert into person
values (1, 'Wang', 'Allen');
insert into person
values (2, 'Alice', 'Bob');

insert into address
values (1, 2, 'New York City', 'New York');
insert into address
values (2, 3, 'Leetcode', 'California');

insert into result values ('Allen', 'Wang', null, null);
insert into result values ('Bob', 'Alice', 'New York City', 'New York');