진수 변환
=================


10진수 -> 2진수
-----------------
+ 10진수를 2로 나누어 0과 1을 조합

+ 2진수 -> 10진수 각 자릿수마다 2의 제곱

> ex) 1010(2) > 2\3, 2\2, 2\1, 2\0


10진수 -> 8진수
-----------------
+ 8진수는 0~7까지 표현

+ 10진수를 2로 나눠서 2진수를 만든다.

+ 이후에 2진수를 8진수로 변환


2진수 -> 8진수
---------------
+ 3자리씩 끊어서 ex) 1010101(2) -> 001011101(8)
> 끝어낸 각 자리는 2의0승 1승 2승으로 계산하여풀어낸다.

+ 소수도 3자리씩 끊어서 계산한다 ex)1101.1101 -> (001)(101).(110)(100) -> 15.64(8)

+ 8진수 -> 2진수 변환은 역으로 한다. ex) 15.15(8) -> (001)(101).(001)(101) -> 1101.001101(2)
> 한자리를 세자리로 바꿔서 계산해준다.


2진수 -> 16진수
-----------------
+ 16진수는0~F까지 9이후는 A,B,C,D,E,F로 표현한다.

+ 4자리씩 끊어서 변환하면 된다. ex) 11011(2) -> (0001)(1011) -> (1)(11) -> 1B(16)
> 각 자리는 2의 0승 1승 2승 3승 까지 표현한다.

+ 소수도 4자리씩 끊어서 계산한다. ex) 110110100.1101111(2) -> (0001)(1011)(0100).(1101)(1110) -> 1B4.DE(16)

+ 16진수 -> 2진수 변환 ex) 2B4(16) -> (0010)(1011)(0100) - > 1010110100(2)
> 소수의 변환 ex) 1BA.2F(16) -> (0001)(1011)(1010).(0010)(1111) -> 110111010.00101111(2)

소수를 포함한 10진수
-------------------
+ 1010.1(2) -> .1은 2의-1승 1/2 -? 1*(1/2) = 0.5

+ 100.25(10) -> 0.25에 2를 계속 곱함 0.25*2=0.5 -> 0.5*2=1 결과값인 0과1을 순서대로 써준다.
> 1100000.01(2)


음수의 표현
------------------
+ 음의 정수 72를 2의 보수 8bit로 표현
> ex) 01001000(2) 72를 표현-> 10110111을 더해준다. -> 10110000(2) -72를 표현

> 8, 16 진수 변환은 2진수로 변환 후에 하는것이 편하다.
