package com.example.patientmanagementplatform.model;

public class Patient {
    private Integer id;
    private String name;
    private int age;
    private String phone;
    private String email;

    public Patient() {
    }

    public Patient(Integer id, String name, int age, String phone, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public int getAge() {return age;}

    public void setAge(int age) {this.age = age;}

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    /** Dosyaya yazarken: CSV üret. */
    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + phone + "," + email;
    }

    public static Patient fromString(String line){
        if (line == null) throw new IllegalArgumentException("line is null");
        line = line.trim();
        if (line.isEmpty() || line.startsWith("#")) {
            throw new IllegalArgumentException("skip");
        }

        String[] parts = line.split(",", -1); // -1: boş son alanlar da gelsin
        if (parts.length < 5) {
            throw new IllegalArgumentException("CSV formatı hatalı: " + line);
        }

        int id = Integer.parseInt(parts[0].trim());
        String name = parts[1].trim();
        int age = Integer.parseInt(parts[2].trim());
        String phone = parts[3].trim();
        String email = parts[4].trim();

        return new Patient(id, name, age, phone, email);
    }
}