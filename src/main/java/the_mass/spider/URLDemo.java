package the_mass.spider;

import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class URLDemo {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.xxx.com");
        URLConnection connection = url.openConnection();
        connection.setConnectTimeout(323);
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.10 Safari/537.36");

        connection.connect();
        Map<String, List<String>> headerFields = connection.getHeaderFields();
        OutputStream stream = connection.getOutputStream();

    }
}
