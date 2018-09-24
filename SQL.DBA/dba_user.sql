set pages 55
set linesize 132
column username format a12
column granted_role for a10
select u.username,r.granted_role,u.account_status from sys.dba_users u,sys.dba_role_privs r
where u.username=r.grantee
and u.account_status='OPEN'
and r.granted_role='DBA';