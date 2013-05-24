package com.org.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.org.entity.AdminRegister;
import com.org.entity.Functions;
import com.org.entity.Matter;
import com.org.entity.TaxPayer;
import com.org.service.AdminRegisterService;
import com.org.service.taxPayerService;

@SuppressWarnings("serial")
public class TaxPayerAction extends ActionSupport implements
		ServletResponseAware {
	/*登录Service*/
	private taxPayerService taxPayerService;
	/*注入推出Service*/
	private AdminRegisterService adminRegisterService;
	private List<Functions> flist=new ArrayList<Functions>();
	public List<Functions> getFlist() {
		return flist;
	}
	public void setFlist(List<Functions> flist) {
		this.flist = flist;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public AdminRegisterService getAdminRegisterService() {
		return adminRegisterService;
	}
	public void setAdminRegisterService(AdminRegisterService adminRegisterService) {
		this.adminRegisterService = adminRegisterService;
	}
	/*用户类*/
	private TaxPayer taxPayer;
	private String confirmPass;
	private String tip;
	private HttpServletResponse response;
	private int taxID;
	private String Matter;
	private String Result;
	private int id;
	private AdminRegister adminRegister;

	public AdminRegister getAdminRegister() {
		return adminRegister;
	}

	public void setAdminRegister(AdminRegister adminRegister) {
		this.adminRegister = adminRegister;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatter() {
		return Matter;
	}

	public void setMatter(String matter) {
		Matter = matter;
	}

	public String getResult() {
		return Result;
	}

	public void setResult(String result) {
		Result = result;
	}

	public int getTaxID() {
		return taxID;
	}

	public void setTaxID(int taxID) {
		this.taxID = taxID;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getConfirmPass() {
		return confirmPass;
	}

	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}

	public TaxPayer getTaxPayer() {
		return taxPayer;
	}

	public void setTaxPayer(TaxPayer taxPayer) {
		this.taxPayer = taxPayer;
	}

	public taxPayerService getTaxPayerService() {
		return taxPayerService;
	}

	public void setTaxPayerService(taxPayerService taxPayerService) {
		this.taxPayerService = taxPayerService;
	}

	/**
	 * 登录操作
	 * */
	public String findLogin() throws Exception {
		//登录前的工作
		quit();
		//session中放入值
		if((Integer)ActionContext.getContext().getSession().get("numError")==null){
			if(taxPayer==null){
				ActionContext.getContext().put("errorPage", "LoginError");
				return "LoginError";
			}
			TaxPayer t=taxPayerService.findTaxPayerByName(taxPayer);
			if(t==null){
				ActionContext.getContext().put("errorPage", "LoginError");
				return "LoginError";
			}
			ActionContext.getContext().getSession().put("numError", t.getState());
		}
		//验证码错误判断
		if((Boolean)ActionContext.getContext().getSession().get("verifyResult")!=null){
			if((Boolean)ActionContext.getContext().getSession().get("verifyResult")==false){
				ActionContext.getContext().put("errorPage", "LoginError");
				return "LoginError";
			}
		}else{
			ActionContext.getContext().getSession().put("verifyResult", null);
		}
		//正常登录操作
		TaxPayer plist =null;//接收用户句柄
		if((plist=(TaxPayer) ActionContext.getContext().getSession().get("taxPayer"))!=null){
			return "LoginSuccess";//如果session中有用户则返回成功否则进行添加用户
		}else{
			if(taxPayer==null){
				ActionContext.getContext().put("errorPage", "LoginError");
				return "LoginError";
			   }
			plist= taxPayerService.findLogin(taxPayer);
			if(plist==null){//三次进行验证码
				ActionContext.getContext().put("errorPage", "LoginError");
				ActionContext.getContext().getSession().put("numError",(((Integer)ActionContext.getContext().getSession().get("numError")==null?0:(Integer)ActionContext.getContext().getSession().get("numError"))+1 ));
				if((Integer)ActionContext.getContext().getSession().get("numError")>=3){
					TaxPayer t=taxPayerService.findTaxPayerByName(taxPayer);
					if(t==null){
						return "LoginError";
					}
					t.setState(3);
					taxPayerService.updateTaxPayerByState(t);
				}
				return "LoginError";
			}
			//登录成功修改状态值
			if(plist.getState()!=null)
				if(plist.getState()==3){
					plist.setState(0);
					taxPayerService.updateTaxPayerByState(plist);
				}
			taxPayer=null;
			Date loginDate=new Date();
			ActionContext.getContext().getSession().put("loginDate",loginDate);
			adminRegister=adminRegisterService.selectUserByUserID(plist.getTaxUserName());
			if(adminRegister==null){
				ActionContext.getContext().getSession().put("adminRegister","欢迎使用");
			}
			else{
				SimpleDateFormat fm=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String date=fm.format(adminRegister.getLoginDate());
				ActionContext.getContext().getSession().put("adminRegister",date);
			}
		}
		ActionContext ctx = ActionContext.getContext();
		Integer counter = (Integer) ctx.getApplication().get("counter");
		if (counter == null) {
			counter = 1;
		} else {
			counter += 1;
		}
		ctx.getApplication().put("counter", counter);
		flist = taxPayerService.findFunction(1);
		ActionContext.getContext().getSession().put("taxPayer", plist);
		setTip(getText("loginSuccess"));
		ctx.put(tip, "服务器提示你已经成功登录");
		{
			Cookie c = new Cookie("user", plist.getTaxUserName());
			c.setMaxAge(60 * 60);
			response.addCookie(c);
		}
		return "LoginSuccess";
	}

	private int checked=0;
	public int getChecked() {
		return checked;
	}
	public void setChecked(int checked) {
		this.checked = checked;
	}
	/**
	 * 添加用户
	 * */
	public String addTaxPayer() throws Exception {
		if((Boolean)ActionContext.getContext().getSession().get("verifyResult")==null){
			taxPayer=null;
			return "yanzhenmaError";
		}
		if((Boolean)ActionContext.getContext().getSession().get("verifyResult")==false){
			taxPayer.setTaxPassWord("");
			return "yanzhenmaError";
		}
		if(checked!=1){
			taxPayer.setTaxPassWord("");
			return "yanzhenmaError";
		}
		if (confirmPass.equals(taxPayer.getTaxPassWord())) {
			 if(taxPayerService.findTaxPayerByName(taxPayer)!=null)
					return "yanzhenmaError";
			 //初始化一个模块
			 taxPayer.setPid("1");
			taxPayerService.addTaxPayer(taxPayer);
			return "addTaxPayerSuccess";
		} else {
			return "addTaxPayerErrror";
		}
	}

	/**
	 * 根据用户名查找用户
	 * */
	private String userhave;
	public String getUserhave() {
		return userhave;
	}
	public void setUserhave(String userhave) {
		this.userhave = userhave;
	}
	public String findtaxPayerByName() throws Exception {
		if((Boolean)ActionContext.getContext().getSession().get("verifyResult")){
			TaxPayer tx = taxPayerService.findTaxPayerByName(taxPayer);
			if (tx != null) {
				ActionContext.getContext().put("tx", tx);
				userhave="错误";
				return "findSuccess";
			} else {
				userhave="正确";
				return "findError";
			}
		}else{return "findError";}
	}

	/**
	 * 找回密码跳转
	 * */
	public String skipTaxPayer() throws Exception {
		List<Matter> mlist = taxPayerService.findMatters(taxID);
		ActionContext.getContext().put("mlist", mlist);
		ActionContext.getContext().put("taxID", taxID);
		return "skopSuccess";
	}

	/**
	 * 根据密码问题验证
	 * */
	public String findResult() throws Exception {
		Matter mr = taxPayerService.findMatterByName(Matter);
		if (mr != null) {
			if (Result.equals(mr.getResult())) {
				ActionContext.getContext().put("id", mr.getTaxID());
				return "resultSuccess";
			} else {
				return "resultError";
			}
		} else {
			return "resultError";
		}
	}

	/***
	 * 根据ID修改密码
	 * */
	public String updPassWord() throws Exception {
		taxPayer.setTaxID(id);
		taxPayerService.updatePassWord(taxPayer);
		return "updPassWordSuccess";

	}

	/**
	 * 
	 * 安全退出
	 * */
	public String quit() throws Exception {
		TaxPayer tax = (TaxPayer) ActionContext.getContext().getSession().get(
				"taxPayer");
		if (tax != null) {
			adminRegister = new AdminRegister();
			adminRegister.setLoginUserName(tax.getTaxUserName());
			adminRegister.setLoginDate((Date)ActionContext.getContext().getSession().get("loginDate"));
			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);  
			String ip = request.getHeader("x-forwarded-for");
	        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("Proxy-Client-IP");
	        }
	        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("WL-Proxy-Client-IP");
	        }
	        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getRemoteAddr();
	        }
			adminRegister.setLoginIP(ip);
			adminRegister.setLoginQuitTime(new Date());
			taxPayerService.addAdminRegister(adminRegister);
			//taxPayerService.updateTaxPayerByState1(tax.getTaxID());
			ActionContext.getContext().getSession().clear();
			return "quitSuccess";
		} else {
			return "quitError";
		}
	}
	/***
	 * 返回首页
	 * */
	public String reboundIndex() throws Exception {
		return "reboundIndexSuccess";
	}
	/***
	 * 
	 * */
	public void setServletResponse(HttpServletResponse arg0) {
		response = arg0;
	}
	/***
	 * 返回个人首页
	 * */
	public String toPersonalPage() throws Exception {
		return "toPersonalPage";
	}
	/***
	 * 进入注册页面
	 * */
	public String toRegisterPage() throws Exception{
		return "toRegisterPage";
	}
}
