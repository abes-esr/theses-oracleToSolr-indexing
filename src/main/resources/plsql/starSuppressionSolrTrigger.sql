create or replace TRIGGER "STAR"."SUPPRESSION_SOLR_TRIGGER" after DELETE
on Document
FOR EACH ROW

DECLARE

iddocparam number;

BEGIN

if not globals_pkg.gv_run_my_trigger
    then return;
end if;
iddocparam := :old.iddoc;
DBMS_OUTPUT.PUT_LINE ( 'iddocparam : '|| iddocparam);
suppressionsolr(iddocparam);

END;