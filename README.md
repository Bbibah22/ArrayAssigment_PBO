# Array and ArrayList

## Informasi Kode

Hubungan antar-class dalam program:

```text
Bank
└── Customer
    └── Account
```

Program ini menerapkan konsep relasi antar objek dan penggunaan struktur data Array untuk mengelola sekumpulan objek.

### 1. Encapsulation

Encapsulation diterapkan dengan membatasi akses langsung terhadap atribut dan menggunakan method untuk mengakses atau mengubah nilai atribut tersebut.

Contohnya pada class `Account`:

```java
private double balance;

public double getBalance() {
    return balance;
}
```

Atribut `balance` dibuat `private`, sehingga tidak dapat diakses secara langsung dari luar class. Untuk mengakses nilainya digunakan method `getBalance()`. 

Konsep yang sama juga diterapkan pada atribut `firstName`, `lastName`, dan `account` pada class `Customer`, serta `customers` dan `numberOfCustomers` pada class `Bank`.

### 2. Array dan Relasi Objek

Class `Bank` menggunakan Array untuk menyimpan sekumpulan objek `Customer`.

```java
private Customer[] customers;
private int numberOfCustomers;

public Bank() {
    customers = new Customer[10];
    numberOfCustomers = 0;
}
```

Sedangkan class `Customer` memiliki atribut berupa objek `Account`, yang menunjukkan relasi *has-a*.

```java
private Account account;

public void setAccount(Account acct) {
    this.account = acct;
}
```

### 3. Penggunaan Method

Operasi untuk manipulasi array atau objek dilakukan secara aman melalui method. Contohnya untuk menambah customer ke dalam bank:

```java
public void addCustomer(String f, String l) {
    if (numberOfCustomers < customers.length) {
        customers[numberOfCustomers] = new Customer(f, l);
        numberOfCustomers++;
    } else {
        System.out.println("Bank is full!");
    }
}
```

## Screenshot

### Hasil Program

```text
=== ATM / Bank Menu ===
1. Add Customer
2. Set Customer Account
3. Deposit
4. Withdraw
5. Check Balance
6. List Customers
0. Exit
Choose option: 6
Total customers: 1
[0] John Doe - Has Account: Yes (Bal: 500.0)
```
