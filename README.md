# 🛍️ MyShop – Prosty sklep internetowy

**MyShop** to aplikacja webowa napisana w **Java Spring Boot**, która symuluje działanie prostego sklepu internetowego.  
Umożliwia zarządzanie produktami, dodawanie ich do koszyka, składanie zamówień oraz obsługę panelu administracyjnego.

---

## ✨ Funkcje

- 📦 **Produkty**
  - Wyświetlanie listy dostępnych produktów
  - Dodawanie, edytowanie i usuwanie produktów (panel administratora)

- 🛒 **Koszyk**
  - Dodawanie produktów do koszyka
  - Usuwanie produktów z koszyka
  - Przechowywanie wielu pozycji (`Cart`, `CartItem`)

- 🧾 **Zamówienia**
  - Składanie zamówienia na podstawie zawartości koszyka
  - Obsługa zamówień poprzez DTO (`OrderDto`) i mapper (`OrderMapper`)
  - Przechowywanie szczegółów w modelu (`Order`, `OrderItem`)

- 👨‍💼 **Panel administratora**
  - Zarządzanie produktami (`AdminController`)
  - Podgląd zamówień użytkowników

- 🗄️ **Inicjalizacja danych**
  - Klasa `DbInit` ładuje przykładowe produkty do bazy przy starcie aplikacji

---

## 📂 Architektura projektu

Projekt oparty jest na typowej architekturze warstwowej:

- `controller` → kontrolery REST (`AdminController`, `OrderController`, `HomeController`)
- `service` → logika biznesowa (`CartService`, `OrderService`)
- `repository` → dostęp do bazy danych (`ItemRepository`, `OrderRepository`, `OrderItemRepository`)
- `model` → encje JPA (`Item`, `Order`, `OrderItem`, `Cart`, `CartItem`)
- `dto` → obiekty transferowe (`OrderDto`)
- `mapper` → mapowanie encji na DTO (`OrderMapper`)
