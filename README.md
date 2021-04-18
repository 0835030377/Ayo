## Table of contents
* [General info](#general-info)
* [Setup](#setup)

## General info
This is a spring boot project that caters for Metric to Imperial conversions and Vice Versa.The app uses a REST API to perfom 5 conversions including (Celcius to Fahrenheit, Centimetres To Feet,Galons To Litres,Inches To Millimeters and Pounds To Kilograms) , its a vice versa conversions so you see ten conversions on your results 
	
## Prerequisites
* Jdk 8 or later
* Docker 
* Postman
* Powershell

## Technologies used
Project is created with:
* Spring boot
* Eclipes
	
## Setup

This maven command below will build a jar file for your projects and drop it under /target directory on your project , noted that the jar is already built for your , this is just for you if you want to build it yourself

```
 clean install
```
## Run project on Docker
Navigate to your project directory and run the below docker commands

Run this docker command to build your image, your can give it name of your choice , mine was "ayo3-image-springboot"


```
 docker build -f Dockerfile -t ayo3-image-springboot .
```

Run this docker command below to see if your image was created 

```
 docker images
````

Now that you happy that your image was created , run ir using the command below, "8081" is the port the app will rut at.

```
docker run -p 8081:8081 ayo3-image-springboot
```

To see that your image is running , please run the command below 

```
docker ps -a
```

see image below as you can see the image status is up and running on port 8081 and its ready for testing

![Screenshot](https://user-images.githubusercontent.com/42491525/115149155-146fa680-a063-11eb-8cf4-1fdd890fb806.png)


## Testing

Use you Rest testing like Postman (you can use any of your choice even a browser)

REST URL : localhost:8081/conversion

See sample url  localhost:8081/conversion/20 , the value "20" will be the Unit value to be converted in five conversions vice versa 

see sample output below from Postman

![Screenshot3](https://user-images.githubusercontent.com/42491525/115149562-fe62e580-a064-11eb-8884-f297696e9dcf.png)

As you can see the results five conversions  vice versa were made for unit value 20
e.g 20 degrees Celsius equals to 68 Fahrenheit

ENJOY 

