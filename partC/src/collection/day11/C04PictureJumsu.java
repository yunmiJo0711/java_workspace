package collection.day11;

import java.util.Arrays;

// 프로그래머스 문제 이름 : 추억 점수
public class C04PictureJumsu {

    public static void main(String[] args) {
        // 문자열 2차원 배열 : 배열의 배열. 2차원 배열은 인덱스가 2개
        String[][] photo = {
            {"may","kein","kain","radi"},  // photo[0]
            {"may","kein","brin","deny"},  // photo[1]
            {"kon","kain","may","coni"}    // photo[2]
        };

        // 2차원 배열 요소들을 모두 가져와 반복하기
        for(int i=0;i<photo.length;i++){
            System.out.println(Arrays.toString(photo[i])); // 큰 배열 출력

            for(int j=0;j<photo[i].length;j++){  // 작은 배열 값 하나씩 출력
            System.out.println(photo[i][j]);

            }

        } // for문 end

        System.out.println("// 문제 풀이 //");
        String[] name = {"may","kein","kain","radi"};
        int[] yearning = {5,10,1,3};

    } // main end

} // class end

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = {};
        return answer;
    }
}

class Test {
    void test(String[][] photo){
        System.out.println("// 배열의 길이 확인 //");
        System.out.println("photo.length : " + photo.length);  // 3
        System.out.println("photo[0].length : " + photo[0].length);  // 4
        System.out.println("photo[1].length : " + photo[1].length);  // 4
        System.out.println("photo[2].length : " + photo[2].length);  // 4

        System.out.println("// 배열의 값 확인 //");
        System.out.println("photo[0] : " + Arrays.toString(photo[0]));
        System.out.println(photo[0][0]);
        System.out.println(photo[0][1]);
        System.out.println(photo[0][2]);
        System.out.println(photo[0][3]);
        System.out.println("photo[1] : " + Arrays.toString(photo[1]));
        // 24~27 라인 출력을 인덱스 사용 for문으로 도전~
        for(int i=0;i<photo[1].length;i++){
            System.out.println(photo[1][i]);
            }
        System.out.println("photo[2] : " + Arrays.toString(photo[2]));
        // 24~27 라인 출력을 향상 for문으로 도전~
        for(String t : photo[2]){
            System.out.println(t);
        }
    }
}
