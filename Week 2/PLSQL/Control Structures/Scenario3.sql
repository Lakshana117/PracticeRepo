DECLARE
    CURSOR c3 IS
        SELECT l.loanid, l.customerid, c.name, l.enddate
        FROM loans l
        JOIN customers c ON l.customerid = c.customerid
        WHERE l.enddate BETWEEN SYSDATE AND SYSDATE + 30;

    lid LOANS.loanid%TYPE;
    cid LOANS.customerid%TYPE;
    cname CUSTOMERS.name%TYPE;
    due LOANS.enddate%TYPE;
    found BOOLEAN := FALSE;
BEGIN
    OPEN c3;
    LOOP
        FETCH c3 INTO lid, cid, cname, due;
        EXIT WHEN c3%NOTFOUND;

        found := TRUE;
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || lid || ' for ' || cname || ' (ID: ' || cid || ') is due on ' || TO_CHAR(due, 'YYYY-MM-DD'));
    END LOOP;
    CLOSE c3;

    IF NOT found THEN
        DBMS_OUTPUT.PUT_LINE('No loans due in next 30 days.');
    END IF;
END;
/