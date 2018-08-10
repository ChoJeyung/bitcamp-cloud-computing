package bitcamp.pms.domain;

public class Namecard {
    protected String name;
    protected String email;
    protected String cellphonenum;
    private String faxnum;
    private String phonenum;
    private String memo;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCellphonenum() {
        return cellphonenum;
    }
    public void setCellphonenum(String password) {
        this.cellphonenum = password;
    }
	public String getFaxnum() {
		return faxnum;
	}
	public void setFaxnum(String faxnum) {
		this.faxnum = faxnum;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
}
