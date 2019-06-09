insert into artikel(id,model,preis) values(100,"Mountainbike",4500);
insert into artikel(id,model,preis) values(101,"Rennvelo",7500);

insert into equipment(id,name,preis, artikel_fk) values(100,"CushCore",12,100);
insert into equipment(id,name,preis, artikel_fk) values(101,"Pumpe",13,101);
insert into equipment(id,name,preis, artikel_fk) values(102,"Tubeless",13,100);
insert into equipment(id,name,preis, artikel_fk) values(103,"Bidonhalter",13,101);

insert into city(id,ort,plz) values(1,"Bern","3000");
insert into city(id,ort,plz) values(2,"Hobbiton","3001");
insert into kunde(id,vorname,nachname,strasse,city_fk) values(100,"Samwise","Gamgee","Strasse",2);
insert into kunde(id,vorname,nachname,strasse,city_fk) values(101,"Frodo","Beutlin","Strasse",2);