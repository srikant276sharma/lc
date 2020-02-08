182. Duplicate Emails
https://leetcode.com/problems/duplicate-emails/

--Solution 1: MS SQL Server.
/* Write your T-SQL query statement below */
SELECT Email
FROM Person
GROUP BY Email
HAVING count(Email) > 1
/*
Runtime: 641 ms, faster than 97.39% of MS SQL Server online submissions for Duplicate Emails.
Memory Usage: 0B, less than 100.00% of MS SQL Server online submissions for Duplicate Emails.
*/
