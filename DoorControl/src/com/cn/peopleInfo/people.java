package rfid.DoorControl.src.com.cn.peopleInfo;

public class people {
    private String name;
    private String id;
    private  String dom;
    private String major;
    private String phone;

    public String getIdCard() {
        return IdCard;
    }

    public void setIdCard(String idCard) {
        IdCard = idCard;
    }

    private String IdCard;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String num) {
        this.id = num;
    }

    public String getDom() {
        return dom;
    }

    public void setDom(String dom) {
        this.dom = dom;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public people() {
    }

    public people(String name) {
        this.name = name;
    }

    public people(String name, String num) {
        this.name = name;
        this.id = num;
    }

    public people(String name, String num, String dom) {
        this.name = name;
        this.id = num;
        this.dom = dom;
    }

    public people(String name, String num, String dom, String major) {
        this.name = name;
        this.id = num;
        this.dom = dom;
        this.major = major;
    }

    public people(String name, String num, String dom, String major, String phone) {
        this.name = name;
        this.id = num;
        this.dom = dom;
        this.major = major;
        this.phone = phone;
    }

    public people(String name, String id, String dom, String major, String phone, String idCard) {
        this.name = name;
        this.id = id;
        this.dom = dom;
        this.major = major;
        this.phone = phone;
        IdCard = idCard;
    }
}
