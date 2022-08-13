USE mydb;

create table `message` (
	`id` bigint(20) not null auto_increment,
	`text` varchar(255) null default null,
	primary key (`id`)
);