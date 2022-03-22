package ru.telda.demo.mapper;

import org.apache.ibatis.annotations.*;
import ru.telda.demo.entity.Region;

import java.util.List;
import java.util.Map;

@Mapper
public interface RegionMapper {

    @Select("select * from region where id = #{id}")
    Region selectRegion(@Param("id") Long id);

    @Select("select * from region where nameSimple like #{name} limit 1")
    Region selectRegionByName(@Param("name") String name);

    @Select("select * from region where nameSimple like #{nameSimple}")
    List<Region> selectRegionByNameSimple(@Param("nameSimple") String nameSimple);

    @Select("select * from region")
    List<Region> selectRegions();

    @Select("select * from region")
    @MapKey("id")
    Map<Long, Region> selectRegionsMap();

    @Insert("insert into region (name, nameSimple) values (#{name}, #{nameSimple})")
    int insertRegion(Region region);

    @Update("update region set name = #{name}, nameSimple = #{nameSimple} where id = #{id}")
    int updateRegion(Region region);

    @Delete("delete from region where id = #{id}")
    int deleteRegionById(Long id);

    @Delete("delete from region where id = #{id}")
    int deleteRegion(Region region);
}
