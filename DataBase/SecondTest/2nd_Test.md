1. hr계정 비밀번호를 hr로 수정하고 락 푸는 명령
-- cmd에서 아래와 같이 입력 한후 오라클에 접속되면 alter 명령을 내린다.

sqlplus / as sysdba    -- cmd에서

alter user hr identified by hr account unlock;  -- 오라클에 접속한 후


2. java document 보는 방법
- jdk-8u202-docs-all.zip 파일의 압축을 푼다
- 폴더 안으로 접근해서 docs\api\index.html을 실행시킨다.
