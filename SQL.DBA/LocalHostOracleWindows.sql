select * from user_tables;

select * from TBLORDERDTL;
select * from user_tab_columns
where table_name=:1;


select 1  from dual where regexp_like('gaurav@gmail.com','^[a-zA-z]+[a-zA-z0-9]*@[a-z]*\.[a-z]{2,4}$');





select employee_id,department_id,salary,avg(salary) over (PARTITION BY department_id ORDER BY department_id rows between 1 preceding and 10 following) from employees;