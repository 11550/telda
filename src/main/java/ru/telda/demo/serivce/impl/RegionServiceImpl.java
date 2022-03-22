package ru.telda.demo.serivce.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.telda.demo.entity.Region;
import ru.telda.demo.exception.RegionNotFoundException;
import ru.telda.demo.repository.RegionDao;
import ru.telda.demo.serivce.RegionService;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionDao regionDao;

    @Override
    @Cacheable(value = "regions")
    @Transactional(readOnly = true)
    public List<Region> getAll() {
        return regionDao.selectRegions();
    }

    @Override
    @Cacheable(value = "regions")
    @Transactional(readOnly = true)
    public Region getById(Long id) {
        return regionDao.selectRegionById(id);
    }

    @Override
    @Cacheable(value = "regions")
    @Transactional(readOnly = true)
    public Region getByName(String name) {
        return regionDao.selectRegionsByName(name);
    }

    @Override
    @Cacheable(value = "regions")
    @Transactional(readOnly = true)
    public List<Region> getByNameSimple(String nameSimple) {
        return regionDao.selectRegionByNameSimple(nameSimple);
    }

    @Override
    @CacheEvict(value = "regions", allEntries = true)
    @Transactional(rollbackForClassName = "Exception")
    public Region createAndGet(Region region) {
        if (regionDao.insertRegion(region) > 0) {
            return regionDao.selectRegionsByName(region.getName());
        }
        return null;
    }

    @Override
    @CacheEvict(value = "regions", allEntries = true)
    @Transactional(rollbackForClassName = "Exception")
    public Region updateAndGet(Region region) {
        if (regionDao.updateRegion(region) > 0) {
            return regionDao.selectRegionsByName(region.getName());
        }
        return null;
    }

    @Override
    @CacheEvict(value = "regions", allEntries = true)
    @Transactional(rollbackForClassName = "Exception", noRollbackFor = RegionNotFoundException.class)
    public Region delete(Long id) {
        Region regionToRemove = regionDao.selectRegionById(id);
        if (regionToRemove == null) {
            throw new RegionNotFoundException("Region Not Found. Id: " + id);
        }
        regionDao.deleteRegion(id);
        return regionToRemove;
    }

    @Override
    @CacheEvict(value = "regions", allEntries = true)
    @Transactional(rollbackForClassName = "Exception", noRollbackFor = RegionNotFoundException.class)
    public Region delete(Region region) {
        Region regionToRemove = regionDao.selectRegionById(region.getId());
        if (regionToRemove == null) {
            throw new RegionNotFoundException("Region Not Found. Id: " + region.getId());
        }
        regionDao.deleteRegion(region);
        return regionToRemove;
    }
}
