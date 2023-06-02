package dev.aquashdw.shoping.entity;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class AddressEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userid;

    private String address;

    private String addrDetail;
    private String name;


    @ManyToOne(
            targetEntity = UserEntity.class,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    public AddressEntity(Long id, Long userid, String address, String addrDetail, String name, UserEntity userEntity) {
        this.id = id;
        this.userid = userid;
        this.address = address;
        this.addrDetail = addrDetail;
        this.name = name;
        this.userEntity = userEntity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AddressEntity() {
    }

    public Long getId() {
        return id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddrDetail() {
        return addrDetail;
    }

    public void setAddrDetail(String addrDetail) {
        this.addrDetail = addrDetail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
