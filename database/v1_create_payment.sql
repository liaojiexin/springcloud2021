create table springcloud2021.payment
(
    id bigint auto_increment comment '主键'
        primary key,
    serial varchar(200) null comment '支付流水号'
)
    comment '服务提供者-支付记录';

