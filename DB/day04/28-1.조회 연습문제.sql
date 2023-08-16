-- <복습 연습문제>

-- 1.) 등록된 영화를 조회하는 쿼리
SELECT * FROM MOVIE;

-- 2.) 장르가 드라마인 영화를 조회하는 쿼리
SELECT 
    MG_GE_NAME AS 장르,
    MO_TITLE AS 영화
FROM -- 장르 정보를 가지고 있는 MOVIE GENRE 출력
    MOVIE_GENRE
    JOIN -- 영화 이름을 알기 위해 MOVIE와 JOIN
		MOVIE ON MG_MO_NUM = MO_NUM
    WHERE 
		MG_GE_NAME = '드라마';
        
-- 2-2.) 강사님 버전
SELECT 
    *
FROM
    MOVIE
		JOIN
    MOVIE_GENRE ON MG_MO_NUM = MO_NUM
WHERE
	MG_GE_NAME = '드라마';

-- 3.) 개봉전인 영화를 조회하는 쿼리
SELECT 
    *
FROM
    MOVIE
WHERE 
	MO_OPENING_DATE > NOW();

-- 4.) 상영 종료된 영화를 조회하는 쿼리(현재 개봉중인 영화는 오늘을 기준으로 2주까지 스케줄이 반드시 등록이 되어 있다는 가정하에)
SELECT 
    MO_TITLE AS 상영종료영화
FROM
    MOVIE
		LEFT JOIN -- 상영 종료된 영화는 상영 정보가 없기 때문에 INNER JOIN을 하면 상영 종료된 영화가 조회되지 않음.
	MOVIE_SCHEDULE ON MS_MO_NUM = MO_NUM
WHERE 
	MO_OPENING_DATE <= NOW()
HAVING  -- 직계함수에 조건을 걸고 싶을 때는 HAVING을 이용한다.
	COUNT(MS_NUM) = 0;
	
-- 5.) 



