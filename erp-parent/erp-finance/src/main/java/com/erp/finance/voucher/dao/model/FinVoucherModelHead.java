package com.erp.finance.voucher.dao.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import redragon.util.math.MoneyUtil;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="fin_voucher_model_head", schema="erp")
@DynamicInsert(true)
@DynamicUpdate(true)
public class FinVoucherModelHead implements java.io.Serializable {

    //serialVersionUID
    private static final long serialVersionUID = 1L;

    //Constructors
    public FinVoucherModelHead() {
    }
    
    //Fields
    
    //凭证头id
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "voucher_head_id", unique = true, nullable = false)
    private Integer voucherHeadId;
    
    public Integer getVoucherHeadId() {
        return this.voucherHeadId;
    }
    public void setVoucherHeadId(Integer voucherHeadId) {
        this.voucherHeadId = voucherHeadId;
    }
    
    //凭证头编码
    @Column(name = "voucher_head_code", unique = true, nullable = false, length = 45)
    private String voucherHeadCode;
    
    public String getVoucherHeadCode() {
        return this.voucherHeadCode;
    }
    public void setVoucherHeadCode(String voucherHeadCode) {
        this.voucherHeadCode = voucherHeadCode;
    }
    
    //模板名称
    @NotBlank(message="模本名称不能为空")
    @Column(name = "model_name", unique = false, nullable = false, length = 45)
    private String modelName;
    
    public String getModelName() {
        return this.modelName;
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    
    //业务类型
    @NotBlank(message="业务类型不能为空")
    @Column(name = "business_type", unique = false, nullable = true, length = 45)
    private String businessType;
    
    public String getBusinessType() {
        return this.businessType;
    }
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }
    
    //凭单字
    @NotBlank(message="凭证字不能为空")
    @Column(name = "voucher_type", unique = false, nullable = false, length = 10)
    private String voucherType;
    
    public String getVoucherType() {
        return this.voucherType;
    }
    public void setVoucherType(String voucherType) {
        this.voucherType = voucherType;
    }
    
    //凭证号
    @Column(name = "voucher_number", unique = false, nullable = true, length = 45)
    private String voucherNumber;
    
    public String getVoucherNumber() {
        return this.voucherNumber;
    }
    public void setVoucherNumber(String voucherNumber) {
        this.voucherNumber = voucherNumber;
    }
    
    //凭证日期
    @Column(name = "voucher_date", unique = false, nullable = true)
    private Date voucherDate;
    
    public Date getVoucherDate() {
        return this.voucherDate;
    }
    public void setVoucherDate(Date voucherDate) {
        this.voucherDate = voucherDate;
    }
    
    //单据数量
    @Column(name = "bill_num", unique = false, nullable = true)
    private Integer billNum;
    
    public Integer getBillNum() {
        return this.billNum;
    }
    public void setBillNum(Integer billNum) {
        this.billNum = billNum;
    }
    
    //版本
    @Column(name = "version", unique = false, nullable = false)
    private Integer version;
    
    public Integer getVersion() {
        return this.version;
    }
    public void setVersion(Integer version) {
        this.version = version;
    }
    
    //状态
    @Column(name = "status", unique = false, nullable = false, length = 10)
    private String status;
    
    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    //制单人
    @Column(name = "staff_code", unique = false, nullable = false, length = 45)
    private String staffCode;
    
    public String getStaffCode() {
        return this.staffCode;
    }
    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }
    
    //制单部门
    @Column(name = "department_code", unique = false, nullable = false, length = 45)
    private String departmentCode;
    
    public String getDepartmentCode() {
        return this.departmentCode;
    }
    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
    
    //创建时间
    @Column(name = "created_date", unique = false, nullable = false)
    private Date createdDate;
    
    public Date getCreatedDate() {
        return this.createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    //创建人
    @Column(name = "created_by", unique = false, nullable = false, length = 45)
    private String createdBy;
    
    public String getCreatedBy() {
        return this.createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    
    //最后修改时间
    @Column(name = "last_updated_date", unique = false, nullable = true)
    private Date lastUpdatedDate;
    
    public Date getLastUpdatedDate() {
        return this.lastUpdatedDate;
    }
    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }
    
    //最后修改人
    @Column(name = "last_updated_by", unique = false, nullable = true, length = 45)
    private String lastUpdatedBy;
    
    public String getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
    
    //组织机构
    @Column(name = "org_code", unique = false, nullable = false, length = 10)
    private String orgCode;
    
    public String getOrgCode() {
        return this.orgCode;
    }
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }
    
    
    
    /*
     * 用于展示的字段
     */
    @Transient
    private String staffName;
    @Transient
    private String departmentName;
    @Transient
    private BigDecimal amount;
    @Transient
    private String amountDesc;
    @Transient
    private String drAmount;
    @Transient
    private String crAmount;
    @Transient
    private String[] drAmountArray;
    @Transient
    private String[] crAmountArray;
    @Transient
    private List<FinVoucherModelLine> finVoucherModelLineList;

    public String getStaffName() {
        return staffName;
    }
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public String[] getDrAmountArray() {
        String[] array = new String[11];
        for(int i=0;i<11;i++) {
            array[i] = "";
        }
        return array;
    }
    public void setDrAmountArray(String[] drAmountArray) {
        this.drAmountArray = drAmountArray;
    }
    public String[] getCrAmountArray() {
        String[] array = new String[11];
        for(int i=0;i<11;i++) {
            array[i] = "";
        }
        return array;
    }
    public void setCrAmountArray(String[] crAmountArray) {
        this.crAmountArray = crAmountArray;
    }
    public String getAmountDesc() {
        try {
            String desc = MoneyUtil.convert(this.amount.doubleValue());
            return desc;
        }catch(Exception e) {
            return "";
        }
    }
    public void setAmountDesc(String amountDesc) {
        this.amountDesc = amountDesc;
    }
    public String getDrAmount() {
        return drAmount;
    }
    public void setDrAmount(String drAmount) {
        this.drAmount = drAmount;
    }
    public String getCrAmount() {
        return crAmount;
    }
    public void setCrAmount(String crAmount) {
        this.crAmount = crAmount;
    }
    public List<FinVoucherModelLine> getFinVoucherModelLineList() {
        return finVoucherModelLineList;
    }
    public void setFinVoucherModelLineList(List<FinVoucherModelLine> finVoucherModelLineList) {
        this.finVoucherModelLineList = finVoucherModelLineList;
    }
    
}