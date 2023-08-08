/*
정규화 : 테이블을 쪼개는 과정을 정규화라고 한다.
 왜 쪼개느냐? => 데이터의 중복을 최소화하고,
			  데이터의 일관성과 무결성(개채 무결성, 참조 무결성)을 유지하기 위해서
제 1정규화
- 각 열은 원자값만 포함해야 한다.
- 각 행은 기본키를 가져야 한다.
- 중복된 데이터를 제거해서 복수개의 행으로 구성한다.

제 2 정규화
- 제 1정규화를 만족해야한다.
- 주요 속성에 완전 종속되어야 한다.

제 3 정규화
- 제 2정규화를 만족한다.
- 이행적 종속성을 제거해야한다.
- A->C : A를 통해 C를 알 수 있는 테이블을 A->B, B->C를 통해 알 수 있도록 테이블을 추가해서 구성

역정규화(반정규화) : 테이블을 합치는 과정
 - 성능향상을 목적으로 데이터 중복을 허용하는 것
*/