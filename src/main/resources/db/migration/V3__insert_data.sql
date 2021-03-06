insert into doctor(active,birth_date,name)values(true,CURRENT_TIMESTAMP  ,'dr.claudio');
insert into doctor(active,birth_date,name)values(true,CURRENT_TIMESTAMP  ,'dr.joao vicente');
insert into doctor(active,birth_date,name)values(true,CURRENT_TIMESTAMP  ,'dr.mauricio');
insert into doctor(active,birth_date,name)values(true,CURRENT_TIMESTAMP  ,'dr.joao marcos');
insert into doctor(active,birth_date,name)values(true,CURRENT_TIMESTAMP  ,'dr.jose');

insert into specialties(name,description,active,doctor_id)values('cardiologia',' especialista nas doenças do coração e seu sistema circulatório',true,3);
insert into specialties(name,description,active,doctor_id)values('cardiologia',' especialista nas doenças do coração e seu sistema circulatório',true,2);
insert into specialties(name,description,active,doctor_id)values('dermatologia','dermatologista cuida da prevenção e tratamento das doenças do maior órgão do corpo',true,2);
insert into specialties(name,description,active,doctor_id)values('dermatologia','dermatologista cuida da prevenção e tratamento das doenças do maior órgão do corpo',true,1);
insert into specialties(name,description,active,doctor_id)values('ortopedia',' especialista no diagnóstico e tratamento das disfunções e lesões do sistema locomotor',true,4);
insert into specialties(name,description,active,doctor_id)values('anestesiologia','especialista responsável pela condução dos procedimentos anestésicos',true,5);
