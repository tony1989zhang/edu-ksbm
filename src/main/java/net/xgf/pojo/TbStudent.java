package net.xgf.pojo;

public class TbStudent extends TbStudentExt{
    private Integer id;
    private String stuname;
    private String examcode;
    private String headurl;
    private String mobile;
    private String deparment;
    private Integer number;
    private Integer seatnumber;
    private String healthurl;
    private String idcard;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname == null ? null : stuname.trim();
    }

    public String getExamcode() {
        return examcode;
    }

    public void setExamcode(String examcode) {
        this.examcode = examcode == null ? null : examcode.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getDeparment() {
        return deparment;
    }

    public void setDeparment(String deparment) {
        this.deparment = deparment == null ? null : deparment.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSeatnumber() {
        return seatnumber;
    }

    public void setSeatnumber(Integer seatnumber) {
        this.seatnumber = seatnumber;
    }

    public String getHeadurl() {
        return headurl;
    }

    public void setHeadurl(String headurl) {
        this.headurl = headurl == null ? null : headurl.trim();
    }

    public String getHealthurl() {
        return healthurl;
    }

    public void setHealthurl(String healthurl) {
        this.healthurl = healthurl == null ? null : healthurl.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

	@Override
	public String toString() {
		return "TbStudent [id=" + id + ", stuname=" + stuname + ", examcode=" + examcode + ", mobile=" + mobile
				+ ", deparment=" + deparment + ", number=" + number + ", seatnumber=" + seatnumber + ", headurl="
				+ headurl + ", healthurl=" + healthurl + ", idcard=" + idcard + "]";
	}

    
    
}