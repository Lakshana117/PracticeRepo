ALTER TABLE customers ADD isvip CHAR(10) CONSTRAINT chk1 CHECK (isvip IN ('TRUE', 'FALSE'));

SET SERVEROUTPUT ON;
DECLARE
    CURSOR c2 IS
        SELECT customerid, balance FROM customers;
    cid CUSTOMERS.customerid%TYPE;
    bal CUSTOMERS.balance%TYPE;
BEGIN
    FOR rec IN c2 LOOP
        cid := rec.customerid;
        bal := rec.balance;

        IF bal > 10000 THEN
            DBMS_OUTPUT.PUT_LINE('Customer ID ' || cid || ': VIP');
            UPDATE customers SET isvip = 'TRUE' WHERE customerid = cid;
        ELSE
            DBMS_OUTPUT.PUT_LINE('Customer ID ' || cid || ': Not VIP');
            UPDATE customers SET isvip = 'FALSE' WHERE customerid = cid;
        END IF;
    END LOOP;
    COMMIT;
END;
/