package com.codingforfun.action.test;

import com.codingforfun.model.test.TestCallBack;
import org.openxava.actions.ViewBaseAction;
import org.openxava.jpa.XPersistence;

import java.util.Date;

public class TestAddAction extends ViewBaseAction {
    @Override
    public void execute() throws Exception {
        TestCallBack testCallBack = new TestCallBack();
        testCallBack.setName("test1");
        testCallBack.setAge(18);
        testCallBack.setBirthDate(new Date());

        XPersistence.getManager().persist(testCallBack);
    }
}
