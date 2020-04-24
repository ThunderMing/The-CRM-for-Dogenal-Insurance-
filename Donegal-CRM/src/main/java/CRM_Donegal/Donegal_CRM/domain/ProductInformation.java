package CRM_Donegal.Donegal_CRM.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Object:the information of the insurance's products
 * Author: Thunder Lei
 */
@Getter
@Setter
public class ProductInformation {
    private Long id;
    
    private String sn;
   
    private String name;
    
    private String Products;
  
    private Long ageLimit;
   
    private BigDecimal coverage;
   
    private BigDecimal annualFee;
    
    private Boolean saleStatus;
    
    private Boolean deductionStatus;

   
    private String organizationName;
 
    private Long organizationId;
	public BigDecimal getAnnualFee() {
		// TODO Auto-generated method stub
		return null;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAgeLimit() {
		return ageLimit;
	}
	public void setAgeLimit(Long ageLimit) {
		this.ageLimit = ageLimit;
	}
	public BigDecimal getCoverage() {
		return coverage;
	}
	public void setCoverage(BigDecimal coverage) {
		this.coverage = coverage;
	}
	public Boolean getSaleStatus() {
		return saleStatus;
	}
	public void setSaleStatus(Boolean saleStatus) {
		this.saleStatus = saleStatus;
	}
	public Boolean getDeductionStatus() {
		return deductionStatus;
	}
	public void setDeductionStatus(Boolean deductionStatus) {
		this.deductionStatus = deductionStatus;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public Long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}
	public void setAnnualFee(BigDecimal annualFee) {
		this.annualFee = annualFee;
	}
	public String getProducts() {
		return Products;
	}
	public void setProducts(String products) {
		Products = products;
	}
	@Override
	public String toString() {
		return "ProductInformation [id=" + id + ", sn=" + sn + ", name=" + name + ", Products=" + Products
				+ ", ageLimit=" + ageLimit + ", coverage=" + coverage + ", annualFee=" + annualFee + ", saleStatus="
				+ saleStatus + ", deductionStatus=" + deductionStatus + ", organizationName=" + organizationName
				+ ", organizationId=" + organizationId + "]";
	}
	
	
	

}