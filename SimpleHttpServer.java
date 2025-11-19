// SimpleHttpServer.java
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleHttpServer {
    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
            server.createContext("/", new MyHandler());
            server.setExecutor(null); // default executor
            server.start();
            System.out.println("Server is running on port 8000");
        } catch (IOException e) {
            System.out.println("Error starting the server: " + e.getMessage());
        }
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "Hello, this is a simple HTTP server response!";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}


//Compile the Program
//javac SimpleHttpServer.java


// Run the Program
//Start the HTTP server by running:
//java SimpleHttpServer


// you will see:
//Server is running on port 8000


//Open any browser and enter:
//http://localhost:8000/


//We will see the response:
//Hello, this is a simple HTTP server response!