package testTBS;

//**********************************************************************************************
//THIS TEST CASE WILL NAVIGATE TO WWW.TCM.COM/TCMB, SELET A TOP 10 MOVIE FROM THE TOP 10 MOVIES
//LIST AND VERIFY THE FOLLOWING: MOVIE TITLE, OVERVEIW, 2 ACTORS, AND RELEASE DATE.
//**********************************************************************************************
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver; 



class tbsAssessment {
//**********************************************************************************************
//Setting up variables to be used for verification
//**********************************************************************************************
public static WebDriver driver;
//DECLARING CONSTANTS FOR 1ST LINK SELECTION
public static final String siteURL = "http://www.tcm.com/tcmdb/";
public static final String movieURL = "http://www.tcm.com/tcmdb/title/3190/To-Have-and-Have-Not/";
public static final String movieTitle = "TO HAVE AND HAVE NOT";
public static final String overView = "A skipper-for-hire's romance with a beautiful drifter is complicated by his growing involvement with the French resistance.";
public static final String actor1 = "Humphrey Bogart";
public static final String actor2 = "Walter Brennan";
public static final String releaseDate = "1944";
public static  String siteURLV,movieURLV,movieTitleV,overViewV,actor1V,actor2V,releaseDateV;

//DECLARING CONSTANTS FOR 2ND LINK SELECTION
public static final String movieURL2 = "http://www.tcm.com/tcmdb/title/23858/Fallen-Angel/";
public static final String movieTitle2 = "FALLEN ANGEL";
public static final String overView2 = "A man is accused of killing a waitress he had tried to seduce with his wife''s money.";
public static final String actor1b = "Alice Faye";
public static final String actor2b = "Dana Andrews";
public static final String releaseDate2 = "1945";
public static  String siteURLV2,movieURLV2,movieTitleV2,overViewV2,actor1V2,actor2V2,releaseDateV2 ;

//DECLARING CONSTANTS FOR 3RDLINK SELECTION
public static final String movieURL3 = "http://www.tcm.com/tcmdb/title/93019/Thoroughly-Modern-Millie/";
public static final String movieTitle3 = "THOROUGHLY MODERN MILLIE";
public static final String overView3 = "A small-town girl hits the big city in search of romance Roaring Twenties style.";
public static final String actor1C = "Julie Andrews";
public static final String actor2C = "Mary Tyler Moore";
public static final String releaseDate3 = "1967";
public static  String siteURLV3,movieURLV3,movieTitleV3,overViewV3,actor1V3,actor2V3,releaseDateV3;

//DECLARING CONSTANTS FOR 4TH LINK SELECTION
public static final String movieURL4 = "http://www.tcm.com/tcmdb/title/26642/Rome-Adventure/";
public static final String movieTitle4 = "ROME ADVENTURE";
public static final String overView4 = "A rebellious teacher moves to Rome and finds love.";
public static final String actor1D = "Angie Dickinson";
public static final String actor2D = "Al Hirt";
public static final String releaseDate4 = "1962";
public static  String siteURLV4,movieURLV4,movieTitleV4,overViewV4,actor1V4,actor2V4,releaseDateV4 ;


//DECLARING CONSTANTS FOR 5THLINK SELECTION
public static final String movieURL5 = "http://www.tcm.com/tcmdb/title/1828/The-Secret-Garden/";
public static final String movieTitle5 = "THE SECRET GARDEN";
public static final String overView5 = "An orphaned girl changes the lives of those she encounters at a remote estate.";
public static final String actor1E = "Gladys Cooper";
public static final String actor2E = "Brian Roper";
public static final String releaseDate5= "1949";
public static  String siteURLV5,movieURLV5,movieTitleV5,overViewV5,actor1V5,actor2V5,releaseDateV5 ;

//**********************************************************************************************
//SET-UP
//**********************************************************************************************

public static void main(String [] args) {
driver = new FirefoxDriver();	
driver.manage().window().maximize();
driver.get(siteURL);
//**********************************************************************************************
//NAVIGATING TO THE WEBSITE AND VERIFYING THAT CORRECT THE PAGE LOADED
//**********************************************************************************************
if (driver.getCurrentUrl().equals(siteURL)){
	System.out.println("The site URL was found");
}
else {
	System.out.println("The site URL was not found. Please check URL ");
}
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;


//**********************************************************************************************
//SELECTING THE MOVIE TITLE BY CLICKING ON IT AND VERIFYING THE TITLE
//**********************************************************************************************
//VERIFYING THAT THE MOVIE LINK IS DISPLAYED
Boolean movieLink =  (driver.findElement(By.xpath("//div[1]/div/div/div/a[1]")).isDisplayed());
//CLICKIN ON THE MOVIE LINK IF IT IS DISPLAYED. IF NOT THE PRINT MESSAGE
if(movieLink) {
	driver.findElement(By.xpath("//div[7]/div[1]/div[1]/div/div/div/a[1]")).click();
}	
else {
	System.out.println("The Movie link To Have and Have not is not visible");
	
}

if (driver.getCurrentUrl().equals(movieURL)) {
	 System.out.println("The To Have and Have not movie page loaded");

}
else {
	 System.out.println("The To Have and Have not movie page didn't load");
	 
}
//VERIFYING THAT THE MOVIE TITLE MATCHES THE EXPECTED MOVIE TITLE. IF NOT PRINT MESSAGE
if(driver.findElement(By.xpath("//div[1]/h1/span[1]")).getText().equals(movieTitle)) {
	System.out.println("The movie title Verification - Passed");
	movieTitleV = driver.findElement(By.xpath("//div[1]/h1/span[1]")).getText();
	
}
else {
	System.out.println("The movie title Verification Failed!");
}

//**********************************************************************************************
//VERIYING THE OVER TEXT DISPLAYS AND VERIFYING THE CONTENT
//**********************************************************************************************
//VERFIYING THE TEXT IS VISIBLE
Boolean overview = driver.findElement(By.xpath("//div[2]/div[1]/div/div[1]/div[1]/a[1]")).isDisplayed();
//IF THE TEXT IS VISIBLE THEN COMPARE THE TEXT TO THE EXPECTED TEXT. IF EXPECTED TEXT IS NOT FOUND THEN PRINT A MESSAGE.
if(overview){	
driver.findElement(By.xpath("//div[2]/div[2]/div/div[4]/div[3]/p[1]")).getText().equals(overView);
System.out.println("The Overview text Verification - Passed");
overViewV =   driver.findElement(By.xpath("//div[2]/div[2]/div/div[4]/div[3]/p[1]")).getText();

	}

else {
		System.out.println("The Overview Text Verification Failed!");
	
}	
	
//**********************************************************************************************
//VERIFYING TWO ACTORS IN THE MOVIE.
//**********************************************************************************************
//VERIFYING THE CAST AND CREW SECTION IS DISPLAYED
Boolean cast = driver.findElement(By.xpath("//*[@id=\"candc\"]")).isDisplayed();
//VERIFYING THE TWO ACTORS NAMES TO THE EXPECTED NAMES.
if(cast){	
driver.findElement(By.xpath("//div[4]/div[6]/div[2]/div[1]/strong/a")).getText().equals(actor1);
driver.findElement(By.xpath("//div[4]/div[6]/div[2]/div[2]/strong/a")).getText().equals(actor2);
System.out.println("The Actor Verification - Passed");
actor1V =   driver.findElement(By.xpath("//div[4]/div[6]/div[2]/div[1]/strong/a")).getText();
actor2V =   driver.findElement(By.xpath("//div[4]/div[6]/div[2]/div[2]/strong/a")).getText();

	}

else {
		System.out.println("The Actor Verification Failed!");
	
}		
//**********************************************************************************************
//VERIFY RELEASE DATE MATCHES EXPECTED RELEASE DATE
//**********************************************************************************************
//VERIFYING RELEASE DATE IS DISPLAYED
Boolean relDate = driver.findElement(By.xpath("//div[4]/div[9]/table/tbody/tr[2]/td[1]/strong")).isDisplayed();
//VERIFYING ACTUAL RELEASE DATE MATCHES EXPECTED RELEASE DATE
if(relDate){	
driver.findElement(By.xpath("//div[9]/table/tbody/tr[2]/td[2]")).getText().equals(releaseDate);
System.out.println("The Release Date Verification - Passed");
releaseDateV =   driver.findElement(By.xpath("//div[9]/table/tbody/tr[2]/td[2]")).getText();

	}

else {
		System.out.println("The Release Date Verification Failed!");
	
}		

//**********************************************************************************************
//NAVIGATING TO THE WEBSITE AND VERIFYING THAT CORRECT THE PAGE LOADED - LINK  2
//**********************************************************************************************
driver.navigate().back();
if (driver.getCurrentUrl().equals(siteURL)){
	System.out.println("The site URL was found");
}
else {
	System.out.println("The site URL was not found. Please check URL ");
}

//**********************************************************************************************
//SELECTING THE MOVIE TITLE BY CLICKING ON IT AND VERIFYING THE TITLE
//**********************************************************************************************
//VERIFYING THAT THE MOVIE LINK IS DISPLAYED
Boolean movieLink2 =  (driver.findElement(By.xpath("//div[1]/div[1]/div/div/div/a[2]")).isDisplayed());
//CLICKIN ON THE MOVIE LINK IF IT IS DISPLAYED. IF NOT THE PRINT MESSAGE
if(movieLink2) {
	driver.findElement(By.xpath("//div[1]/div[1]/div/div/div/a[2]")).click();
}	
else {
	System.out.println("The Fallen Angel is not visible");
	
}

if (driver.getCurrentUrl().equals(movieURL2)) {
	 System.out.println("The Fallen Angle movie page loaded");

}
else {
	 System.out.println("Fallen Angel movie page didn't load");
	 
}
//VERIFYING THAT THE MOVIE TITLE MATCHES THE EXPECTED MOVIE TITLE. IF NOT PRINT MESSAGE
if(driver.findElement(By.xpath("//div[1]/h1/span[1]")).getText().equals(movieTitle2)) {
	System.out.println("The movie title Verification - Passed");
	movieTitleV2 = driver.findElement(By.xpath("//div[1]/div/div[1]/h1/span[1]")).getText();
	
}
else {
	System.out.println("The movie title Verification Failed!");
}


//**********************************************************************************************
//VERIYING THE OVER TEXT DISPLAYS AND VERIFYING THE CONTENT
//**********************************************************************************************
//VERFIYING THE TEXT IS VISIBLE
Boolean overview2 = driver.findElement(By.xpath("//div[2]/div[1]/div/div[1]/div[1]/a[1]")).isDisplayed();
//IF THE TEXT IS VISIBLE THEN COMPARE THE TEXT TO THE EXPECTED TEXT. IF EXPECTED TEXT IS NOT FOUND THEN PRINT A MESSAGE.
if(overview2){	
driver.findElement(By.xpath("//div[2]/div/div[4]/div[3]/p[1]")).getText().equals(overView2);
System.out.println("The Overview text Verification - Passed");
overViewV2 =   driver.findElement(By.xpath("//div[2]/div/div[4]/div[3]/p[1]")).getText();

	}

else {
		System.out.println("The Overview Text Verification Failed!");
	
}	
	
//**********************************************************************************************
//VERIFYING TWO ACTORS IN THE MOVIE.
//**********************************************************************************************
//VERIFYING THE CAST AND CREW SECTION IS DISPLAYED
Boolean cast2 = driver.findElement(By.xpath("//*[@id=\"candc\"]")).isDisplayed();
//VERIFYING THE TWO ACTORS NAMES TO THE EXPECTED NAMES.
if(cast2){	
driver.findElement(By.xpath("//div/div[4]/div[6]/div[2]/div[1]/strong/a")).getText().equals(actor1b);
driver.findElement(By.xpath("//div[2]/div[2]/div/div[4]/div[6]/div[2]/div[2]/strong/a")).getText().equals(actor2b);
System.out.println("The Actor Verification - Passed");
actor1V2 =   driver.findElement(By.xpath("//div/div[4]/div[6]/div[2]/div[1]/strong/a")).getText();
actor2V2 =   driver.findElement(By.xpath("//div[2]/div[2]/div/div[4]/div[6]/div[2]/div[2]/strong/a")).getText();

	}

else {
		System.out.println("The Actor Verification Failed!");
	
}		
//**********************************************************************************************
//VERIFY RELEASE DATE MATCHES EXPECTED RELEASE DATE
//**********************************************************************************************
//VERIFYING RELEASE DATE IS DISPLAYED
Boolean relDate2 = driver.findElement(By.xpath("//div[4]/div[9]/table/tbody/tr[2]/td[1]/strong")).isDisplayed();
//VERIFYING ACTUAL RELEASE DATE MATCHES EXPECTED RELEASE DATE
if(relDate2){	
driver.findElement(By.xpath("//div[9]/table/tbody/tr[2]/td[2]")).getText().equals(releaseDate2);
System.out.println("The Release Date Verification - Passed");
releaseDateV2 =   driver.findElement(By.xpath("//div/div[4]/div[9]/table/tbody/tr[2]/td[2]")).getText();

	}

else {
		System.out.println("The Release Date Verification Failed!");
	
}		

//**********************************************************************************************
//NAVIGATING TO THE WEBSITE AND VERIFYING THAT CORRECT THE PAGE LOADED - LINK  3
//**********************************************************************************************
driver.navigate().back();
if (driver.getCurrentUrl().equals(siteURL)){
	System.out.println("The site URL was found");
}
else {
	System.out.println("The site URL was not found. Please check URL ");
}

//**********************************************************************************************
//SELECTING THE MOVIE TITLE BY CLICKING ON IT AND VERIFYING THE TITLE
//**********************************************************************************************
//VERIFYING THAT THE MOVIE LINK IS DISPLAYED
Boolean movieLink3 =  (driver.findElement(By.xpath("//div[1]/div/div/div/a[3]")).isDisplayed());
//CLICKIN ON THE MOVIE LINK IF IT IS DISPLAYED. IF NOT THE PRINT MESSAGE
if(movieLink3) {
	driver.findElement(By.xpath("//div[1]/div/div/div/a[3]")).click();
}	
else {
	System.out.println("Thoroughly Modern Millie  is not visible");
	
}

if (driver.getCurrentUrl().equals(movieURL3)) {
	 System.out.println("Thoroughly Modern Millie movie page loaded");

}
else {
	 System.out.println("Thoroughly Modern Millie movie page didn't load");
	 
}
//VERIFYING THAT THE MOVIE TITLE MATCHES THE EXPECTED MOVIE TITLE. IF NOT PRINT MESSAGE
if(driver.findElement(By.xpath("//div[1]/h1/span[1]")).getText().equals(movieTitle3)) {
	System.out.println("The movie title Verification - Passed");
	movieTitleV3 = driver.findElement(By.xpath("//div[1]/div/div[1]/h1/span[1]")).getText();
	
}
else {
	System.out.println("The movie title Verification Failed!");
}


//**********************************************************************************************
//VERIYING THE OVER TEXT DISPLAYS AND VERIFYING THE CONTENT
//**********************************************************************************************
//VERFIYING THE TEXT IS VISIBLE
Boolean overview3 = driver.findElement(By.xpath("//div[2]/div[1]/div/div[1]/div[1]/a[1]")).isDisplayed();
//IF THE TEXT IS VISIBLE THEN COMPARE THE TEXT TO THE EXPECTED TEXT. IF EXPECTED TEXT IS NOT FOUND THEN PRINT A MESSAGE.
if(overview3){	
driver.findElement(By.xpath("//div[2]/div/div[4]/div[4]/p[1]")).getText().equals(overView3);
System.out.println("The Overview text Verification - Passed");
overViewV3 =   driver.findElement(By.xpath("//div[2]/div/div[4]/div[4]/p[1]")).getText();

	}

else {
		System.out.println("The Overview Text Verification Failed!");
	
}	
	
//**********************************************************************************************
//VERIFYING TWO ACTORS IN THE MOVIE.
//**********************************************************************************************
//VERIFYING THE CAST AND CREW SECTION IS DISPLAYED
Boolean cast3 = driver.findElement(By.xpath("//*[@id=\"candc\"]")).isDisplayed();
//VERIFYING THE TWO ACTORS NAMES TO THE EXPECTED NAMES.
if(cast2){	
driver.findElement(By.xpath("//div/div[4]/div[7]/div[2]/div[1]/strong/a")).getText().equals(actor1C);
driver.findElement(By.xpath("//div/div[4]/div[7]/div[2]/div[2]/strong/a")).getText().equals(actor2C);
System.out.println("The Actor Verification - Passed");
actor1V3 =   driver.findElement(By.xpath("//div/div[4]/div[7]/div[2]/div[1]/strong/a")).getText();
actor2V3 =   driver.findElement(By.xpath("//div/div[4]/div[7]/div[2]/div[2]/strong/a")).getText();

	}

else {
		System.out.println("The Actor Verification Failed!");
	
}		
//**********************************************************************************************
//VERIFY RELEASE DATE MATCHES EXPECTED RELEASE DATE
//**********************************************************************************************
//VERIFYING RELEASE DATE IS DISPLAYED
Boolean relDate3 = driver.findElement(By.xpath("//div[10]/table/tbody/tr[2]/td[1]/strong")).isDisplayed();
//VERIFYING ACTUAL RELEASE DATE MATCHES EXPECTED RELEASE DATE
if(relDate3){	
driver.findElement(By.xpath("//div[10]/table/tbody/tr[2]/td[2]")).getText().equals(releaseDate3);
System.out.println("The Release Date Verification - Passed");
releaseDateV3 =   driver.findElement(By.xpath("//div[10]/table/tbody/tr[2]/td[2]")).getText();

	}

else {
		System.out.println("The Release Date Verification Failed!");
	
}		

//**********************************************************************************************
//NAVIGATING TO THE WEBSITE AND VERIFYING THAT CORRECT THE PAGE LOADED - LINK  4
//**********************************************************************************************
driver.navigate().back();
if (driver.getCurrentUrl().equals(siteURL)){
	System.out.println("The site URL was found");
}
else {
	System.out.println("The site URL was not found. Please check URL ");
}

//**********************************************************************************************
//SELECTING THE MOVIE TITLE BY CLICKING ON IT AND VERIFYING THE TITLE
//**********************************************************************************************
//VERIFYING THAT THE MOVIE LINK IS DISPLAYED
Boolean movieLink4 =  (driver.findElement(By.xpath("//div[1]/div/div/div/a[4]")).isDisplayed());
//CLICKIN ON THE MOVIE LINK IF IT IS DISPLAYED. IF NOT THE PRINT MESSAGE
if(movieLink4) {
	driver.findElement(By.xpath("//div[1]/div/div/div/a[4]")).click();
}	
else {
	System.out.println("Rome Adventure  is not visible");
	
}

if (driver.getCurrentUrl().equals(movieURL4)) {
	 System.out.println("Rome Adventure page loaded");

}
else {
	 System.out.println("Rome Adventure movie page didn't load");
	 
}
//VERIFYING THAT THE MOVIE TITLE MATCHES THE EXPECTED MOVIE TITLE. IF NOT PRINT MESSAGE
if(driver.findElement(By.xpath("//div[1]/div/div[1]/h1/span[1]")).getText().equals(movieTitle4)) {
	System.out.println("The movie title Verification - Passed");
	movieTitleV4 = driver.findElement(By.xpath("//div[1]/div/div[1]/h1/span[1]")).getText();
	
}
else {
	System.out.println("The movie title Verification Failed!");
}
//**********************************************************************************************
//VERIYING THE OVERVIEW TEXT DISPLAYS AND VERIFYING THE CONTENT
//**********************************************************************************************
//VERFIYING THE TEXT IS VISIBLE
Boolean overview4 = driver.findElement(By.xpath("//div[2]/div[1]/div/div[1]/div[1]/a[1]")).isDisplayed();
//IF THE TEXT IS VISIBLE THEN COMPARE THE TEXT TO THE EXPECTED TEXT. IF EXPECTED TEXT IS NOT FOUND THEN PRINT A MESSAGE.
if(overview4){	
driver.findElement(By.xpath("//div[2]/div/div[4]/div[3]/p[1]")).getText().equals(overView4);
System.out.println("The Overview text Verification - Passed");
overViewV4 =   driver.findElement(By.xpath("//div[2]/div/div[4]/div[3]/p[1]")).getText();

	}

else {
		System.out.println("The Overview Text Verification Failed!");
	
}	
	
//**********************************************************************************************
//VERIFYING TWO ACTORS IN THE MOVIE.
//**********************************************************************************************
//VERIFYING THE CAST AND CREW SECTION IS DISPLAYED
Boolean cast4 = driver.findElement(By.xpath("//*[@id=\"candc\"]")).isDisplayed();
//VERIFYING THE TWO ACTORS NAMES TO THE EXPECTED NAMES.
if(cast4){	
driver.findElement(By.xpath("//div[4]/div[6]/div[2]/div[2]/strong/a")).getText().equals(actor1D);
driver.findElement(By.xpath("//div/div[4]/div[6]/div[3]/div[3]/strong/a")).getText().equals(actor2D);
System.out.println("The Actor Verification - Passed");
actor1V4 =   driver.findElement(By.xpath("//div[4]/div[6]/div[2]/div[2]/strong/a")).getText();
actor2V4 =   driver.findElement(By.xpath("//div/div[4]/div[6]/div[3]/div[3]/strong/a")).getText();

	}

else {
		System.out.println("The Actor Verification Failed!");
	
}		
//**********************************************************************************************
//VERIFY RELEASE DATE MATCHES EXPECTED RELEASE DATE
//**********************************************************************************************
//VERIFYING RELEASE DATE IS DISPLAYED
Boolean relDate4 = driver.findElement(By.xpath("//div[4]/div[9]/table/tbody/tr[2]/td[1]")).isDisplayed();
//VERIFYING ACTUAL RELEASE DATE MATCHES EXPECTED RELEASE DATE
if(relDate4){	
driver.findElement(By.xpath("//div[4]/div[9]/table/tbody/tr[2]/td[2]")).getText().equals(releaseDate3);
System.out.println("The Release Date Verification - Passed");
releaseDateV4 =   driver.findElement(By.xpath("//div[4]/div[9]/table/tbody/tr[2]/td[2]")).getText();

	}

else {
		System.out.println("The Release Date Verification Failed!");
	
}		

//**********************************************************************************************
//NAVIGATING TO THE WEBSITE AND VERIFYING THAT CORRECT THE PAGE LOADED - LINK  5
//**********************************************************************************************
driver.navigate().back();
if (driver.getCurrentUrl().equals(siteURL)){
	System.out.println("The site URL was found");
}
else {
	System.out.println("The site URL was not found. Please check URL ");
}

//**********************************************************************************************
//SELECTING THE MOVIE TITLE BY CLICKING ON IT AND VERIFYING THE TITLE
//**********************************************************************************************
//VERIFYING THAT THE MOVIE LINK IS DISPLAYED
Boolean movieLink5 =  (driver.findElement(By.xpath("//div[1]/div/div/div/a[5]")).isDisplayed());
//CLICKIN ON THE MOVIE LINK IF IT IS DISPLAYED. IF NOT THE PRINT MESSAGE
if(movieLink5) {
	driver.findElement(By.xpath("//div[1]/div/div/div/a[5]")).click();
}	
else {
	System.out.println("The Secret Garden is not visible");
	
}

if (driver.getCurrentUrl().equals(movieURL5)) {
	 System.out.println("The Secret Garden page loaded");

}
else {
	 System.out.println("The Secret Garden movie page didn't load");
	 
}
//VERIFYING THAT THE MOVIE TITLE MATCHES THE EXPECTED MOVIE TITLE. IF NOT PRINT MESSAGE
if(driver.findElement(By.xpath("//div/div[1]/h1/span[1]")).getText().equals(movieTitle5)) {
	System.out.println("The movie title Verification - Passed");
	movieTitleV5 = driver.findElement(By.xpath("//div[1]/div/div[1]/h1/span[1]")).getText();
	
}
else {
	System.out.println("The movie title Verification Failed!");
}


//**********************************************************************************************
//VERIYING THE OVER TEXT DISPLAYS AND VERIFYING THE CONTENT
//**********************************************************************************************
//VERFIYING THE TEXT IS VISIBLE
Boolean overview5 = driver.findElement(By.xpath("//div[2]/div/div[4]/div[3]/p[1]")).isDisplayed();
//IF THE TEXT IS VISIBLE THEN COMPARE THE TEXT TO THE EXPECTED TEXT. IF EXPECTED TEXT IS NOT FOUND THEN PRINT A MESSAGE.
if(overview5){	
driver.findElement(By.xpath("//div[2]/div/div[4]/div[3]/p[1]")).getText().equals(overView5);
System.out.println("The Overview text Verification - Passed");
overViewV5 =   driver.findElement(By.xpath("//div[2]/div/div[4]/div[3]/p[1]")).getText();

	}

else {
	System.out.println("The Overview Text Verification Failed!");
	
}	
	
//**********************************************************************************************
//VERIFYING TWO ACTORS IN THE MOVIE.
//**********************************************************************************************
//VERIFYING THE CAST AND CREW SECTION IS DISPLAYED
Boolean cast5 = driver.findElement(By.xpath("//*[@id=\"candc\"]")).isDisplayed();
//VERIFYING THE TWO ACTORS NAMES TO THE EXPECTED NAMES.
if(cast5){	
driver.findElement(By.xpath("//div[4]/div[6]/div[3]/div[1]/strong/a")).getText().equals(actor1E);
driver.findElement(By.xpath("//div[4]/div[6]/div[3]/div[3]/strong/a")).getText().equals(actor2E);
System.out.println("The Actor Verification - Passed");
actor1V5 =   driver.findElement(By.xpath("//div[4]/div[6]/div[3]/div[1]/strong/a")).getText();
actor2V5 =   driver.findElement(By.xpath("//div[4]/div[6]/div[3]/div[3]/strong/a")).getText();

	}

else {
	System.out.println("The Actor Verification Failed!");
	
}		
//**********************************************************************************************
//VERIFY RELEASE DATE MATCHES EXPECTED RELEASE DATE
//**********************************************************************************************
//VERIFYING RELEASE DATE IS DISPLAYED
Boolean relDate5 = driver.findElement(By.xpath("//div[4]/div[9]/table/tbody/tr[2]/td[1]/strong")).isDisplayed();
//VERIFYING ACTUAL RELEASE DATE MATCHES EXPECTED RELEASE DATE
if(relDate5){	
driver.findElement(By.xpath("//div/div[4]/div[9]/table/tbody/tr[2]/td[2]")).getText().equals(releaseDate3);
System.out.println("The Release Date Verification - Passed");
releaseDateV5 =   driver.findElement(By.xpath("//div/div[4]/div[9]/table/tbody/tr[2]/td[2]")).getText();

	}

else {
	System.out.println("The Release Date Verification Failed!");
	
}		

//**********************************************************************************************
//DATA OUTPUT PRINTED
//**********************************************************************************************

System.out.println("--------------------------------------");
System.out.println("The movie Title is- " +     movieTitleV);
System.out.println("The Movie overview is-  " + overViewV);
System.out.println("The First Actor is-   " +   actor1V);
System.out.println("The Second Actor is-  " +   actor2V);
System.out.println("The Release date is-  " +   releaseDateV);
System.out.println("--------------------------------------");

//OUTPUT FOR THE SECOND LINK
System.out.println("--------------------------------------");
System.out.println("The movie Title is- " +     movieTitleV2);
System.out.println("The Movie overview is-  " + overViewV2);
System.out.println("The First Actor is-   " +   actor1V2);
System.out.println("The Second Actor is-  " +   actor2V2);
System.out.println("The Release date is-  " +   releaseDateV2);
System.out.println("--------------------------------------");

//OUTPUT FOR THE THIRD LINK
System.out.println("--------------------------------------");
System.out.println("The movie Title is- " +     movieTitleV3);
System.out.println("The Movie overview is-  " + overViewV3);
System.out.println("The First Actor is-   " +   actor1V3);
System.out.println("The Second Actor is-  " +   actor2V3);
System.out.println("The Release date is-  " +   releaseDateV3);
System.out.println("--------------------------------------");

//OUTPUT FOR THE FOURTH LINK
System.out.println("--------------------------------------");
System.out.println("The movie Title is- " +     movieTitleV4);
System.out.println("The Movie overview is-  " + overViewV4);
System.out.println("The First Actor is-   " +   actor1V4);
System.out.println("The Second Actor is-  " +   actor2V4);
System.out.println("The Release date is-  " +   releaseDateV4);
System.out.println("--------------------------------------");

//OUTPUT FOR THE 5TH LINK
System.out.println("--------------------------------------");
System.out.println("The movie Title is- " +     movieTitleV5);
System.out.println("The Movie overview is-  " + overViewV5);
System.out.println("The First Actor is-   " +   actor1V5);
System.out.println("The Second Actor is-  " +   actor2V5);
System.out.println("The Release date is-  " +   releaseDateV5);
System.out.println("--------------------------------------");
driver.quit();
}

}		
		
	


