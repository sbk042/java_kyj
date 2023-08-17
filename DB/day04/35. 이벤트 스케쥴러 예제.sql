/*
이벤트 스케줄러 : 일정주기마다 이벤트를 발생시켜서 등록된 이벤트를 실행하는 것
CREATE EVENT 이벤트명
ON SCHEDULE EVERY 숫자 단위(DAY, HOUR, MINUTE,...)
DO
	작업할코드; -- 작업할 코드는 한줄로 된 INSERT/UPDATE/DELETE나 프로시저 이용
*/
-- 이벤트 스케줄러의 ON/OFF를 조회하는 쿼리
SHOW VARIABLES LIKE 'EVENT%';
USE TEXT;
-- 등록된 이벤트 스케줄러 조회
-- SHOW EVENTS;
DROP EVENT IF EXISTS TEXT_EVENT;
CREATE EVENT TEXT_EVENT ON SCHEDULE EVERY 1 MINUTE
DO
	UPDATE DASH BOARD SET DB_MEMBER = DB_MEMBER + 1 ;
