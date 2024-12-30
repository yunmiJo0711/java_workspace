package basic.day04;

// 배열 활용 예시
public class A25ArrayExample {

    public static void main(String[] args) {

        int[] scores = {87,67,99,56,72};

        int sum = 0;  // 누적 합계. 초기값 꼭 정의하기.
        int avg;    // 평균
        // 1) 배열 요소의 모든 겂 합계와 평균 구하기
        for(int i=0;i<scores.length;i++){
            sum += scores[i];
        }
        System.out.println("합계 : " + sum);  //381
        System.out.println("평균 : " + (double)sum/scores.length);  //76.2


        // 2) 배열 요소에서 가장 큰값 (또는 작은 값) 구하기
        int max = scores[0];  // max 는 배열의 첫번째 값으로 초기화
        int min = scores[0]; 
        for(int i=1;i<scores.length;i++){
            if(max < scores[i]){
                max = scores[i];  // 99
            }
            if(min > scores[i])
               min = scores[i];  // 56
        }
        System.out.println("max : " + max);
        System.out.println("min : " + min);

        // 3) 배열을 메소드의 인자로 전달할 수 있습니다.
        // 메소드로 전달된 값은 배열의 요소 전체가 아니라 배열이 저장된 시작주소
        long result = arraysMul(scores);
        System.out.println("배열 요소의 곱 : " + result);  // 2326750272

        // 4) 전달된 배열의 값을 변경하는 메소드
        arraysChg(scores);
        for(int i=0;i<scores.length;i++)
            System.out.println(scores[i] + "\t");  //{97,77,109,66,82}

        System.out.println("scores 배열의 참조값 : " + scores);   // [I@3e3abc88
           


    }

    // 배열을 전달받아서 배열 요소를 모두 곱합니다. 
    // 인자 선언은 지역변수 선언. 
    // array 배열은 초기값 x, 크기x 아직 모름 => 배열할당은 호출할 때 전달.
    public static long arraysMul(int[] array){
        long result = 1;
        for(int i=0;i<array.length;i++)
            result*=array[i];  // 반복명령어 1개일 때 { } 생략.
        return result;
    }

    // 호출할 때 전달한 scores 배열의 시작 주소를 array 변수가 저장합니다. 
    public static void arraysChg(int[] array){   //{87,67,99,56,72}
        for(int i=0;i<array.length;i++){
            array[i] += 10;   //{97,77,109,66,82}
        }
        System.out.println("array 배열의 참조값 : " + array);  // [I@3e3abc88
    }


}
