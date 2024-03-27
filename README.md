Implement Guideline

1. Install Apache Netbeans IDE 21 [https://netbeans.apache.org/front/main/download/nb17/](https://drive.google.com/file/d/1zW5Hguc-8HoWw3yfenf28sBRdnxEeBbP/view?usp=drive_link)
2. Install MySQL Workbench 8.0 CE [https://dev.mysql.com/downloads/workbench/](https://dev.mysql.com/downloads/workbench/)
3. Install Apache Tomcat v9.0.69 [https://tomcat.apache.org/download-90.cgi](https://tomcat.apache.org/download-90.cgi)
   Extract the downloaded files to a location of your choice (e.g., C:\).
4. Open NetBeans.
  Go to the Services tab.
  Right-click on Servers and select Add Server.
  In the pop-up dialog, choose Apache Tomcat as the server type.
  Browse to locate your Tomcat server directory (e.g., C:\apache-tomcat-9.0.69).
  Set a username and password for the manager role (used when logging in to Tomcat via the browser).
  Click Finish.
5. Test Your Tomcat Server:
  In the Services tab, expand the Servers section.
  Right-click on Apache Tomcat and click Start.
  View the logs in the Console tab.
  Open your web browser (e.g., Chrome) and visit localhost:8080 (the default port for Tomcat). You should see the Tomcat welcome page.
6. Download the source code in Github.
7. Download library for MySQL [https://drive.google.com/file/d/17Wh6E0cQzG7EqgIOm2ZqsaDjv6OJsLn6/view?usp=sharing](https://drive.google.com/file/d/17Wh6E0cQzG7EqgIOm2ZqsaDjv6OJsLn6/view?usp=sharing).
  Browse to locate the jar file (e.g., C:\mysql-connector)
8. Import project in Netbeans
9. Right click "Libraries" choose "Add JAR/Folder" then choose the file you are browsed on step 7.
   Right click "Libraries" one more time, choose "Add Library" then find and select "JSTL 1.2.1"
10. Download database data [https://drive.google.com/drive/folders/1eBZ9Qje1Pk8HuA3oTJmGg6WcMH_p22Dm?usp=sharing](https://drive.google.com/drive/folders/1_3y_PVG2N7Go7jsKFCrZI05P3J0Mr1Vd?usp=drive_link). Extract all tables to MySQL workbench
11. Run project

Documentation: [https://docs.google.com/document/d/1rC-IH61aLLHFXwplJB7C7hEE7_GeTVcAT8g-P9i1CRI/edit?usp=sharing](https://docs.google.com/document/d/1rC-IH61aLLHFXwplJB7C7hEE7_GeTVcAT8g-P9i1CRI/edit?usp=sharing)
