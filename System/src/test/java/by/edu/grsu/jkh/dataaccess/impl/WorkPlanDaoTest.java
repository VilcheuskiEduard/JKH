package by.edu.grsu.jkh.dataaccess.impl;

import by.edu.grsu.jkh.datamodel.WorkPlan;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WorkPlanDaoTest {
  private static final String TEST_XML_FOLDER = "testXmlFolder";
  private static WorkPlanDao workPlanDao;

  @BeforeClass
  public static void createDao() {
    workPlanDao = new WorkPlanDao(TEST_XML_FOLDER);
  }


  @AfterClass
  public static void deleteTestXmlData() {
    //	 write code to clean up test results from FS

  }

  @Test
  public void testAdd() {
    System.out.println("Start 'save' test for Work Plan");
    final WorkPlan newWorkPlan = saveNewWorkPlan();
    Assert.assertNotNull(workPlanDao.get(newWorkPlan.getId()));
  }

  @Test
  public void testDelete() {
    System.out.println("Start 'delete' test for Work Plan");
    final WorkPlan newWorkPlan = saveNewWorkPlan();
    workPlanDao.delete(newWorkPlan.getId());
    Assert.assertNull(workPlanDao.get(newWorkPlan.getId()));
  }

  @Test
  public void testGetAll() {
    System.out.println("Start 'getAll' test for Work Plan");
    final int initialRowsCount = workPlanDao.getAll().size();
    saveNewWorkPlan();
    Assert.assertEquals(workPlanDao.getAll().size(), initialRowsCount + 1);
  }

  private WorkPlan saveNewWorkPlan() {
    final WorkPlan newWorkPlan = new WorkPlan();
    /*newCircle.setRadius(10d);
    newCircle.setColour("red");
    newCircle.setCreated(new Date());
    circleDao.saveNew(newCircle);*/

    workPlanDao.saveNew(newWorkPlan);
    return newWorkPlan;
  }
}
