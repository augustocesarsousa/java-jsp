CREATE TABLE usuario (
	id int4 NOT NULL GENERATED ALWAYS AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE),
	login varchar NOT NULL,
	senha varchar NULL,
	nome varchar NULL,
	sobrenome varchar NULL,
	email varchar NULL,
	telefone varchar NULL,
	logradouro varchar NULL,
	numero numeric NULL,
	bairro varchar NULL,
	cidade varchar NULL,
	estado varchar NULL,
	cep varchar NULL,
	fotobase64 text NULL,
	curriculobase64 text NULL,
	fotominiaturabase64 text NULL,
	temcurriculo bool NULL
);

insert into usuario (login,senha,nome,sobrenome,telefone,email) values ('sylvaro','1234','Sylvaro', 'Latrial', '11112222', 'sylvaro@email.com');
insert into usuario (login,senha,nome,sobrenome,telefone,email) values ('nemesys','1234','Nemesys', 'Jozeiros', '22223333', 'nemesys@email.com');
insert into usuario (login,senha,nome,sobrenome,telefone,email) values ('sebethera','1234','Sebethera', 'Cairis', '33334444', 'sebethera@email.com');
insert into usuario (login,senha,nome,sobrenome,telefone,email) values ('timitrion','1234','Timitrion', 'Darri', '44445555', 'timitrion@email.com');
insert into usuario (login,senha,nome,sobrenome,telefone,email) values ('natifer','1234','Natifer', 'Matnu', '55556666', 'natifer@email.com');
insert into usuario (login,senha,nome,sobrenome,telefone,email) values ('rymona','1234','Rymona', 'Crale', '66667777', 'rymona@email.com');
insert into usuario (login,senha,nome,sobrenome,telefone,email) values ('demetrio','1234','Demetrio', 'Adyarus', '77778888', 'demetrio@email.com');
insert into usuario (login,senha,nome,sobrenome,telefone,email) values ('dromeda','1234','Dromeda', 'Yindan', '88889999', 'dromeda@email.com');
insert into usuario (login,senha,nome,sobrenome,telefone,email) values ('bershan','1234','Bershan', 'Yladi', '99990000', 'bershan@email.com');
insert into usuario (login,senha,nome,sobrenome,telefone,email) values ('akra','1234','Akra', 'Vaer', '00009999', 'akra@email.com');
insert into usuario (login,senha,nome,sobrenome,telefone,email) values ('rhenibelle','1234','Rhenibelle', 'Dithas', '99998888', 'rhenibelle@email.com');
insert into usuario (login,senha,nome,sobrenome,telefone,email) values ('sorina','1234','Sorina', 'Saadin', '88887777', 'sorina@email.com');
insert into usuario (login,senha,nome,sobrenome,telefone,email) values ('aslaois','1234','Aslaois', 'Druddeon', '77776666', 'aslaois@email.com');
insert into usuario (login,senha,nome,sobrenome,telefone,email) values ('vania','1234','Vania', 'Quimmer', '66665555', 'vania@email.com.com');
insert into usuario (login,senha,nome,sobrenome,telefone,email) values ('callister','1234','Callister', 'Tayne', '55554444', 'callister@email.com');
