package com.Util;

import java.io.FileNotFoundException;

import org.dom4j.Document;
import org.dom4j.DocumentException;

import util.StringUtil;

import XMLDao.Dao;
import Map.XMLMapDocument;

public class LoginXMLMain {
	public static final String path="/open[value=";
	public static final String adminPath="/adminOpen[value=";
	public static final String userPath="/userOpen[value=";
	public static final String down="]";
	public static XMLMapDocument xmlDoucument =new XMLMapDocument();
	static {
		Document document = null;
		try {
			document = Dao.getDocument(StringUtil.getReadXML()+"/web-lock.xml");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		xmlDoucument.getDocument(document,xmlDoucument);
	}
}
