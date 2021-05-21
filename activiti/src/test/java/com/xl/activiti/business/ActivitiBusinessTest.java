package com.xl.activiti.business;


import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 业务与activiti的融合
 */
@SpringBootTest
public class ActivitiBusinessTest {

    @Resource
    RuntimeService runtimeService;

    @Resource
    RepositoryService repositoryService;

    /**
     * 添加业务key,启动实例的时候添加进去,
     * ACT_RU_EXECUTION 表中有Business字段显示
     */
    @Test
    public void test1() {
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("_event", "10001");
        System.out.println("流程实例中的业务主键"+instance.getBusinessKey());
    }

    /**
     * 批量流程实例的挂起与激活   也可以进行单例，通过实例的id就行了
     *  其实是更新  ACT_RU_TASK 表中的 SUSPENSION_STATE_的数据  1 激活  2挂起
     *  还有其他几张表也有此字段
     */
    @Test
    public void test2() {
        //查询实例
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey("_event")
                .singleResult();

        //获取该实例状态（挂起、激活）
        boolean suspended = processDefinition.isSuspended();

        //获取实例ID
        String id = processDefinition.getId();
        if(suspended){
            //如果是挂起，可以执行激活的操作，参数1：流程定义id  参数2：是否激活  参数3：激活时间
            repositoryService.activateProcessDefinitionById(id,true,new Date());
            System.out.println("流程实例"+id+"已激活");
        }else {
            //如果是激活，可以执行挂起的操作，参数1：流程定义id  参数2：是否激活  参数3：激活时间
            repositoryService.suspendProcessDefinitionById(id,true,new Date());
            System.out.println("流程实例"+id+"已挂起");
        }


    }


}
