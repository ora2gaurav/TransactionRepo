create or replace procedure emp_rep
(cond in number) 

is

emp_id number(6);
name varchar2(60);
email varchar2(50);
depart_id number(4);
count1 number(4):=0;

cursor emp_cursor
is 
select employee_id ,first_name || last_name as NAME ,email,department_id from employees where employee_id>cond order by 2 asc;

begin
open emp_cursor;

LOOP

fetch emp_cursor into emp_id,name,email,depart_id;
exit when emp_cursor%NOTFOUND;
dbms_output.put_line('EMPLOYEE ID:'|| emp_id||'   NAME :'||name||'  EMAIL :'||email||'   DEPARTMENT ID:  '||depart_id );
count1:=count1+1;
end loop;
dbms_output.put_line(count1||'RECORDS RETRIEVED');
end;
/
