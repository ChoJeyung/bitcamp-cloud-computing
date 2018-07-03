# 프로그래밍 준비
## 개발도구 설치
- openjdk 10.0.1
- eclipse photon
- visual studio code
- git client
- scoop (package manager)
- scoop install gradle
- scoop install mariadb

## mysql 설정
...
서버에 접속
> mysql -uroot -p
Enter password: (암호 없기 때문에 그냥 엔터친다.)

root 사용자의 암호설정

암호 변경 후 권한 갱신
mysql> flush privilieges;

애플리케이션에서 DB에 접속할 때 사용할 사용자를 추가한다.
mysql> create user 'study'@'localhost' identified by '1111';

 study 사용자가 사용할 데이터베이스 생성한다
 mysql> create database studydb character set utf8 COLLATE utf8_general_ci;

 studydb 데이터베이스의 사용권한을 study 사용자에게 부여한다
 mysql> grant all privileges on studydb.* to 'study'@'loalhost';

 study 사용자로 접속한다.
 mysql> quit 또는 exit
 > mysql -u study -p

 studydb에 테이블 생성
 =?> bitcamp-sql/pms-ddl.sql 실행
 mysql> SQL을 복사하여 붙여 넣는다.

 ## 웹 프로젝트 폴더 준비

