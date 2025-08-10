#  Patient Management Platform

Bu proje, **Java** ve **Spring Boot** kullanılarak geliştirilmiş **dosya tabanlı bir Hasta Kayıt Sistemi**dir.  
Hasta bilgileri **HashMap** veri yapısında tutulur ve **text dosyası** aracılığıyla kalıcı hale getirilir.  
REST API ile kullanıcılar hasta ekleme, listeleme, güncelleme ve silme işlemlerini gerçekleştirebilir.

---

##  İçindekiler
- [Özellikler](#-özellikler)
- [Kullanılan Teknolojiler](#-kullanılan-teknolojiler)
- [Kurulum](#-kurulum)
- [Çalıştırma](#-çalıştırma)
- [API Endpoints](#-api-endpoints)
- [Postman Örnekleri](#-postman-örnekleri)
- [Veri Kaydetme ve Yükleme](#-veri-kaydetme-ve-yükleme)
- [Notlar](#-notlar)
- [Lisans](#-lisans)

---

##  Özellikler
- **Hasta Kaydetme:** ID, ad-soyad, yaş, telefon ve e-posta bilgileri ile yeni kayıt
- **Hasta Listeleme:** Sistemdeki tüm kayıtların listelenmesi
- **Hasta Güncelleme:** Mevcut hastaların bilgilerinin değiştirilmesi
- **Hasta Silme:** ID ile hasta silme
- **Dosya Tabanlı Veri Saklama:** Veriler `patients.txt` dosyasında saklanır

---

## Kullanılan Teknolojiler
| Teknoloji  | Açıklama |
|------------|----------|
| Java 21    | Ana programlama dili |
| Spring Boot 3.5.4 | REST API geliştirme |
| Spring Web | HTTP endpoint oluşturma |
| Spring Validation | Veri doğrulama |
| Lombok | Boilerplate kod azaltma |
| Gradle | Proje yönetim ve derleme aracı |

---

##  Kurulum

### Depoyu Klonla
```bash
git clone https://github.com/kullaniciadi/patient-management-platform.git
cd patient-management-platform
```

### Bağımlılıkları Yükle ve çalıştırma
```bash
./gradlew build
```

```bash
./gradlew bootRun
 ```

## API Endpoints

| Method | Endpoint         | Açıklama                           |
| ------ | ---------------- | ---------------------------------- |
| GET    | `/patients`      | Tüm hastaları listeler             |
| GET    | `/patients/{id}` | ID ile hasta getirir               |
| POST   | `/patients`      | Yeni hasta ekler                   |
| PUT    | `/patients/{id}` | ID ile hasta bilgilerini günceller |
| DELETE | `/patients/{id}` | ID ile hasta siler                 |

## Postman Örnekleri 


## 1. Tüm Hastaları Listele
### Request:

```bash
GET /patients
 ```

### Response:

```bash

[
  {
    "id": 1,
    "name": "Ahmet Yılmaz",
    "age": 35,
    "phone": "05555555555",
    "email": "ahmet@example.com"
  }
]
```

## 2. ID ile Hasta Getir
### Request:

```bash
GET /patients/1
```
### Response:

```bash
{
  "id": 1,
  "name": "Ahmet Yılmaz",
  "age": 35,
  "phone": "05555555555",
  "email": "ahmet@example.com"
}
```
## 3. Yeni Hasta Ekle

### Request:

```bash
POST /patients
Content-Type: application/json

{
  "id": 2,
  "name": "Mehmet Kaya",
  "age": 29,
  "phone": "05443332211",
  "email": "mehmet@example.com"
}
```

### Response:

```bash
{
  "id": 2,
  "name": "Mehmet Kaya",
  "age": 29,
  "phone": "05443332211",
  "email": "mehmet@example.com"
}
```

## 4. Hasta Güncelle

### Request:
```bash


PUT /patients/2
Content-Type: application/json

{
  "name": "Mehmet K.",
  "age": 30,
  "phone": "05440000000",
  "email": "mehmetk@example.com"
}
```
### Response:
```bash

{
  "id": 2,
  "name": "Mehmet K.",
  "age": 30,
  "phone": "05440000000",
  "email": "mehmetk@example.com"
}
```

## 5. Hasta Sil

### Request:

```bash
DELETE /patients/2
```

### Response:
```bash
204 No Content
```

## Veri Kaydetme ve Yükleme
- Veriler patients.txt dosyasında saklanır
- Uygulama açıldığında dosya okunur ve hastalar belleğe yüklenir
- Yeni ekleme, güncelleme veya silme işlemlerinde dosya güncellenir

 ## Notlar
- ID benzersiz olmalı
- Eksik veya hatalı veri girişinde 400 Bad Request döner
- Mevcut olmayan ID için 404 Not Found döner










