/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.trantri.guru99.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author trant
 */
public class Guru99Test {
    
    static WebDriver myBrower;
    
    //Test case #1: Check the login process of Demo Guru 99 in sucessfully
    //  Step: 
    //          1. Open acertain brower, e.q. Chrome
    //          2. Navigate to Demo Guru99 login page
    //             by the url: https://demo.guru99.com/v4/
    //          3. Input a valid account into the login page
    //             e.g. mngr533982/uzatYmU
    //          4. Hit [Login] button to process the login form
    //EXPETED RESULT:
    //              A new dashboard page us showed
    //              with a wellcome meassage is under the format of
    //              Manager Id: <user-name>
    
     @Test //Code để test cái gì thì nằm ở đây
           //Code để tự động hóa các test case nằm ở đây
           //asserEquals() nằm ở đây
    public void CheckLoginGivenValidAccountLoginsSuccessfully() throws InterruptedException{
        myBrower = new ChromeDriver(); 
        myBrower.get("https://demo.guru99.com/v4/");
        myBrower.manage().window().maximize();
        //đưa valid account vào, ta phải đi tìm các thẻ của màn hình login
        WebElement txtUsername = myBrower.findElement(By.xpath("//input[@name='uid']"));
        txtUsername.sendKeys("mngr533982");
        
        WebElement txtPassword = myBrower.findElement(By.xpath("//input[@name='password']"));
        txtPassword.sendKeys("uzatYmU");
        
        WebElement btnLogin = myBrower.findElement(By.cssSelector("input[value='LOGIN']"));
        btnLogin.click(); //Enter để submit là submit(), click mouse là click()
        
        //đảm baoỏ bắt đc tag ở trang mới, ta cần wait 1 chút
        //code cứ ngắm mắt chạy, trang thì chưa kịp tải về do mạng lag
        //ko wait code ko ổn định: mạg 
        
        Thread.sleep(1000);
        
        //chuyển trang, bắt tag wellcome
        WebElement lblMessage = myBrower.findElement(By.cssSelector("tr[class='heading3'] td"));
        String wellcomeMessage = lblMessage.getText();
        //System.out.println("Message: " + wellcomeMessage);
         assertEquals("Manger Id : mngr533982", wellcomeMessage);
    }
    
    
 
    @BeforeAll //hàm này sẽ chạy trc tất cả các @Test nếu có
               //đi đầu tiên, dùng để thiết lập môi trường kiểm thử
               //khởi động các biến gì đó sẽ dùng ở @Test
    public static void setUpClass() {
        
        System.setProperty("webderiver.chrome.driver", "chromedriver.exe");
        
        //Mở ẩn danh, tiếng mọi thứ tiếng thì ở đây
        
        //     <here>
        
    }
    
   
    
    @AfterAll   //chạy sau tất cả, sau khi các @Test đã xong thì thằng 
                //này chạy. Nó dùng để dọn những thứ mà @Test bày ra
                //ví dụ: xóa data trong table do việc chạy @Test insert vào
    public static void tearDownClass() throws InterruptedException {
        
       Thread.sleep(3000);   //ngủ 1 tí xem kết quả rồi dọn dẹp
       myBrower.quit(); // đóng trình duyệt, dọn dẹp ram
       
    }
    
}
