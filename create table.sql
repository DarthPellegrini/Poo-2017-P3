create schema if not exists dicionario;
use dicionario;

drop table if exists palavras;
create table palavras(
	id int auto_increment,
    palavra varchar(30) not null,
    score int default 0,
    primary key (id)
)engine = InnoDB;