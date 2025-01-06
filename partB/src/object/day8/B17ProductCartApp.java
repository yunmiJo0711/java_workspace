package object.day8;

import java.util.ArrayList;

// Product 클래스 정의하녀 객체 활용 연습하기
public class B17ProductCartApp {

    public static void main(String[] args) {
        ArrayList<Product> cart = new ArrayList<>();
        
        Product snack = new Product("쌀새우깡", 2300, "농심");
        Product drink = new Product("칠성사이다", 1500, "롯데");

        cart.add(snack);  // 인덱스 0번
        cart.add(drink);  // 인덱스 1번

        cart.add(new Product("청송사과", 23400, "청송농협"));  // 인덱스 2번
        cart.add(new Product("크리넥스티슈", 15000, "크리넥스"));  // 인덱스 3번

        System.out.println("cart 리스트의 요소 개수 확인 : " + cart.size());  // 배열이름.length 와 같음

        System.out.println("배열 인덱스 1번 객체의 참조값 확인하기 === ");
        System.out.println("cart.get(1) : " + cart.get(1).hashCode());
        System.out.println("drink : " + drink.hashCode());

        // cart 리스트에 담긴 Product 객체의 물품 가격 합계를 구해 보세요.

        int sum = 0;
        // 1) 인덱스 사용하는 for문 : cart.get(i)
        for(int i=0;i<cart.size();i++){
            int temp = cart.get(i).getPrice();  
            sum += temp;
            System.out.println(cart.get(i).toString());
        }
        System.out.println("cart 가격 합계 : " + sum);


        sum=0;
        System.out.println("///////// /////////");
        // 2) 향상 for문 : cart.get(i) 는 자동으로 처리(Product 타입 변수에 하나씩 참조)됩니다. 
        for(Product p : cart){
            sum += p.getPrice();
            System.out.println(p.toString());
            }
        
        System.out.println("cart 가격 합계 : " + sum);
        
    }


    }



// toString() 메소드를 테스트하는 클래스 
class Product {
    private String proName;
    private int price;
    private String company;
    
    // 커스텀 생성자 : vs code 자동완성 기능 -> 우클릭 -> 소스 작업 메뉴
    public Product(String proName, int price, String company) {
        this.proName = proName;
        this.price = price;
        this.company = company;
    }

    @Override  // 상속에서 배웁니다.  @Override 없어도 실행은 됩니다. 
    public String toString() {
        return "[상품명=" + proName + ", 가격=" + price + ", 제조사=" + company + "]";
    }

    // '문자열을 리턴'하는 toString() 메소드를 정의하면 객체 변수 출력은 참조값이 아니라
    //                     toString() 메소드 실행하여 리턴받은 문자열을 출력합니다. 

    // getter, setter 는 필요시 만들어 봅니다. 
    public int getPrice(){
        return this.price;
    }

}
