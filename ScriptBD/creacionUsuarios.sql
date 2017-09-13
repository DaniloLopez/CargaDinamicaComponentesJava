create user 'sgd'@'localhost' identified by '123456';

grant select on dinamico to 'sgd'@'localhost';
flush privileges;

grant insert on dinamico to 'sgd'@'localhost';
flush privileges;

grant create on dinamico to 'sgd'@'localhost';
flush privileges;

grant update on dinamico to 'sgd'@'localhost';
flush privileges;

grant delete on dinamico to 'sgd'@'localhost';
flush privileges;