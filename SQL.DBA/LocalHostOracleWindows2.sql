create table order_dt (order_day date,order_id int,product_id varchar2(2),quantity number,price number);
insert into order_dt
values(to_date('20170702','yyyymmdd'),110,'P2',4,10);
select * from order_dt;
select product_id,count(order_id)  sales from order_dt
group by product_id
having count(distinct order_day)>1
order by 2
;
select distinct product_id from order_dt where PRODUCT_ID not in (select product_id from order_dt where ORDER_DAY =to_date('20170701','yyyymmdd'));

select order_day,product_id,(total) from (
select order_day,product_id,sum(QUANTITY*price) total from order_dt
group by order_day,product_id
) t
where (order_day,total) in ( select order_day,max(total) from (
select order_day,product_id,sum(QUANTITY*price) total from order_dt
group by order_day,product_id
) t 
group by order_day)
order by 3 desc;
select order_day,product_id,aa from(
select order_day,product_id,max(total) over (partition by order_day ) aa,total
from (select order_day,product_id,sum(QUANTITY*price) total from order_dt
group by order_day,product_id
) t) t1 where aa=total

; 

select order_day,product_id,sum(QUANTITY*price) total,rank() over (partition by order_day order by sum(QUANTITY*price) desc) rnk   from order_dt
group by order_day,product_id
;
with t as (select order_day,product_id,sum(QUANTITY*price)total
from order_dt
group by order_day,product_id) 
select * from t t2 where 0=(select count(1) from t t1 where t1.total>t2.total and t1.order_day=t2.order_day )
order by 3 desc;

select product_id,sum(QUANTITY*price) ,order_day  from order_dt
group by  order_day,product_id;
select product_id,sum(nvl(a,0)) AA,sum(nvL(b,0)) BB from order_dt
pivot(sum(QUANTITY*price)
for order_day in(to_date('20170702','yyyymmdd') a,to_date('20170701','yyyymmdd') b )
)
group by product_id
order by 1,2,3
;







----------------------------------------------
CREATE TABLE SIMPLE_ORDERS(
ORDER_ID VARCHAR2(40)
, ITEM VARCHAR2(10)
, QUANTITY NUMBER
);
insert into 
SIMPLE_ORDERS values
('O4','A3',2);
select level from simple_orders
CONNECT BY PRIOR 
;

select order_id
     , item
     , QUANTITY
  from SIMPLE_ORDERS
  model
  partition by (order_id, item)
  dimension by (1 as indx)
  measures(QUANTITY)
  rules(
    QUANTITY[for indx from 1 to QUANTITY[1] increment 1] = 1
  )
order by Order_Id, item;
--------------------------------
CREATE TABLE battles(
datea date);
-------------------------------
declare 
v_date date:=to_date('20170801','YYYYMMDD');
begin
for i in 1..10
loop 
insert into battles values(v_date);
v_date:=v_date+1;
end loop;
end;
-------------------------


select to_char(datea,'yyyy-mm'),
count(decode(trim(to_char(datea,'DAY')),'MONDAY',1)) MON,
count(decode(trim(to_char(datea,'DAY')),'SATURDAY',1)) SAT
from battles
group by to_char(datea,'yyyy-mm');
