package com.example.KMA.mapper;

import com.example.KMA.model.User;
import com.example.KMA.model.UserExample;
import com.example.KMA.model.UserKey;
import com.example.KMA.model.UserWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Sat Mar 25 20:50:26 ICT 2023
	 */
	long countByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Sat Mar 25 20:50:26 ICT 2023
	 */
	int deleteByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Sat Mar 25 20:50:26 ICT 2023
	 */
	int insert(User row);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Sat Mar 25 20:50:26 ICT 2023
	 */
	int insertSelective(User row);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Sat Mar 25 20:50:26 ICT 2023
	 */
	List<User> selectByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Sat Mar 25 20:50:26 ICT 2023
	 */
	int updateByExampleSelective(@Param("row") User row, @Param("example") UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Sat Mar 25 20:50:26 ICT 2023
	 */
	int updateByExample(@Param("row") User row, @Param("example") UserExample example);
}