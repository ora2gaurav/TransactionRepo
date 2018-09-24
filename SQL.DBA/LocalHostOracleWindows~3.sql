Error starting at line : 1 in command -
declare
type tb is table of int ;
n tb;
begin
n(1):=1;
end;
Error report -
ORA-06531: Reference to uninitialized collection
ORA-06512: at line 5
06531. 00000 -  "Reference to uninitialized collection"
*Cause:    An element or member function of a nested table or varray
           was referenced (where an initialized collection is needed)
           without the collection having been initialized.
*Action:   Initialize the collection with an appropriate constructor
           or whole-object assignment.
Error starting at line : 1 in command -
declare
type tb is table of int ;
n tb;
begin
n:=tb();
n(1):=1;
end;
Error report -
ORA-06533: Subscript beyond count
ORA-06512: at line 6
06533. 00000 -  "Subscript beyond count"
*Cause:    An in-limit subscript was greater than the count of a varray
           or too large for a nested table.
*Action:   Check the program logic and explicitly extend if necessary.
PL/SQL procedure successfully completed.

PL/SQL procedure successfully completed.

PL/SQL procedure successfully completed.

SP2-0158: unknown SET option "serverouput"
PL/SQL procedure successfully completed.

Error starting at line : 2 in command -
declare
type tb is table of int ;
n tb;
n1 tb;
begin
n:=tb();
n.extend;
n(1):=1;
n:=n1;
dbms_output.put_line(n(1));
end;
Error report -
ORA-06531: Reference to uninitialized collection
ORA-06512: at line 10
06531. 00000 -  "Reference to uninitialized collection"
*Cause:    An element or member function of a nested table or varray
           was referenced (where an initialized collection is needed)
           without the collection having been initialized.
*Action:   Initialize the collection with an appropriate constructor
           or whole-object assignment.
PL/SQL procedure successfully completed.

1

Error starting at line : 2 in command -
declare
type tb is table of int ;
n tb;
n1 tb;
begin
n:=tb();
n.extend;
n(1):=1;
n:=n1;
dbms_output.put_line(n(1));
end;
Error report -
ORA-06531: Reference to uninitialized collection
ORA-06512: at line 10
06531. 00000 -  "Reference to uninitialized collection"
*Cause:    An element or member function of a nested table or varray
           was referenced (where an initialized collection is needed)
           without the collection having been initialized.
*Action:   Initialize the collection with an appropriate constructor
           or whole-object assignment.
Error starting at line : 2 in command -
declare
type tb is table of int ;
n tb;
n1 tb;
begin
n:=tb();
n.extend;
n(1):=1;
n:=n1;
dbms_output.put_line(n(1));
execute immediate 'update tblvendor_history set vencode=:1;' using NULL;

end;
Error report -
ORA-06550: line 11, column 68:
PLS-00457: expressions have to be of SQL types
ORA-06550: line 11, column 1:
PL/SQL: Statement ignored
06550. 00000 -  "line %s, column %s:\n%s"
*Cause:    Usually a PL/SQL compilation error.
*Action:
Error starting at line : 2 in command -
declare
type tb is table of int ;
n tb;
n1 tb;
begin
n:=tb();
n.extend;
n(1):=1;
n:=n1;
dbms_output.put_line(n(1));
execute immediate 'update tblvendor_history set vencode=:1;' using NULL;

end;
Error report -
ORA-06550: line 11, column 68:
PLS-00457: expressions have to be of SQL types
ORA-06550: line 11, column 1:
PL/SQL: Statement ignored
06550. 00000 -  "line %s, column %s:\n%s"
*Cause:    Usually a PL/SQL compilation error.
*Action:
Error starting at line : 2 in command -
declare
type tb is table of int ;
n tb;
n1 tb;
begin
n:=tb();
n.extend;
n(1):=1;
n:=n1;
dbms_output.put_line(n(1));
execute immediate 'update tblvendor_history set vencode=:1;' ;

end;
Error report -
ORA-06531: Reference to uninitialized collection
ORA-06512: at line 10
06531. 00000 -  "Reference to uninitialized collection"
*Cause:    An element or member function of a nested table or varray
           was referenced (where an initialized collection is needed)
           without the collection having been initialized.
*Action:   Initialize the collection with an appropriate constructor
           or whole-object assignment.
Error starting at line : 2 in command -
declare
type tb is table of int ;
n tb;
n1 tb;
begin
n:=tb();
n.extend;
n(1):=1;
n:=n1;
--dbms_output.put_line(n(1));
execute immediate 'update tblvendor_history set vencode=:1;' ;

end;
Error report -
ORA-00911: invalid character
ORA-06512: at line 11
00911. 00000 -  "invalid character"
*Cause:    identifiers may not start with any ASCII character other than
           letters and numbers.  $#_ are also allowed after the first
           character.  Identifiers enclosed by doublequotes may contain
           any character other than a doublequote.  Alternative quotes
           (q'#...#') cannot use spaces, tabs, or carriage returns as
           delimiters.  For all other contexts, consult the SQL Language
           Reference Manual.
*Action:
Error starting at line : 2 in command -
declare
type tb is table of int ;
n tb;
n1 tb;
begin
n:=tb();
n.extend;
n(1):=1;
n:=n1;
--dbms_output.put_line(n(1));
execute immediate 'update tblvendor_history set vencode=:1;' using NULL ;

end;
Error report -
ORA-06550: line 11, column 68:
PLS-00457: expressions have to be of SQL types
ORA-06550: line 11, column 1:
PL/SQL: Statement ignored
06550. 00000 -  "line %s, column %s:\n%s"
*Cause:    Usually a PL/SQL compilation error.
*Action:
Error starting at line : 2 in command -
declare
type tb is table of int ;
n tb;
n1 tb;
begin
n:=tb();
n.extend;
n(1):=1;
n:=n1;
--dbms_output.put_line(n(1));
execute immediate 'update tblvendor_history set vencode=:1;' using n ;

end;
Error report -
ORA-06550: line 11, column 68:
PLS-00457: expressions have to be of SQL types
ORA-06550: line 11, column 1:
PL/SQL: Statement ignored
06550. 00000 -  "line %s, column %s:\n%s"
*Cause:    Usually a PL/SQL compilation error.
*Action:
Error starting at line : 2 in command -
declare
type tb is table of int ;
a number;
n tb;
n1 tb;
begin
n:=tb();
n.extend;
n(1):=1;
n:=n1;
--dbms_output.put_line(n(1));
execute immediate 'update tblvendor_history set vencode=:1;' using a;

end;
Error report -
ORA-00911: invalid character
ORA-06512: at line 12
00911. 00000 -  "invalid character"
*Cause:    identifiers may not start with any ASCII character other than
           letters and numbers.  $#_ are also allowed after the first
           character.  Identifiers enclosed by doublequotes may contain
           any character other than a doublequote.  Alternative quotes
           (q'#...#') cannot use spaces, tabs, or carriage returns as
           delimiters.  For all other contexts, consult the SQL Language
           Reference Manual.
*Action:
Error starting at line : 2 in command -
declare
type tb is table of int ;
a number;
n tb;
n1 tb;
begin
--n:=tb();
--n.extend;
--n(1):=1;
--n:=n1;
--dbms_output.put_line(n(1));
execute immediate 'update tblvendor_history set vencode=:1;' using a;

end;
Error report -
ORA-00911: invalid character
ORA-06512: at line 12
00911. 00000 -  "invalid character"
*Cause:    identifiers may not start with any ASCII character other than
           letters and numbers.  $#_ are also allowed after the first
           character.  Identifiers enclosed by doublequotes may contain
           any character other than a doublequote.  Alternative quotes
           (q'#...#') cannot use spaces, tabs, or carriage returns as
           delimiters.  For all other contexts, consult the SQL Language
           Reference Manual.
*Action:
Error starting at line : 2 in command -
declare
type tb is table of int ;
a number;
n tb;
n1 tb;
begin

execute immediate 'update tblvendor_history set vencode=:1;' using a;

end;
Error report -
ORA-00911: invalid character
ORA-06512: at line 8
00911. 00000 -  "invalid character"
*Cause:    identifiers may not start with any ASCII character other than
           letters and numbers.  $#_ are also allowed after the first
           character.  Identifiers enclosed by doublequotes may contain
           any character other than a doublequote.  Alternative quotes
           (q'#...#') cannot use spaces, tabs, or carriage returns as
           delimiters.  For all other contexts, consult the SQL Language
           Reference Manual.
*Action:
Error starting at line : 2 in command -
declare
type tb is table of int ;
a number;
n tb;
n1 tb;
begin

execute immediate 'update tblvendor_history set vencode=:1;' using a;

end;
Error report -
ORA-00911: invalid character
ORA-06512: at line 8
00911. 00000 -  "invalid character"
*Cause:    identifiers may not start with any ASCII character other than
           letters and numbers.  $#_ are also allowed after the first
           character.  Identifiers enclosed by doublequotes may contain
           any character other than a doublequote.  Alternative quotes
           (q'#...#') cannot use spaces, tabs, or carriage returns as
           delimiters.  For all other contexts, consult the SQL Language
           Reference Manual.
*Action:
Error starting at line : 2 in command -
declare
type tb is table of int ;
a number;
n tb;
n1 tb;
begin

execute immediate 'update tblvendor_history set vencode=:1;' using a;

end;
Error report -
ORA-00911: invalid character
ORA-06512: at line 8
00911. 00000 -  "invalid character"
*Cause:    identifiers may not start with any ASCII character other than
           letters and numbers.  $#_ are also allowed after the first
           character.  Identifiers enclosed by doublequotes may contain
           any character other than a doublequote.  Alternative quotes
           (q'#...#') cannot use spaces, tabs, or carriage returns as
           delimiters.  For all other contexts, consult the SQL Language
           Reference Manual.
*Action:
