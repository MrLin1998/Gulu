package com.linzb.guluuser.test.entity;


import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 单位基本信息扩展记录表
 */
@Data
@Accessors(chain = true)
public class EmpBasInfoExtCDO{
    /**
     * 单位编号
     */
    @NotBlank(message="单位编号不可为空")
    @Length(max =40,message ="单位编号长度不超过40")
    private String empNo;

    /**
     * 单位实体编码
     */
    @Length(max =40,message ="单位实体编码长度不超过40")
    private String empEnttCodg;

    /**
     * 单位管理类型
     */
    @NotBlank(message="单位管理类型不可为空")
    @Length(max =6,message ="单位管理类型长度不超过6")
    private String empMgtType;

    /**
     * 上级单位编号
     */
    @Length(max =40,message ="上级单位编号长度不超过40")
    private String prntEmpNo;

    /**
     * 关联法人标志
     */
    @NotBlank(message="关联法人标志不可为空")
    @Length(max =6,message ="关联法人标志长度不超过6")
    private String asocLegentFlag;

    /**
     * 单位类型
     */
    @Length(max =6,message ="单位类型长度不超过6")
    private String empType;

    /**
     * 单位名称
     */
    @NotBlank(message="单位名称不可为空")
    @Length(max =200,message ="单位名称长度不超过200")
    private String empName;

    /**
     * 注册名称
     */
    @Length(max =500,message ="注册名称长度不超过500")
    private String regName;

    /**
     * 所属医保区划
     */
    @Length(max =6,message ="所属医保区划长度不超过6")
    private String locAdmdvs;

    /**
     * 联系人证件类型
     */
    @Length(max =50,message ="联系人证件类型长度不超过50")
    private String conerCertType;

    /**
     * 联系人证件号
     */
    @Length(max =50,message ="联系人证件号长度不超过50")
    private String conerCertno;

    /**
     * 联系人姓名
     */
    @Length(max =50,message ="联系人姓名长度不超过50")
    private String conerName;

    /**
     * 联系人电子邮箱
     */
    @Length(max =100,message ="联系人电子邮箱长度不超过100")
    private String conerEmail;

    /**
     * 联系电话
     */
    @Length(max =50,message ="联系电话长度不超过50")
    private String tel;

    /**
     * 传真号码
     */
    @Length(max =50,message ="传真号码长度不超过50")
    private String faxNo;

    /**
     * 税务登记号
     */
    @Length(max =50,message ="税务登记号长度不超过50")
    private String taxRegNo;

    /**
     * 组织机构代码
     */
    @Length(max =20,message ="组织机构代码长度不超过20")
    private String orgcode;

    /**
     * 注册号
     */
    @Length(max =30,message ="注册号长度不超过30")
    private String regno;

    /**
     * 注册号证件类型
     */
    @Length(max =6,message ="注册号证件类型长度不超过6")
    private String regnoCertType;

    /**
     * 单位地址
     */
    @Length(max =200,message ="单位地址长度不超过200")
    private String empAddr;

    /**
     * 邮政编码
     */
    @Length(max =6,message ="邮政编码长度不超过6")
    private String poscode;

    /**
     * 批准成立部门
     */
    @Length(max =100,message ="批准成立部门长度不超过100")
    private String aprvEstaDept;

    /**
     * 批准成立日期
     */
    private Date aprvEstaDate;

    /**
     * 批准成立文号
     */
    @Length(max =100,message ="批准成立文号长度不超过100")
    private String aprvEstaDocno;

    /**
     * 上级医保区划
     */
    @Length(max =6,message ="上级医保区划长度不超过6")
    private String prntAdmdvs;

    /**
     * 参保所属医保区划
     */
    @NotBlank(message="参保所属医保区划不可为空")
    @Length(max =6,message ="参保所属医保区划长度不超过6")
    private String insuAdmdvs;

    /**
     * 组织有效状态
     */
    @NotBlank(message="组织有效状态不可为空")
    @Length(max =3,message ="组织有效状态长度不超过3")
    private String orgValiStas;

    /**
     * 法定代表人电话号码
     */
    @Length(max =50,message ="法定代表人电话号码长度不超过50")
    private String legrepTel;

    /**
     * 法定代表人姓名
     */
    @Length(max =255,message ="法定代表人姓名长度不超过255")
    private String legrepName;

    /**
     * 法定代表人证件类型
     */
    @Length(max =6,message ="法定代表人证件类型长度不超过6")
    private String legrepCertType;

    /**
     * 法定代表人证件号码
     */
    @Length(max =50,message ="法定代表人证件号码长度不超过50")
    private String legrepCertno;

    /**
     * 组织机构代码证颁发单位
     */
    @Length(max =100,message ="组织机构代码证颁发单位长度不超过100")
    private String orgcodeIssuEmp;

    /**
     * 虚拟标志
     */
    @Length(max =1,message ="虚拟标志长度不超过1")
    private String virFlag;

    /**
     * 最新变更信息
     */
    @Length(max =200,message ="最新变更信息长度不超过200")
    private String lastChgInfo;

    /**
     * 发送注册标志
     */
    @Length(max =3,message ="发送注册标志长度不超过3")
    private String sendRegFlag;

    /**
     * 备注
     */
    @Length(max =500,message ="备注长度不超过500")
    private String memo;

    /**
     * 有效标志
     */
    @NotBlank(message="有效标志不可为空")
    @Length(max =3,message ="有效标志长度不超过3")
    private String valiFlag;

    /**
     * 统筹区编号
     */
    @Length(max =6,message ="统筹区编号长度不超过6")
    private String poolareaNo;

    /**
     * 经办渠道
     */
    @Length(max =3,message ="经办渠道长度不超过3")
    private String optChnl;

    /**
     * 数据创建时间
     */
    @NotNull(message="数据创建时间不可为空")
    private Date crteTime;

    /**
     * 数据更新时间
     */
    @NotNull(message="数据更新时间不可为空")
    private Date updtTime;

    /**
     * 数据唯一记录号
     */
    @NotBlank(message="数据唯一记录号不可为空")
    @Length(max =40,message ="数据唯一记录号长度不超过40")
    private String rid;

    /**
     * 参保单位管理事件ID
     */
    @NotBlank(message="参保单位管理事件ID不可为空")
    @Length(max =20,message ="参保单位管理事件ID长度不超过20")
    private String insuEmpMgtEid;

    /**
     * 企业规格标志
     */
    @Length(max =3,message ="企业规格标志长度不超过3")
    private String entpSpecFlag;
}
