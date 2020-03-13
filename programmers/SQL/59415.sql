#최댓값 구하기

SELECT DATETIME
from ANIMAL_INS
WHERE datetime >= all (select datetime from ANIMAL_INS )