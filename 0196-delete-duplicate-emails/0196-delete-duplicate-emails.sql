# Write your MySQL query statement below
delete from Person where id Not in
 (select id from (
    select MIN(id) as id from Person group by email
 ) temp
 );