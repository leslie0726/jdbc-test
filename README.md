# JDBC (Hive / Impala)
概述: Spring jpa 與 Hive / Impala 叢集連線

## 環境說明
Hive / Impala Database : default
Hive / Impala Table : users

## 建立 Table 語法 (在 Hive Beeline 操作)
```sql
create external table if not exists default.users (
  name string,
  age int
);

insert into default.users values
 ("Alice", 16),  ("Bob", 18),
 ("Cindy", 53),  ("Joe", 28),
 ("Apple", 5),   ("John", 33),
 ("Roger", 45),  ("Kevin", 17),
 ("Gordon", 30), ("Paul", 33),
 ("Sandy", 39),  ("Alex", 70);
```

## 打包所需環境:
    1. JDK 1.8
    2. Maven 環境

## 相關設定檔:
    1. application.properties
        1.1 spring.datasource.url : Hive / Impala JDBC 連線
        1.2 spring.datasource.driver-class-name : Hive / Impala JDBC Driver
        Hive 通常為 com.cloudera.hive.jdbc.HS2Driver , 以 Cloudera 提供之 jdbc 文件為主
        Impala 通常為 com.cloudera.impala.jdbc.Driver , 以 Cloudera 提供之 jdbc 文件為主
        1.3 spring.jpa.database-platform : Database 方言 
            （Hibernate 並未支援 Impala 方言, 故提供MS SQL的方言）
## 打包方式:
    terminal 到該檔案路徑底下，輸入 mvn clean package 即可

## 執行所需資源:
    1. JDK 1.8
    2. 8080 port (或在config/application.properties 修改server.port 參數)

## 環境應呈現之程式清單：
    ~/jdbc-kerberos-0.0.1-SNAPSHOT.jar
    ~/application.properties


## 執行方式:
    1. 先修改 application.properties 中的 Hive / Impala jdbc URL
    vi ~/application.properties

    2. 環境變數設定與啟動
    export SPRING_CONFIG_LOCATION=<home>/application.properties
    java -jar jdbc-kerberos-0.0.1-SNAPSHOT.jar

    3. 若需要變換另一個連線方式(如 Hive 改 Impala , 或 Impala 改 Hive)，先將服務停下, 更改 <home>/application.properties 的設定即可

## API 使用方式
    若方便可使用 postman 嘗試
    http 方法: POST
    http URL: http://<ip>:8080/api/query
    
    或使用 curl 
    
    curl --location --request POST 'http://<ip>:8080/api/query' \
    --data-raw ''