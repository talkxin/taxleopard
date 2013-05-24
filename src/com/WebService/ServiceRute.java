package com.WebService;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.HashMap;

import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;

import util.StringUtil;
import XMLDao.Dao;

import Map.XMLMapDocument;

public class ServiceRute {
	private Service srvcModel = new ObjectServiceFactory().create(TaxEngineDao.class); //service
	private XFireProxyFactory factory = new XFireProxyFactory(XFireFactory.newInstance().getXFire());//XFireProxyFactory工厂类
	private static String webServiceUrl;//路径
	private ServicePojo pojo=new ServicePojo();//计算类
	static {
		XMLMapDocument xmlDoucument =new XMLMapDocument();
		Document document = null;
		try {
			document = Dao.getDocument(StringUtil.getReadXML()+"/TaxEngine.xml");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		xmlDoucument.getDocument(document,xmlDoucument);
		webServiceUrl=xmlDoucument.getXMLMapDocument("/url[name=url]").getAttribute("value");
		xmlDoucument=null;
		document=null;
	}
	
	/**
	 * 获取连接
	 * @return
	 * @throws MalformedURLException
	 */
	private TaxEngineDao getTaxEngineDao() throws MalformedURLException{
		return (TaxEngineDao)factory.create(srvcModel, webServiceUrl);
	}
	public void setWebServiceUrl(String webServiceUrl) {
		this.webServiceUrl = webServiceUrl;
	}
	public ServicePojo getPojo() throws MalformedURLException {
		return getTaxEngineDao().returnService(pojo);
	}
	@SuppressWarnings("unchecked")
	public void setMap(HashMap<String,HashMap> businessList){
		pojo.setBusinessList(businessList);
	}
	public void setVerification(String verification){
		pojo.setVerification(verification);
	}
	public static void main(String[] args) throws MalformedURLException {
		ServiceRute serviceRute=new ServiceRute();//实例化对象
		
		HashMap map=new HashMap();
		//工资薪金测试
		map.put("moduleName", "PayChex");
		map.put("userTime", "20110101");
		map.put("nationality", "CN");
		map.put("trade", "普通");
		map.put("taxed", "OnTaxed");
		map.put("paychexD", "5669");
		//劳务报酬测试
//		map.put("moduleName", "labor");
//		map.put("userTime", "20110103");
//		map.put("laborTaxEd", "0");
//		map.put("laborNumber", "5004");
		HashMap<String,HashMap> list=new HashMap<String,HashMap>();
		//将单一业务map加入批量业务map
		list.put("one", map);
		System.out.println(new Date().getTime());
		serviceRute.setMap(list);
		System.out.println(new Date().getTime());
		System.out.println(serviceRute.getPojo().getBusinessList());
	}
	
}
