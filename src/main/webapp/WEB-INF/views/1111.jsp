<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>

package pkg.book.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pkg.book.dao.GaipDAO;
import pkg.book.dto.MemberDTO;
import pkg.book.services.GaipService;

@RestController
public class GaipController {
   @Autowired
   GaipService gaipservice;
   @PostMapping("test1")
   public String gaipid(@RequestBody Map<String,Object> map) {
      System.out.println(map);
      gaipservice.chk(map);
   
      return "";
   }
   
   @PostMapping("test2")
   public String gaipid3(@RequestBody Map<String, ArrayList<MemberDTO>> map) {
      System.out.println("Controller : " + map.get("data"));
      
   /*   ArrayList<MemberDTO> arr = map.get("data");
      for(MemberDTO dt : arr) {
         System.out.println(dt.getBirth());
      }
      */
      
      
      System.out.println(map);
      return "";
   }
   
   
   var alldata = {      
           mid : $("#ida").val(),
           mpass : $("#a").val(),
           mnickname : $("#nicka").val(),
           birth   :$("input#year").val() +"/"+ $("select#month").val() +"/" + $("input#date").val(),
           mgender : $("select#gender").val(),
           signdate : "now"
           /*
           mid;
           mpass;
  private String birth;
  private String mname;
  private String mnickname;
  private String mgender;
  private String signdate;
           
           */
           
        }
        console.log(alldata);
        $.ajax({
           url: "test2",
           data: JSON.stringify({data : alldata}),
           type: "post",
           dataType: "json",
           contentType:"application/json",
           success : function(result){
              
              
           },
           error: function(error){
              console.log(error);
           }
           
        })
   
   
}

</script>
</head>
<body>
ㅁㄴㅇㅁㄴㅇㄴㅁ






</body>
</html>