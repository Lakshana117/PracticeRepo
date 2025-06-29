SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE update_bonus(
    dept IN employees.department%TYPE,
    bonus_pct IN NUMBER
) IS
BEGIN
    UPDATE employees
    SET salary = salary + (salary * bonus_pct / 100),
        hiredate = SYSDATE
    WHERE department = dept;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Bonus updated for department: ' || dept);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/


EXEC update_bonus('IT', 5);
EXEC update_bonus('HR', 3);