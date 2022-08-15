create table IF NOT EXISTS "public".tenant_details(
    id serial primary key ,
    tenant_name varchar(255) not null,
    permanent_address varchar(255) not null,
    start_date_of_renting timestamp default now(),
    end_date_of_renting timestamp,
    currently_renting boolean,
    pan_number varchar(50) unique,
    aadhar_number varchar(50) unique,
    email_id varchar(100) ,
    created_ts timestamp  default now(),
    updated_ts  timestamp
);


insert into tenant_details (    aadhar_number,    currently_renting,    email_id,    pan_number,    permanent_address,    tenant_name)
values (    '29040989167',     true,     'abc@gmail.com',      'DDFJHHGKGI',    'Abc Mahalla, JBD, 8032044',        'New Tenanat');

insert into tenant_details (    aadhar_number,    currently_renting,    email_id,    pan_number,    permanent_address,    tenant_name)
values (    '29040919167',     true,     'abc2@gmail.com',      'DKFJHHGKGI',    'New Chowk, JBD, 8032044',        'Avneesh');

select * from     tenant_details td;




select * from tenant_details;

commit;
alter table tenant_details alter column created_ts set default now();
alter table tenant_details alter column start_date_of_renting set default now();