CREATE OR REPLACE PROCEDURE transfer_funds(
    from_acc IN accounts.accountid%TYPE,
    to_acc IN accounts.accountid%TYPE,
    amount IN NUMBER
) IS
    from_balance accounts.balance%TYPE;
BEGIN
    SELECT balance INTO from_balance
    FROM accounts
    WHERE accountid = from_acc
    FOR UPDATE;

    IF from_balance < amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance.');
    END IF;

    UPDATE accounts
    SET balance = balance - amount,
        lastmodified = SYSDATE
    WHERE accountid = from_acc;

    UPDATE accounts
    SET balance = balance + amount,
        lastmodified = SYSDATE
    WHERE accountid = to_acc;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transfer completed.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/


EXEC transfer_funds(1, 2, 100);