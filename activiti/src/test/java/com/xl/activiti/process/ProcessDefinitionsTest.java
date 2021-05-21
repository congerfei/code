package com.xl.activiti.process;


import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 部署完成后
 * 流程定义的相关操作
 */
@SpringBootTest
public class ProcessDefinitionsTest {

    @Resource
    RepositoryService repositoryService;


    /**
     * 查询流程定义信息
     */
    @Test
    public void test1(){
        Set<String> str = new HashSet<>();
        str.add("_event");

        //得到流程定义表的查询对象
        ProcessDefinitionQuery definitionQuery = repositoryService.createProcessDefinitionQuery();
        List<ProcessDefinition> processDefinitions = definitionQuery.processDefinitionKeys(str)  //新版本通过key的集合来获取流程定义，逻辑是不重复的，数据库并没有限制，返回的是一个集合
                .orderByProcessDefinitionVersion()    //通过版本号排序
                .desc()
                .list();

        for (ProcessDefinition p : processDefinitions) {
            System.out.println("流程定义ID："+ p.getId());
            System.out.println("流程定义名称："+ p.getName());
            System.out.println("流程定义key："+ p.getKey());
            System.out.println("流程部署主键ID："+ p.getDeploymentId());
        }
    }

    /**
     * 删除流程定义信息,部署创建的表都删除了
     *  历史数据还都在，便于分析
     *  如果还有数据在流程中则无法删除定义信息，需要用2个参数的方法，称为级联删除
     */
    @Test
    public void test2() {
        repositoryService.deleteDeployment("1288e52e-b0c1-11eb-8d2e-4cedfb690a53");
        //联级删除，流程中的数据也一并删除
//        repositoryService.deleteDeployment("1288e52e-b0c1-11eb-8d2e-4cedfb690a53",true);
    }

    /**
     * 下载资源文件，流程图（png和bpmn文件）  部署表中的——byte的 longlob字段类型的，使用activiti的api更简单
     */
    @Test
    public void test3() throws IOException {
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey("_event")
                .singleResult();
        //通过流程定义信息获取部署ID
        String deploymentId = processDefinition.getDeploymentId();
        //通过流程定义表获取png图片和目录和名字
        String pngName = processDefinition.getDiagramResourceName();
        //通过流程id以及资源的名称获取输入流
        InputStream resourceAsStream = repositoryService.getResourceAsStream(deploymentId, pngName);

        //存放的位置
        File file = new File("src/main/resources/png/event.png ");

        //构建输出流，这里会抛出异常,文件不存在只会创建文件，并不会创建文件夹，所以文件夹一定要存在
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        //输入流和输出流的转换
        IOUtils.copy(resourceAsStream,fileOutputStream);

        //关闭流
        fileOutputStream.close();
        resourceAsStream.close();


    }





}
