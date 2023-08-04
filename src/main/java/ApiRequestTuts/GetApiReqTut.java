/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApiRequestTuts;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson; 
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
 

/**
 *
 * @author DELL
 */
class NewsObjList{
    List<NewsObj> newsObjList;

    @Override
    public String toString() {
        return "NewsObjList{" + "newsObjList=" + newsObjList + '}';
    }
    
    
}

class NewsObj{
    int id;
    int userId;
    String title;
    String body;
    
    public NewsObj(){
       
    }

    @Override
    public String toString() {
        return "NewsObj{" + "id=" + id + ", userId=" + userId + ", title=" + title + ", body=" + body + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
   
}
class GetData{
    private String url = "";
    private String resp = "";
    private List<NewsObj> jsonResp;
    
    public void seturl(String url){
        this.url = url;
    }
    
    public String getUrl(){
        return this.url;
    }
    
    public void getStringData(){
        
        
        HttpRequest request = HttpRequest.newBuilder().GET()
                .uri(URI.create(this.url)).build();
        
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = null;
        try {
            response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(response.statusCode());
        System.out.println("Type of Response "+response.body().getClass().getName());
        //System.out.println(response.body());
        this.resp = response.body();
        
        
    }
    
    public void getJsonData(){
       
        GsonBuilder builder= new GsonBuilder();
        builder.setPrettyPrinting();
        
         
        Gson gSon = builder.create();
        List<NewsObj> newsObjList = new ArrayList<>();
//          System.out.println(this.resp);
        List<NewsObj> json = gSon.fromJson(this.resp, newsObjList.getClass());
        this.jsonResp = json;
        System.out.println(json);
        System.out.println(json.getClass().getName());
        

          
    }
    public void getTitle(){
//        System.out.println(this.jsonResp);
        
//        for(var i:this.jsonResp){
//            System.out.println(i);
//        }
    }
    
}
public class GetApiReqTut {
    public static void main(String[] args) {
        String url = "https://jsonplaceholder.typicode.com/posts";
        GetData data = new GetData();
        data.seturl(url);
        
        data.getStringData();
        data.getJsonData();
        data.getTitle();
        
    }
}
