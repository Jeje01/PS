#상위 n개 레코드

SELECT name
from animal_ins
where datetime <= all (select datetime from animal_ins)