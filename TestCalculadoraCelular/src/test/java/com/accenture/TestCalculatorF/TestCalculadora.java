package com.accenture.TestCalculatorF;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestCalculadora {

	public static AppiumDriver<MobileElement> driver; //Este driver es el que contralara los eventos de la automatizacion
	DesiredCapabilities capabilities = new DesiredCapabilities(); //caracteristicas de la automatizacion

	@BeforeMethod
	public void setUpAppium() throws MalformedURLException, InterruptedException {
		String packagename = "com.sec.android.app.popupcalculator"; //Paquete principal de la aplicacion a automatizar
		String URL = "http://127.0.0.1:4723/wd/hub"; //IP y puerto de Appium
		String activityname = "com.sec.android.app.popupcalculator.Calculator"; //Nombre de la actividad (o vista) en donde empezara la automatizacion
		capabilities.setCapability("deviceName", "Samsung Galaxy Note (8)"); //No es obligatorio que este nombre coincida
		capabilities.setCapability("udid", "ce081718a9050533027e"); //Serial del dispositivo, se obtiene activando la depuración USB y con el comando adb devices
		capabilities.setCapability("platformVersion", "7.0"); //No es obligatorio que la version coincida
		capabilities.setCapability("platformName", "Android"); //Nombre del sistema operativo
		capabilities.setCapability("appPackage", packagename);
		capabilities.setCapability("appActivity", activityname);
		driver = new AndroidDriver<MobileElement>(new URL(URL), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	}

	@AfterTest
	public void CleanUpAppium() {
		driver.quit();
	}

	@Test
	public void mytest() throws InterruptedException {
		try {
			Thread.sleep(2000);
			// hacer click boton 4
			MobileElement numero4 = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_04"));
			numero4.click();

			// hacer click boton mas( +)
			MobileElement mas = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_add"));
			mas.click();

			// hacer click boton9
			MobileElement num9 = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_09"));
			num9.click();


			// hacer click botonigual
			MobileElement igual = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal"));
			igual.click();



			/*MobileElement result = driver.findElementById("de.underflow.calc:id/Result");
			String textResult = result.getText();
			System.out.print(textResult);*/
		} catch (Exception e) {
			System.out.print("Se presento Excepción " + e);
		}
	}
}
