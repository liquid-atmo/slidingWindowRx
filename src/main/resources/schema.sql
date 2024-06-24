-- Create a schema if not exists
CREATE SCHEMA IF NOT EXISTS users_schema;

-- Switch to the created schema
USE users_schema;

-- Create a table named 'users'
CREATE TABLE IF NOT EXISTS users (
                                     id BIGINT PRIMARY KEY,
                                     name TEXT NOT NULL,
                                     email TEXT
);

-- Insert 5 users into the 'users' table
INSERT INTO users (id, name, email) VALUES
                                        (1, 'John Doe', 'john@example.com'),
                                        (2, 'Jane Smith', 'jane@example.com'),
                                        (3, 'Michael Brown', 'michael@example.com'),
                                        (4, 'Emily Davis', 'emily@example.com'),
                                        (5, 'William Johnson', 'william@example.com');