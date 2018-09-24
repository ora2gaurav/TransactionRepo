select table_name from user_tables;
select department_id,count(employee_id)
from employees 
having SUM(salary)>MIN(salary)*2
group by department_id
select count(*),department_id from (
select min(salary),sum(salary),
department_id,case when min(salary)*2>sum(salary) then 'LOW' else 'HIGH' end REMARK  from employees  group by DEPARTMENT_ID ) 
where remark='HIGH'
group by department_id
order by 2
select * from jobs
delete from jobs_history where employee_id=145 
