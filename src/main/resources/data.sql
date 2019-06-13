insert into artikel(id,model,preis, aktiv, pfad) values(100,"Mountainbike",4500, 1, "/mountainbike.jpg");
insert into artikel(id,model,preis, aktiv, pfad) values(101,"Rennvelo",7500, 1, "/rennvelo.jpg");

insert into equipment(id,name,preis, artikel_fk, aktiv) values(100,"CushCore",12,100,1);
insert into equipment(id,name,preis, artikel_fk, aktiv) values(101,"Pumpe",13,101,1);
insert into equipment(id,name,preis, artikel_fk, aktiv) values(102,"Tubeless",13,100,1);
insert into equipment(id,name,preis, artikel_fk, aktiv) values(103,"Bidonhalter",13,101,1);

insert into city(id,ort,plz) values(100,"Bern","3000");
insert into city(id,ort,plz) values(101,"Hobbiton","3001");
insert into kunde(id,vorname,nachname,strasse,city_fk) values(100,"Samwise","Gamgee","Strasse",100);
insert into kunde(id,vorname,nachname,strasse,city_fk) values(101,"Frodo","Beutlin","Strasse",101);