Api Get Post işlemleri
=====================

Senaryo Pet
-------------

* Pet servisine request body oluştur
* "pet" endpointi ile servisi başlat
* "POST" islemi yap
* "19979" idli request bodyde 'name' keyini "ERD" ile güncelle
* "PUT" islemi yap
* "pet/{petId}" endpointi ile servisi başlat
* "petId" keyi ve "19979" degeri ile url pathi ekle
* "GET" islemi yap
* "pet/{petId}" endpointi ile servisi başlat
* "petId" keyi ve "19979" degeri ile url pathi ekle
* "DELETE" islemi yap

POST/User
----------------

* User createWithArray request body oluştur
* "user" endpointi ile servisi başlat
* "POST" islemi yap
* StatusCode Degerinin Kontrolu

GET/User
----------------

* "user/{username}" endpointi ile servisi başlat
* "username" keyi ve "EH37" degeri ile url pathi ekle
* "GET" islemi yap
* StatusCode Degerinin Kontrolu
* Json Objesini Temizle