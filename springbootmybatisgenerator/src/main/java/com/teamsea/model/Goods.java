package com.teamsea.model;

public class Goods {
    @Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", num=" + num + ", isdelete=" + isdelete + "]";
	}

	/**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.id
     *
     * @mbg.generated Wed Apr 12 18:41:06 CST 2023
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.name
     *
     * @mbg.generated Wed Apr 12 18:41:06 CST 2023
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.num
     *
     * @mbg.generated Wed Apr 12 18:41:06 CST 2023
     */
    private Integer num;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.isdelete
     *
     * @mbg.generated Wed Apr 12 18:41:06 CST 2023
     */
    private Byte isdelete;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.id
     *
     * @return the value of goods.id
     *
     * @mbg.generated Wed Apr 12 18:41:06 CST 2023
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.id
     *
     * @param id the value for goods.id
     *
     * @mbg.generated Wed Apr 12 18:41:06 CST 2023
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.name
     *
     * @return the value of goods.name
     *
     * @mbg.generated Wed Apr 12 18:41:06 CST 2023
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.name
     *
     * @param name the value for goods.name
     *
     * @mbg.generated Wed Apr 12 18:41:06 CST 2023
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.num
     *
     * @return the value of goods.num
     *
     * @mbg.generated Wed Apr 12 18:41:06 CST 2023
     */
    public Integer getNum() {
        return num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.num
     *
     * @param num the value for goods.num
     *
     * @mbg.generated Wed Apr 12 18:41:06 CST 2023
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.isdelete
     *
     * @return the value of goods.isdelete
     *
     * @mbg.generated Wed Apr 12 18:41:06 CST 2023
     */
    public Byte getIsdelete() {
        return isdelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.isdelete
     *
     * @param isdelete the value for goods.isdelete
     *
     * @mbg.generated Wed Apr 12 18:41:06 CST 2023
     */
    public void setIsdelete(Byte isdelete) {
        this.isdelete = isdelete;
    }
}