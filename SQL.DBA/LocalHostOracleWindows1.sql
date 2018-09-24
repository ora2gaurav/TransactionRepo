select table_name from user_tables;
select b.venid,b.VENNAME,a.ITEMDESC from TBLITEM a,tblvendor b where a.venid=b.venid
and UPPER(a.ITEMDESC) like '%'||UPPER(:p_item)||'%';

begin
PROC_ITEM('Electronis');
end;













select 1 from dual where Regexp_like('ora2gaurav@gmail.in','^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z]+\.[a-zA-Z]{2,4}$');
select 1 from dual where Regexp_like('6934119938','^[7-9][0-9]{9}$');