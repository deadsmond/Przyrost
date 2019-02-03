https://spring.io/guides/gs/accessing-data-mysql/

service mysql start
service mysql status

database:
mysql --password
create database db_example;
create user 'springuser'@'%' identified by 'ThePassword';
grant all on db_example.* to 'springuser'@'%';