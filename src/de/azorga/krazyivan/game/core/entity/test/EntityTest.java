package de.azorga.krazyivan.game.core.entity.test;

import static org.junit.Assert.*;

import org.junit.Test;

import de.azorga.krazyivan.game.core.entity.Entity;

public class EntityTest {

	@Test
	public void test() {
		Entity entity = new Entity("Testentity");
		assertEquals(entity.getId(), "Testentity");
		//assertEquals(entity.getEntityPoly().getX(), entity.getEntityPoly().getX()!=0);
	}

}
