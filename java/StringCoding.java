import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

class StringCoding {
  public static void main(String[] args) {
    
    System.out.println("J&K encoded: "+ getEncodedString("J&K"));
    System.out.println("J&K decoded: "+ getDecodedString(getEncodedString("J&K")));
  }


  public static String getEncodedString(String simple) {
      try {
          return URLEncoder.encode(simple, "utf-8");
      } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
      }
      return simple;
  }

  public static String getDecodedString(String simple) {
      try {
          return URLDecoder.decode(simple, "utf-8");
      } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
      }
      return simple;
  }
}