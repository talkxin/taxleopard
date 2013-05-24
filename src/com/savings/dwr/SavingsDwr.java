package com.savings.dwr;

import java.sql.SQLException;
import java.util.List;

import com.savings.entity.SaInterest;
import com.savings.entity.SaSavings;
import com.savings.entity.SaSavingsInfo;
import com.savings.service.SavingsService;

public class SavingsDwr {
	private SavingsService savingsService;

	public SavingsService getSavingsService() {
		return savingsService;
	}

	public void setSavingsService(SavingsService savingsService) {
		this.savingsService = savingsService;
	}

	/**
	 * 添加账户
	 * 
	 * @param sa
	 * @return
	 */
	public SaSavingsInfo addSaSavingsInfo(SaSavingsInfo sa) {
		try {
			return savingsService.addSaSavingsInfo(sa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 修改账户
	 * 
	 * @param sa
	 */
	public void upSaSavingsInfo(SaSavingsInfo sa) {
		try {
			savingsService.upSaSavingsInfo(sa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 删除账户
	 * 
	 * @param sa
	 */
	public void delSaSavingsInfo(int sa) {
		try {
			savingsService.delSaSavingsInfo(sa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 添加信息
	 * 
	 * @param sa
	 */
	public void addSaSavings(SaSavings sa) {
		try {
			savingsService.addSaSavings(sa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 修改信息
	 * 
	 * @param sa
	 */
	public void upSaSavings(SaSavings sa) {
		try {
			savingsService.upSaSavings(sa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 删除信息
	 * 
	 * @param sa
	 */
	public void delSaSavings(int sa) {
		try {
			savingsService.delSaSavings(sa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 返回所有账户
	 * 
	 * @param sa
	 * @return
	 */
	public List<SaSavingsInfo> isGetSavingsInfo(int sa) {
		try {
			return savingsService.isGetSavingsInfo(sa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}/**
	 * 添加利率
	 * 
	 * @param sa
	 * @throws SQLException
	 */
	public void addInterest(SaInterest sa){
		try {
			savingsService.addInterest(sa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 修改利率
	 * 
	 * @param sa
	 * @throws SQLException
	 */
	public void upInterest(SaInterest sa){
		try {
			savingsService.upInterest(sa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 删除利率
	 * 
	 * @param sa
	 * @throws SQLException
	 */
	public void delInterest(int sa){
		try {
			savingsService.delInterest(sa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 返回利率
	 * 
	 * @param sa
	 * @return
	 */
	public List<SaInterest> isGetInterest(int sa){
		try {
			return savingsService.isGetInterest(sa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 返回最新利率
	 * @param sa
	 * @return
	 * @throws SQLException
	 */
	public SaInterest isGetNewInterest(int sa) {
		try {
			return savingsService.isGetNewInterest(sa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
