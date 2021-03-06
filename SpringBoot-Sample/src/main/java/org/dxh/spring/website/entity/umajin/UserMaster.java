package org.dxh.spring.website.entity.umajin;

import java.io.Serializable;
import java.util.Date;

/**
 * Class Name	:  <br />
 * Description : テーブルumajin..user_master
 * @since 2019/02/26
 * @author Link BIt Consulting 
 */
public class UserMaster implements Serializable {
    /** ユーザid (PK) (デフォルトなし) */
    private Integer user_id;

    /** ふりがな(必須) (デフォルトなし) */
    private String nickname;

    /** 0:指定しない,1:男性、2:女性(必須)  (デフォルト: 0) */
    private Integer sex;

    /** 0:指定無し、1:10代、2:20代、3:30代、4:40代、5:50代、6:60代、7:70代以上(必須)  (デフォルト: 0) */
    private Integer age;

    /** 生年月日(必須) (デフォルトなし) */
    private Date birthday;

    /** 登録日時(非必須) (デフォルトなし) */
    private Date regist_date;

    /**   (デフォルト: 0000-00-00 00:00:00) */
    private Date update_date;

    /** 無効フラグ0:有効、1:自動無効、2:手動無効、3、退会無効(非必須)  (デフォルト: 0) */
    private Integer disable;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table umajin..user_master
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umajin..user_master.user_id
     *
     * @return the value of umajin..user_master.user_id
     *
     * @mbg.generated
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umajin..user_master.user_id
     *
     * @param user_id the value for umajin..user_master.user_id
     *
     * @mbg.generated
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umajin..user_master.nickname
     *
     * @return the value of umajin..user_master.nickname
     *
     * @mbg.generated
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umajin..user_master.nickname
     *
     * @param nickname the value for umajin..user_master.nickname
     *
     * @mbg.generated
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umajin..user_master.sex
     *
     * @return the value of umajin..user_master.sex
     *
     * @mbg.generated
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umajin..user_master.sex
     *
     * @param sex the value for umajin..user_master.sex
     *
     * @mbg.generated
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umajin..user_master.age
     *
     * @return the value of umajin..user_master.age
     *
     * @mbg.generated
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umajin..user_master.age
     *
     * @param age the value for umajin..user_master.age
     *
     * @mbg.generated
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umajin..user_master.birthday
     *
     * @return the value of umajin..user_master.birthday
     *
     * @mbg.generated
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umajin..user_master.birthday
     *
     * @param birthday the value for umajin..user_master.birthday
     *
     * @mbg.generated
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umajin..user_master.regist_date
     *
     * @return the value of umajin..user_master.regist_date
     *
     * @mbg.generated
     */
    public Date getRegist_date() {
        return regist_date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umajin..user_master.regist_date
     *
     * @param regist_date the value for umajin..user_master.regist_date
     *
     * @mbg.generated
     */
    public void setRegist_date(Date regist_date) {
        this.regist_date = regist_date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umajin..user_master.update_date
     *
     * @return the value of umajin..user_master.update_date
     *
     * @mbg.generated
     */
    public Date getUpdate_date() {
        return update_date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umajin..user_master.update_date
     *
     * @param update_date the value for umajin..user_master.update_date
     *
     * @mbg.generated
     */
    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umajin..user_master.disable
     *
     * @return the value of umajin..user_master.disable
     *
     * @mbg.generated
     */
    public Integer getDisable() {
        return disable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umajin..user_master.disable
     *
     * @param disable the value for umajin..user_master.disable
     *
     * @mbg.generated
     */
    public void setDisable(Integer disable) {
        this.disable = disable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umajin..user_master
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UserMaster other = (UserMaster) that;
        return (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getRegist_date() == null ? other.getRegist_date() == null : this.getRegist_date().equals(other.getRegist_date()))
            && (this.getUpdate_date() == null ? other.getUpdate_date() == null : this.getUpdate_date().equals(other.getUpdate_date()))
            && (this.getDisable() == null ? other.getDisable() == null : this.getDisable().equals(other.getDisable()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umajin..user_master
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getRegist_date() == null) ? 0 : getRegist_date().hashCode());
        result = prime * result + ((getUpdate_date() == null) ? 0 : getUpdate_date().hashCode());
        result = prime * result + ((getDisable() == null) ? 0 : getDisable().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umajin..user_master
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", user_id=").append(user_id);
        sb.append(", nickname=").append(nickname);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", birthday=").append(birthday);
        sb.append(", regist_date=").append(regist_date);
        sb.append(", update_date=").append(update_date);
        sb.append(", disable=").append(disable);
        sb.append("]");
        return sb.toString();
    }
}