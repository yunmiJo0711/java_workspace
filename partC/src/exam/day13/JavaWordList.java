package exam.day13;

import java.util.ArrayList;
import java.util.List;



public class JavaWordList implements WordList{
    //private : 현재 클래스에서만 사용할 목적으로 접근 제한합니다.
    //필드
    private List<JavaWord> words;
    private String filePath;
    
    public JavaWordList(String filePath) {
        System.out.println("최대 단어 저장 개수 : " + WordList.MAX_LENGTH);
        words = new ArrayList<>();
        this.filePath = filePath;
    }
    
    //새로운 단어등록, 기존단어 삭제 등의 변경사항을 파일에 저장하기
    public void fileSave(){
           
    }


    //단어장.txt 에서 데이터를 읽어와서 `words 리스트에 담기`
    public void fileLoad() {    //이 메소드에서 모든 동작을 실행하도록 작성하세요.
        
        
    }


    // 지정된 인덱스 i 의 JavaWord 객체 리턴
    @Override
    public JavaWord getWord(int i) {
       return words.get(i);
    }

    //단어장 전체 리스트 리턴
    @Override
    public List<JavaWord> list() {     //getWords 에서 이름 변경
        return words;
    }

    //단어 추가
    @Override
    public void add(JavaWord word) {
       
        words.add(word);
    }

  
    @Override
    public int indexOfWord(String english,int position){
        
        
        return -1;
    }

    //단어를 인덱스로 삭제
    @Override
    public JavaWord remove(int index) {
       
        return null;            
    }
    
    //단어 목록 조회
    @Override
    public List<JavaWord> searchAllByEnglish(String english){
        List<JavaWord> list = new ArrayList<>();    //검색 결과 저장할 리스트
        for(JavaWord word : words) {
            if(word.getEnglish().equals(english)) {
               list.add(word);          //일치하는 하는 단어를 만날 때마다 저장
            }
        }
        return list;
    }

    public List<JavaWord> searchAllByLevel(int level){
        List<JavaWord> list = new ArrayList<>();    //검색 결과 저장할 리스트
        for(JavaWord word : words) {
            if(word.getLevel()==level ) {
               list.add(word);          //일치하는 하는 단어를 만날 때마다 저장
            }
        }
        return list;
    }
    // 인스턴스 메소드 : 인스턴스 필드 words 를 사용하여 동작.
    @Override
    public void print(){
        for(JavaWord word : words) {
            System.out.println(String.format("%-20s %-30s %-20s",
                                    word.getEnglish(),word.getKorean(),word.getLevel()));
        }
    }
   
    // 출력 메소드 
    // static 메소드 : 인스턴스 필드를 사용하지 않고 메소드 인자를 받아 동작.
    public static void print(List<JavaWord> list){
        for(JavaWord word : list) {
            System.out.println(String.format("%-20s %-30s %-20s",
                                    word.getEnglish(),word.getKorean(),word.getLevel()));
        }
    }
}