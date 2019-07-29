1. 본인이 원하는 API가 있는 곳에서 API 활용신청 
  ex)NAVER, 서울시 등..
  
2. 키값을 받아서 원하는 API에 접근

3. API의 사용법을 숙지해 둘것

4. API 사용 예

<pre>import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
 
public class OpenApi {
    public static void main(String[] args) {
        BufferedReader br = null;
        try{            
            String urlstr = "http://openapi.airkorea.or.kr/"
                    + "openapi/services/rest/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty"
                    + "?stationName=수내동&dataTerm=month&pageNo=1&numOfRows=10&ServiceKey=서비스키&ver=1.3";
            URL url = new URL(urlstr);
            HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
            urlconnection.setRequestMethod("GET");
            br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
            String result = "";
            String line;
            while((line = br.readLine()) != null) {
                result = result + line + "\n";
            }
            System.out.println(result);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}</pre>

