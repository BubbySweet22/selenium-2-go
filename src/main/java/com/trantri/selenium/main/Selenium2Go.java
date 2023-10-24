/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.trantri.selenium.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author trant
 */
public class Selenium2Go {

    
    static WebDriver myBrowser;
    //biến trỏ đến tab trình duyệt
    //trong OOP, cái gì cx là object, pahỉ new, tốn ram
    // 1 tab trình duyệt là 1 object trong RAM, có UI ra bên ngoài
    
    
    
    //mún có trình duyệt xuất hiện thì phải new()
    
    
    public static void main(String[] args) throws InterruptedException {
       //Nạp cái driver là file.exe vào máy ảo Java để lắng nghe
       //những hành động code của mình nó chuuyển lại cho trình duyệt
       //~~~ câu lệnh Class.forName(jdbc driver); môn Java Web
       //System.out.println();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        
        //Mở trình duyệt ẩn danh
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--incognito");
        opt.addArguments("--lang=th-TH");
        
        //gọi trình duyệt xuất hiện
        myBrowser = new ChromeDriver(opt);
        
        //lúc này myBrowser trỏ thẳng vào tab vừa mở
        //chấm gọi hàm là bất tri
     
        //bung full screen
        myBrowser.manage().window().maximize();
        
        
        //duyệt web tải trang về
        myBrowser.get("https://youtube.com");
        
        //ta đi tìm các tag để sau đó gọi các event trên tag 
        //hoặc là đưa data vào tag
        //mọi tag trong trang web đều là object: WebElement
        //tìm 1 tag trong trang web giống như select 1 dòng trong table
        //ta phải vt ra câu query để tìm tag như vt SQL tìm data trong CSDL
        //có nhìu cách để query 1 tag: query theo name của tag 
        //                                                 id, tên tag, css, class
        //                                                 xPath - ngầu nhất
        
        WebElement SearchBox = myBrowser.findElement(By.name("search_query"));
        
        SearchBox.sendKeys("Đất rừng phương nam");
        SearchBox.submit();//nhấn enter để search
        
        //mỗi khi ta tắt trình duyệt , driver vẫn nằm trong ram
        //ko đc xài đến, ram giảm dung lượng dần dần - MEMORY LEAKING
        //ta phải tắt trình duyệt đúng chuẩn để free lun cả driver
        
        Thread.sleep(30000); //dừng CPU, đừng chạy trình duyệt 
                                  // sau 3s hãy làm
                                  
        myBrowser.quit(); //tắt trình duyệt, gõ lun driver khỏi ram
    }
}
