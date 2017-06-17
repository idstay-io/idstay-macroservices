insert into hotel values('1','MAKERS HOTEL');

insert into room_type (room_type_code, hotel_id, room_type_name, acronym) values ('2','1','MODERN_DOUBLE','MD');
insert into room_type (room_type_code, hotel_id, room_type_name, acronym) values ('3','1','SEMI_DOUBLE','SD');


insert into room (room_code, room_name, hotel_id, room_type_code, floor) values ('1','201','1','2',1);
insert into room (room_code, room_name, hotel_id, room_type_code, floor) values ('2','301','1','2',2);
insert into room (room_code, room_name, hotel_id, room_type_code, floor) values ('3','401','1','2',3);
insert into room (room_code, room_name, hotel_id, room_type_code, floor) values ('4','501','1','2',4);
insert into room (room_code, room_name, hotel_id, room_type_code, floor) values ('5','601','1','2',5);


insert into room (room_code, room_name, hotel_id, room_type_code, floor) values ('6','602','1','3',5);

insert into crew (crew_id, crew_name, nick_name, email, language, hotel_id, active) values ('1','min', '@min', 'minsoo.kim@jkglobe.com', 'en_US', '1', true);
insert into crew (crew_id, crew_name, nick_name, email, language, hotel_id, active) values ('2','giny','@giny','biz@jkglobe.com',        'en_US', '1', true);