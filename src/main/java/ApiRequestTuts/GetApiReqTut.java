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

/**
 *
 * @author DELL
 */

class GetData{
    private String url = "";
    
    public void seturl(String url){
        this.url = url;
    }
    
    public String getUrl(){
        return this.url;
    }
    
    public void getJsonData(){
        
        
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
        System.out.println(response.body());
        
        
    }
    
}
public class GetApiReqTut {
    public static void main(String[] args) {
        String url = "https://jsonplaceholder.typicode.com/posts";
        GetData data = new GetData();
        data.seturl(url);
        
        data.getJsonData();
        
    }
}
