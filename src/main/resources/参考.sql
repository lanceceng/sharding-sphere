create table t_config
(
  id               int                                 not null
    primary key,
  remark           varchar(50)                         null,
  create_time      timestamp default CURRENT_TIMESTAMP not null,
  last_modify_time timestamp default CURRENT_TIMESTAMP not null
    on update CURRENT_TIMESTAMP
);

create table t_order0
(
  order_id         int                                 not null
    primary key,
  user_id          int                                 not null,
  config_id        int                                 not null,
  remark           varchar(50)                         null,
  create_time      datetime default CURRENT_TIMESTAMP  not null,
  last_modify_time timestamp default CURRENT_TIMESTAMP not null
    on update CURRENT_TIMESTAMP
);

create table t_order1
(
  order_id         int                                 not null
    primary key,
  user_id          int                                 not null,
  config_id        int                                 not null,
  remark           varchar(50)                         null,
  create_time      timestamp default CURRENT_TIMESTAMP not null,
  last_modify_time timestamp default CURRENT_TIMESTAMP not null
    on update CURRENT_TIMESTAMP
);

create table t_order_item0
(
  item_id          bigint auto_increment
    primary key,
  order_id         bigint                              not null,
  remark           varchar(50)                         null,
  create_time      timestamp default CURRENT_TIMESTAMP not null,
  last_modify_time timestamp default CURRENT_TIMESTAMP not null
    on update CURRENT_TIMESTAMP
);

create table t_order_item1
(
  item_id          bigint auto_increment
    primary key,
  order_id         bigint                              not null,
  remark           varchar(50)                         null,
  create_time      timestamp default CURRENT_TIMESTAMP not null,
  last_modify_time timestamp default CURRENT_TIMESTAMP not null
    on update CURRENT_TIMESTAMP
);
