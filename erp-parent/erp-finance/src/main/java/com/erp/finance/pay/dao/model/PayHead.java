package com.erp.finance.pay.dao.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="pay_head", schema="erp")
@DynamicInsert(true)
@DynamicUpdate(true)
public class PayHead implements java.io.Serializable {

    //serialVersionUID
    private static final long serialVersionUID = 1L;

    //Constructors
    public PayHead() {
    }
    
    //Fields
    
    //付款头id
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "pay_head_id", unique = true, nullable = false)
    private Integer payHeadId;
    
    public Integer getPayHeadId() {
        return this.payHeadId;
    }
    public void setPayHeadId(Integer payHeadId) {
        this.payHeadId = payHeadId;
    }
    
    //付款头编码
    @NotBlank(message="付款头编码不能为空")
    @Column(name = "pay_head_code", unique = true, nullable = false, length = 45)
    private String payHeadCode;
    
    public String getPayHeadCode() {
        return this.payHeadCode;
    }
    public void setPayHeadCode(String payHeadCode) {
        this.payHeadCode = payHeadCode;
    }
    
    //付款来源类型（采购订单PO、入库单INPUT）
    @NotBlank(message="付款来源类型不能为空")
    @Column(name = "pay_source_type", unique = false, nullable = false, length = 45)
    private String paySourceType;
    
    public String getPaySourceType() {
        return this.paySourceType;
    }
    public void setPaySourceType(String paySourceType) {
        this.paySourceType = paySourceType;
    }
    
    //付款来源头编码（采购订单头编码、入库单头编码）
    @NotBlank(message="付款来源头编码不能为空")
    @Column(name = "pay_source_head_code", unique = false, nullable = false, length = 45)
    private String paySourceHeadCode;
    
    public String getPaySourceHeadCode() {
        return this.paySourceHeadCode;
    }
    public void setPaySourceHeadCode(String paySourceHeadCode) {
        this.paySourceHeadCode = paySourceHeadCode;
    }
    
    //付款方
    @Column(name = "payer", unique = false, nullable = false, length = 45)
    @NotBlank(message="付款方不能为空")
    private String payer;
    
    public String getPayer() {
        return this.payer;
    }
    public void setPayer(String payer) {
        this.payer = payer;
    }
    
    //收款方
    @NotBlank(message="收款方不能为空")
    @Column(name = "receiver", unique = false, nullable = false, length = 45)
    private String receiver;
    
    public String getReceiver() {
        return this.receiver;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    
    //币种
    @NotBlank(message="币种不能为空")
    @Column(name = "currency_code", unique = false, nullable = false, length = 45)
    private String currencyCode;
    
    public String getCurrencyCode() {
        return this.currencyCode;
    }
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
    
    //付款时间
    @NotNull(message="付款时间不能为空")
    @Column(name = "pay_date", unique = false, nullable = false)
    private Date payDate;
    
    public Date getPayDate() {
        return this.payDate;
    }
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }
    
    //预付款标识
    @NotBlank(message="预付款标识不能为空")
    @Column(name = "prepay_flag", unique = false, nullable = false, length = 1)
    private String prepayFlag;
    
    public String getPrepayFlag() {
        return this.prepayFlag;
    }
    public void setPrepayFlag(String prepayFlag) {
        this.prepayFlag = prepayFlag;
    }
    
    //付款方式
    @NotBlank(message="付款方式不能为空")
    @Column(name = "pay_mode", unique = false, nullable = false, length = 45)
    private String payMode;
    
    public String getPayMode() {
        return this.payMode;
    }
    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }
    
    //银行编码
    @NotBlank(message="银行不能为空")
    @Column(name = "bank_code", unique = false, nullable = true, length = 45)
    private String bankCode;
    
    public String getBankCode() {
        return this.bankCode;
    }
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }
    
    //分行编码
    @Column(name = "sub_bank_code", unique = false, nullable = true, length = 45)
    private String subBankCode;
    
    public String getSubBankCode() {
        return this.subBankCode;
    }
    public void setSubBankCode(String subBankCode) {
        this.subBankCode = subBankCode;
    }
    
    //银行账户
    @NotBlank(message="银行账户不能为空")
    @Column(name = "bank_account", unique = false, nullable = true, length = 45)
    private String bankAccount;
    
    public String getBankAccount() {
        return this.bankAccount;
    }
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }
    
    //摘要
    @Column(name = "memo", unique = false, nullable = true, length = 200)
    private String memo;
    
    public String getMemo() {
        return this.memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
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
    
    //状态（新建NEW，确认CONFIRM，取消CANCEL）
    @Column(name = "status", unique = false, nullable = false, length = 10)
    private String status;
    
    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    //审批状态（未提交UNSUBMIT、已提交SUBMIT、已审批APPROVE、已驳回REJECT）
    @Column(name = "approve_status", unique = false, nullable = false, length = 10)
    private String approveStatus;
    
    public String getApproveStatus() {
        return this.approveStatus;
    }
    public void setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus;
    }
    
    //付款状态（未付款N，已付款Y，部分付款PART）
    @Column(name = "paid_status", unique = false, nullable = true, length = 10)
    private String paidStatus;
    
    public String getPaidStatus() {
        return paidStatus;
    }
    public void setPaidStatus(String paidStatus) {
        this.paidStatus = paidStatus;
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
    private Double amount = 0D;
    @Transient
    private String paySourceHeadName;
    @Transient
    private Double paySourceHeadAmount = 0D;
    @Transient
    private Double paySourceHeadHISAmount = 0D;
    @Transient
    private String receiverName;
    @Transient
    private String bankName;

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
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public String getPaySourceHeadName() {
        return paySourceHeadName;
    }
    public void setPaySourceHeadName(String paySourceHeadName) {
        this.paySourceHeadName = paySourceHeadName;
    }
    public Double getPaySourceHeadAmount() {
        return paySourceHeadAmount;
    }
    public void setPaySourceHeadAmount(Double paySourceHeadAmount) {
        this.paySourceHeadAmount = paySourceHeadAmount;
    }
    public Double getPaySourceHeadHISAmount() {
        return paySourceHeadHISAmount;
    }
    public void setPaySourceHeadHISAmount(Double paySourceHeadHISAmount) {
        this.paySourceHeadHISAmount = paySourceHeadHISAmount;
    }
    public String getReceiverName() {
        return receiverName;
    }
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    
}