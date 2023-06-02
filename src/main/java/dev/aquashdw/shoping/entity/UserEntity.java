package dev.aquashdw.shoping.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long teerid;
    private String name;
    private int age;
    private boolean gender;
    private String email;
    private String contact;
    private int zipCode;
    private String address;


    @OneToMany(
            targetEntity = UserEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "userEntity"
    )
    private List<AddressEntity> addressEntityList  = new ArrayList<>();
    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity(Long id, Long teerid, String name, int age, boolean gender, String email, String contact, int zipCode, String address, List<AddressEntity> addressEntityList) {
        this.id = id;
        this.teerid = teerid;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.contact = contact;
        this.zipCode = zipCode;
        this.address = address;
        this.addressEntityList = addressEntityList;
    }


    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public Long getTeerid() {
        return teerid;
    }

    public void setTeerid(Long teerid) {
        this.teerid = teerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<AddressEntity> getAddressEntityList() {
        return addressEntityList;
    }

    public void setAddressEntityList(List<AddressEntity> addressEntityList) {
        this.addressEntityList = addressEntityList;
    }
}
