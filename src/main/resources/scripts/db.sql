create table IF NOT EXISTS tenant_details(
    id serial primary key ,
    tenant_name varchar(255) not null,
    permanent_address varchar(255) not null,
    start_date_of_renting timestamp not null,
    end_date_of_renting timestamp,
    currently_renting boolean,
    pan_number varchar(50) unique,
    aadhar_number varchar(50) unique,
    email_id varchar(100) ,
    created_ts timestamp,
    updated_ts  timestamp
);
--ALTER table tenant_details ALTER COLUMN created_at SET DEFAULT now();
insert into tenant_details (    aadhar_number,    currently_renting,    email_id,    pan_number,    permanent_address,    tenant_name)
values (    '29040989167',     true,     'abc@gmail.com',      'DDFJHHGKGI',    'Abc Mahalla, JBD, 8032044',        'New Tenanat');


select
    td.aadhar_number,
    td.created_ts,
    td.currently_renting,
    td.email_id,
    td.end_date_of_renting,
    td."id",
    td.pan_number,
    td.permanent_address,
    td.start_date_of_renting,
    td.tenant_name,
    td.updated_ts
from
    tenant_details td;




select * from tenant_details;

commit;
alter table tenant_details alter column created_ts set default now();
alter table tenant_details alter column start_date_of_renting set default now();