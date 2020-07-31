package com.codingforfun.action.test;

import com.codingforfun.model.test.TestCallBack;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openxava.actions.ViewBaseAction;
import org.openxava.jpa.XPersistence;

public class TestUpdateAction extends ViewBaseAction {
    private static Log log = LogFactory.getLog(TestCallBack.class);
    @Override
    public void execute() throws Exception {
        TestCallBack testCallBack = XPersistence.getManager().find(TestCallBack.class, 1L);
        System.out.println("Before Update : " + testCallBack);

        testCallBack.setAge(20);
        System.out.println("After Update" + testCallBack);
        XPersistence.getManager().persist(testCallBack);


    }
}
