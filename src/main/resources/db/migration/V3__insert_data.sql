insert into doctor(active,birth_date,name)values(true,CURRENT_TIMESTAMP  ,'doctor');

insert into specialties(name,description,active,doctor_id)values('Cardiologia',' especialista nas doenças do coração e seu sistema circulatório',true,1);
insert into specialties(name,description,active,doctor_id)values('Dermatologia','dermatologista cuida da prevenção e tratamento das doenças do maior órgão do corpo',true,1);
insert into specialties(name,description,active,doctor_id)values('Ortopedia',' especialista no diagnóstico e tratamento das disfunções e lesões do sistema locomotor',true,1);
insert into specialties(name,description,active,doctor_id)values('Anestesiologia','especialista responsável pela condução dos procedimentos anestésicos',true,1);
