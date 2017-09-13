insert into sgd_facultad (nombre) values ('Ingeniería Electronica y Telecomunicaciones');
insert into sgd_facultad (nombre) values ('Tecnologia en telematica');

insert into sgd_posgrado (nombre, sgd_facultad_idx) values ('Doctorado telematica', 2);
insert into sgd_posgrado (nombre, sgd_facultad_idx) values ('Doctorado electronica', 1);
insert into sgd_posgrado (nombre, sgd_facultad_idx) values ('Ciencias de la computacion', 1);

insert into sgd_tipo_documento (nombre) values ('Publicacion');
insert into sgd_tipo_documento (nombre) values ('Tesis');
insert into sgd_tipo_documento (nombre) values ('Tesis II');
insert into sgd_tipo_documento (nombre) values ('Ingles');

insert into sgd_categoria_documento (nombre) values ('Congreso');
insert into sgd_categoria_documento (nombre) values ('Libro');
insert into sgd_categoria_documento (nombre) values ('Revista');

insert into sgd_estudiante (nombre, apellido) values ('Juan','Chen');
insert into sgd_estudiante (nombre, apellido) values ('Pedro','Khan');
insert into sgd_estudiante (nombre, apellido) values ('Lucas','Shikovski');

insert into sgd_posgrado_tipo_documento (sgd_tipo_documento_idx, sgd_posgrado_idx) values (1,1);
insert into sgd_posgrado_tipo_documento (sgd_tipo_documento_idx, sgd_posgrado_idx) values (1,2);
insert into sgd_posgrado_tipo_documento (sgd_tipo_documento_idx, sgd_posgrado_idx) values (1,3);
insert into sgd_posgrado_tipo_documento (sgd_tipo_documento_idx, sgd_posgrado_idx) values (2,1);
insert into sgd_posgrado_tipo_documento (sgd_tipo_documento_idx, sgd_posgrado_idx) values (2,2);
insert into sgd_posgrado_tipo_documento (sgd_tipo_documento_idx, sgd_posgrado_idx) values (2,3);
insert into sgd_posgrado_tipo_documento (sgd_tipo_documento_idx, sgd_posgrado_idx) values (3,2);
insert into sgd_posgrado_tipo_documento (sgd_tipo_documento_idx, sgd_posgrado_idx) values (3,3);

insert into sgd_campos_documento (nombre) values('Nombre');
insert into sgd_campos_documento (nombre) values('Fecha');
insert into sgd_campos_documento (nombre) values('ISSN');
insert into sgd_campos_documento (nombre) values('ISBN');
insert into sgd_campos_documento (nombre) values('DOI');
insert into sgd_campos_documento (nombre) values('Congreso PDF');
insert into sgd_campos_documento (nombre) values('Evidencia PDF');