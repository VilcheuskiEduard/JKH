package by.edu.grsu.jkh.dataaccess.impl;

import by.edu.grsu.jkh.datamodel.Brigade;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BrigadeDaoTest {
  private static final String TEST_XML_FOLDER = "testXmlFolder";
  private static BrigadeDao brigadeDao;

  @BeforeClass
  public static void createDao() {
    brigadeDao = new BrigadeDao(TEST_XML_FOLDER);
  }


  @AfterClass
  public static void deleteTestXmlData() {
    //	 write code to clean up test results from FS

  }

  @Test
  public void testAdd() {
    System.out.println("Start 'save' test for Brigade");
    final Brigade newBrigade = saveNewBrigade();
    Assert.assertNotNull(brigadeDao.get(newBrigade.getId()));
  }

  @Test
  public void testDelete() {
    System.out.println("Start 'delete' test for Brigade");
    final Brigade newBrigade = saveNewBrigade();
    brigadeDao.delete(newBrigade.getId());
    Assert.assertNull(brigadeDao.get(newBrigade.getId()));
  }

  @Test
  public void testGetAll() {
    System.out.println("Start 'getAll' test for Brigade");
    final int initialRowsCount = brigadeDao.getAll().size();
    saveNewBrigade();
    Assert.assertEquals(brigadeDao.getAll().size(), initialRowsCount + 1);
  }

  private Brigade saveNewBrigade() {
    final Brigade newBrigade = new Brigade();
    /*newCircle.setRadius(10d);
    newCircle.setColour("red");
    newCircle.setCreated(new Date());
    circleDao.saveNew(newCircle);*/
    newBrigade.setBrigadeName("Name");
    newBrigade.setPersonsNumbers(12);
    brigadeDao.saveNew(newBrigade);
    return newBrigade;
  }
}
