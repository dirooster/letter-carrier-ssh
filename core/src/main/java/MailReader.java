import com.sun.deploy.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MailReader {


    public Map<String, String> readAccount() throws IOException {
        Map<String, String> accountMap = new HashMap<>();
        File file = new File("C:\\Users\\Dimasik\\IdeaProjects\\letter-carrier-ssh\\core\\src\\main\\resources\\1.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String account = null;
        while ((account = reader.readLine()) != null) {
            if (!account.isEmpty()) {
                String[] acc = account.split(":");
                String email = acc[0];
                String password = acc[1];
                accountMap.put(email, password);
            }
        }
            return accountMap;
        }
}





