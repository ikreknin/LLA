package lv.bc.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lv.bc.models.MenuList;

public class MenuListUnitTest {

	MenuList menuListTestObj;
	MenuList menuListTestObjWithNull;

	@Before
	public void setUp() {
		menuListTestObj = new MenuList("ENG-LAT");
		menuListTestObjWithNull = new MenuList(null);
	}

	@Test
	public final void testInitalize() {
		MenuList menuList = new MenuList("ENG-LAT");

		assertEquals("Topic menu list", menuListTestObj.getTopicMenu(), menuList.getTopicMenu());

	}

	@Test
	public final void testInitalizeWithNoLanguage() {

		MenuList menuList = new MenuList(null);
		assertEquals("Topic menu list with no any languages", menuListTestObjWithNull.getTopicMenu(),
				menuList.getTopicMenu());
	}
}
