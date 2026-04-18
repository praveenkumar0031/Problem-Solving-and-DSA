# Write your MySQL query statement below
select Department,Employee,Salary from(
select d.name as Department,e.name Employee,e.salary Salary,
Dense_Rank() Over(Partition by e.departmentId order by e.salary desc) as rk
 from Employee e left join Department d on e.departmentId=d.id
) as temp where rk<=3;