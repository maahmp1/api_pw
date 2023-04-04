alter table contasreceebr add constraint FK_ID_Cliente foreign key (id) references cliente(id);

insert into cliente(nomecliente) values ('Pedro');
insert into cliente(nomecliente) values ('Lucas');
insert into cliente(nomecliente) values ('Santana');
insert into cliente(nomecliente) values ('Cristian');
