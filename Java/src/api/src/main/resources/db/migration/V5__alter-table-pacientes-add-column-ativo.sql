alter table pacientes add ativo tinyint(1);
update pacientes set ativo = 1;
