package com.auto.util;

import com.auto.action.pojo.GoodsPage;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import static org.apache.catalina.security.SecurityUtil.remove;

public class ModifyXmlFile {


    public  static String LOGINURL = "http://193.112.201.116:4399/login";
    public  static String LOGINNAME = "13666666666";
    public  static String LOGINPASSWORD = "aaa888888";



    public void readXml(){



    }

    public static void removeXml() {
        try{
        SAXReader reader = new SAXReader();
            String path1 =  Thread.currentThread().getContextClassLoader().getResource("testng2.xml").getPath();


            Document document = reader.read(new File(path1));


            Element root = document.getRootElement();

            Element test =  root.element("test");
            List<Element> parameter =  root.elements("parameter");

            if (parameter!=null){
                if(parameter.size()>0){
                    for (int i=0;i<parameter.size();i++){
                        root.remove(parameter.get(i));
                    }
                }

            }
            if (test!=null){
                root.remove(test);
            }

            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("UTF-8");
            XMLWriter writer = new XMLWriter(new FileWriter(path1),format);
            writer.write(document);
            writer.close();


        } catch (DocumentException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }


    }


    public  static void creatXml(GoodsPage page){

        try{
            //读取XML文件，获得document对象
            SAXReader reader = new SAXReader();
//            Document document = reader.read(new File(".\\src\\main\\resources\\testng2.xml"));

            String fileName = GetPathUtil.getResourcesPath("testng2.xml");
            Document document = reader.read(new File(fileName));

            //获得某个节点的属性对象
            Element rootElem = document.getRootElement();

            //获取根节点属性对象
    //        Attribute rootAttr = rootElem.attribute("name");

            //新增 parameter 节点
            if (page.getLoginUrl()!=null){
                Element parameterEle = rootElem.addElement("parameter");
                parameterEle.addAttribute("name","url");
                parameterEle.addAttribute("value",page.getLoginUrl());

            }

            //新增 parameter 节点
            if(page.getLoginName()!=null){
                Element parameterEle = rootElem.addElement("parameter");
                parameterEle.addAttribute("name","loginName");
                parameterEle.addAttribute("value",page.getLoginName());
            }

            //新增 parameter 节点
            if(page.getLoginPassword()!=null){
                Element parameterEle = rootElem.addElement("parameter");
                parameterEle.addAttribute("name","password");
                parameterEle.addAttribute("value",page.getLoginPassword());
            }



            //创建test节点
            Element testEle = rootElem.addElement("test");
            testEle.addAttribute("name","test1");


            //创建classes节点
            Element classesEle = rootElem.element("test").addElement("classes");



            // 新增class login 节点
            Element element1 =classesEle.addElement("class");
            element1.addAttribute("name","com.auto.service.TestLogin");

            if (page.getHotelProduct()!=null || page.getOtherProduct()!=null || page.getTrivalProduct()!=null  ){

                // 新增class addGoods 节点
                Element classElement2 = classesEle.addElement("class");
                classElement2.addAttribute("name","com.auto.service.TestAddGoods");
                Element methods = classElement2.addElement("methods");


                if(page.getHotelProduct()!=null){
                    methods.addElement("include").addAttribute("name","testCaseAddHotel");
                }

                if(page.getOtherProduct()!=null){
                    methods.addElement("include").addAttribute("name","testCaseNewAddOther");
                }

                if(page.getTrivalProduct()!=null){
                    methods.addElement("include").addAttribute("name","testCaseAddTravel");
                }

            }

        if(page.getGoodsOtUp() !=null || page.getGoodsDown() !=null || page.getGoodsDel() !=null ){

            // 新增class addGoods 节点
            Element classElement2 = classesEle.addElement("class");
            classElement2.addAttribute("name","com.auto.service.TestGoodsOperation");
            Element methods = classElement2.addElement("methods");

            if(page.getGoodsOtUp() !=null ){
                methods.addElement("include").addAttribute("name","testCaseGoodsOtUp");
            }

            if(page.getGoodsDown() !=null ){

                methods.addElement("include").addAttribute("name","testCaseGoodsDown");
            }

            if(page.getGoodsDel() !=null){

                methods.addElement("include").addAttribute("name","getGoodsDel");

            }

        }


            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("UTF-8");
            XMLWriter writer = new XMLWriter(new FileWriter(fileName),format);
            writer.write(document);
            writer.close();



        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {

            removeXml();
//            creatXml();

            //读取XML文件，获得document对象
//            SAXReader reader = new SAXReader();
//            Document document = reader.read(new File(".\\src\\main\\resources\\testng2.xml"));
//
//            //获得某个节点的属性对象
//            Element rootElem = document.getRootElement();
//
//            //获取根节点属性对象
//            Attribute rootAttr = rootElem.attribute("name");
//            System.out.println(rootAttr.getValue());
            //获取指定节点属性对象
//             Element contactElem = rootElem.element("parameter");
//             Attribute contactAttr = contactElem.attribute("name");
//            Attribute conValue1 = contactElem.attribute("value");
//
//            System.out.println(contactElem.getName()+"="+contactAttr.getValue()+"="+conValue1.getValue());


//            List<Element> parameter = rootElem.elements("parameter");
//            for (int i =0;i<parameter.size();i++){
//                Attribute contactAttr1 =  parameter.get(i).attribute("name");
//                Attribute contactAttr2 =  parameter.get(i).attribute("value");
//                System.out.println(contactAttr1.getValue()+"="+contactAttr2.getValue());
//            }
            // 通过test 获取节点
//            Element parameter2 = rootElem.element("test");
//            List<Element> element = parameter2.element("classes").elements("class");
//            for (int i =0;i<element.size();i++){
//                Attribute className = element.get(i).attribute("name");
//                System.out.println(className.getValue());
//            }


            // 新增class login 节点
//            List<Element> classElement = rootElem.element("test").element("classes").elements("class");
//            for (int i =0;i<classElement.size();i++){
//                classElement.get(i).remove(classElement.get(i));
//            }




            // 新增class login 节点
//            Element element1 = rootElem.element("test").element("classes").addElement("class");
//            element1.addAttribute("name","com.auto.service.TestLogin");
//
//            // 新增class addGoods 节点
//            Element classElement2 = rootElem.element("test").element("classes").addElement("class");
//            classElement2.addAttribute("name","com.auto.service.TestAddGoods");
//            classElement2.addElement("methods").addElement("include").addAttribute("name","testCaseAddHotel");
//


//            OutputFormat format = OutputFormat.createPrettyPrint();
//            format.setEncoding("UTF-8");
//            XMLWriter writer = new XMLWriter(new FileWriter(".\\src\\main\\resources\\testng2.xml"),format);
//            writer.write(document);
//            writer.close();



//            //遍历某个节点的所有属性
//             for (Iterator it = contactElem2.attributeIterator(); it.hasNext();){
//                     Attribute  conAttr= (Attribute)it.next();
//                     String conTxt = conAttr.getValue();
//                     String conAttrName = conAttr.getName();
//                     System.out.println(conAttrName+" = "+conTxt);
//                 }






    }



//           try {
//
//        String filePath = ".\\src\\main\\resources\\testng.xml";
//        // 1、创建 File 对象，映射 XML 文件
//        File file = new File(filePath);
//        // 2、创建 DocumentBuilderFactory 对象，用来创建 DocumentBuilder 对象
//        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//        // 3、创建 DocumentBuilder 对象，用来将 XML 文件 转化为 Document 对象
//        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
//        // 4、创建 Document 对象，解析 XML 文件
//        Document document = documentBuilder.parse(file);
//        // 修改第一个 student
//        // 5、获取第一个 student 结点
//        Node student = document.getElementsByTagName("student").item(0);
//        // 获取结点 student 结点的所有属性
//        NamedNodeMap namedNodeMap = student.getAttributes();
//        // 获取界定 student 的 属性 id
//        Node id = namedNodeMap.getNamedItem("id");
//        // 给属性 id 重新设置值
//        id.setTextContent("student11");
//        // 6、获取根结点 students 的第一个直接子结点 student
//        student = document.getElementsByTagName("student").item(0);
//        Element studentElement = (Element) student;
//        // 7、获取结点 student 的直接子结点 name、sex
//        Node name = studentElement.getElementsByTagName("name").item(0);
//        Node sex = studentElement.getElementsByTagName("sex").item(0);
//        Element nameElement = (Element) name;
//        Element sexElement = (Element) sex;
//        // 8、给节点进行设置值
//        nameElement.setTextContent("TomTom");
//        sexElement.setTextContent("FemaleFemale");
//        // 9、创建 TransformerFactory 对象
//        TransformerFactory transformerFactory = TransformerFactory.newInstance();
//        // 10、创建 Transformer 对象
//        Transformer transformer = transformerFactory.newTransformer();
//        // 11、创建 DOMSource 对象
//        DOMSource domSource = new DOMSource(document);
//        // 12、创建 StreamResult 对象
//        StreamResult reStreamResult = new StreamResult(file);
//        transformer.transform(domSource, reStreamResult);
//
//        // 输出测试结果
//        StreamResult consoleResult = new StreamResult(System.out);
//        transformer.transform(domSource, consoleResult);
//
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//}  public static void main(String[] args) {


}
