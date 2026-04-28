use BAMS;
-- =========================
-- PART 1: SQL SECTION
-- Bank Account Management System
-- =========================

-- Task 1: Create Tables

CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    city VARCHAR(50)
);

CREATE TABLE accounts (
    account_id INT PRIMARY KEY,
    customer_id INT UNIQUE,
    balance DECIMAL(10,2) CHECK (balance >= 0),
    account_type VARCHAR(30),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

-- =========================
-- Task 2: Insert Data
-- =========================

INSERT INTO customers (customer_id, name, city)
VALUES
(1, 'John', 'Hyderabad'),
(2, 'Alice', 'Chennai'),
(3, 'Bob', 'Hyderabad');

INSERT INTO accounts (account_id, customer_id, balance, account_type)
VALUES
(101, 1, 5000, 'Savings'),
(102, 2, 10000, 'Current'),
(103, 3, 3000, 'Savings');

-- =========================
-- Task 3: DML Operations
-- =========================

-- Deposit ₹2000 into account 101
UPDATE accounts
SET balance = balance + 2000
WHERE account_id = 101;

-- Withdraw ₹1000 from account 102 only if sufficient balance exists
UPDATE accounts
SET balance = balance - 1000
WHERE account_id = 102
AND balance >= 1000;

-- Delete accounts where balance < 2000
DELETE FROM accounts
WHERE balance < 2000;

-- =========================
-- Task 4: SELECT Queries
-- =========================

-- Customers from Hyderabad
SELECT * 
FROM customers
WHERE city = 'Hyderabad';

-- Accounts with balance greater than ₹5000
SELECT * 
FROM accounts
WHERE balance > 5000;

-- Accounts sorted by balance descending
SELECT * 
FROM accounts
ORDER BY balance DESC;