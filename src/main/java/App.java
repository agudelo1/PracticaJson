import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class App {

    static Gson gson =new Gson();
    private File fileJson;
    private static final String JsonFilePath = "src/main/resources/User.json";
    public static void main(String[] args) {
      //  gson = new Gson();
        User userTransformation = new App()
                .JsonToUserT();

        System.out.println(String.format("Desde el objeto >> \n%s",userTransformation));
        String newJsonT = gson.toJson(userTransformation);
        System.out.println(String.format("transformacion hacia json\n%s\n",newJsonT));
    }
    public User JsonToUserT(){
        try{
            fileJson= new File(JsonFilePath);
            BufferedReader buffer = new BufferedReader(new FileReader(fileJson));
            String json= "";
            String Line="";
            while((Line=buffer.readLine())!= null){
                json= json + Line;

            }
            buffer.close();
            User user= gson.fromJson(json,User.class);

            return user;




        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
