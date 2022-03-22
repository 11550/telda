package ru.telda.demo.serivce;

import ru.telda.demo.entity.Region;

import java.util.List;

public interface RegionService {

    /**
     * @return all Regions from DB as List
     */
    List<Region> getAll();

    /**
     * method allows to get an instance of Region by id
     * @param id unique identificator
     * @return Region instance
     */
    Region getById(Long id);

    /**
     * @param name name of Region
     * @return Region instance having searching parameter from DB
     */
    Region getByName(String name);

    /**
     * @param nameSimple nameSimple of Region
     * @return all Regions having searching parameter from DB as List
     */
    List<Region> getByNameSimple(String nameSimple);

    /**
     * method allows to save an instance of Region in DB
     * @param region Region instance to save
     * @return 1 if success
     */
    Region createAndGet(Region region);

    /**
     * method allows to edit an instance of Region in DB
     * @param region Region instance to save
     * @return 1 if success
     */
    Region updateAndGet(Region region);

    /**
     * method allows to remove an instance of Region from DB by id
     * @param id unique identificator
     * @return 1 if success
     */
    Region delete(Long id);

    /**
     * method allows to remove an instance of Region from DB
     * @param region Region instance with id to remove
     * @return 1 if success
     */
    Region delete(Region region);
}
