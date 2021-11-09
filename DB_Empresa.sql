/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     10/8/2021 1:31:33 PM                         */
/*==============================================================*/


drop table if exists ADMINISTRADOR;

drop table if exists EMPLEADOS;

drop table if exists EMPRESAS;

drop table if exists TIPO_EMPLEADOS;

/*==============================================================*/
/* Table: ADMINISTRADOR                                         */
/*==============================================================*/
create table ADMINISTRADOR
(
   LOGIN                varchar(20) not null,
   CLAVE                varchar(20) not null,
   primary key (LOGIN)
);

/*==============================================================*/
/* Table: EMPLEADOS                                             */
/*==============================================================*/
create table EMPLEADOS
(
   CODIGO               int not null auto_increment,
   IDEMPRESA            int,
   IDTIPO               int,
   NOMBRE               varchar(20) not null,
   SALARIO              float(0) not null,
   HIJOS                int not null,
   primary key (CODIGO)
);

/*==============================================================*/
/* Table: EMPRESAS                                              */
/*==============================================================*/
create table EMPRESAS
(
   IDEMPRESA            int not null auto_increment,
   NOMBRE               varchar(20) not null,
   primary key (IDEMPRESA)
);

/*==============================================================*/
/* Table: TIPO_EMPLEADOS                                        */
/*==============================================================*/
create table TIPO_EMPLEADOS
(
   IDTIPO               int not null auto_increment,
   NOMBRE               varchar(20) not null,
   primary key (IDTIPO)
);

alter table EMPLEADOS add constraint FK_REFERENCE_1 foreign key (IDEMPRESA)
      references EMPRESAS (IDEMPRESA) on delete restrict on update restrict;

alter table EMPLEADOS add constraint FK_REFERENCE_2 foreign key (IDTIPO)
      references TIPO_EMPLEADOS (IDTIPO) on delete restrict on update restrict;

