create table blog (
    `blog_id` int auto_increment,
    `tittle` varchar(100),
    `author` varchar(20),
    `create_time` timestamp,
    `content` text,
    `desc` varchar(300),
    primary key (`blog_id`)
)