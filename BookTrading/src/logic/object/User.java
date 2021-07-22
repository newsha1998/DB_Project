package logic.object;

public class User {
    int id;
    String username, name, surname, email, credit, city, region, street, alley, houseNumber, telephone, address, national;
    double seller, lender, borrower, purchaser;

    public User() {
    }

    public User(int id, String username, String name, String surname) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getNational() {
        return national;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setAlley(String alley) {
        this.alley = alley;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setSeller(double seller) {
        this.seller = seller;
    }

    public void setLender(double lender) {
        this.lender = lender;
    }

    public void setBorrower(double borrower) {
        this.borrower = borrower;
    }

    public void setPurchaser(double purchaser) {
        this.purchaser = purchaser;
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getCredit() {
        return credit;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getStreet() {
        return street;
    }

    public String getAlley() {
        return alley;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getTelephone() {
        return telephone;
    }

    public double getSeller() {
        return seller;
    }

    public double getLender() {
        return lender;
    }

    public double getBorrower() {
        return borrower;
    }

    public double getPurchaser() {
        return purchaser;
    }
}
