import static com.API.ApiUtils.splitQuery;
import static domain.user.UserService.getUserService;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;

import com.API.user.OtherHandler;
import com.API.user.handler.HolidayHandler;
import com.API.user.handler.MinimumSlotHandler;
import com.API.user.handler.OpenCloseHandler;
import com.API.user.handler.RegistrationHandler;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import javax.swing.text.html.MinimalHTMLWriter;

public class Application{
    public static void main(String[] args) throws IOException {

        int serverPort = 8001;

        HttpServer server =	HttpServer.create(new InetSocketAddress(serverPort), 0);
        RegistrationHandler registrationHandler = new RegistrationHandler(getUserService(), Configuration.getObjectMapper(),
                Configuration.getErrorHandler());
        OtherHandler otherHandler = new OtherHandler(getUserService(), Configuration.getObjectMapper()
        , Configuration.getErrorHandler());
        HolidayHandler holidayHandler = new HolidayHandler(getUserService(), Configuration.getObjectMapper()
                , Configuration.getErrorHandler());
        OpenCloseHandler openCloseHandler = new OpenCloseHandler(getUserService(), Configuration.getObjectMapper()
                , Configuration.getErrorHandler());
        MinimumSlotHandler minimumSlotHandler = new MinimumSlotHandler(getUserService(), Configuration.getObjectMapper()
                , Configuration.getErrorHandler());

        server.createContext("/api/users/cityholiday", holidayHandler::handle);
        server.createContext("/api/users/register", registrationHandler::handle);
        server.createContext("/api/users/listbooking", otherHandler::handle);
        server.createContext("/api/users/openclose_hours", openCloseHandler::handle);
        server.createContext("/api/users/minimumslot", minimumSlotHandler::handle);


        HttpContext context =server.createContext("/api/hello", (exchange -> {
            if ("GET".equals(exchange.getRequestMethod())) {
                Map<String, List<String>> params = splitQuery(exchange.getRequestURI().getRawQuery());
                String noNameText = "Anonymous";
                String name = params.getOrDefault("name", List.of(noNameText)).stream().findFirst().orElse(noNameText);
                String respText = String.format("Hello %s!", name);
                exchange.sendResponseHeaders(200, respText.getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(respText.getBytes());
                output.flush();
            } else {
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed
            }
            exchange.close();
        }));

        server.setExecutor(null); // creates a default executor - use only 1 thread
        server.start();
    }

}

