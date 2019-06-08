insert into artikel(id,model,preis) values(100,"Etui",22);
insert into artikel(id,model,preis) values(101,"Holz",22);

insert into equipment(id,name,preis, artikel_fk) values(100,"Spitzer",12,100);
insert into equipment(id,name,preis, artikel_fk) values(101,"Bleistift",13,101);
insert into equipment(id,name,preis, artikel_fk) values(102,"Gummi",13,100);
insert into equipment(id,name,preis, artikel_fk) values(103,"Kugelschreiber",13,101);

insert into city(id,ort,plz) values(1,"Bern","3000");
insert into city(id,ort,plz) values(2,"Hobbiton","3001");
insert into kunde(id,vorname,nachname,strasse,city_fk) values(100,"Samwise","Gamgee","Strasse",2);
insert into kunde(id,vorname,nachname,strasse,city_fk) values(101,"Frodo","Beutlin","Strasse",2);