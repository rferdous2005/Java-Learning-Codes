import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpConnection {
    public void downloadFile() {
        try {
            URL url = new URL("https://www.tutorialspoint.com/javafx/images/javafx-mini-logo.jpg");

            HttpURLConnection http = (HttpURLConnection) url.openConnection();

            int code = http.getResponseCode();

            if(code == HttpURLConnection.HTTP_OK) {
                String disposition = http.getHeaderField("Content-Disposition");
                String contentType = http.getContentType();
                String fileName = "downloaded_file.jpg";
                int contentLength = http.getContentLength();


                System.out.println("File Type = " + contentType);
                System.out.println("Length = " + (contentLength/1000)+" KB");

                // opens input stream from the HTTP connection
                InputStream inputStream = http.getInputStream();
                String saveFilePath = fileName;

                // opens an output stream to save into file
                FileOutputStream outputStream = new FileOutputStream(saveFilePath);

                int bytesRead = -1;
                outputStream.write(inputStream.readAllBytes());

                outputStream.close();
                inputStream.close();

                System.out.println("File downloaded");
                http.disconnect();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
