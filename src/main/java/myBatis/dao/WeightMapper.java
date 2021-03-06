package myBatis.dao;

import java.util.List;
import org.mybatis.cdi.Mapper;
import myBatis.model.Weight;

@Mapper
public interface WeightMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.WEIGHT
     *
     * @mbg.generated Tue Apr 06 21:15:39 EEST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.WEIGHT
     *
     * @mbg.generated Tue Apr 06 21:15:39 EEST 2021
     */
    int insert(Weight record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.WEIGHT
     *
     * @mbg.generated Tue Apr 06 21:15:39 EEST 2021
     */
    Weight selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.WEIGHT
     *
     * @mbg.generated Tue Apr 06 21:15:39 EEST 2021
     */
    List<Weight> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.WEIGHT
     *
     * @mbg.generated Tue Apr 06 21:15:39 EEST 2021
     */
    int updateByPrimaryKey(Weight record);
}