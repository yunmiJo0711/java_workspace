package thread.day14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List; 

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class C19OpenAPITest {

    public static void main(String[] args) {
        // 요청시 필요한 값 저장
        String authkey="AluENEwBXPhUPGfCO8dy3cfaqFJD8yb9";
        String serchdate="20250113";
        HttpURLConnection connection=null;
        // 가변객체 문자열을 저장하기
        StringBuilder url = 
        new StringBuilder("https://www.koreaexim.go.kr/site/program/financial/exchangeJSON");

        try {
            // 요청 URL 문자열
            url.append("?authkey=").append(authkey)
               .append("&searchdate=").append(serchdate)
               .append("&data=AP01");
            URL fullUrl = new URL(url.toString());  // 요청 URL 객체
            connection = (HttpURLConnection) fullUrl.openConnection();
            // http 요청 객체 생성하여 연결



        } catch (Exception e) {
            System.out.println("API 요청 예외 : " + e.getMessage());
        }

        String line=null;
        String jsonStr="";
        String filename="환율20250113.txt";

        // try with resources 구문 : close 해야할 자원들을 자동 처리 
        // close 해야할 입출력 스트림 선언을 try 뒤에 () 안에 합니다.
        try( 
            // HttpURLConnection 객체를 통해 문자기반 입력 스트림 생성하기
            // Open API 제공 응답이 UTF-8 인코딩된 문자열
            InputStreamReader ir=new InputStreamReader(connection.getInputStream(),StandardCharsets.UTF_8);         
            //문자기반 파일 출력스트림
            PrintWriter pw =new PrintWriter(new File(filename),StandardCharsets.UTF_8);   //자동 flush 기능이 있는 메소드 사용.
              
            // 문자기반 입출력 보조 스트림
            BufferedWriter   bw = new BufferedWriter(pw);
            BufferedReader br=new BufferedReader(ir);
           )
        {
            while((line=br.readLine())!=null){      // 문자 기반 스트림에는 line 단위로 읽는 메소드가 있습니다.
            // 줄 단위로 읽기. 여기서는 데이터가 1개 라인에 모두 저장하여 사실은 반복문 필요없음.
                jsonStr+=line;            
            }
            System.out.println("----------- HttpsURLConnection 으로 읽어온 응답 문자열  -------------");
            //System.out.println(jsonStr);   // 콘솔 출력
            bw.write(jsonStr);      // 파일 출력
            //bw.flush();     // 버퍼를 사용하는 출력일 때는 필요함.pw가 flush 기능이 있으므로 여기서는 생략가능.
        }catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println(jsonToList(jsonStr).size());
        // 문자열을 자바 리스트로 변환하는 메소드-개발자 정의

        List<CurrencyRate> list = jsonToList(jsonStr);
        // 예시 : 유로 화폐 환전을 위해서 살 때 환율 금액을 알아내보세요.
        // 답 : 1480.87 원
        double won=0;
        for(CurrencyRate cur : list){
            if(cur.getCur_unit().equals("USD")){
                String temp = cur.getTtb();  // ttb 가져오기
                won = Double.parseDouble(temp.replace(",", ""));
                break;
            }
        }
        System.out.println("살 때 환율 금액 : " + won + " 원");
        
    }  // main end

    public static List<CurrencyRate> jsonToList(String json){
        // json 문자열을 객체로 변환 -> gson(구글) 라이브러리 사용.
        // https://mvnrepository.com/artifact/com.google.code.gson/gson/2.10.1 에서 
        // gson-2.10.1.jar 파일 다운로드 -> Referenced Libraries 항목에 + 버튼 클릭으로 추가

        // {"result":1,"cur_unit":"AED","ttb":"393.71","tts":"401.66","deal_bas_r":"397.69","bkpr":"397","yy_efee_r":"0","ten_dd_efee_r":"0","kftc_bkpr":"397","kftc_deal_bas_r":"397.69","cur_nm":"아랍에미리트 디르함"},
        //    ㄴ 하나의 객체 : cur_unit, ttb, tts, cur_nm 4개 필드값만 자바 CurrencyRate 객체로 만들기 
        Gson gson = new Gson();
        // 문자열 json 을 List<CurrencyRate> 로 변환
        List<CurrencyRate> list =
            gson.fromJson(json, new TypeToken<List<CurrencyRate>>(){}.getType());
        System.out.println(list);

        return list;
    }

}
