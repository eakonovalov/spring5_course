insert into pet_type(id, name) values(1, 'Dog');
insert into pet_type(id, name) values(2, 'Cat');

insert into specialty(id, name) values(1, 'Radiology');
insert into specialty(id, name) values(2, 'Surgery');
insert into specialty(id, name) values(3, 'Dentistry');

insert into owner(id, first_name, last_name, address, city, phone)
values(1, 'Ivan', 'Ivanov', '', '', '');
insert into owner(id, first_name, last_name, address, city, phone)
values(2, 'Petr', 'Petrov', '', '', '');
insert into owner(id, first_name, last_name, address, city, phone)
values(3, 'Alexander', 'Alexandrov', '', '', '');
insert into owner(id, first_name, last_name, address, city, phone)
values(4, 'Alexey', 'Alexeev', '', '', '');
insert into owner(id, first_name, last_name, address, city, phone)
values(5, 'Leonid', 'Leonidov', '', '', '');

insert into pet(id, name, birth_date, owner_id, type_id)
values(1, 'Bobik', '2010-10-01', 1, 1);
insert into pet(id, name, birth_date, owner_id, type_id)
values(2, 'Tuzik', '2010-07-28', 1, 1);
insert into pet(id, name, birth_date, owner_id, type_id)
values(3, 'Sharik', '2016-03-06', 2, 1);
insert into pet(id, name, birth_date, owner_id, type_id)
values(4, 'Murka', '2014-11-13', 3, 2);

insert into vet(id, first_name, last_name) values(1, 'Danil', 'Danilov');
insert into vet(id, first_name, last_name) values(2, 'Fedor', 'Fedorov');

insert into vet_specialty(vet_id, specialty_id) values(1, 2);
insert into vet_specialty(vet_id, specialty_id) values(1, 3);
insert into vet_specialty(vet_id, specialty_id) values(2, 1);
insert into vet_specialty(vet_id, specialty_id) values(2, 2);
insert into vet_specialty(vet_id, specialty_id) values(2, 3);
