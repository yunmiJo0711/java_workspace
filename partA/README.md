
#### 자바 프로그래밍 키워드

- public
- class
- static : 나중에 설명
- void : 메소드의 리턴값이 없음.
- throws : 나중에 설명

### 자바의 특징

- 패키지 : 클래스들을 모아 놓은 그룹. 그래서, 클래스를 만들 때 패키지를
정하고 해당 패키지 안에서 클래스 생성합니다. 
+ 패키지 이름의 예시 : 우리 회사 도메인명이 himedia.com 라고 하면
+           ㄴ com.himedia.xxx.xxx
+ 수업 중에는 basic.day01 

### 자바 연산의 특징

- 2개의 데이터가 형식이 같습니다. 이 2개의 데이터로 연산을 하면 
  결과도 같은 데이터 타입입니다.
    + int 와 int 를 더하기, 빼기, 곱하기, 나누기 하면 결과 int
    + long 와 long 를 더하기, 빼기, 곱하기, 나누기 하면 결과 long
    + double 와 double 를 더하기, 빼기, 곱하기, 나누기 하면 결과 double

- 2개의 데이터가 형식이 다릅니다. 이 2개의 데이터로 연산을 하면 
  결과는 데이터의 범위가 큰 쪽으로 데이터 형식이 결정됩니다. 
    + long 와 int 를 더하기, 빼기, 곱하기, 나누기 하면 결과 long
    + double 와 int 를 더하기, 빼기, 곱하기, 나누기 하면 결과 double
    + double 와 long 를 더하기, 빼기, 곱하기, 나누기 하면 결과 double

- 결론 : 데이터 형식이 같은 2개를 연산하고 결과를 다른 데이터 형식으로 원한다면 
  2개 중 하나는 형변환을 합니다. 

  ### 메소드의 유형

  - 1. 클래스 이름으로 클래스에 포함된 'static 메소드 또는 속성' 호출 
    - System.out   : System 클래스의 static 속성
    - A04Quiz.dollarToWon()

  - 2. message 또는 sc 는 변수. String message 또는 Scanner sc 로 선언된 변수
      : message 와 sc 는 메모리 주소 참조형 변수. '인스턴스 메소드'.
    - message.length()
    - sc.nextLine()

  - 3.  println 은 out 의 메소드. => 인스턴스 메소드

  ### Escape 문자 : \ 기호로 시작하는 문자.

  : 출력문에서 특정 기능을 갖는 문자. 

  - \"
  - \n : 줄바꿈
  - \t : 탭(tab). 일정 간격을 두고 커서 이동
  