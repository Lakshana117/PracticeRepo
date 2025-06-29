SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE process_interest IS
BEGIN
    UPDATE accounts
    SET balance = balance * 1.01,
        lastmodified = SYSDATE
    WHERE accounttype = 'Savings';

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Interest updated for savings accounts.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/


EXEC process_interest;