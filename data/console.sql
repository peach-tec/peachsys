drop table if exists `account`;
create table if not exists `account`(
                                        `id` int not null primary key auto_increment,
                                        `name` varchar(20) not null,
                                        `money` decimal(10, 2) not null
) engine = innodb default charset = utf8;

insert into `account` values (default,'A',2000.00),(default,'B',10000.00);

# 数据库的事务模拟代码
set autocommit = 0; # 关闭自动提交
start transaction; # 开启一个事务
update account set money = money - 500 where name = 'A'; # A减少500
update account set money = money + 500 where name = 'B'; # B增加500
commit; # 提交事务
rollback; # 回滚

set autocommit = 1; # 开启自动提交


# 使用数据库方法插入百万条数据
drop table if exists `users`;
create table if not exists `users`(
                                      `id` int not null auto_increment,
                                      `name` varchar(20) not null ,
                                      `email` varchar(255) not null,
                                      `phone` varchar(255) not null,
                                      `gender` tinyint not null,
                                      `password` varchar(255) not null,
                                      `age` int not null,
                                      `created_time` datetime default now(),
                                      `updated_time` datetime default now(),
                                      primary key (`id`)
)comment '用户表' engine = innodb default charset=utf8;

# 插入百万条数据
delimiter $$ # 函数的开始标志
create procedure mock_data() # 定义函数
# returns int # 返回值
begin # 开始
declare num int default 1000000; # 定义循环次数
declare i int default 0; # 定义开始变量
while i < num do # 循环条件
# 循环执行的sql
        insert into users (name,email,phone,gender,password,age)
        values (
                   concat('用户',i),
                   '123456@qq.com',
                   concat('18',floor(rand()*((999999999-100000000)+100000000))),
                   floor(rand()*2),
                   uuid(),
                   floor(rand()*100));
        set i=i+1;# 循环变量自增
    end while; # 结束循环
#     return i;
end $$ # 结束
delimiter ;

call mock_data();

# 导出数据库数据
# mysqldump -h 主机 -u 用户名 -p 数据库 [表名1] [表名2] ... [表名n] > 导出的路径/文件名

# 导入备份数据
# mysql -u 用户名 -p 库名 < 备份文件
