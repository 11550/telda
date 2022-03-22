package ru.telda.demo.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.telda.demo.entity.Region;

import java.util.List;

@Component
public class RegionDao {

    @Autowired
    private SqlSession sqlSession;

    public Region selectRegionById(Long id) {
        return sqlSession.selectOne("selectRegion", id);
    }

    public List<Region> selectRegions() {
        return sqlSession.selectList("selectRegions");
    }

    public Region selectRegionsByName(String name) {
        return sqlSession.selectOne("selectRegionByName", name);
    }

    public List<Region> selectRegionByNameSimple(String nameSimple) {
        return sqlSession.selectList("selectRegionByNameSimple", nameSimple);
    }

    public int insertRegion(Region region) {
        return sqlSession.insert("insertRegion", region);
    }

    public int updateRegion(Region region) {
        return sqlSession.update("updateRegion", region);
    }

    public int deleteRegion(Long id) {
        return sqlSession.delete("deleteRegionById", id);
    }

    public int deleteRegion(Region region) {
        return sqlSession.delete("deleteRegion", region);
    }
}
