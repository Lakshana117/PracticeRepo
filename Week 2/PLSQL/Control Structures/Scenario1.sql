DECLARE
    CURSOR c1 IS
        SELECT customerid, EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM dob) age
        FROM customers;
    cid CUSTOMERS.customerid%TYPE;
    age NUMBER;
BEGIN
    FOR rec IN c1 LOOP
        cid := rec.customerid;
        age := rec.age;
        IF age > 60 THEN
            UPDATE loans
            SET interestrate = interestrate - 1
            WHERE customerid = cid;
        ELSE
            DBMS_OUTPUT.PUT_LINE('Customer ID: ' || cid || ' Age: ' || age || ' - No change in loan');
        END IF;
    END LOOP;
    COMMIT;
END;
/