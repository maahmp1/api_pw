alter table contasareceber add constraint FK_ID_Cliente foreign key (idcliente) references cliente(id);

insert into cliente(nomecliente) values ('Pedro');
insert into cliente(nomecliente) values ('Lucas');
insert into cliente(nomecliente) values ('Santana');
insert into cliente(nomecliente) values ('Cristian');

insert into contasareceber(valorconta, dataconta, idcliente) values ('900.25', '2004-02-04', 1);
insert into contasareceber(valorconta, dataconta, idcliente) values ('980.00', '2009-02-10', 2);
insert into contasareceber(valorconta, dataconta, idcliente) values ('750.30', '2007-02-09', 3);
