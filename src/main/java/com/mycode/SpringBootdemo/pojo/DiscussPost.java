package com.mycode.SpringBootdemo.pojo;/*
    @author ððð
    @create 2022--04--12--15:42
*/

import lombok.Data;

import java.util.Date;

//æ³¨æå¯¹è±¡å±æ§åè¦åæ°æ®åºå­æ®µåä¸è´(é¤äºå½åè§èãé©¼å³°å½åä¸ä¸åçº¿å½å)
@Data
public class DiscussPost {
    private int id; //å¸å­id
    private int userId; //å¸ä¸»id
    private String title;   //å¸å­æ é¢
    private String content; //å¸ä¸»åå®¹
    private int type;   //å¸å­åå®¹(0æ¯æ®é,1æ¯ç½®é¡¶)
    private int status; //å¸å­ç¶æ(0æ¯æ­£å¸¸,1æ¯ç²¾å,2æ¯æé»)
    private Date createTime;   //åå»ºæ¶é´
    private int commentCount;   //è¯è®ºæ°
    private double score; //å¸å­çåæ°
}
