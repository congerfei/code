package com.xl.activiti;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class ActivitiApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    ProcessEngine processEngine;

    @Autowired
    RepositoryService repositoryService;

    @Autowired
    TaskService taskService;

    @Autowired
    RuntimeService runtimeService;


    @Test
    public void contextLoads() {
        System.out.println("数据源："+dataSource);
        System.out.println("工作流引擎："+processEngine);
        //可以从引擎得到，也可以直接注入，下面证明是同一个对象
        RepositoryService repositoryService2 = processEngine.getRepositoryService();
        System.out.println(repositoryService.equals(repositoryService2));//ture
    }

    /**
     * 加载配置生成25张表
     * 并证明和注入的对象是一样的
     */
    @Test
    public void test0(){
        ProcessEngine processEngine1 = ProcessEngines.getDefaultProcessEngine();
        System.out.println(processEngine1.equals(processEngine));//true
    }

    /**
     * 部署流程,关键对象RepositoryService, 通过 processEngine.getRepositoryService()得到;整合spring boot后可以直接注入
     * 插入了数据涉及的表：
     * ACT_RE_DEPLOYMENT  一条记录，流程实例的部署时间
     * ACT_RE_PROCDEF    流程定义表   一条记录，流程定义信息，每走一次流程就要创建一条流程实例
     * ACT_GE_BYTEARRAY  2条记录，流程实例和bpmn，png的关系
     */
    @Test
    public void test1(){
        Deployment deployment = repositoryService.createDeployment().name("请假流程申请")
                .addClasspathResource("test/qingjia.bpmn")
                .addClasspathResource("test/qingjia.png")
                .deploy();

        System.out.println("流程部署ID："+deployment.getId());
        System.out.println("流程部署名字:"+deployment.getName());
    }


    /**
     * 流程实例的启动
     * 插入数据涉及的表
     * ACT_HI_TASKINST
     * ACT_HI_PROCINST
     * ACT_HI_ACTINST
     * ACT_RU_EXECUTION
     * ACT_RU_TASK
     *
     */
    @Test
    public void test2(){
        //根据流程定义启动一个流程实例,通过流程定义表ACT_RE_PROCDEF中的key(来自我们设计bpmn时候点击空白处的设置ID)
        HashMap map = new HashMap();
        map.put("assignee_","zhangsan");
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("_event",map);

        System.out.println("流程定义ID："+processInstance.getProcessDefinitionId());
        System.out.println("流程实例ID："+processInstance.getId());
    }

    /**
     * 查询待完成的任务，。业务上是申请人开始的，但是代码是开始事件就已经进入了流程，
     *  现在可以查启动了哪些流程实例，
     */
    @Test
    public void test3() {
        List<Task> list = taskService.createTaskQuery()
                .processDefinitionKey("_event")
//                .taskAssignee("zhangsan")
                .list();

        for (Task task : list) {
            System.out.println("流程实例ID"+task.getProcessInstanceId());
            System.out.println("任务ID"+task.getId());
            System.out.println("任务负责人"+task.getAssignee());
            System.out.println("任务名称："+task.getName());

        }
    }


    /**
     * 通过任务id完成任务即可
     * 删除ACT_RU_TASK表中的旧数据，新增新的数据
     * 添加到历史表中 ACT_HI_TASKINST   ACT_HI_ACTINST
     * 以及更新  ACT_RU_EXECUTION    ACT_HI_ACTINST    ACT_HI_TASKINST
     *
     * 依次可完成剩下的任务
     */
    @Test
    public void test4() {
        taskService.complete("b6dd62a7-b0c5-11eb-ada2-4cedfb690a53");
    }

    @Test
    public void test5() {



    }






}


