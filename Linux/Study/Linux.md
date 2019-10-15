Linux
=====
+ 리누스 토르발스가 커뮤니티 주체로 개발한 컴퓨터 운영 체제
+ UNIX운영체제를 기반으로 만들어진 운영
+ UNIX와 마찬가지로 다중 사용자, 다중 작업(멀티태스킹), 다중 스레드를 지원하는 네트워크 운영 체제(NOS)
+ UNIX가 애초부터 통신 네트워크를 지향하여 설계된것처럼 리눅스 역시 서버로 작동하는데 최적화    
  -> 서버에서 사용되는 운영체제로 많이 사용 
  
  
Linux의 특징
-----
+ UNIX와 완벽하게 호환가능합니다.
+ 공개 운영체제 -> 오픈소스이므로 누구든지 자유롭게 수정 가능
+ PC용 OS보다 안정적, 보안쪽면에서도 PC용 OS보다 비교적 우수한 성능
+ 다양한 네트워킹 기술을 제공하고 있으며 서버용 OS로 적합
+ 배포판이 아닌 리눅스는 그 자체는 무료


CentOS & Ubuntu
------
+ CentOS
  + Community Enterprise Operating System
  + Red Hat이 공개한 RHEL을 그대로 가져와서 Red Hat의 브랜드와 로고만 제거하고 배포한 배포본
  + RHEL 과 OS 버전, Kernel 버전, 패키지 구성이 똑같고 바이너리가 100%로 호환
  + 서버용 운영체제로 인기가 매우 높으며 서버용으로 리눅스를 운영할 목적이라면 아마 대부분 이 센토스OS를 사용하는것이 대부분

+ Ubuntu
  + 영국의 캐노니컬이라는 회사에서 만든 배포판
  + 쉽고 편한 설치와 이용법 덕분에 진입장벽이 낮아 초보자들이 쉽게 접근
  + 데스크탑용 리눅스 배포판 가운데서 가장 많이 사용
  + 개인용 데스크톱 운영체제로 많이 사용


Linux의 구조
-----
+ Linux는 Linux kernel + shell + compiler + 다양한 소프트웨어를 포함한 하나의 패키지를 지칭

![LinuxStructure](/Image/LinuxStructure.png "LinuxStructure")

+ 다양한 소프트웨어가 Linux kernel이 관리하고 있는 시스템 자원을 마구 사용할 경우, 시스템 안정성에 심각한 문제가 초래됨
+ 운영체제가 시스템 자원을 관리하고, 다양한 소프트웨어는 Linux kernel이 제공하는 시스템 콜을 통해 시스템 자원 사용을 요청
+ 시스템 콜은 shell, 다양한 언어별 compiler, library를 통해 호출되게 됨
+ Linux kernel은 시스템 자원을 관리
  + 프로세스 관리(Process Management)
  + 메모리 관리(Memory Management)
  + 파일 시스템 관리(File System Management)
  + 디바이스 관리(Device Management)
  + 네트워크 관리(Network Management)
  
![LinuxStructure2](/Image/os_arch.png "LinuxStructure2")
