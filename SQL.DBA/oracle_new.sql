set serveroutput on ;
create or replace procedure proc_CursorRefEx(emp_id in int)
as
type ref_cur is ref cursor;
emp_cv ref_cur;
emp_rec employees%ROWTYPE;
  
stmt varchar(100):='select * from employees';
v_empid int :=emp_id;
begin
if v_empid is null then open emp_cv for stmt;
else
stmt:=stmt ||' where EMPLOYEE_ID= :v_empid';
open emp_cv for stmt using v_empid;
end if;
loop
fetch emp_cv into emp_rec;
exit when emp_cv%NotFOUND;
DBMS_OUTPUT.PUT_LINE('CURSOR LOOP 2 -- Employee:  '||emp_rec.First_Name||'has salary :'||emp_rec.salary);
end loop;
  close emp_cv;
  end;
  
clear scr
exec PROC_CURSORREFEX(null);

CREATE OR REPLACE TYPE BODY rectangle AS
   MEMBER FUNCTION enlarge(inc number) return rectangle IS
   BEGIN
      return rectangle(self.length + inc, self.width + inc);
   END enlarge;

   MEMBER PROCEDURE display IS
   BEGIN
      dbms_output.put_line('Length: '|| length);
      dbms_output.put_line('Width: '|| width);
   END display;

   MAP MEMBER FUNCTION measure return number IS
   BEGIN
      return (sqrt(length*length + width*width));
   END measure;
END;
/

DECLARE
   r1 rectangle;
   r2 rectangle;
   r3 rectangle;
   inc_factor number := 5;
BEGIN
   r1 := rectangle(3, 4);
   r2 := rectangle(5, 7);
   r3 := r1.enlarge(inc_factor);
   r3.display;

   IF (r1 > r2) THEN -- calling measure function
      r1.display;
   ELSE
      r2.display;
   END IF;
END;
/