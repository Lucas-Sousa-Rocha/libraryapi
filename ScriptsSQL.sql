create table author (
    id uuid not null primary key,
    name varchar(100) not null,
    dt_birth date not null,
    nationality varchar(50) not null
)

create table book (
    id uuid not null,
    isbn varchar(20)not null,
    title varchar(150) not null,
    dt_publication date not null,
    gender varchar(30) not null,
    price numeric(18,2),
    id_author uuid not null references author(id),
    constraint chk_gender check (gender in ('Ficção','Fantasia','Misterio','Romance','Biografia','Ciencia'))
)